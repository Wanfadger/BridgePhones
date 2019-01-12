<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/BridgePhones/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary"> <a
		class="navbar-brand" href="/BridgePhones/index.jsp">Bridge
		Phone(SAMSUNG)</a>

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item "><a class="nav-link"
				href="/BridgePhones/index.jsp">Products <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link active"
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

	<div class="container mt-2 ">
	<p class="text-danger">
			 <% 
			 if(request.getQueryString()!=null){
				 out.print(request.getParameter("error"));
			 }
			 %>
			 </p>
		<form method="POST" action="addproduct"  >
			<div class="form-group row">
				<label for="colFormLabelSm"
					class="col-sm-2 col-form-label col-form-label-sm">Name</label>
				<div class="col-sm-4">
					<input type="text" name="name" class="form-control form-control-sm"
						id="colFormLabelSm" placeholder="enter product name">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="colFormLabelSm"
					class="col-sm-2 col-form-label col-form-label-sm">Category</label>
				<div class="col-sm-4">
					<input type="text" class="form-control form-control-sm"
						id="colFormLabelSm" name="category" placeholder="enter product category">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="colFormLabelSm"
					class="col-sm-2 col-form-label col-form-label-sm">Brand</label>
				<div class="col-sm-4">
					<input type="text" class="form-control form-control-sm"
						id="colFormLabelSm" placeholder="enter product brand" name="brand" >
				</div>
			</div>
			
			<div class="form-group row">
				<label for="colFormLabelSm"
					class="col-sm-2 col-form-label col-form-label-sm">quantity</label>
				<div class="col-sm-4">
					<input type="number" class="form-control form-control-sm"
						id="colFormLabelSm" placeholder="enter product quantity" name="quantity" >
				</div>
			</div>
			
			<div class="form-group row">
				<input role="btn" class="btn btn-primary btn-sm offset-2" type="submit" value="Add Product" >
				<input role="btn" class="btn btn-warning btn-sm ml-2" type="reset" value="reset">
			</div>
			
		</form>
	</div>
</body>
</html>