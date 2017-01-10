<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post Page</title>
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
/* Style the list */
ul.tab {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Float the list items side by side */
ul.tab li {float: right;}

#Post {margin-left: 300px;}

#tab1 {
                    width: 40%;
                    height: 200%;
                    background-color: #dddddd;                
					border-radius: 25px;
					padding: 20px;
					margin: 0 auto;
                    }

</style>
<body>
<div id="frame">
		<ul class = "tab">
			
			<li>
				<form action="../LoginServlet" method="get">
				<input type="submit" value="Logout" >
				</form>
			</li>
			<li>
				<jsp:useBean id="user" type="classes.User" scope="session"/>
				Welcome, <% if((user.firstName == null))
								out.print("admin!");
							else
								out.print(user.firstName + " " + user.lastName + "!"); %>
			</li>
		
		</ul>
		<h1 align="center">Blog - New Post</h1>
		<table id="tab1">
                    <tr>
                        <td>
                        	<form action="NewPostContoller">
								<% String error_msg=(String)request.getAttribute("errorPost");  
									if(error_msg!=null)
									out.println("<font color=red size=4px>"+error_msg+"</font>");%>
                        	
							<textarea id="tab2" rows="10" cols="100" name="title"></textarea>
							<br>
							<input id="Post" type="submit" value="Post"> or <a href = "Welcome.jsp">Back to Welcome Page</a>
										
							
							</form>
						</td>
                    </tr>
            </table>     
            <br>
	
	<div style = "background-color:lightgrey;"> 
	
		<% String url;			
		if(session.getAttribute("username")!=null)
		{
			url = "Welcome.jsp";
								
		}
		else
		{
			url = "../Login.jsp";
								
		}%> 
			
		
		<footer>
			<a href="../Registration.jsp" id="bottomButton">Register</a>
			<a href="<%=url %>"  id="bottomButton">User</a>
			<a href="#" id="bottomButton">Personal</a>
		</footer>
		</div>
	</div>
</body>
</html>