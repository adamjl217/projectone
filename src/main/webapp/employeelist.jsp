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
	<%@ page import="java.time.LocalDate" %>
	<%@ page import="com.revature.factory.Reimbursement"%>
	<%@ page import="com.revature.daoservice.EmployeeDaoService"%>
	<%@ page import="com.revature.daoservice.ReimbursementDaoService"%>
	<%@ page import="java.util.List"%>

	<%
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		List<Employee> employeelist = EmployeeDaoService.getAllEmployees();
		List<Employee> managerlist = EmployeeDaoService.getAllManagers();
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
				<li><a class="btn btn-default" href="./reimbursementpage.jsp" role="button">Reimbursements</a></li>
				<li><a class="btn btn-default" href="./employeelist.jsp" role="button">Employee Info</a></li>
			</ul>
			<ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-3">
                <li><a href="./logout.jsp">Log Out <span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>	
		</nav>
	</div>



	<!-- Breadcrumb -->
	<div class="container">
		<ol class="breadcrumb">

		</ol>
	</div>
	
				<% if(employee.isManagerstatus()){ %>
				
	
	<div class="container well">
		<div class="container col-md-12">
			<button type="button" class="btn btn-info col-md-offset-1" onclick="hideEmployeesButton()">List Employees</button>
			<button type="button" class="btn btn-info" onclick="hideManagersButton()">List Managers</button>
		
			<br><br>
			<div id="infoEmployeesButton" style="display: none;">
					<div class="col-md-12">
					<h3>Here is a list of employees:</h3>
					  <input class="form-control" id="employee_Filter" type="text" placeholder="Filter list here">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>User Name</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Phone Number</th>
									<th>Email</th>
									<th>Date Hired</th>
								</tr>
							</thead>	
							<tbody id="employee_Table">

							</tbody>
						</table>
					</div>
				</div>

			<div id="infoManagersButton" style="display: none;">
				<div class="col-md-12">
				<h3>Here is a list of managers:</h3>
  				<input class="form-control" id="manager_Filter" type="text" placeholder="Filter list here">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>User Name</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Phone Number</th>
								<th>Email</th>
								<th>Date Hired</th>
							</tr>
						</thead>	
						<tbody id="manager_Table">
						
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	

	
	
	<% }else{ %>	
	<div class="container well">
		<h2>You can't fool me! You're not even a manager!</h2>
		<h4>Only managers can view the employee list</h4>
	</div>
	<% } %>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
		  $("#employee_Filter").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#employee_Table tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
	<script >
		$(document).ready(function(){
		  $("#manager_Filter").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#manager_Table tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
	
	<script src="./js/getmanagerlist.js"></script>
	<script src="./js/hideemployeebutton.js"></script>
	<script src="./js/hidemanagerbutton.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
	