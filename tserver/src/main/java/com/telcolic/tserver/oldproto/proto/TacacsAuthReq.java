package oldproto.tacacs.proto;

public final class TacacsAuthReq extends TacacsPacket {

	/**
	 * 
	 */
	private static final long serialVersionUID = -627402747127376291L;
	               
	byte action = 0;
	byte priv_lvl = 0; 
	byte authen_type = 0;
	byte service = 0;
	byte user_len = 0; 
	byte port_len = 0; 
	byte rem_addr_lenght = 0;
	byte data_len = 0 ;
	               
	

	
	
}
