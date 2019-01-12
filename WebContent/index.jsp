<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bridgePhone.model.*"%>
<%@ page import="com.bridgePhone.dao.*"%>
<%@ page import="java.util.*"%>

<%
	List<Product> products = ProductDao.getAllProductS();
%>

<!DOCTYPE html PUBLIC>
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

		<div class="card">

			<div class="card-body">
				<table class="table table-striped table-sm  table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Category</th>
							<th scope="col">brand</th>
							<th scope="col">Quantity</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							int count = 1;
							for (Product product : products) {
						%>

						<tr>
							<th scope="row"><%=count++%></th>
							<td><a href="/BridgePhones/product-detail.jsp?id=<%=product.getId()%>" ><%=product.getName()%></a></td>
							<td><%=product.getCategory()%></td>
							<td><%=product.getBrand()%></td>
							<td><%=product.getQuantity()%></td>

							<td><a class="btn btn-success btn-sm"
								href="/BridgePhones/update-product.jsp?id=<%=product.getId()%>"
								role="btn">Edit</a> <a class=" btn btn-danger btn-sm"
								href="DeleteProduct?id=<%=product.getId()%>" role="btn">Delete</a></td>

						</tr>

						<%
							}
						%>

					</tbody>
				</table>
			</div>
			<div class="card-footer">Bridge phone </div>
		</div>





	</div>


</body>
</html>