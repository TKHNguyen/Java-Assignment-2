/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: If valid user this servlet will redirect user to welcome page otherwise user
 * 					be redirect to Login page with error message.
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


@WebServlet("/Auth/WelcomeController")
public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WelcomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username =(String)session.getAttribute("username");
		String auth_error= "Please login before access that page";
		if(username==null){
			request.setAttribute("auth_error", auth_error);
			   RequestDispatcher rd = request.getRequestDispatcher("../Login.jsp");
	            rd.include(request, response);
		}
		else{
			response.sendRedirect("Welcome.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
