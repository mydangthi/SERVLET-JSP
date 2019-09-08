package jsp.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp.demo.jdbc.ConnectionUtils;
import jsp.demo.model.User;

public class UserDAO extends ConnectionUtils {
	public List<User> getAll(){
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		Connection conn;
		
		try {
		     conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
				
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return userList;
		
	}
	 public List<User> finByNameUser(String userName) {
		 List<User> userList = new ArrayList<User>();
		
		 String sql = "SELECT * FROM user WHERE userName = ?" ;
		 System.out.print("sql");
		 Connection conn;
			try {
				conn = super.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					User userN = new User();
					userN.setUserName(rs.getString("userName"));
					userN.setPassword(rs.getString("password"));

					userList.add(userN);
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return userList;
		
	 }
    
	public User findUser(String userName, String password) {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User userOut = new User();
				userOut.setUserName(rs.getString("userName"));
				userOut.setPassword(rs.getString("password"));
				userList.add(userOut);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	
}
