<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/BridgePhones/bootstrap/css/bootstrap.min.css">
</head>
<body>


	<div class="class="container mt-5">
		
			<div  class="offset-lg-4 offset-sm-2">
			<h4 class="offset-lg-2">User Login</h4>
			<p class="text-danger">
			 <% 
			 if(request.getQueryString()!=null){
			  out.print(request.getParameter("error"));
			 }
			 %>
			 </p>
			<form action="login" method="POST">
				<div class="form-group row">
					<label for="username"
						class="col-sm-2 col-form-label col-form-label-sm">Username</label>
					<div class="col-sm-4">
						<input type="text" class="form-control form-control-sm"
							id="username" placeholder="enter username" name="username"
							name="username">
					</div>
				</div>

				<div class="form-group row">
					<label for="password"
						class="col-sm-2 col-form-label col-form-label-sm">Password</label>
					<div class="col-sm-4">
						<input type="password" class="form-control form-control-sm"
							id="password" placeholder="enter password" name="password"
							name="password">
					</div>
				</div>



				<div class="form-group offset-2">
					<button type="submit" name="submit"
						class="btn btn-primary mr-1 btn-sm">Login</button>
					<button type="reset" name="reset" class="btn btn-danger btn-sm">Reset</button>
				</div>
			</form>
			</div>
	
	</div>

</body>
</html>