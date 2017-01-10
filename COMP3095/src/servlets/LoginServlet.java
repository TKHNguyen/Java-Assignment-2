/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: The login servlet will prompt user for the necessary credentials to login
 *******************************************************************************************/
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Comment;
import Bean.Post;
import classes.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private int  age = 60*60*24*365;
    
    public LoginServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	
    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	System.out.println("User="+session.getAttribute("username"));
    	System.out.println("Remeber="+session.getAttribute("remember"));
    	if(session != null){
    		session.invalidate();
    	}
    	response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get username, password, and remember me value from login form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		
		//if username == null, server will redirect user back to login page with error message
		if (username == null || username.trim().equals("")){
			request.setAttribute("invalid", "Please enter username");
			   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	            rd.include(request, response);			
		}
		//if password == null, server will redirect user back to login page with error message
		else if (password == null || password.trim().equals("")){
			request.setAttribute("invalid", "Please enter password");
			   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	            rd.include(request, response);			
		}
		
		//else server will check whether username and password are correct, it will redirect user to welcome page
		else{
			User user = new User();
			if(user.isValidLogin(username, password)){
				   HttpSession session = request.getSession();
					session.setAttribute("username", username);
					
					user= (User)user.getUser(username);
					Post post = new Post();
					//post = post.getPost(1);
					Comment comment = new Comment();
					session.setAttribute("user", user);
					session.setAttribute("post", post);
					session.setAttribute("comment", comment);
					
					//setting session to expire in 10 mins
					session.setMaxInactiveInterval(10*60);

					if(remember != null){
						HttpSession session1 = request.getSession();
						session1.setAttribute("remember", remember);
						session1.setMaxInactiveInterval(24*60*60);
						session.setMaxInactiveInterval(24*60*60);
					}

				response.sendRedirect("Auth/WelcomeController");
			}
			else
			{
				request.setAttribute("invalid", "Incorrect username or password");
				   RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		            rd.include(request, response);			
			}
		}
		
		 

	}

}
