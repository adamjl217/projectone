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
                <li>
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


    <!-- Jumbotron -->
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Employee Reimbursement System</h1>
            <p class="lead">Employing innovative technologies for innovative employers.</p>
            <hr class="my-4">
            <p>This webpage utilizes cutting-edge techniques, such as JSON coupled with AJAX, to display all the information
                ever needed by both financial managers and employees.
            </p>
            <a href="./about_out.jsp" class="btn btn-info btn-lg">Learn More</a>
        </div>
    </div>
</body>

</html>