<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<style>

#formStyle{
	border: 1px solid black;
	border-radius: 8px;
	width: 80%;
	padding: 10px;
	background-color: #f2f2f2;
}

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
	<h1>Personal Information</h1>
	</div>
	<%
	
	
	%>
	
	<form action="http://localhost:8080/COMP3095/assignment1/RegisterServlet" method="post">
	
	
		<div align="center">
			
		 	<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Username:</td><td id="rightTable"><input type="text" name="username" value= <%
				String uName=(String)request.getAttribute("uName");  
				if(uName!=null)
					out.print(uName);
				else
					out.print("");
				%>></td></tr>
				</table>
			</div>
			</br>
			
			<div><%
			String user_msg=(String)request.getAttribute("user_msg");  
			if(user_msg!=null)
			out.println("<font color=red size=4px>"+user_msg+"</font>");
		 	%></div>
		 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Password:</td><td id="rightTable"><input type="password" name="password"></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String pass_msg=(String)request.getAttribute("pass_msg");  
			if(pass_msg!=null)
			out.println("<font color=red size=4px>"+pass_msg+"</font>");
		 	%></div>
		 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Confirm Password:</td><td id="rightTable"><input type="password" name="confirmPass"></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String cPass_msg=(String)request.getAttribute("cPass_msg");  
			if(cPass_msg!=null)
			out.println("<font color=red size=4px>"+cPass_msg+"</font>");
		 	%></div>
		 	
		 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">First Name:</td><td id="rightTable"><input type="text" name ="firstName" value= <%
				String fn=(String)request.getAttribute("fn");  
				if(fn!=null)
					out.print(fn);
				else
					out.print("");
				%>></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String fn_msg=(String)request.getAttribute("fn_msg");  
			if(fn_msg!=null)
			out.println("<font color=red size=4px>"+fn_msg+"</font>");
		 	%></div>
	 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Last Name:</td><td id="rightTable"><input type="text" name ="lastName" value= <%
				String ln=(String)request.getAttribute("ln");  
				if(ln!=null)
					out.print(ln);
				else
					out.print("");
				%>></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String ln_msg=(String)request.getAttribute("ln_msg");  
			if(ln_msg!=null)
			out.println("<font color=red size=4px>"+ln_msg+"</font>");
		 	%></div>
	 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Email:</td><td id="rightTable"><input type="email" name ="email" value= <%
				String e=(String)request.getAttribute("e");  
				if(e!=null)
					out.print(e);
				else
					out.print("");
				%>></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String email_msg=(String)request.getAttribute("email_msg");  
			if(email_msg!=null)
			out.println("<font color=red size=4px>"+email_msg+"</font>");
		 	%></div>
	 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Confirm E-mail:</td><td id="rightTable"><input type="email" name ="cEmail"></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String cEmail_msg=(String)request.getAttribute("cEmail_msg");  
			if(cEmail_msg!=null)
			out.println("<font color=red size=4px>"+cEmail_msg+"</font>");
		 	%></div>
	 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Telephone:</td><td id="rightTable"><input type="text" name ="telephone"  placeholder="xxxxxxxxxx" value= <%
				String p=(String)request.getAttribute("p");  
				if(p!=null)
					out.print(p);
				else
					out.print("");
				%>></td></tr>
				</table>
			</div>
			</br>
			<div><%
			String tel_msg=(String)request.getAttribute("tel_msg");  
			if(tel_msg!=null)
			out.println("<font color=red size=4px>"+tel_msg+"</font>");
		 	%></div>
	 	
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Year:</td><td id="rightTable">
			<select name="year">
				  <option value = "Select One...">Select One...</option>
				  <option value="2015">2015</option>
				  <option value="2016">2016</option>
				  <option value="2017">2017</option>
				  <option value="2018">2018</option>
			</select>
			</td></tr>
			</table>
			</div>
			</br>
				<div><%
				String year_msg=(String)request.getAttribute("year_msg");  
				if(year_msg!=null)
				out.println("<font color=red size=4px>"+year_msg+"</font>");
			 	%></div>
		
		<div id="formStyle">
			 	<table>
				<tr><td id="leftTable">Major:</td><td id="rightTable">
			<select name="major">
				  <option value = "Select One...">Select One...</option>
				  <option value="Business">Business</option>
				  <option value="Psychology">Psychology</option>
				  <option value="Biology">Biology</option>
			</select>
			</td></tr>
			</table>
			</div>
			</br>
				<div><%
				String major_msg=(String)request.getAttribute("major_msg");  
				if(major_msg!=null)
				out.println("<font color=red size=4px>"+major_msg+"</font>");
			 	%></div>
			 
		<div id="formStyle">
			<input type="submit" name="registration">
			</div>
			</br>
			</div>
	
	</form>
	<div style = "background-color:lightgrey;">
	<% String url = "http://localhost:8080/COMP3095/Login.jsp";			
		if(session.getAttribute("username")!=null)
			url = "Auth/Welcome.jsp";				
		%> 
	<footer>
		<a href="http://localhost:8080/COMP3095/Registration.jsp" id="bottomButton">Register</a>
		<a href="<%=url %>" id="bottomButton">User</a>
		<a href="#" id="bottomButton">Personal</a>
	</footer>
	</div>
</div>
</body>
</html>