package oldproto.tacacs;
/**
 * @author Jay Colson, Copyright 2000
 * @version v0.10, 06/13/2000
 */

public class Bytes{
  private Bytes() {
  }
  // convert int to byte[4]
  public static byte[] InttoBytes( int v ){
    byte[] bytes = new byte[ 4 ];
    bytes[ 0 ] = (byte)(( v & 0xff000000 ) >>> 24 );
    bytes[ 1 ] = (byte)(( v & 0x00ff0000 ) >>> 16 );
    bytes[ 2 ] = (byte)(( v & 0x0000ff00 ) >>> 8 );
    bytes[ 3 ] = (byte)(  v & 0x000000ff );
    return bytes;
  }
  // convert int to byte[1]
  public static byte InttoByte( int v ){
    return (byte)(  v & 0x000000ff );
  }
  //convert short to byte[2]
  public static byte[] ShorttoBytes( short v ){
    byte[] bytes = new byte[ 2 ];
    bytes[ 0 ] = (byte)(( v & 0x0000ff00 ) >>> 8 );
    bytes[ 1 ] = (byte)(  v & 0x000000ff );
    return bytes;
  }
  //convert byte[4] to int
  public static int IntBytetoInt( byte[] bytes ){
    if( bytes.length<4 )
      return 0;
    int v = ((bytes[ 0 ]<<24)&0xff000000) |
    ((bytes[ 1 ]<<16)&0x00ff0000) |
    ((bytes[ 2 ]<< 8)&0x0000ff00) |
    ( bytes[ 3 ]     &0x000000ff);
    return v;
  }
  //convert byte byte byte byte to int
  public static int IntBytetoInt( byte byte1, byte byte2, byte byte3, byte byte4 ){
    int v = ((byte1<<24)&0xff000000) |
    ((byte2<<16)&0x00ff0000) |
    ((byte3<< 8)&0x0000ff00) |
    ( byte4     &0x000000ff);
    return v;
  }
  // convert byte[2] to int
  public static int ShortBytetoInt( byte[] bytes ){
    if( bytes.length<2 )
      return 0;
    int v = ((bytes[ 0 ]<< 8)&0x0000ff00) |
    ( bytes[ 1 ]     &0x000000ff);
    return v;
  }
  // convert byte byte to int
  public static int ShortBytetoInt( byte byte1, byte byte2 ){
    int v = ((byte1 << 8)&0x0000ff00) |
    ( byte2     &0x000000ff);
    return v;
  }
  public static int BytetoInt (byte byte1) {
    int v = (byte1 &0x000000ff);
    return v;
  }
}

