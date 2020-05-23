<%@page import="com.classes.ControllStructure"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Change weight of Control Structures</title>

<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css" rel="stylesheet">

</head>
<body>
<header>
		
	<!--Navbar-->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark special-color-dark">
		<!-- Collapse button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#basicExampleNav" aria-controls="basicExampleNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- Collapsible content -->
		<div class="collapse navbar-collapse" id="basicExampleNav">

			<!-- Links -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="fileUpload.jsp">Home</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Change Control Structures Weight<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="controlStructure.jsp">Control Structure Complexity</a></li>
			</ul>
			<!-- Links -->
		</div>
		<!-- Collapsible content -->
	</nav>

	<!-- ---------------------------- End of Nav ----------------------------- -->
		
		</header>


	<!-- ------------------------------- Table ------------------------------- -->
	
	<div class="container-fluid pt-5">

		<div class="container text-center pt-4">
			<div class="row">
				<div class="col">
					<p class="h4 mb-4">Change Default Weight of Size control</p>
				</div>
			</div>
		</div>

		<form action="WeightControlStructureServlet" method=POST class="text-center border border-light p-5">
			<div class="container">
				<div class="row">
					<div class="col">
						<table class="table table-hover text-center table-bordered">
							<tr class='black white-text'>
								<th>Control Structure Type</th>
								<th>Weight</th>
							</tr>
							<tr>
								<td>A conditional control structure such as an if or else-if condition</td>
								<td><input type="text" name="weightIf" value=2 style="width: 100px;"></td>
							</tr>
							<tr>
								<td>An iterative control structure such as a for, while, or do-while loop</td>
								<td><input type="text" name="weightCase" value=3 style="width: 100px;"></td>
							</tr>
							<tr>
								<td>The switch statement in a switch_case control structure</td>
								<td><input type="text" name="weightCase" value=2 style="width: 100px;"></td>
							</tr>
							<tr>
								<td>Each case statement in a switch-case control structure</td>
								<td><input type="text" name="" value=1 style="width: 100px;"></td>
							</tr>

						</table>
					</div>
				</div>

				<div class="row">
					<div class="col">
						<div>
							<input class="btn btn-dark-green btn-sm" type="submit" name="submit" value="save" style="float:right">
						</div>
					</div>
				</div>
			</div>
		</form><br>

	</div>
	
	<footer class="page-footer font-small special-color-dark pt-5">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">Complexity Tool</div>
		<!-- Copyright -->

	</footer>
	
</body>
</html>