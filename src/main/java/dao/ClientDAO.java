package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Client;

public class ClientDAO {
	
		
//Insert new client
public boolean insert(Client cl) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "insert into client (username, password, fullname,  phonenumber, email, address) values (?,?,?,?,?,?)";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, cl.getUsername());
		ps.setString(2, cl.getPassword());
		ps.setString(3, cl.getFullname());
		ps.setString(4, cl.getPhonenumber());
		ps.setString(5, cl.getEmail());
		ps.setString(6, cl.getAddress());
		

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
//update
public boolean updateClientInfo (Client cl) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update client set password =?, fullname =?, phonenumber =?, email =?, address =?  where id = ?";
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, cl.getPassword());
		ps.setString(2, cl.getFullname());
		ps.setString(3, cl.getPhonenumber());
		ps.setString(4, cl.getEmail());
		ps.setString(5, cl.getAddress());
		ps.setInt(6, cl.getId());
		
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
//update Password
public boolean updateClientPassword (String pass, int id) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update client set password ='"+pass+"' where id = "+id;
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return check;
}
//Login
public boolean loginAdmin(String username, String password) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql ="SELECT * from client where username=? and password=? and role_id=1";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			check =true;
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return check;
	
}
public boolean loginClient(String username, String password) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql ="SELECT * from client where username=? and password=? and role_id=0";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			check =true;
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return check;
	
}
// get all list client
public List<Client> getListclient(){
	List<Client> listclient = new ArrayList<Client>();
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM client WHERE role_id =0";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		
		Client client = new Client();
		client.setId(rs.getInt("id"));
		client.setUsername(rs.getString("username"));
		client.setPassword(rs.getString("password"));
		client.setFullname(rs.getString("fullname"));
		client.setEmail(rs.getString("email"));
		client.setPhonenumber(rs.getString("phonenumber"));
		client.setAddress(rs.getString("address"));
		
		
			
		listclient.add(client);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listclient;
}
		

//GetInfoByID
public Client getByNameclient(String username){
	
	Client cl = null;
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM client WHERE username=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {
		
		cl = new Client();
		cl.setId(rs.getInt(1));
		cl.setUsername(rs.getString(2));
		cl.setPassword(rs.getString(3));
		cl.setFullname(rs.getString(4));
		cl.setPhonenumber(rs.getString(5));
		cl.setEmail(rs.getString(6));
		cl.setAddress(rs.getString(7));
		
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cl;
}
//GetInfoByID
public Client getByClientID(int client_id){
	
	Client cl = null;
	Connection con = DBconnect.getConnection();
	String sql = "SELECT * FROM client WHERE id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, client_id);
		ResultSet rs = ps.executeQuery();
		
	while(rs.next()) {
		
		cl = new Client();
		cl.setId(rs.getInt(1));
		cl.setUsername(rs.getString(2));
		cl.setPassword(rs.getString(3));
		cl.setFullname(rs.getString(4));
		cl.setPhonenumber(rs.getString(5));
		cl.setEmail(rs.getString(6));
		cl.setAddress(rs.getString(7));
		
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cl;
}
//Delete clients
public void DeleteCartClient(int id) {
	Connection conn = DBconnect.getConnection();

	String sql3 = "delete from cart where client_id="+id;

	try {
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		ps3.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void DeleteOrderClient(int id) {
	Connection conn = DBconnect.getConnection();
	String sql3 = "delete from orderAdmin where client_id="+id;
	try {
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		ps3.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void DeleteClient(int id) {
	Connection conn = DBconnect.getConnection();
	String sql3 = "delete from client where id="+id;

	try {
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		ps3.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
