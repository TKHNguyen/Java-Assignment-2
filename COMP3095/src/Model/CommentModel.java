/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: Comment model is used for inserting and retrieving comment from database
 *******************************************************************************************/
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import DBHelper.DBHelper;
import Bean.Comment;

public class CommentModel {
	
	//insert data into comment table
	public static void insertComment(Comment com){
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			String query = "INSERT INTO COMMENT "+ 
					" VALUES (null,\'"+ com.getPostID() +"\', \'"+ com.getName() +
					"\',\'" + com.getMessage() +"\',\'"+ currentTimestamp +"\')";
			try {
				helper.stmt.execute(query);
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
		
		
	}
	//Retrieve an arrayList comment object from comment table base on postID
	public static ArrayList<Comment> getComment(int postID){
		ArrayList<Comment> myList = new ArrayList<Comment>();
		//Comment comment = new Comment();
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			String query = "select*from COMMENT where postID="+ postID;
			try {
				ResultSet rset = helper.stmt.executeQuery(query);
				while(rset.next()){
					Comment comment = new Comment();
					comment.setId(rset.getInt("id"));
					comment.setPostID(rset.getInt("postID"));
					comment.setName(rset.getString("name"));
					comment.setMessage(rset.getString("message"));
					comment.setTimestamp(rset.getTimestamp("timestamp"));
					myList.add(comment); 
				   
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
	
	//Count number of comment rows
	public static int countRows(int id){
		int count =0;
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			String query = "SELECT COUNT(*) FROM COMMENT where postID="+ id;
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

}
