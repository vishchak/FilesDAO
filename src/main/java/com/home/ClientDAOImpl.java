package com.home;

import java.sql.Connection;

public class ClientDAOImpl extends AbstractDAO<Files> {
    public ClientDAOImpl(Connection conn, String table) {
        super(conn, table);
    }
}
