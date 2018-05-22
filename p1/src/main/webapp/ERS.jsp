<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project One Welcomepage</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="./stylesheet.css">
</head>

<body>

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
			<ul class="navbar-nav nav col-md-8">
				<li><a href="./home.jsp">Home</a></li>
				<li><a href="./about.jsp">About</a></li>
				<li><a href="./services.jsp">Services</a></li>
				<li><a href="./contact.jsp">Contact</a></li>
				<% if(loggedin){ %>
				<li><a class="btn btn-default" href="./reimbursementpage.jsp" role="button">Reimbursements</a></li>
				<% if(managerstatus){ %>
				<li><a class="btn btn-default" href="./employeelist.jsp" role="button">Employee Info</a></li>
				<% } %>	
				<% } %>
			</ul>
			<% if(loggedin){ %>
			<ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-3">
                <li><a href="./logout.jsp">Log Out <span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>
            <% } else { %>
            <ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-2">
                <li>
                    <a href="./login.jsp">Log In
                        <span class="glyphicon glyphicon-log-in"></span>
                    </a>
                </li>
            </ul>
            <% } %>
		</nav>
	</div>


    <!-- Jumbotron -->
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Employee Reimbursement System</h1>
            <p class="lead">Employing innovative technologies for innovative employers.</p>
            <hr class="my-4">
            <p>This webpage utilizes cutting-edge techniques, such as JSON coupled with AJAX, to display all the information
                ever needed by both financial managers and employees.
            </p>
            <a href="./about.jsp" class="btn btn-info btn-lg">Learn More</a>
        </div>
    </div>
</body>

</html>