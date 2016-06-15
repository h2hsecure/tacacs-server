package com.telcolic.tests;

import com.telcolic.tserver.persistance.impl.HsqlAdapter;
import org.junit.Test;

/**
 * Created by h2e on 15/06/16.
 */
public class HsqlTest {
    @Test
    public void testConnection() {
        new HsqlAdapter();

    }
}
