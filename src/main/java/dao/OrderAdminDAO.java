package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.OrderAd;


// hiển thị đơn hàng
public class OrderAdminDAO {

	public List<OrderAd> getorderadmin(){
		List<OrderAd> list = new ArrayList<OrderAd>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM orderAdmin";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			OrderAd orad = new OrderAd();
			int order_id = rs.getInt(1);
			int client_id = rs.getInt(2);
			Date create_date = rs.getDate(3);
			double totalPrice = rs.getDouble(4);
			String status = rs.getString(5);
			
			orad.setOrder_id(order_id);
			orad.setClient_id(client_id);
			orad.setCreate_date(create_date);
			orad.setTotalPrice(totalPrice);
			orad.setStatus(status);

			list.add(orad);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//getlist orderAD by clientID where status = In delivery
	public List<OrderAd> getListOrderAD(int client_id){
		List<OrderAd> list = new ArrayList<OrderAd>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM orderAdmin where client_id =? and status in ('In Delivery','In Process')";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, client_id);
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()) {
			
			OrderAd ord = new OrderAd();
			ord.setOrder_id(rs.getInt("order_id"));
			ord.setClient_id(rs.getInt("client_id"));
			ord.setCreate_date(rs.getDate("create_date"));
			ord.setTotalPrice(rs.getDouble("totalPrice"));
			ord.setStatus(rs.getString("status"));
			
			
				
			list.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

//getlist orderAD by clientID where not status = In delivery
public List<OrderAd> getListOrderHistory(int client_id){
	List<OrderAd> list = new ArrayList<OrderAd>();
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM orderAdmin where client_id =? and status in ('Received', 'Cancel Order')";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, client_id);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {
		
		OrderAd ord = new OrderAd();
		ord.setOrder_id(rs.getInt("order_id"));
		ord.setClient_id(rs.getInt("client_id"));
		ord.setCreate_date(rs.getDate("create_date"));
		ord.setTotalPrice(rs.getDouble("totalPrice"));
		ord.setStatus(rs.getString("status"));
		
		
			
		list.add(ord);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
	// lọc đơn hàng theo client_id
	public OrderAd getByClientID(int client_id){
		 ArrayList<OrderAd> orders =new ArrayList<>();
		OrderAd order = null;
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM orderAdmin WHERE client_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, client_id);
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()) {
			
			order = new OrderAd();
			order.setOrder_id(rs.getInt("order_id"));
			order.setClient_id(rs.getInt("client_id"));
			order.setTotalPrice(rs.getDouble("totalPrice"));
			orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
//Get orderAd by order_id
public OrderAd getByOrderID(int order_id){
	 ArrayList<OrderAd> orders =new ArrayList<>();
	OrderAd order = null;
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM orderAdmin WHERE order_id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, order_id);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {
		
		order = new OrderAd();
		order.setOrder_id(rs.getInt("order_id"));
		order.setClient_id(rs.getInt("client_id"));
		order.setCreate_date(rs.getDate("create_date"));
		order.setTotalPrice(rs.getDouble("totalPrice"));
		order.setStatus(rs.getString("status"));
		order.setAddress(rs.getString("address"));
		order.setNote(rs.getString("note"));
		orders.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return order;
}
	
	
	
	//Get order_ID by totalprice
	public OrderAd getByTotal(int client_id, double totalPrice){

		OrderAd cl = null;
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM orderAdmin WHERE client_id=? and totalPrice=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, client_id);
			ps.setDouble(2, totalPrice);
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()) {
			
			cl = new OrderAd();
			cl.setOrder_id(rs.getInt("order_id"));
			cl.setClient_id(rs.getInt("client_id"));
			cl.setTotalPrice(rs.getDouble("totalPrice"));		
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}
	
//Update trạng thái đơn hàng	
public boolean updateStatus (OrderAd update) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update orderAdmin set status=? where order_id=?";
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, update.getStatus());
		ps.setInt(2, update.getOrder_id());

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

//Update status after receiving 
public boolean updateStatusReceive (int order_id) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update orderAdmin set status= 'Received' where order_id="+order_id;
	
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
	//thêm đơn hàng mới
	public boolean insert(OrderAd insert) {
		boolean check = false;
		Connection conn = DBconnect.getConnection();
		String sql = "insert into orderAdmin(client_id, totalPrice, address, note) values (?,?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, insert.getClient_id());
			ps.setDouble(2, insert.getTotalPrice());
			ps.setString(3, insert.getAddress());
			ps.setString(4, insert.getNote());
			
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

}



