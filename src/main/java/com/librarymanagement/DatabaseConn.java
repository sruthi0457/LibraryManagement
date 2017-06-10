/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.librarymanagement;
import java.sql.*;
import java.util.logging.Level;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
/**
 *
 * @author praneeth
 */
public class DatabaseConn {
    
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/test";
	static final String USER="SRUTHI";
	static final String PASS="password";
	Connection conn=null;
   private static DatabaseConn sqlconn;
   
    private static DatabaseConn getinstance(){
        if(sqlconn==null){
            sqlconn=new DatabaseConn();
        }
               
        
        return sqlconn;
    }
    public void setconnection(){
       
        
        try {
          
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to selected database");
            conn= (Connection)DriverManager.getConnection(DB_URL,USER,PASS);	
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(conn!=null)
                try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConn.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
    private boolean verifyusercreds(String UserId,String Password){
        try {
            
            String sql;
            sql = "select * from test.student";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            
                while(rs.next()){
                    String studentid=rs.getString("stid");
                    String studentpassword=rs.getString("password");
                    if(studentid.equals(UserId)&&studentpassword.equals(Password)){
                        return true;
                    }
                    else
                        return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        return false;
    
    }
    public boolean verifylibrariancreds(String UserId,String Password ){
        try{
            
            String sql="select * from test.staff";
                    
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String Username=rs.getString("staffid");
                String password=rs.getString("spassword");
                if(Username.equals(UserId)&&password.equals(Password)){
                    return true;
                }
                else
                    return false;
            }
        }catch (SQLException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
      return false;
    }

    public static void main (String args[]){
        DatabaseConn db=DatabaseConn.getinstance();
        db.setconnection();
        
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

    

