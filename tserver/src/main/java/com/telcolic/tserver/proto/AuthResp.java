package com.telcolic.tserver.proto;

/**
 * Created by h2e on 15/06/16.
 *
 *
 * Authentication Continue packet
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |          user_msg len           |            data len             |
 +----------------+----------------+----------------+----------------+
 |     flags      |  user_msg ...
 +----------------+----------------+----------------+----------------+
 |    data ...
 +----------------+
 *
 *
 *Authentication Reply packet
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |     status     |      flags     |        server_msg len           |
 +----------------+----------------+----------------+----------------+
 |           data len              |        server_msg ...
 +----------------+----------------+----------------+----------------+
 |           data ...
 +----------------+----------------+
 */
public class AuthResp {
    // Status
    public static final byte TAC_PLUS_AUTHEN_STATUS_PASS     = 0x01;
    public static final byte TAC_PLUS_AUTHEN_STATUS_FAIL     = 0x02;
    public static final byte TAC_PLUS_AUTHEN_STATUS_GETDATA  = 0x03;
    public static final byte  TAC_PLUS_AUTHEN_STATUS_GETUSER  = 0x04;
    public static final byte TAC_PLUS_AUTHEN_STATUS_GETPASS  = 0x05;
    public static final byte TAC_PLUS_AUTHEN_STATUS_RESTART  = 0x06;
    public static final byte TAC_PLUS_AUTHEN_STATUS_ERROR    = 0x07;
    public static final byte TAC_PLUS_AUTHEN_STATUS_FOLLOW   = 0x21;

    //Flags
    public static final byte TAC_PLUS_REPLY_FLAG_NOECHO      = 0x01;
    public static final byte TAC_PLUS_CONTINUE_FLAG_ABORT    = 0x01;


}
