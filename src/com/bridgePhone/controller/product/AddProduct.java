package com.bridgePhone.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgePhone.dao.ProductDao;
import com.bridgePhone.model.Owner;
import com.bridgePhone.model.Product;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	

    
    





	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	;
		 
		String name = req.getParameter("name");
		String cat = req.getParameter("category");
		String brand = req.getParameter("brand");
		String qty = req.getParameter("quantity");
		
		 String ERROR = null;//to hold error message
		if(!name.isEmpty() && !cat.isEmpty() && !brand.isEmpty() && !qty.isEmpty() ) {
			Product product = new Product();
			product.setBrand(brand.toLowerCase().trim());
			product.setCategory(cat.toLowerCase().trim());
			product.setName(name.toLowerCase().trim());
			product.setQuantity(Integer.parseInt(qty));
			//product owner
			Owner owner = new Owner();
			HttpSession session = req.getSession();
			 int id =(Integer)session.getAttribute("ID");
			 owner.setId(id);
			 product.setOwner(owner);
			 
			
			if(!ProductDao.checkIfProductExits(product.getName())) {
				if(ProductDao.addProduct(product)){
				  System.out.println("product successfully added");
				  resp.sendRedirect("/BridgePhones/index.jsp");
				}else {
					ERROR = "failed to add product";
					System.out.println("failed to add product");
					resp.sendRedirect("/BridgePhones/add-product.jsp?error="+ERROR);
				}
				
			}else {
				ERROR = "product already exists";
				System.out.println("product already exists");
				resp.sendRedirect("/BridgePhones/add-product.jsp?error="+ERROR);
			}
			
			
		}else {
			ERROR = "please fill all the fields";
			System.err.println("please fill all the fields");
			resp.sendRedirect("/BridgePhones/add-product.jsp?error="+ERROR);
		}
	}

	
	


}
