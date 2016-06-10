package com.telcolic.tserver.proto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.telcolic.tserver.Bytes;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;

public class TacacsPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3034401807210067401L;
	
	
	byte major = 0; 
	byte minor = 0;
	byte type = 0;
	byte seq_no = 0;
	byte flags = 0;
	int session = 0;
	int lenght = 0;
	
	
	
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
			keepLoop = pad.length <= body.capacity();
		}
		
		int i = 0;
		final ByteBuf readBody = UnpooledByteBufAllocator.DEFAULT.buffer(body.capacity());
		while (body.isReadable()) {
			readBody.writeByte(Bytes.InttoByte(Bytes.BytetoInt(body.readByte()) ^ Bytes.BytetoInt(pad[i++])));
		}

		return readBody;
	}

}
