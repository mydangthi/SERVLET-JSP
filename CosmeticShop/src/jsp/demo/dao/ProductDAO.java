package jsp.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp.demo.jdbc.ConnectionUtils;
import jsp.demo.model.Product;



public class ProductDAO extends ConnectionUtils{
	public List<Product> getAll(){
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product";
		Connection conn;
		
		try {
		     conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setImage(rs.getString("image"));
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				productList.add(product);
				
				
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return productList;
		
	}

	
	public void updateProduct(Product product) {
		String updatesql = "UPDATE Product SET image = ?,productName = ?, price = ?,status= ? WHERE id = ?";
				
		System.out.print("updatesql");
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(updatesql);
			ps.setString(1, product.getImage());
			ps.setString(2,product.getProductName());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getStatus());
			ps.setInt(5, product.getId());
			ps.executeUpdate();
			
			

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void deletProduct(int id) {
		String sql = "DELETE From product WHERE id = "+id;
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (ClassNotFoundException e1) {  
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void addProduct(Product product) {
		String sql = "INSERT INTO Product(image,productName,price, status) VALUES(?,?,?,?)";
				
		System.out.print("sql");	
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getImage());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getStatus());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	 public List<Product> finByNameProduct(String productName) {
		 List<Product> productList = new ArrayList<Product>();
		
		 String sql = "SELECT * FROM product WHERE productName = ?" ;
		 System.out.print("sql");
		 Connection conn;
			try {
				conn = super.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, productName);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Product productN = new Product();
					productN.setId(rs.getInt("id"));
					productN .setImage(rs.getString("image"));
					productN .setProductName(rs.getString("productName"));
					productN .setPrice(rs.getString("price"));
					productN .setStatus(rs.getString("status"));
					productList.add(productN );
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return productList;
		
	 }
    
	

	public Product findProductById(int id){
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE id = "+id+"" ;
		System.out.print("sql");
		Connection conn;
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
            
			while (rs.next()) {
				Product productI = new Product();
				productI.setId(rs.getInt("id"));
				productI.setImage(rs.getString("image"));
				productI.setProductName(rs.getString("productName"));
				productI.setPrice(rs.getString("price"));
				productI.setStatus(rs.getString("status"));
				productList.add(productI);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (productList != null && !productList.isEmpty()) {
			return productList.get(0);
		}
		return null;
	}
	
	

}
