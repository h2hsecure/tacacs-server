package com.telcolic.tserver.proto;

import java.io.Serializable;

/**
 * Created by h2e on 15/06/16.
 *
 *
 1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8  1 2 3 4 5 6 7 8

 +----------------+----------------+----------------+----------------+
 |      flags     |  authen_method |    priv_lvl    |  authen_type   |
 +----------------+----------------+----------------+----------------+
 | authen_service |    user len    |    port len    |  rem_addr len  |
 +----------------+----------------+----------------+----------------+
 |    arg_cnt     |   arg 1 len    |   arg 2 len    |      ...       |
 +----------------+----------------+----------------+----------------+
 |   arg N len    |    user ...
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
public class AcctReq implements Serializable {
    public static final byte TAC_PLUS_ACCT_FLAG_MORE     = 0x01; //(deprecated)
    public static final byte TAC_PLUS_ACCT_FLAG_START    = 0x02;
    public static final byte TAC_PLUS_ACCT_FLAG_STOP     = 0x04;
    public static final byte TAC_PLUS_ACCT_FLAG_WATCHDOG = 0x08;
}
