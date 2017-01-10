/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description:Post model is used for inserting and retrieving post from database
 *******************************************************************************************/
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DBHelper.DBHelper;
import Bean.Post;

public class PostModel {
	
	
	//Insert post into post table
	public static void insertPost(Post post){
		
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			String query = "INSERT INTO POST "+ 
					" VALUES (null,\'"+ post.getName() +"\', \'"+ post.getTitle() +
					"\',\'" + df.format(dateobj) +"\',\'"+ currentTimestamp +"\')";
			try {
			    helper.stmt.execute(query);
				helper.stmt.close();
				helper.conn.close();
			} catch (SQLException e) {
				System.out.println("cannot insert values into post");
				e.printStackTrace();
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	//get post by post id
	public static Post getPost(int id){
		Post post = new Post();
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			String query = "select*from POST where id="+ id;
			try {
				ResultSet rset = helper.stmt.executeQuery(query);
				if (rset.next()) {
					post.setId(rset.getInt("id"));
					post.setName(rset.getString("name"));
					post.setTitle(rset.getString("title"));
					post.setDate(rset.getDate("date"));
					post.setTimestamp(rset.getTimestamp("timestamp"));
				   
				   
				}
				
				rset.close();
				helper.stmt.close();
				helper.conn.close();
			} catch (SQLException e) {
				System.out.println("cannot insert values into post");
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		
		return post;
	}
	
	//Count number of post rows
	public  static int countRows(){
		int count = 0;
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			String query = "SELECT COUNT(*) FROM POST";
			ResultSet rset = helper.stmt.executeQuery(query);
			if(rset.next()){
				count = rset.getInt(1);
			}
			helper.stmt.close();
			helper.conn.close();
		} catch (SQLException e) {
				System.out.println("an error has occured");
				e.printStackTrace();
		}catch (ClassNotFoundException ex) {
			System.out.println("an error has occured");
			ex.printStackTrace();
		}
		return count;
	}
	
	//Get an arrayList of post object from post table
	public static ArrayList<Post> getPost(){
		ArrayList<Post> myList = new ArrayList<Post>();
		
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			String query = "select*from POST";
			try {
				ResultSet rset = helper.stmt.executeQuery(query);
				while(rset.next()){
					Post post = new Post();
					post.setId(rset.getInt("id"));
					post.setName(rset.getString("name"));
					post.setTitle(rset.getString("title"));
					post.setDate(rset.getDate("date"));
					post.setTimestamp(rset.getTimestamp("timestamp"));
					myList.add(post); 
				   
				}
				
				rset.close();
				helper.stmt.close();
				helper.conn.close();
			} catch (SQLException e) {
				System.out.println("cannot insert values into post");
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		
		return myList;
	}

}
