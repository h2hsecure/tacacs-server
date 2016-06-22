package com.telcolic.tserver.persistance.impl;

import com.telcolic.tserver.persistance.NasAdapter;
import com.telcolic.tserver.persistance.SessionAdapter;
import com.telcolic.tserver.persistance.UserAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by h2e on 15/06/16.
 */
public class HsqlAdapter implements NasAdapter, SessionAdapter, UserAdapter {

    public HsqlAdapter() {
        try {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
            Statement statement = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findNas(String name) {
        return 0;
    }
}
