package com.bridgePhone.dao;

import java.sql.*;

import com.bridgePhone.dbconnections.DBConnection;
import com.bridgePhone.model.Owner;

public class OwnerDao {
	
	public static void main(String[] args) {
		
		//testing create owner
		
		Owner owner = new Owner("Galiwango fahad ", "wanfadger", "123");
//		if(OwnerDao.registerOwner(owner)) {
//			System.out.println("success");
//		}else {
//			System.out.println("failed");
//		}
		
//		if(OwnerDao.loginOwner(owner.getUsername() , owner.getPassword())) {
//			
//			System.out.println("valid user");
//			
//		}else {
//			System.out.println("invalid user");
//		}
//		
//		Owner own = OwnerDao.getOwnerByUsernameAndPassword(owner.getUsername(), owner.getPassword());
//		System.out.println("fullname "+own.getFullname() + " username "+own.getUsername());
//		
		
	}
	
	
	private static boolean registerOwner(Owner owner) {
		boolean status = false;
		//getting Connection
		Connection conn = DBConnection.getConnection();
		//query
		String sql = "INSERT INTO owner (fullname , username , password) VALUES (?,?,?)";
		//statement
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			//binding values
			pst.setString(1, owner.getFullname());
			pst.setString (2, owner.getUsername());
			pst.setString(3, owner.getPassword());
			//running query
			status = (pst.executeUpdate()>0)?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	
	
	public static boolean loginOwner(String username , String password) {
	  boolean	status = false;
		Owner owner = null;
		//get connection 
		Connection conn = DBConnection.getConnection();
		//query
		String sql = "SELECT * FROM owner WHERE username=?  AND password=?";
		//statement
		try {
			PreparedStatement pst  = conn.prepareStatement(sql);
			//bind variable
			pst.setString(1, username);
			pst.setString(2, password);
			//run query
			ResultSet rs = pst.executeQuery();
			status =  rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status; 
	}
	
	
	
	public static Owner getOwnerByUsernameAndPassword(String username , String password) {
		  
			Owner owner = null;
			//get connection 
			Connection conn = DBConnection.getConnection();
			//query
			String sql = "SELECT * FROM owner WHERE username=?  AND password=?";
			//statement
			try {
				PreparedStatement pst  = conn.prepareStatement(sql);
				//bind variable
				pst.setString(1, username);
				pst.setString(2, password);
				//run query
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					owner = new Owner();
					owner.setFullname(rs.getString("fullname"));
					owner.setUsername(rs.getString("username"));
					owner.setId(rs.getInt("owner_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return owner; 
		}
	
	
	

}
