/*****************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: User class is as connection between servlet and database.
 * ****************************************************************************/
package classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class User {
	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String year;
	public String major;
	public String username;
	public String password;

public User(){
		
	}
	public User(String fn, String ln, String e, String tel, String y, String m, String name,String pass) {
		this.firstName = fn;
		this.lastName = ln;
		this.email = e;
		this.phone = tel;
		this.year= y;
		this.major = m;
		this.username = name;
		this.password = pass;
		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	//Validate username and password 
	public boolean isValidLogin(String username, String password){
		
		boolean value=false;
		User user = new User();
		user = (User)user.getUser(username);
		
			   if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
				   value = true;
				}
		
		return value;
	}
	
	//Check if username is exist in the database
	public  boolean isValidUsername(String username){
		
		boolean value=true;
		User user = new User();
		user = (User)user.getUser(username);
		
			   if(username.equals(user.getUsername())){
				   value = false;
				}
		
		return value;
	}
	
	//insert user information into the database
	public void insertUser(){
		try{
			
			//1. Allocate a database connection object
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/COMP3095","root","admin");
			
			//2. Allocate a statement object within the connection
			Statement stmt = (Statement) conn.createStatement();

			
			//3. Execute a SQL query
			String insert = "INSERT INTO users "+ 
			" VALUES (null,\'"+ this.firstName +"\', \'"+ this.lastName +
			"\',\'" + this.email +"\',\'"+ this.phone+ "\',\'" + this.year +"\',\'" + this.major +"\',\'"+ this.username +"\',\'"+
			this.password +"\')";
			
			stmt.executeUpdate(insert);
			stmt.close();
			conn.close();

		}catch(SQLException ex){
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
	}
	
	//Retrieve user info from the database
	public User getUser(String username){
		User user = new User();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		Connection	conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/COMP3095?useSSL=false","root","admin");
		Statement	stmt = (Statement) conn.createStatement();

			//Check database if username exist
			String getUser = "select*from users where username='"+ username +"'";
			ResultSet rset = stmt.executeQuery(getUser);
			if (rset.next()) {
			   user.setFirstName(rset.getString("firstname"));
			   user.setLastName(rset.getString("lastname"));
			   user.setEmail(rset.getString("email"));
			   user.setPhone(rset.getString("phone"));
			   user.setYear(rset.getString("year"));
			   user.setMajor(rset.getString("major"));
			   user.setUsername(rset.getString("username"));
			   user.setPassword(rset.getString("password"));
			   
			}
			
			rset.close();
			stmt.close();
			conn.close();

		}
		
		catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		
		catch(Exception ex){
			ex.printStackTrace();				
		}
		
		return user;
				
	}
	

}
