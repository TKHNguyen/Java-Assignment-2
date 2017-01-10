<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment Page</title>
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

#tab4 {
                    width: 53%;
                    height: 200%;
                    background-color: #dddddd;                
					border-radius: 10px;
					padding: 20px 30px 20px 100px;
					margin: 0 auto;
                    }
#addComment{margin-left: 150px;}
#footer{background-color: #dddddd; }
#nameDiv {width: 50%;
          height: 200%;
          background-color: #dddddd;                
	      border-radius: 10px;
		  padding: 20px;
		  margin: 0 auto;}


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
	<h1 align="center">Blog - Add a Comment</h1>
	<div id="nameDiv">
	<%if(request.getParameter("title")!=null){ %>
		<%= request.getParameter("title")%><br>
		<%= request.getParameter("name")%>
		<%= request.getParameter("date")%> <br>
		<%}else{ %>
		${requestScope.title }<br>
		${requestScope.name }
		${requestScope.date } <br>
		
		<%} %>
	</div>
	<br>
	
	<!--  <%= request.getParameter("postID")%>-->
	
	<table id="tab4">
                    <tr>
                        <td>
							<form action="AddCommentController">
								<% String error_msg=(String)request.getAttribute("errorComment");  
									if(error_msg!=null)
									out.println("<font color=red size=4px>"+error_msg+"</font>");%></br>
								<textarea rows="7" cols="70" name="message"></textarea><br>
								<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
								<input type="hidden" name="title" value="<%=request.getParameter("title")%>">
								<input type="hidden" name="name" value="<%=request.getParameter("name")%>">
								<input type="hidden" name="date" value="<%=request.getParameter("date")%>">
								<input id="addComment" type="submit" value="Add Comment">
								or <a href = "Welcome.jsp">Back to Welcome Page</a>
								
							</form>
						</td>
                    </tr>
            </table>     
	
		<% String url;			
		if(session.getAttribute("username")!=null)
		{
			url = "Welcome.jsp";
								
		}
		else
		{
			url = "../Login.jsp";
								
		}%> 
			
		<br><br>
		<footer id="footer">
			<a href="../Registration.jsp" id="bottomButton">Register</a>
			<a href="<%=url %>"  id="bottomButton">User</a>
			<a href="#" id="bottomButton">Personal</a>
		</footer>

	</div>
</body>
</html>