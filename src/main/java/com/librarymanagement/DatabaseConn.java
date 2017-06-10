/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author SruthiReddy Connection Class to connect to MySQL
 */
public class DatabaseConn {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String USER = "SRUTHI";
    static final String PASS = "password";
    Connection conn = null;
    private static DatabaseConn sqlConn;
    private static Logger logger = Logger.getLogger(Connection.class.getName());

    private static DatabaseConn getInstance() {
        if (sqlConn == null) {
            sqlConn = new DatabaseConn();
        }
        return sqlConn;
    }

    public void setConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            logger.log(Level.INFO, "Connected");
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private boolean verifyUserCreds(String UserId, String Password) {
        try {
            String sql;
            sql = "select * from test.student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String studentid = rs.getString("stid");
                String studentpassword = rs.getString("password");
                if (studentid.equals(UserId) && studentpassword.equals(Password)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean verifyLibrarianCreds(String UserId, String Password) {
        try {
            String sql = "select * from test.staff";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String Username = rs.getString("staffid");
                String password = rs.getString("spassword");
                if (Username.equals(UserId) && password.equals(Password)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String args[]) {
        DatabaseConn db = DatabaseConn.getInstance();
        db.setConnection();
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
