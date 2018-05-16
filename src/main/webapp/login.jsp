<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project One Welcomepage</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="./stylesheet.css">
</head>

	<%
		request.getSession().setAttribute("authorizedUser", "");
	%>

<body>
	<!-- Main Navbar -->
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-header col-md-2 active">
				<a href="./ERS_out.jsp" class="navbar-brand">ERS</a>
			</div>
			<ul class="navbar-nav nav col-md-6">
				<li><a href="./home_out.jsp">Home</a></li>
				<li><a href="./about_out.jsp">About</a></li>
				<li><a href="./services_out.jsp">Services</a></li>
				<li><a href="./contact_out.jsp">Contact</a></li>
			</ul>

			<ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-2">
				<li class="active"><a href="./login.jsp">Log In <span
						class="glyphicon glyphicon-log-in"></span>
				</a></li>
			</ul>
		</nav>
	</div>

	<!-- Breadcrumb -->
	<div class="container">
		<ol class="breadcrumb">

		</ol>
	</div>

	<div class="container">
		<div class="well col-md-6 col-md-offset-3">
			<h2>Login</h2>
			<form action="login.do" method="post">
				<div class="form-group">
					<input type="text" name="username" class="form-control" required
						placeholder="Username">
				</div>
				<div class="form-group">
					<input type="password" name="password" class="form-control"
						required placeholder="Password">
				</div>
				<div class="button-group">
					<input type="submit" class="btn btn-success" value="Submit">
					<input type="reset" class="btn btn-danger" value="Reset">
				</div>
			</form>
		</div>
	</div>

	

</body>

</html>