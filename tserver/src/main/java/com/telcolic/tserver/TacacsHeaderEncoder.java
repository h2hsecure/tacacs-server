package com.telcolic.tserver;

import com.telcolic.tserver.proto.TacacsHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by hekemen on 5/21/16.
 */
public class TacacsHeaderEncoder extends MessageToByteEncoder<TacacsHeader> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, TacacsHeader tacacsHeader, ByteBuf byteBuf) throws Exception {

    }
}
