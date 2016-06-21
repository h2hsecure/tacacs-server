package com.telcolic.tserver.proto;

import java.io.Serializable;

/**
 * Created by hekemen on 5/25/16.
 *
 *
 *
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |    action      |    priv_lvl    |  authen_type   |     service    |
 +----------------+----------------+----------------+----------------+
 |    user len    |    port len    |  rem_addr len  |    data len    |
 +----------------+----------------+----------------+----------------+
 |    user ...
 +----------------+----------------+----------------+----------------+
 |    port ...
 +----------------+----------------+----------------+----------------+
 |    rem_addr ...
 +----------------+----------------+----------------+----------------+
 |    data...
 +----------------+----------------+----------------+----------------+
 */
public class AuthReq implements Serializable {
    //Actions
    public static final byte  TAC_PLUS_AUTHEN_LOGIN = 0x01;
    public static final byte TAC_PLUS_AUTHEN_CHPASS = 0x02;
    public static final byte TAC_PLUS_AUTHEN_SENDPASS = 0x03; //(deprecated)
    public static final byte TAC_PLUS_AUTHEN_SENDAUTH = 0x04;

    // Privilieges
    public static final byte TAC_PLUS_PRIV_LVL_MAX = 0x0f;
    public static final byte TAC_PLUS_PRIV_LVL_ROOT = 0x0f;
    public static final byte TAC_PLUS_PRIV_LVL_USER = 0x01;
    public static final byte TAC_PLUS_PRIV_LVL_MIN  = 0x00;

    // Types
    public static final byte TAC_PLUS_AUTHEN_TYPE_ASCII      = 0x01;
    public static final byte TAC_PLUS_AUTHEN_TYPE_PAP        = 0x02;
    public static final byte TAC_PLUS_AUTHEN_TYPE_CHAP       = 0x03;
    public static final byte TAC_PLUS_AUTHEN_TYPE_ARAP       = 0x04;
    public static final byte TAC_PLUS_AUTHEN_TYPE_MSCHAP     = 0x05;

    // Services
    public static final byte TAC_PLUS_AUTHEN_SVC_NONE        = 0x00;
    public static final byte TAC_PLUS_AUTHEN_SVC_LOGIN       = 0x01;
    public static final byte TAC_PLUS_AUTHEN_SVC_ENABLE      = 0x02;
    public static final byte TAC_PLUS_AUTHEN_SVC_PPP         = 0x03;
    public static final byte TAC_PLUS_AUTHEN_SVC_ARAP        = 0x04;
    public static final byte TAC_PLUS_AUTHEN_SVC_PT          = 0x05;
    public static final byte TAC_PLUS_AUTHEN_SVC_RCMD        = 0x06;
    public static final byte TAC_PLUS_AUTHEN_SVC_X25         = 0x07;
    public static final byte TAC_PLUS_AUTHEN_SVC_NASI        = 0x08;
    public static final byte TAC_PLUS_AUTHEN_SVC_FWPROXY     = 0x09;



}
