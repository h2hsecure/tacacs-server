package com.telcolic.tserver.persistance.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by h2e on 15/06/16.
 */
public class HsqlAdapter {

    public HsqlAdapter() {
        try {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
