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
	<%@ page import="com.revature.factory.Reimbursement"%>
	<%@ page import="com.revature.daoservice.EmployeeDaoService"%>
	<%@ page import="com.revature.daoservice.ReimbursementDaoService"%>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.Scanner" %>
	<%@ page import="java.io.InputStream" %>


	<%
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		List<Reimbursement> reimbursementlist = ReimbursementDaoService.getAllReimbursements();
	%>
	<%
	boolean loggedin = false;
	boolean managerstatus = true;
	try{
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpResponse.setHeader("Pragma","no-cache"); 
		httpResponse.setDateHeader ("Expires", 0); 
		if (session.getAttribute("authorizedUser") == null ) {                               
										 response.sendRedirect("/invalidSession.jsp");
										 return;
		 }


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
				<li><a class="btn btn-default" href="./reimbursementpage.jsp" role="button">Reimbursements</a></li>
				<% if(employee.isManagerstatus()){ %>
				<li><a class="btn btn-default" href="./employeelist.jsp" role="button">Employee Info</a></li>
				<% } %>			
			</ul>
			<ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-3">
                <li><a href="./logout.jsp">Log Out <span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>	
		</nav>
	</div>



	
	
	<div class="container well">
		<div class="col-md-12">
			<h2>Reimbursements Homepage</h2>
		</div>
		<button type="button" class="btn btn-info col-md-offset-1" onclick="hideButton()">Add New Reimbursement</button>
		<% if(employee.isManagerstatus()){ %>
		<button type="button" class="btn btn-info col-md-offset-1" onclick="hideReimbursementsButton()">List Reimbursements</button>
		<button type="button" class="btn btn-info col-md-offset-1" onclick="hidePendingButton()">Approve/Deny Reimbursements</button>
		<% } else{  %>
		<button type="button" class="btn btn-info col-md-offset-1" onclick="hideReimbursementsButton()">List Your Reimbursements</button>
		<% } %>
		<br><br>
		
		<div id="infoUpdateButton" style="display: none;">
			<h3>Adding reimbursement:</h3>
			<form action="rewreimbursement.do" enctype="multipart/form-data" method="post">
				<div class="form-group">
					    <label for="categoryselect">Category</label>
					    <select class="form-control" name="categoryselect" id="categoryselect" required>
					      <option>Food</option>
					      <option>Lodging</option>
					      <option>Travel</option>
					      <option>Other</option>
					    </select>
				</div>
				<div class="form-group">
				
				</div>
				<div class="form-group">
					<label for="reimbursementamount">Enter the amount: </label> 
					<input type="number" step=".01" name="reimbursementamount" class="form-control" required>
				</div>
				<div class="form-group">
					<label for="receiptimage">Image of receipt</label>
				    <input onchange="ValidateSize(this)" type="file" name="receiptimage" id="receiptimage" accept=".jpg, .jpeg, .png">
				</div>
				<input type="submit" class="form-control btn btn-success" enctype="multipart/form-data" value="Submit Form">
			</form>
		</div>
		
		<% if(employee.isManagerstatus()){ %>

		<div id="infoReimbursementButton" style="display: none;">
			<div class="col-md-12">
				<h3>Here is a list of all reimbursements:</h3>
  				<input class="form-control" id="reimbursement_Filter" type="text" placeholder="Filter list here">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Category</th>
								<th>Amount</th>
								<th>Requestor ID</th>
								<th>Approver ID</th>
								<th>Status</th>
								<th>Reason</th>
								<th>Time Made</th>
								<th>Time Approved</th>
								<th>Image</th>
							</tr>
						</thead>	
						<tbody id="reimbursement_Table">
						<%
							for (Reimbursement r : reimbursementlist) {
								if (r.getStatus().equals("pending")) {
						%>
						<tr>
							<td><%=r.getId()%></td>
							<td><%=r.getCategory()%></td>
							<td><%=r.getAmount()%></td>
							<td><%=r.getRequestor_id()%></td>
							<td> </td>
							<td><%=r.getStatus()%></td>
							<td></td>
							<td><%=r.getTimemade().toGMTString()%></td>
							<td> </td>
							<td><%if(r.getImagestring() != null){ %>
								<img id="myImg" height="42" width="42" src="data:image/png;base64,<%=r.getImagestring() %>"> 
								<% } %>
							</td>
						</tr>
						<% } else { %>
						<tr>
							<td><%=r.getId()%></td>
							<td><%=r.getCategory()%></td>
							<td><%=r.getAmount()%></td>
							<td><%=r.getRequestor_id()%></td>
							<td><%=r.getApprover_id() %></td>
							<td><%=r.getStatus()%></td>
							<td><%=r.getReason() %></td>
							<td><%=r.getTimemade().toGMTString()%></td>
							<td><%=r.getTimeapproved().toGMTString()%></td>
							<td><%if(r.getImagestring() != null){ %>
								<img id="myImg" height="42" width="42" src="data:image/png;base64,<%=r.getImagestring() %>"> 
								<% } %>
							</td>						
						</tr>
						<% } %>
						<% } %>
						</tbody>
					</table>
			</div>
		</div>
		
		<% } else { %>
		<div id="infoReimbursementButton" style="display: none;">
			<div class="col-md-12">
				<h3>Here is a list of all your reimbursements:</h3>
  				<input class="form-control" id="reimbursement_Filter2" type="text" placeholder="Filter list here">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Category</th>
								<th>Amount</th>
								<th>Requestor ID</th>
								<th>Approver ID</th>
								<th>Status</th>
								<th>Reason</th>
								<th>Time Made</th>
								<th>Time Approved</th>
								<th>Image</th>
							</tr>
						</thead>	
						<tbody id="reimbursement_Table2">
						<%
							for (Reimbursement r : reimbursementlist) {
								if(r.getRequestor_id() == employee.getId()){
						%>
						<% if (r.getStatus().equals("pending")) { %>
						<tr>
							<td><%=r.getId()%></td>
							<td><%=r.getCategory()%></td>
							<td><%=r.getAmount()%></td>
							<td><%=r.getRequestor_id()%></td>
							<td> </td>
							<td><%=r.getStatus()%></td>
							<td></td>
							<td><%=r.getTimemade().toGMTString()%></td>
							<td> </td>
							<td><%if(r.getImagestring() != null){ %>
								<img id="myImg" height="42" width="42" src="data:image/png;base64,<%=r.getImagestring() %>"> <% } %>
							</td>								<tr>
						<% } else { %>
						<tr>
							<td><%=r.getId()%></td>
							<td><%=r.getCategory()%></td>
							<td><%=r.getAmount()%></td>
							<td><%=r.getRequestor_id()%></td>
							<td><%=r.getApprover_id() %></td>
							<td><%=r.getStatus()%></td>
							<td><%=r.getReason() %></td>
							<td><%=r.getTimemade().toGMTString()%></td>
							<td><%=r.getTimeapproved().toGMTString()%></td>
							<td><%if(r.getImagestring() != null){ %>
								<img id="myImg" height="42" width="42" src="data:image/png;base64,<%=r.getImagestring() %>"> <% } %>
							</td>								<tr>
						<% } %>
						<% } %>
						<% } %>
						</tbody>
					</table>
			</div>
		</div>
		
		<% } %>
		
		<div id="infoPendingButton" style="display: none;">
		
			<div class="col-md-12">
				<h2>Please note, if you made a request, another manager is required to approve it.</h2>
				<h2>You can only approve or deny one request at a time!</h2>
				<h3>Here is a list of pending reimbursements:</h3>
  				<input class="form-control" id="pending_Filter2" type="text" placeholder="Filter list here">
				<form action="/ProjectOneWeb/ReimbursementApprovalServlet" method="POST">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Category</th>
								<th>Amount</th>
								<th>Requestor ID</th>
								<th>Time Made</th>
								<th>Image</th>
							</tr>
						</thead>	
						<tbody id="pending_Table2">
						<%
							for (Reimbursement r : reimbursementlist) {
								if(r.getStatus().equals("pending")){
						%>
						<tr>
							<td><%=r.getId()%></td>
							<td><%=r.getCategory()%></td>
							<td><%=r.getAmount()%></td>
							<td><%=r.getRequestor_id()%></td>
							<td><%=r.getTimemade().toGMTString()%></td>
							<td><%if(r.getImagestring() != null){ %>
								<img id="myImg" height="42" width="42" src="data:image/png;base64,<%=r.getImagestring() %>"> <% } %>
							</td>		
						<% if(r.getRequestor_id() != employee.getId()){ 
						%>
								<td><input type="radio" id="ap" name="approval" value=<%="approved" + r.getId() + r.getCategory()%>>
								<label for="Approve">Approve</label></td>
								<td><input type="radio" id="de" name="approval" value=<%="rejected" + r.getId() + r.getCategory()%>>
								<label for="Reject">Reject</label></td>
								<td><input type="text" name="reasongiven" class="form-control" placeholder="Explain your reasoning here..">
						<% } %>
						</tr>
						<% } }%>
				
					</tbody>
	
					</table>
					<div class="button-group">
						<input type="submit" class="btn btn-success" value="Submit Form">
					</div>
				</form>	
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	window.onload = function() {
		document.addEventListener("click", ifchecked());
	}
	function ifchecked() {
	    let checked = document.getElementById("ap").checked;
	    if(checked){
	        document.getElementById("de").checked = false;
	    }
	}
	
	</script>
	<script>
		$(document).ready(function(){
		  $("#reimbursement_Filter").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#reimbursement_Table tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
		<script>
		$(document).ready(function(){
		  $("#pending_Filter").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#pending_Table tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
		<script>
		$(document).ready(function(){
		  $("#reimbursement_Filter2").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#reimbursement_Table2 tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
		<script>
		$(document).ready(function(){
		  $("#pending_Filter2").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#pending_Table2 tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
	

	<script src="./js/hidebutton.js"></script>
	<script src="./js/hidereimbursementbutton.js"></script>
	<script src="./js/hidependingbutton.js"></script>
	<script src="./js/filesizelimit.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>