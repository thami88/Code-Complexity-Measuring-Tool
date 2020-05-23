<%@page import="com.classes.FileUpload"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home</title>

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
				<li class="nav-item active"><a class="nav-link" href="fileUpload.jsp">Home<span class="sr-only">(current)</span></a></li>
			</ul>
			<!-- Links -->
		</div>
		<!-- Collapsible content -->
	</nav>

	<!-- ---------------------------- End of Nav ----------------------------- -->

	</header>
	
		<div class="container-fluid pt-5">

		<div class="container text-center pt-5">
			<div class="row">
				<div class="col">
					<p class="h4 mb-4">Upload Files</p>
				</div>
			</div>
		</div>
		
		<form action='FileSelectServlet' class="border border-light">
			<%
			FileUpload fu = new FileUpload();
			out.print(fu.getFileList());
			%>

		</form>
		
	<div class="container">
		<form action="codeServlet" method=POST class="border border-light">
		
			<div class="textarea" style="margin-left: 50px;">
				<textarea readonly="readonly" name="code" rows="20" cols="70" placeholder="CODE..." Style="">${tb}</textarea>
			</div>
			
			<div style="margin-left: 50px">
			
				<div class="btn-group">
					<input class="btn btn-dark-green btn-sm" type="submit" name="button" value="Size">
				</div>

				<div class="btn-group">
					<input class="btn btn-dark-green btn-sm" type="submit" name="button" value="Variable" style="float: left;">
				</div>
				
				<div class="btn-group">
					<input class="btn btn-dark-green btn-sm" type="submit" name="button" value="ControlStructure" style="float: left;'">
				</div>
				
				<div class="btn-group">
					<input class="btn btn-dark-green btn-sm" type="submit" name="button" value="All-Factors" style="float: left;">
				</div>
			</div>

		</form>
	</div>
  </div>
  
  	<!-- ------------------------------ Footer ------------------------ -->
		<footer
		class="page-footer font-small special-color-dark fixed-bottom pt-5">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">Complexity Tool</div>
		<!-- Copyright -->

	</footer>
  
</body>
</html>