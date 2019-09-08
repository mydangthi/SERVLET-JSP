package jsp.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	
	public static Connection getConnection()
	         throws ClassNotFoundException, SQLException {
	     // Chú ý: Thay đổi các thông số kết nối cho phù hợp.
	     String hostName = "localhost";
	     String dbName = "web";
	     String userName = "root";
	     String password = "123456";
	     return getConnection(hostName, dbName, userName, password);
	 }
	  
	 public static Connection getConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName("com.mysql.jdbc.Driver");
	  
	     
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	  
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
	 public static void main(String args[]) throws ClassNotFoundException, SQLException {
		 System.out.print(getConnection());
	 }

}
