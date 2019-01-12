package com.bridgePhone.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgePhone.dao.ProductDao;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		 String ERROR = null;//to hold error message
		if(id.isEmpty()) {
			//note String 'id' conversion from string to int, before passing it as an argument 
			if(ProductDao.deleteProductById(Integer.parseInt(id))) {
				System.out.println("successfully deleted");
				response.sendRedirect("/BridgePhones/index.jsp");
				
			}else {
				ERROR = "failed to delete";
				response.sendRedirect("/BridgePhones/index.jsp?error="+ERROR);
				System.out.println("failed to delete");
			}			
		}else {
			System.out.println("unknown product");
			ERROR = "unknown product";
			response.sendRedirect("/BridgePhones/index.jsp?error="+ERROR);
		}
			
	}


}
