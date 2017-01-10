/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: Validate input from post from then insert it into post table
 *******************************************************************************************/
package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Post;
import classes.User;
import Model.PostModel;


@WebServlet("/Auth/NewPostContoller")
public class NewPostContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewPostContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instantiate Post bean 
		Post post = new Post();
		//Get parameter from post form
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		//Instantiate user class
		User user = new User();
		//get user object from session then assign it to user variable
		user = (User)session.getAttribute("user");
		String name = user.getFirstName() + " " + user.getLastName();
		if(isValidInput(title)){
			post.setName(name);
			post.setTitle(title);
			//insert post into post table
			PostModel.insertPost(post);
			response.sendRedirect("Welcome.jsp");
		}
		else{
			request.setAttribute("errorPost", "Invalid post");
			   RequestDispatcher rd = request.getRequestDispatcher("Post.jsp");
	            rd.include(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public static boolean isValidInput(String message){
		if(message.length()==0 || message==null){
			return false;
		}
		else return true;
		
	}

}
