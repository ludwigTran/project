package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Cart;




public class CartDAO {
	
//get list cart where status ='In Cart'
public List<Cart> getListCartByID(int client_id){
	List<Cart> list = new ArrayList<Cart>();
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM cart where client_id=? and status='In Cart'";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, client_id);
		ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		
		Cart cl = new Cart();
		cl.setClient_id(rs.getInt("client_id"));
		cl.setProduct_id(rs.getInt("product_id"));
		cl.setProduct_name(rs.getString("product_name"));
		cl.setPrice(rs.getDouble("price"));
		cl.setQuantity(rs.getInt("quantity"));	
		cl.setProduct_image(rs.getString("product_image"));
		
		list.add(cl);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

//get list cart where status ='In Delivery'
public List<Cart> getListCartByOrderID(int order_id){
	List<Cart> list = new ArrayList<Cart>();
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM cart where order_id=? and status in ('In Delivery', 'In Process')";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, order_id);
		ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		
		Cart cl = new Cart();
		cl.setClient_id(rs.getInt("client_id"));
		cl.setProduct_id(rs.getInt("product_id"));
		cl.setProduct_name(rs.getString("product_name"));
		cl.setPrice(rs.getDouble("price"));
		cl.setQuantity(rs.getInt("quantity"));	
		cl.setProduct_image(rs.getString("product_image"));
		
		list.add(cl);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
//get list cart where status ='In Delivery' or "Already Delivered"
public List<Cart> getListStock(){
	List<Cart> list = new ArrayList<Cart>();
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM cart where not status='In Cart'";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		
		Cart cl = new Cart();
		cl.setClient_id(rs.getInt("client_id"));
		cl.setProduct_id(rs.getInt("product_id"));
		cl.setProduct_name(rs.getString("product_name"));
		cl.setPrice(rs.getDouble("price"));
		cl.setQuantity(rs.getInt("quantity"));	
		cl.setProduct_image(rs.getString("product_image"));
		
		list.add(cl);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}



//GetInfoByID
public List<Cart> getListByClientID(int order_id){
	List<Cart> list = new ArrayList<Cart>();
	
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM cart WHERE order_id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, order_id);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {	
		Cart cl = new Cart();
		cl.setClient_id(rs.getInt("client_id"));
		cl.setProduct_id(rs.getInt("product_id"));
		cl.setProduct_name(rs.getString("product_name"));
		cl.setPrice(rs.getDouble("price"));
		cl.setQuantity(rs.getInt("quantity"));			
		cl.setStatus(rs.getString("status"));
		cl.setOrder_id(rs.getInt("order_id"));
		list.add(cl);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}


//GetInfoByID
public Cart getByOrderID(int id){
	
	Cart cl = null;
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM cart WHERE order_id="+id;
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {
		
		cl = new Cart();
		cl.setClient_id(rs.getInt("client_id"));
		cl.setProduct_id(rs.getInt("product_id"));
		cl.setProduct_name(rs.getString("product_name"));
		cl.setPrice(rs.getDouble("price"));
		cl.setQuantity(rs.getInt("quantity"));			
		cl.setStatus(rs.getString("status"));
		cl.setOrder_id(rs.getInt("order_id"));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cl;
}

//GetInfoByProduct_Name
public Cart getByIdProduct(int client_id, int product_id){

	Cart cl = null;
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM cart WHERE client_id=? and product_id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, client_id);
		ps.setInt(2, product_id);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {
		
		cl = new Cart();
		
		cl.setClient_id(rs.getInt("client_id"));
		cl.setProduct_id(rs.getInt("product_id"));
		cl.setProduct_name(rs.getString("product_name"));
		cl.setPrice(rs.getDouble("price"));
		cl.setQuantity(rs.getInt("quantity"));	
		cl.setOrder_id(rs.getInt("order_id"));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cl;
}



			
//Insert new clientInfo
public boolean insert(Cart cl) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "insert into cart (client_id, product_id, product_name, price, quantity, product_image) values (?,?,?,?,?,?)";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cl.getClient_id());
		ps.setInt(2, cl.getProduct_id());
		ps.setString(3, cl.getProduct_name());
		ps.setDouble(4, cl.getPrice());
		ps.setInt(5, cl.getQuantity());
		ps.setString(6, cl.getProduct_image());
		
		
		int row = ps.executeUpdate();
		if(row >0) {
			check = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return check;
}

//Update Quantity
public boolean updateQuantity (Cart cl) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update cart set quantity=? where client_id = ? and product_id=?";
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, cl.getQuantity());
		ps.setInt(2, cl.getClient_id());
		ps.setInt(3, cl.getProduct_id());
		
		int row = ps.executeUpdate();
		if(row>0) {
			check = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return check;
}

//Update status
public boolean updateStatus (String status, int order_id) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update cart set status= '"+status+"' where order_id="+order_id;
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);


		
		int row = ps.executeUpdate();
		if(row>0) {
			check = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return check;
}
	//Update order_id
	
	public boolean updateStatusOrderID (int order_id) {
		boolean check = false;
		Connection conn = DBconnect.getConnection();
		String sql = "update cart set status='In Process', order_id ="+order_id+" where status = 'In Cart'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			
			int row = ps.executeUpdate();
			if(row>0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	

	//Delete Cart
	public void DeleteCart(int product_id, int client_id) {
		Connection conn = DBconnect.getConnection();
		String sql = "delete from cart where product_id=? and client_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product_id);
			ps.setInt(2, client_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
}
