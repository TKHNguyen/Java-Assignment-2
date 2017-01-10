/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: Comment bean
 *******************************************************************************************/
package Bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import DBHelper.DBHelper;

public class Comment {
	private int id;
	private int postID;
	private String name;
	private String message;
	private Timestamp timestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	/*
	public boolean isValidComment(String message){
		if(message.length()==0 || message==null){
			return false;
		}
		else return true;
		
	}

	public void insertComment(){
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			String query = "INSERT INTO COMMENT "+ 
					" VALUES (null,\'"+ this.postID +"\', \'"+ this.name +
					"\',\'" + this.message +"\',\'"+ currentTimestamp +"\')";
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
	public ArrayList<Comment> getComment(int postID){
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
	public int countRows(int id){
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
*/

}
