package com.telcolic.tserver;

import com.telcolic.tserver.com.telcolic.tserver.proto.TacacsHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketAddress;
import java.util.List;

/**
 * Created by hekemen on 5/21/16.
 */
public class TacacsHeaderDecoder extends ByteToMessageDecoder {
    private Logger log = LoggerFactory.getLogger(TacacsHeaderDecoder.class);


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        SocketAddress address = channelHandlerContext.channel().remoteAddress();
        if (byteBuf.readableBytes() < TacacsHeader.SIZE_OF) {
            log.warn("illegal header of packet {}", address.toString());
            byteBuf.clear();
            channelHandlerContext.close();
            return;
        }

        TacacsHeader header = new TacacsHeader();
        header.setVersion(byteBuf.readByte());

        if (header.getVersion() != TacacsHeader.TAC_PLUS_MAJOR_VER) {
            log.warn("illegal header of packet: version mismatch: {}", address.toString());
            byteBuf.clear();
            channelHandlerContext.close();
            return;
        }

        header.setType(byteBuf.readByte());
        header.setSeq_no(byteBuf.readByte());
        header.setFlags(byteBuf.readByte());
        header.setSession_id(byteBuf.readInt());
        header.setLength(byteBuf.readInt());

        if (header.getLength() > TacacsHeader.MAX_SIZE) {
            log.warn("illegal header of packet: too big package source: {}, length {}", address.toString(), header.getLength());
            byteBuf.clear();
            channelHandlerContext.close();
            return;
        }


        list.add(header);
        list.add(byteBuf.readBytes(header.getLength()));
    }
}
