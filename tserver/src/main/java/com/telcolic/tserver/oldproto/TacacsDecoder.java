package oldproto.tacacs;

import java.util.List;

import oldproto.tacacs.proto.TacacsAuthReq;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class TacacsDecoder extends ByteToMessageDecoder { 
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { 
        
        
        out.add(new TacacsAuthReq());
    }
}
