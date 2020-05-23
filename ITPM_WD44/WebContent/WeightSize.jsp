<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change weight of Size</title>

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
		
	<form action = "WeightSizeServlet" method= POST>
	<div class="container">
			<table class="table table-hover" border="1">
			<tr><th>Program Component</th><th>Weight</th></tr>
			<tr><td >Keyword</td><td ><input type="text" name = "Wkw" value = 1> </td></tr>
			<tr><td>Identifier</td><td><input type="text" name = "Wid" value = 1> </td></tr>
			<tr><td>Operator</td><td><input type="text" name = "Wop" value = 1> </td></tr>
			<tr><td>Numerical value</td><td><input type="text" name = "Wnv" value = 1> </td></tr>
			<tr><td>String literal</td><td> <input type="text" name = "Wsl" value = 1></td></tr>
				
			</table>
			
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
				<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 200px;height: 50px">
			</div>
		</div>
     </form>
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