/**
 * 
 */
package com.bridgePhone.dbconnections;

import java.sql.*;

import com.bridgePhone.dbconnections.DbVariables;

/**
 * @author Wanfadger8
 *
 */
public class DBConnection implements DbVariables{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  if(DBConnection.getConnection() !=null) {
	  System.out.println("connection successfully got");
  }else {
	  System.out.println("connection failed");
  }
	}
	
	//connection methods returns connection
	public static Connection getConnection() {
    Connection conn = null;
    try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(CONNECTION_URL , USERNAME , PASSWORD);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return conn;
    }//end of connection method


}//end of class

