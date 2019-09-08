package jsp.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp.demo.jdbc.ConnectionUtils;
import jsp.demo.model.Order;

public class OrderDAO  extends ConnectionUtils{
	public List<Order> getAll(){
		List<Order> orderList = new ArrayList<Order>();
		String sql = "SELECT * FROM OrderCustomer";
		Connection conn;
		
		try {
		     conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setCustomerName(rs.getString("customerName"));
				order.setPhoneNumber(rs.getInt("phoneNumber"));
				order.setAddress(rs.getString("address"));
				order.setTotal(rs.getString("total"));
				order.setProductId(rs.getInt("productId"));
				orderList.add(order);
				
				
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return orderList;
		
	}
	public Order findOrderById(int id){
		List<Order> orderList = new ArrayList<Order>();
		String sql = "SELECT * FROM OrderCustomer WHERE id = " + id;
		System.out.print("sql");
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
            
			while (rs.next()) {
				Order orderId = new Order();
				orderId.setId(rs.getInt("id"));
				orderId.setCustomerName(rs.getString("customerName"));
				orderId.setPhoneNumber(rs.getInt("phoneNumber"));
				orderId.setAddress(rs.getString("address"));
				orderId.setTotal(rs.getString("total"));
				orderId.setProductId(rs.getInt("productId"));
				orderList.add(orderId);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (orderList != null && !orderList.isEmpty()) {
			return orderList.get(0);
		}
		return null;
	}
	public void addOrder(Order order){
		String sql= "INSERT INTO ordercustomer(customerName,phoneNumber, address,total, productId) VALUES(?,?,?,?,?)";
				
		System.out.print("sql");
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, order.getCustomerName());
			ps.setInt(2, order.getPhoneNumber());
			ps.setString(3, order.getAddress());
			ps.setString(4, order.getTotal());
		    ps.setInt(5, order.getProductId());
			ps.executeUpdate();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
}
