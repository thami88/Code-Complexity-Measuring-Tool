<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change weight of Variable</title>

<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css" rel="stylesheet">

</head>
<body>

<div class="container-fluid pt-5">

		<div class="container text-center pt-5">
			<div class="row">
				<div class="col">
					<p class="h4 mb-4">Change Default Weight of Size</p>
				</div>
			</div>
		</div>
		
	<form action = "WeightVariableServlet" method= POST>
	<div style = "width : 50%; float : left;">
			<table class="table table-hover" border="1">
			<tr><th bgcolor= '#839192'>Program Component</th><th bgcolor= '#839192'>Weight</th></tr>
			<tr><td >Global variable </td><td ><input type="text" name = "WvsG" value = 2> </td></tr>
			<tr><td>Local variable</td><td><input type="text" name = "WvsL" value = 1> </td></tr>
			<tr><td>Primitive data type variable</td><td><input type="text" name = "Wpdtv" value = 1> </td></tr>
			<tr><td>Composite data type variable</td><td><input type="text" name = "Wcdtv" value = 2> </td></tr>
				
			</table>
			
			</div>
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
			<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 200px;height: 50px">
			</div>
	</form>
  </div>
  
   		<!-- ------------------------- Footer ------------------------ -->
   		
	<footer class="page-footer font-small special-color-dark fixed-bottom pt-5">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">Complexity Tool</div>
		<!-- Copyright -->

	</footer>
	

</body>
</html>