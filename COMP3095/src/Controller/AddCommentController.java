/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: Validate input from comment form then insert it into comment table
 *******************************************************************************************/
package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Comment;
import Bean.Post;
import classes.User;
import Model.CommentModel;


@WebServlet("/Auth/AddCommentController")
public class AddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddCommentController() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		Comment com = new Comment();
		//get parameters from comment form
		String message = request.getParameter("message");
		String title =  request.getParameter("title");
		String name =  request.getParameter("name");
		String date =  request.getParameter("date");
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		//session.setAttribute("postID", id);
		User user = new User();
		user = (User)session.getAttribute("user");
		String fullName = user.getFirstName() + " " + user.getLastName();
		if(isValidInput(message)){
			com.setPostID(id);
			com.setName(fullName);
			com.setMessage(message);
			CommentModel.insertComment(com);
			//redirect user to welcome Page
			response.sendRedirect("Welcome.jsp");
		}
		else{
			//RequestDispatcher to Comment page with error
			request.setAttribute("errorComment", "Invalid comment");
			request.setAttribute("title", title);
			request.setAttribute("name", name);
			request.setAttribute("date", date);
			   RequestDispatcher rd = request.getRequestDispatcher("Comment.jsp");
	            rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	//validate input message
	public static boolean isValidInput(String message){
		if(message.length()==0 || message==null){
			return false;
		}
		else return true;
		
	}

}
