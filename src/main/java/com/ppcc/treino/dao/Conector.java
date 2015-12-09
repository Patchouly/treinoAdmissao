/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ppcc.treino.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class Conector {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/treino";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "cabong";


    public static Connection createConnection() throws SQLException {
        
        Connection conn = null;
        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            conn = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return conn;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return conn;

    }
}
