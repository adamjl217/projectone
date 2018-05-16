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


    <!-- Main Navbar -->
    <div class="container">
        <nav class="navbar navbar-inverse">
            <div class="navbar-header col-md-2 active">
                <a href="./ERS_out.jsp" class="navbar-brand">ERS</a>
            </div>
            <ul class="navbar-nav nav col-md-6">
                <li>
                    <a href="./home_out.jsp">Home</a>
                </li>
                <li>
                    <a href="./about_out.jsp">About</a>
                </li>
                <li class="active">
                    <a href="./services_out.jsp">Services</a>
                </li>
                <li>
                    <a href="./contact_out.jsp">Contact</a>
                </li>
            </ul>

            <ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-2">
                <li>
                    <a href="./login.jsp">Log In
                        <span class="glyphicon glyphicon-log-in"></span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <!-- Breadcrumb -->
    <div class="container">
        <ol class="breadcrumb">

        </ol>
    </div>
    
	<div class="container well">
		<div class="list-group">
		  	<h2>Services provided:</h2>
		  	<br>
		    <li class="list-group-item">
		      <h3 class="list-group-item-heading">Employee Services</h3>
		      <h4 class="list-group-item-text">Log in and off</h4>
		      <h4 class="list-group-item-text">Home page with your information</h4>
		      <h4 class="list-group-item-text">Update your information</h4>
		    </li>	 
		  	<br>
		    <li class="list-group-item">
		      <h3 class="list-group-item-heading">Manager Services</h3>
		      <h4 class="list-group-item-text">View manager home page</h4>
		      <h4 class="list-group-item-text">View employees</h4>
		      <h4 class="list-group-item-text">Create new employees</h4>
		    </li>		
		  	<br>
		    <li class="list-group-item">
		      <h3 class="list-group-item-heading">Reimbursements</h3>
		      <h4 class="list-group-item-text">Employees and Managers can add</h4>
		      <h4 class="list-group-item-text">Managers can view all</h4>
		      <h4 class="list-group-item-text">Managers can approve / deny</h4>
		      <h4 class="list-group-item-text">Managers cannot approve / deny their own</h4>
		    </li>			
		</div>
	</div>

</body>

</html>