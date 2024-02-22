package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClientInfo;
import model.Product;



public class ClientInfoDAO {
	
	public boolean loginClient(String username, String password) {
		boolean check = false;
		Connection conn = DBconnect.getConnection();
		String sql ="SELECT * from clientInfor where username=? and password=?";
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
	
	public List<ClientInfo> getAll(){
		List<ClientInfo> list = new ArrayList<ClientInfo>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM clientInfor";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			ClientInfo cl = new ClientInfo();
			cl.setId(rs.getInt(1));
			cl.setFullname(rs.getString(2));
			cl.setUsername(rs.getString(3));
			cl.setPassword(rs.getString(4));
			cl.setPhonenumber(rs.getInt(5));
			cl.setEmail(rs.getString(6));
			cl.setAddress(rs.getString(7));
			
			
			list.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//GetInfoByID
			public ClientInfo getByNameClient(String username){
				
				ClientInfo cl = null;
				Connection con = DBconnect.getConnection();
				String sql = "SELECT * FROM clientInfor WHERE username=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					
				while(rs.next()) {
					
					cl = new ClientInfo();
					cl.setId(rs.getInt(1));
					cl.setFullname(rs.getString(2));
					cl.setUsername(rs.getString(3));
					cl.setPassword(rs.getString(4));
					cl.setPhonenumber(rs.getInt(5));
					cl.setEmail(rs.getString(6));
					cl.setAddress(rs.getString(7));
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return cl;
			}
	//Insert new clientInfo
	public boolean insert(ClientInfo cl) {
		boolean check = false;
		Connection conn = DBconnect.getConnection();
		String sql = "insert into clientInfor (fullname, username, password, phonenumber, email, address) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cl.getFullname());
			ps.setString(2, cl.getUsername());
			ps.setString(3, cl.getPassword());
			ps.setInt(4, cl.getPhonenumber());
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

	
}
