package com.telcolic.tserver.proto;

import java.io.Serializable;

/**
 * Created by h2e on 15/06/16.
 *
 *
 *
 *
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |  authen_method |    priv_lvl    |  authen_type   | authen_service |
 +----------------+----------------+----------------+----------------+
 |    user len    |    port len    |  rem_addr len  |    arg_cnt     |
 +----------------+----------------+----------------+----------------+
 |   arg 1 len    |   arg 2 len    |      ...       |   arg N len    |
 +----------------+----------------+----------------+----------------+
 |   user ...
 +----------------+----------------+----------------+----------------+
 |   port ...
 +----------------+----------------+----------------+----------------+
 |   rem_addr ...
 +----------------+----------------+----------------+----------------+
 |   arg 1 ...
 +----------------+----------------+----------------+----------------+
 |   arg 2 ...
 +----------------+----------------+----------------+----------------+
 |   ...
 +----------------+----------------+----------------+----------------+
 |   arg N ...
 +----------------+----------------+----------------+----------------+
 */
public class AuthzReq implements Serializable {
    // Authentication Methods
    public static final byte TAC_PLUS_AUTHEN_METH_NOT_SET    = 0x00;
    public static final byte TAC_PLUS_AUTHEN_METH_NONE       = 0x01;
    public static final byte TAC_PLUS_AUTHEN_METH_KRB5       = 0x02;
    public static final byte TAC_PLUS_AUTHEN_METH_LINE       = 0x03;
    public static final byte TAC_PLUS_AUTHEN_METH_ENABLE     = 0x04;
    public static final byte TAC_PLUS_AUTHEN_METH_LOCAL      = 0x05;
    public static final byte TAC_PLUS_AUTHEN_METH_TACACSPLUS = 0x06;
    public static final byte TAC_PLUS_AUTHEN_METH_GUEST      = 0x08;
    public static final byte TAC_PLUS_AUTHEN_METH_RADIUS     = 0x10;
    public static final byte TAC_PLUS_AUTHEN_METH_KRB4       = 0x11;
    public static final byte TAC_PLUS_AUTHEN_METH_RCMD       = 0x20;

}
