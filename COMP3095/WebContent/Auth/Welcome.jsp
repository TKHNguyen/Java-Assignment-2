<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="post" type="Bean.Post" scope="session"/> 
<%@page import="java.util.ArrayList" %>
<%@page import="Bean.Post" %>
<%@page import="Model.PostModel" %>
<jsp:useBean id="comment" type="Bean.Comment" scope="session"/> 
<%@page import="Bean.Comment" %>
<%@page import="Model.CommentModel" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
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

#tab1 {
	     width: 60%;                 
		 border-radius: 15px;
		 background: #a1cca5;
		 padding: 20px;
	  }
 #row, #col{
 		border-left: 0px;
 		border-right: 0px;
 		border-top: 0px;
 		border-bottom: 1px dotted #ff0000;
 }     
 #col{
 padding-left: 10%; }        
 
 #blog {
 	padding-left: 20%;
 }
 #aComment {border: 0px;}
 #gTitle{border: 0px;
 		border-radius: 5px;
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
		<table id="blog">
			<tr>
				<td><h1>Blog</h1></td>
				<td>&nbsp;&nbsp;&nbsp;<a href="Post.jsp">Write a Post</a></td>
			</tr>
		</table>
		<br>
		<br>
		
		
		<!-- Post And Comment -->
		
		
		<% 
		ArrayList<Post> List = PostModel.getPost();
		Post p = new Post();
		for(int j = List.size()-1  ; j>-1; j--){
			p = List.get(j);
		%>
		
		<table id="tab1" border="1px">
		<thead style="background-color: #defffc;">
		<td id="gTitle"><%=p.getTitle() %><br>
		<strong><%=p.getName()%><%=" - "%><%=p.getDate()%></strong></td>
		</thead>
		
	
		
		<%
		
		 ArrayList<Comment> myList = CommentModel.getComment(p.getId());
		Comment com = new Comment();
		for(int i = 0; i<myList.size(); i++){
			com = (Comment)myList.get(i);
			%> 
			<tr id="row">
			
			<td id="col">
	      
			<strong> <% 
			out.println(com.getName());%> says, </strong><%
			out.println(com.getMessage());%> <br><% 
			 
			%>
			</td>
			</tr>
			<% 
		}
		%>
		<tr>
		<td id="aComment">
		<form action="Comment.jsp">
		  <input type="hidden" name="title" value="<%=p.getTitle() %>">
		  <input type="hidden" name="name" value="<%=p.getName() %>">
		  <input type="hidden" name="date" value="<%=p.getDate() %>">
		  <input type="hidden" name="id" value="<%=p.getId() %>">
		  <input type="submit" value="Add a Comment">
		</form>
		<!--  <a href="Comment.jsp">Add a Comment</a>-->
		</td>
		</tr>
		
		</table>
		<br>
		<%}%>
		
		
		
		
		
		
		
		
		
		
		
		
		
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