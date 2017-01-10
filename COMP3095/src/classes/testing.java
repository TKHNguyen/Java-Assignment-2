package classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import DBHelper.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class testing {

	public static void main(String[] args) {
		//Date date = new Date(0, 0, 0);
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		System.out.println(currentTimestamp);
		//System.out.println(date);
		/*
		int count =0;
		DBHelper helper = new DBHelper();
		try{
			helper.connection();
			String query = "SELECT COUNT(*) FROM COMMENT where postID = 1";
			
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
		//return count;
		System.out.println(count);*/
	
		
		
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
		System.out.println(count);
		
		/*
		int[] array = new int[4];
		int i = 0 ;
		//DBHelper helper = new DBHelper();

		try{
			helper.connection();
			String query = "SELECT*FROM POST";
			ResultSet rset = helper.stmt.executeQuery(query);
			while(rset.next()){
				array[i] = rset.getInt(1);
				i++;
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
		for(int a = 0; a<array.length; a++){
			System.out.println(array[a]);
		}*/
		
/*ArrayList<Post> myList = new ArrayList<Post>();
		
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
		for(int i =1 ; i<5 ; i++)
		{
			System.out.println(myList.get(i).getName());
		}
		System.out.println(myList.get(3).getName());

	}*/
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "value");
		
		if(map.get("value")!=null)
			System.out.println(map.get("value"));
		else
			System.out.println(map.get("name"));
		
	}		

}
