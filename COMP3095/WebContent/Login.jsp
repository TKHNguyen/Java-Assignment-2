<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
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

td{
	width: 150px;
}

#leftTable{
text-align: right;
}

#rightTable{
text-align: left;
}


</style>

<body>
	<div id="frame">
	<div style = "background-color:powderblue;">
	<h1>Login </h1>
	</div>
		<form action="http://localhost:8080/COMP3095/LoginServlet" method="post">
		
			<div align="center">
			<%
			String login_msg=(String)request.getAttribute("invalid");  
			if(login_msg!=null)
			out.println("<font color=red size=4px>"+login_msg+"</font>");
		 	%></div>
		 	<%
			String auth_error=(String)request.getAttribute("auth_error");  
			if(auth_error!=null)
			out.println("<font color=red size=4px>"+auth_error+"</font>");
		 	%></div>
		 	
		 	<div align="center">
			
		 	<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Username:</td><td id="rightTable"> <input type="text" name="username"></td></tr>
				</table>
			</div>
			</br>
			
			<div id="formStyle">
		 	<table >
			<tr><td id="leftTable">Password:</td><td id="rightTable"> <input type="password" name="password"></td></tr>
				</table>
			</div>
			</br>
			
			
			<div id="formStyle">
		 	<table >
			<tr><td id="leftTable">Remember Me:</td><td id="rightTable"><input type="checkbox" name="remember" value="remeber"></td></tr>
			</table>
			</div>
			</br>
			
			<div id="formStyle">
			<a href="Registration.jsp">Register</a> -or- <input type="submit">
			</div>
			</br>
			
		 	</div>
		 	</div>
		</form>
		<div style = "background-color:lightgrey;">
		<footer>
			<a href="Registration.jsp" id="bottomButton">Register</a>
			<a href="Login.jsp" id="bottomButton">User</a>
			<a href="#" id="bottomButton">Personal</a>
		</footer>
		</div>
	</div>
</body>
</html>