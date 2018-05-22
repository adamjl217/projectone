<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project One Welcomepage</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="./stylesheet.css">
</head>

	<%@ page import="com.revature.model.Employee"%>
	<%
	boolean loggedin = false;
	boolean managerstatus = false;
	try{
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		if(employee != null){
			loggedin = true;
			if(employee.isManagerstatus()){
				managerstatus = true;
			}
		}
	} catch(ClassCastException cce){
		cce.getMessage();
	}
	
	%>

	<!-- Main Navbar -->
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-header col-md-1">
				<a href="./ERS.jsp" class="navbar-brand">ERS</a>
			</div>
			<ul class="navbar-nav nav col-md-10">
				<li><a href="./home.jsp">Home</a></li>
				<li><a href="./about.jsp">About</a></li>
				<li><a href="./services.jsp">Services</a></li>
				<li><a href="./contact.jsp">Contact</a></li>
				<li><a class="btn btn-default" href="./reimbursementpage.jsp" role="button">Reimbursements</a></li>
				<% if(managerstatus){ %>
				<li><a class="btn btn-default" href="./employeelist.jsp" role="button">Employee Info</a></li>
				<% } %>
			</ul>
			<ul class="navbar-nav nav navbar-right col-md-offset-3">
                <li class="active"><a href="./logout.jsp">Log Out <span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>	
		</nav>
	</div>

	<div class="container">
		<div class="well col-md-6 col-md-offset-2">
			<h2 class="col-md-offset-2">Click below to log out</h2>
			<form action="./login.jsp" method="post">
				<div class="button-group col-md-offset-2">
					<input type="submit" class="btn btn-danger col-md-offset-3" value="Log Off">
				</div>
			</form>
		</div>	
	</div>

</body>

</html>