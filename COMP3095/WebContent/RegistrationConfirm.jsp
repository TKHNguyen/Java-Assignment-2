<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Confirm Page</title>
</head>
<style>

#bottomButton{
	border: 1px solid black;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 8px;
	width: 5%;
	margin-left: 10px;
}

a:hover{
	background-color: grey;
}

#formStyle{
border: 1px solid black;
	border-radius: 8px;
	width: 80%;
	background-color: #f2f2f2;
	padding: 10px;
}

</style>

<body>
	<div id="frame">
	
		<div style = "background-color:powderblue;">
		<h1>Congratulations, <%=request.getAttribute("name")%> !</h1>
		</div>
		
		<div align="center">
		
			<div id="formStyle">
				<h3>Your registration is now complete.</h3>
			</div>
			</br>
	
		</div> 
		
		 	
		<div style = "background-color:lightgrey;"> 	
		<footer>
			<a href="http://localhost:8080/COMP3095/Registration.jsp" id="bottomButton">Register</a>
			<a href="http://localhost:8080/COMP3095/Login.jsp" id="bottomButton">User</a>
			<a href="#" id="bottomButton">Personal</a>
		</footer>
		</div>
	</div>
</body>
</html>