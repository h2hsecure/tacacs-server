package com.telcolic.tserver.proto;

/**
 * Created by h2e on 15/06/16.
 *
 *
 *
 *
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |         server_msg len          |            data len             |
 +----------------+----------------+----------------+----------------+
 |     status     |         server_msg ...
 +----------------+----------------+----------------+----------------+
 |     data ...
 +----------------+
 */
public class AcctResp {
    //Status
    public static final byte TAC_PLUS_ACCT_STATUS_SUCCESS    = 0x01;
    public static final byte TAC_PLUS_ACCT_STATUS_ERROR      = 0x02;
    public static final byte TAC_PLUS_ACCT_STATUS_FOLLOW     = 0x21;
}
