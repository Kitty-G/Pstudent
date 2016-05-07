/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.databasecontrol.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ConnectDatabase {

    private static Connection connection = null;

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "aptx4869");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getInstance() {
        if (connection == null) {
            init();
        }
        return connection;
    }
}
