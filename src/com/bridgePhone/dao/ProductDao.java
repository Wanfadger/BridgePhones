package com.bridgePhone.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bridgePhone.dbconnections.DBConnection;
import com.bridgePhone.model.Owner;
import com.bridgePhone.model.Product;



public class ProductDao {

	public static void main(String[] args) {
		//product owner
		Owner owner = new Owner();
		owner.setId(1);
		//add product
		Product product = new Product("sam sung galaxy", "smart phone", "samsung", 4, owner);
		product.setOwner(owner);
		
	
		
///		System.out.println("current stock "+stock);
		
	
		
//		if(ProductDao.addProduct(product)) {
//			System.out.println("success");
//		}else {
//			System.out.println("failed");
//		}
//		
		
		//check product name

//		if(ProductDao.checkIfProductExits(product.getName())) {
//			int existingStock = ProductDao.getProductQuantity(product.getName());
//			int newStock = existingStock+product.getQuantity();
//		     product.setQuantity(newStock);
//			ProductDao.updateProductBy(product);
//			System.out.println("updated stock");
//			
//		}else {
//			ProductDao.addProduct(product);
//			System.out.println("new product");
//		}
		
//		List<Product> products = ProductDao.getAllProductS();
//		for (Product product2 : products) {
//			System.out.println("name "+product2.getName() +" qty "+product2.getQuantity() );
//		}
//	
//		product.setId(3);
//
//		if(ProductDao.deleteProductById(3)) {
//			System.out.println("success");
//		}else {
//			System.out.println("failed");
//		}
		
		
		//if(ProductDao.updateProductBy(product)) {
//			System.out.println("success");
//		}else {
//			System.out.println("faild");
//		}
	
		////add to existing update stock 
		//add new insert 
		
		
		
	}
	
	
	public static boolean addProduct(Product product) {
		boolean status = false;
		//getting connection 
		Connection conn = DBConnection.getConnection();
		//query
		String sql = "INSERT INTO product (product_name , product_category , product_brand , product_quantity , owner_id ) VALUES(?,?,?,?,?)";
		
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			//bind parameters
			pst.setString(1, product.getName());
			pst.setString(2, product.getCategory() );
			pst.setString(3, product.getBrand());
			pst.setInt(4, product.getQuantity());
			pst.setInt(5, product.getOwner().getId());
			//run query
			status = (pst.executeUpdate()>0)?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	
	public static boolean checkIfProductExits(String productName) {
		boolean status = false;
		
				//get connection 
		Connection conn = DBConnection.getConnection();
		//query
		String sql = "SELECT * FROM product WHERE product_name=?";
		//statement
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			//bind parameter
			pst.setString(1, productName);
			//run
			ResultSet rs = pst.executeQuery();
			 
		  status = rs.next();//returns true if the resultset contains roe of data
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return status;
				
	}
	
	
	public static int getProductQuantity(String productName) {
		int stock = 0;
		//get connection 
		Connection conn = DBConnection.getConnection();
		//query
		String sql = "SELECT product_quantity FROM product WHERE product_name=?";
		//statement
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			//bind parameter
			pst.setString(1, productName);
			//run
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				stock = rs.getInt("product_quantity");
			}
		  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stock;
	}
	
	
	public static Product getProductById(int id) {
		Product product= new Product();
		//get connection 
		Connection conn = DBConnection.getConnection();
		//query
		String sql = "SELECT * FROM product WHERE product_id=?";
		//statement
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			//bind parameter
			pst.setInt(1, id);
			//run
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				product.setName(rs.getString("product_name"));
	    		product.setBrand(rs.getString("product_brand"));
	    		product.setCategory(rs.getString("product_category"));
	    		product.setQuantity(rs.getShort("product_quantity"));
	    		product.setId(rs.getInt("product_id"));	
			}
		 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	public static List<Product> getAllProductS(){
		List<Product> products = new ArrayList<>();
		//dbConnection
	    Connection conn = DBConnection.getConnection();
	    //sql query
	    String sql = "SELECT * FROM product";
	    //creating statement
	    PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery();
			    
			    if(rs.isBeforeFirst()) {
			    	while(rs.next()) {
			    		Product product = new Product();
			    		product.setName(rs.getString("product_name"));
			    		product.setBrand(rs.getString("product_brand"));
			    		product.setCategory(rs.getString("product_category"));
			    		product.setQuantity(rs.getShort("product_quantity"));
			    		product.setId(rs.getInt("product_id"));
			    		///store each product into the products list
			    		products.add(product);
			    	}
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //result and run query
	   
	    return products;
	}
	
	
	public static boolean deleteProductById(int productId) {
       boolean status = false;
		
		//get connection 
		Connection conn = DBConnection.getConnection();
		//sql query
		String sql = "DELETE  FROM product  WHERE product_id=?";
		//statement
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			//bind id
			pst.setInt(1, productId);
			//run the query
			status = (pst.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public static boolean updateProductBy(Product product) {
		boolean status = false;
		//get connection
Connection conn = DBConnection.getConnection();
//query
	String sql = "UPDATE product  SET  product_name=? , product_category=? , product_brand=? , product_quantity=? WHERE product_id =?";
//statement
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
		//bind category
		pst.setString(1, product.getName());
		pst.setString(2, product.getCategory());
		pst.setString(3, product.getBrand());
		pst.setInt(4 ,  product.getQuantity());
		pst.setInt(5, product.getId());
		//run query
		status = (pst.executeUpdate()>0)?true:false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
return status;	
	}
	
	
	
	
	
	
	
}
