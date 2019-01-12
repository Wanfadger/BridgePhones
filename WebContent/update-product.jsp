<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bridgePhone.model.*"%>
<%@ page import="com.bridgePhone.dao.*"%>
<%@ page import="java.util.*"%>
    
    <% 
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = ProductDao.getProductById(id);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/BridgePhones/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/BridgePhones/index.jsp">Bridge Phone(SAMSUNG)</a>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="/BridgePhones/index.jsp">Products
						<span class="sr-only">(current)</span>
				</a></li>
				
				<li class="nav-item active"><a class="nav-link" href="/BridgePhones/add-product.jsp">Add Product
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
	</nav>
	
	
	<div class="container mt-2 ">
		<form action="UpdateProduct" method="POST" >
			<div class="form-group row">
				<label for="name"
					class="col-sm-2 col-form-label col-form-label-sm">Name</label>
				<div class="col-sm-4">
					<input type="text" name="name" class="form-control form-control-sm"
						id="name" placeholder="enter product name"  value="<%= product.getName() %>" >
				</div>
			</div>
			
			<div class="form-group row">
				<label for="category"
					class="col-sm-2 col-form-label col-form-label-sm">Category</label>
				<div class="col-sm-4">
					<input type="text" class="form-control form-control-sm"
						id="category" name="category" placeholder="enter product category" value="<%= product.getCategory() %>">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="brand"
					class="col-sm-2 col-form-label col-form-label-sm">Brand</label>
				<div class="col-sm-4">
					<input type="text" class="form-control form-control-sm"
						id="brand" placeholder="enter product brand" name="brand" value="<%= product.getBrand() %>" >
				</div>
			</div>
			
			<div class="form-group row">
				<label for="quantity"
					class="col-sm-2 col-form-label col-form-label-sm">quantity</label>
				<div class="col-sm-4">
					<input type="number" class="form-control form-control-sm"
						id="quantity" placeholder="enter product quantity" name="quantity" value="<%= product.getQuantity() %>" >
				</div>
			</div>
			
			<div class="form-group row">
			<input type="hidden"
						 name="id" value="<%= product.getId() %>" >
				<input role="btn" class="btn btn-primary btn-sm offset-2" type="submit" value="Edit Product" >
				<input role="btn" class="btn btn-warning btn-sm ml-2" type="reset" value="reset">
			</div>
			
		</form>
	</div>
	
</body>
</html>