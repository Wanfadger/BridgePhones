<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.bridgePhone.model.*"%>
<%@ page import="com.bridgePhone.dao.*"%>
<%@ page import="java.util.*"%>
    
    <% 
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = ProductDao.getProductById(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/BridgePhones/bootstrap/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/BridgePhones/index.jsp">Bridge
			Phone(SAMSUNG)</a>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/BridgePhones/index.jsp">Products <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item " style="float:left"><a class="nav-link"
					href="/BridgePhones/add-product.jsp">Add Product <span
						class="sr-only">(current)</span>
				</a></li>
				
				<li class="nav-item active"><a class="nav-link  "
					href="/BridgePhones/logout">Logout <span
						class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
	</nav>
<div class="container mt-3">

<center>
<h4>Product Details</h4>
<p>Name: <span><%= product.getName() %></span></p>
<p>Category: <span><%= product.getCategory() %></span></p>
<p>Brand: <span><%= product.getBrand() %></span></p>
<p>Quantity: <span><%= product.getQuantity() %></span></p>
</center>
</div>
</body>
</html>