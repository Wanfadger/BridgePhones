package com.bridgePhone.controller.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgePhone.dao.OwnerDao;
import com.bridgePhone.model.Owner;

/**
 * Servlet implementation class LoginOwner
 */
@WebServlet("/login")
public class OwnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username").toLowerCase().trim();
		String password = request.getParameter("password").toLowerCase().trim();
		

		 String ERROR = null;//to hold error message
		
		
		if(!username.isEmpty()  && !password.isEmpty()) {
			if(OwnerDao.loginOwner(username, password)) {
			Owner owner = OwnerDao.getOwnerByUsernameAndPassword(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("FULLNAME", owner.getFullname());
			session.setAttribute("ID", owner.getId());
			session.setAttribute("USERNAME", owner.getUsername());
			
			response.sendRedirect("/BridgePhones/index.jsp");
					
			}else {
				ERROR="invalid user name or password";
				System.out.println("invalid user name or password");
				response.sendRedirect("/BridgePhones/login.jsp?error="+ERROR);

			}
		}else {
			ERROR = "please provide username and password";
			response.sendRedirect("/BridgePhones/login.jsp?error="+ERROR);
			System.out.println("please provide username and password");
		}
	}

}
