package com.telcolic.tserver.proto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hekemen on 5/21/16.
 */
public class TacacsHeader {
    public static final byte TAC_PLUS_MAJOR_VER = (byte)0xc0;
    public static final byte SIZE_OF = 0xc;
    public static final int MAX_SIZE = 0x100;
    private static final byte HEADERFLAG_NO_ENCRYPT = 0x1;

    byte version;
    byte type;
    byte seq_no;
    byte flags;
    int session_id;
    int length;

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(byte seq_no) {
        this.seq_no = seq_no;
    }

    public byte getFlags() {
        return flags;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public ByteBuf crypt(byte versionNumber, byte sequenceNumber,
                        ByteBuf body, byte headerFlags, byte[] sessionID, byte[] secretkey) throws IOException, NoSuchAlgorithmException {
        if (headerFlags == HEADERFLAG_NO_ENCRYPT)
            return body;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] pad = null;
        byte[] lastPad = null;
        boolean keepLoop = true;
        while (keepLoop) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(sessionID);
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
        ByteBuf realBody = UnpooledByteBufAllocator.DEFAULT.buffer(body.capacity());
        while (body.isReadable()) {
            realBody.writeByte((((body.readByte() & 0x000000ff) ^ (pad[i] & 0x000000ff)) & 0x000000ff));
        }
        return realBody;
    }
}
