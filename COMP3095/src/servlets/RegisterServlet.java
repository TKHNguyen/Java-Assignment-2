/*******************************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: Resgistration servlet is used to validate all user inputs then store them into database
 ****************************************************************************************************** */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

import classes.User;


@WebServlet("/assignment1/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     	//get all parameters from the registration from
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String confirmPass = request.getParameter("confirmPass");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String email = request.getParameter("email");
				String cEmail = request.getParameter("cEmail");
				String telephone = request.getParameter("telephone");
				String year = request.getParameter("year");
				String major = request.getParameter("major");
				Boolean isValid = true;
				User user  = new User(firstName, lastName, email, telephone, year, major,username, password);
				
				if(user.getUsername().trim().equals("") || user.getUsername()==null  )
				{
					request.setAttribute("user_msg", "Username cannot be blank ");
					
					isValid = false;
				}
				if( user.getUsername().length()>20 )
				{
					request.setAttribute("user_msg", " Username cannot be greater than 20 characters");
					
					isValid = false;
				}
				
				//Check whether username is exist in the database
			   if(user.isValidUsername(username)==false){
					request.setAttribute("user_msg", "Username is already exist");
					isValid = false;
				}
					
				//validate input parameters
				if(user.getPassword().trim().equals("") || user.getPassword()==null )
				{
					request.setAttribute("pass_msg", "Password cannot be blank ");			
					isValid = false;
				}
				if( user.getPassword().length()>20)
				{
					request.setAttribute("pass_msg", "Password cannot be greater than 20 characters");			
					isValid = false;
				}
				if((confirmPass.trim().equals("") || password==null) && !confirmPass.equals(password))
				{
					request.setAttribute("cPass_msg", "Password is not match");
					isValid = false;
				}
				if(user.getFirstName().trim().equals("") || user.getFirstName()==null )
				{
					request.setAttribute("fn_msg", "First name cannot be blank");
					isValid = false;
				}
				if( user.getFirstName().length()>225)
				{
					request.setAttribute("fn_msg", "First name cannot be greater than 225 characters");
					isValid = false;
				}
				if(user.getLastName().trim().equals("") || user.getLastName()==null )
				{
					request.setAttribute("ln_msg", "Last name cannot be blank");
					isValid = false;
				}
				if(user.getLastName().length()>255)
				{
					request.setAttribute("ln_msg", "Last name cannot be greater than 225 characters");
					isValid = false;
				}
				if(user.getEmail().trim().equals("") || user.getEmail()==null)
				{
					request.setAttribute("email_msg", "Email cannot be blank");
					isValid = false;
				}
				if( user.getEmail().length()>255)
				{
					request.setAttribute("email_msg", "Email cannot be greater than 225 characters");
					isValid = false;
				}
				if(!user.getEmail().matches("^(.+)@(.+)$"))
				{
					request.setAttribute("email_msg", "Invalid email address");
					isValid = false;
				}
				if(cEmail.trim().equals("") || cEmail==null  || (!cEmail.equals(email)))
				{
					request.setAttribute("cEmail_msg", "Email is not match");
					isValid = false;
				}
				if(user.getPhone().trim().equals("") || user.getPhone()==null)
				{
					request.setAttribute("tel_msg", "Telephone cannot be blank");
					isValid = false;
				}
				if(validatePhoneNumber(telephone)==false)
				{
					request.setAttribute("tel_msg", "Invalid telephone number");
					isValid = false;
				}
				if(user.getYear().equals("Select One...") )
				{
					request.setAttribute("year_msg", "Please select one");
					isValid = false;
				}
				if(user.getMajor().equals("Select One..."))
				{
					request.setAttribute("major_msg", "Please select one");
					isValid = false;
				}
				
				
				//if all parameters are valid, direct user to Confirm page
				if(isValid==true){
					//insert user into database
					user.insertUser();
					
					request.setAttribute("name", user.getFirstName());
					RequestDispatcher rd = request.getRequestDispatcher("../RegistrationConfirm.jsp");
		            rd.forward(request, response);
					
				}
				
				//else servlet will redirect user back to registration page with error messages
				else
				{
					request.setAttribute("uName", user.getUsername());
					request.setAttribute("fn", user.getFirstName());
					request.setAttribute("ln", user.getLastName());
					request.setAttribute("e", user.getEmail());
					request.setAttribute("p", user.getPhone());
					
					 RequestDispatcher rd = request.getRequestDispatcher("../Registration.jsp");
		             rd.forward(request, response); 
				}
	}
	
	private static boolean validatePhoneNumber(String phoneNo) {
		
		//validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}")) return true;
		else return false;
		
	}
	

	

}
