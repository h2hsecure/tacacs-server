package com.telcolic.tserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TacacsServerHandler2 extends ChannelInboundHandlerAdapter {

	private Logger log = LoggerFactory.getLogger(TacacsServerHandler2.class);
	private List<Channel> list = new ArrayList<Channel>();

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
		list.add(ctx.channel());
	}
	
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		super.channelUnregistered(ctx);
		list.remove(ctx.channel());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;

		byte major = (byte) (buf.getByte(0) & (byte) 0xF0 >>> 4);
		byte minor = (byte) (buf.getByte(0) & (byte) 0x0F);
		byte type = buf.getByte(1);
		byte seq_no = buf.getByte(2);
		byte flags = buf.getByte(3);
		int session = buf.getInt(4);
		int lenght = buf.getInt(8);

		log.info("version {}/{} type {} seq_no {} flags {} session {} lenght {}",
				new Object[] { major, minor, type, seq_no, flags, session, lenght });

		ByteBuf bs = crypt(buf.getByte(0), seq_no, flags, session, buf.slice(12, lenght), "kr10".getBytes());
		
		byte action = bs.readByte();
		byte priv_lvl = bs.readByte();
		byte authen_type = bs.readByte();
		byte service = bs.readByte();
		byte user_len = bs.readByte();
		byte port_len = bs.readByte();
		byte rem_addr_len = bs.readByte();
		byte data_len = bs.readByte();
		
		
		log.info("action {} priv_lvl {} authen_type {} service {} user_len {} port_len {} rem_addr_len {} data_len {}",
				new Object[] { action, priv_lvl, authen_type, service, user_len, port_len, rem_addr_len, data_len });
		
		String username = bs.readBytes(user_len).toString(Charset.defaultCharset());
		String port = bs.readBytes(port_len).toString(Charset.defaultCharset());
		String rem_addr = bs.readBytes(rem_addr_len).toString(Charset.defaultCharset());
		String data = bs.readBytes(data_len).toString(Charset.defaultCharset());
		
		log.info("username {} port {} rem_addr {} data {}",
				new Object[] { username, port, rem_addr, service, data});
		
		bs.release();
		buf.release();
		
		final ByteBuf respBuf = UnpooledByteBufAllocator.DEFAULT.buffer(512);
		
		
	}

	ByteBuf crypt(byte versionNumber, byte sequenceNumber, byte headerFlags, int sessionID, ByteBuf body,
			byte[] secretkey) throws IOException, NoSuchAlgorithmException {
		if (headerFlags == 0x01)
			return body;
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] pad = null;
		byte[] lastPad = null;
		boolean keepLoop = true;
		while (keepLoop) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(Bytes.InttoBytes(sessionID));
			baos.write(secretkey);
			baos.write(versionNumber);
			baos.write(sequenceNumber);
			if (lastPad != null)
				baos.write(lastPad);
			lastPad = md.digest(baos.toByteArray());
			baos.reset();
			if (pad != null)
				baos.write(pad);
			baos.write(lastPad);
			pad = baos.toByteArray();
			if (pad.length > body.capacity())
				keepLoop = false;
		}
		
		int i = 0;
		final ByteBuf readBody = UnpooledByteBufAllocator.DEFAULT.buffer(body.capacity());
		while (body.isReadable()) {
			readBody.writeByte(Bytes.InttoByte(Bytes.BytetoInt(body.readByte()) ^ Bytes.BytetoInt(pad[i++])));
		}

		return readBody;
	}
}