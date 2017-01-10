/*******************************************************************************************
 * Assignment: 1
 * Authors:    John Cetin : 100955200
 * 		       Hoa Nguyen : 100959069
 * 		       Rose Ann Yabut: 100949100
 * Date:       10/25/2016
 * Description: The DBHelper is a database connection
 *******************************************************************************************/
package DBHelper;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBHelper {
	public DBHelper(){}
	public Connection conn;
	public Statement stmt;
	public void connection() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/COMP3095?useSSL=false","root","admin");
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
