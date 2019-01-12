package com.bridgePhone.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgePhone.dao.ProductDao;
import com.bridgePhone.model.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String cat = req.getParameter("category");
		String brand = req.getParameter("brand");
		String qty = req.getParameter("quantity");
		String id = req.getParameter("id");
		String ERROR = null;//to hold error message
		
		if(!name.isEmpty()  && !cat.isEmpty() && !brand.isEmpty() && !qty.isEmpty() && !id.isEmpty()) {
	
			///getting already existing stock
			int oldStock = ProductDao.getProductQuantity(name.toLowerCase().trim());
			//note string conversion to an int before performing addition
			int newStock = oldStock + Integer.parseInt(qty);
			//having got the change in stock , now its ready to update
			Product product = new Product();
			product.setId(Integer.parseInt(id));
			product.setBrand(brand);
			product.setCategory(cat);
		    product.setQuantity(newStock);
		    product.setName(name);
		   
		    
		 
		    	 
	             if(ProductDao.updateProductBy(product)) {
	            	 System.out.println("product successfully added");
	            	 resp.sendRedirect("/BridgePhones/index.jsp");
	             }else {
	            	 System.out.println("failed to add product");
	            	 ERROR="failed to add product";
	            	 resp.sendRedirect("/BridgePhones/index.jsp?error="+ERROR);
	             }
		    
			
		}else {
			System.out.println("please fill all the fields");
			resp.sendRedirect("/BridgePhones/index.jsp");
		}
		
		
	}


    




}
