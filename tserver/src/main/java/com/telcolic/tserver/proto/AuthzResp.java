package com.telcolic.tserver.proto;

/**
 * Created by h2e on 15/06/16.
 *
 *
 *
 *
 *
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |    status      |     arg_cnt    |         server_msg len          |
 +----------------+----------------+----------------+----------------+
 +            data len             |    arg 1 len   |    arg 2 len   |
 +----------------+----------------+----------------+----------------+
 |      ...       |   arg N len    |         server_msg ...
 +----------------+----------------+----------------+----------------+
 |   data ...
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
public class AuthzResp {
    // Status
    public static final byte TAC_PLUS_AUTHOR_STATUS_PASS_ADD  = 0x01;
    public static final byte TAC_PLUS_AUTHOR_STATUS_PASS_REPL = 0x02;
    public static final byte TAC_PLUS_AUTHOR_STATUS_FAIL      = 0x10;
    public static final byte TAC_PLUS_AUTHOR_STATUS_ERROR     = 0x11;
    public static final byte TAC_PLUS_AUTHOR_STATUS_FOLLOW    = 0x21;
}
