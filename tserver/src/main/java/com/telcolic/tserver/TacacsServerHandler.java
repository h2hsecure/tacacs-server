package com.telcolic.tserver;

import com.telcolic.tserver.proto.TacacsHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hekemen on 5/21/16.
 */
public class TacacsServerHandler extends ChannelInboundHandlerAdapter {
    Logger log = LoggerFactory.getLogger(TacacsServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("get tacacas request");
        TacacsHeader h = (TacacsHeader) msg;
        log.info("version : {}, length {}", h.getVersion(), h.getLength());
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
