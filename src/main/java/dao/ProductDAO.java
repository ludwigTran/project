package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
public class ProductDAO {
	public List<Product> getAll(){
		List<Product> list = new ArrayList<Product>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM product";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {

			Product pro = new Product();
			pro.setId(rs.getInt(1));
			pro.setName(rs.getString(2));
			pro.setPrice(rs.getDouble(3));
			pro.setQuantity(rs.getInt(4));
			pro.setImage(rs.getString(5));
			pro.setDesc(rs.getString(6));
			pro.setCategory_id(rs.getInt(7));
			pro.setStatus(rs.getString(8));
			pro.setSold(rs.getInt(9));
			
			list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//GetInforIphone
	public List<Product> getIphone(){
		List<Product> list = new ArrayList<Product>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM product WHERE category_id= 1 and `status` = 'active'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Product pro = new Product();
			pro.setId(rs.getInt(1));
			pro.setName(rs.getString(2));
			pro.setPrice(rs.getDouble(3));
			pro.setQuantity(rs.getInt(4));
			pro.setImage(rs.getString(5));
			pro.setDesc(rs.getString(6));
			pro.setCategory_id(rs.getInt(7));
			
			list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//GetInfoSpeaker
	public List<Product> getSpeaker(){
		List<Product> list = new ArrayList<Product>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM product WHERE category_id=3 and `status` = 'active'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Product pro = new Product();
			pro.setId(rs.getInt(1));
			pro.setName(rs.getString(2));
			pro.setPrice(rs.getDouble(3));
			pro.setQuantity(rs.getInt(4));
			pro.setImage(rs.getString(5));
			pro.setDesc(rs.getString(6));
			pro.setCategory_id(rs.getInt(7));
			list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//GetInfoWatch
	public List<Product> getWatch(){
		List<Product> list = new ArrayList<Product>();
		Connection con = DBconnect.getConnection();
		String sql = "SELECT * FROM product WHERE category_id=2 and `status` = 'active'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Product pro = new Product();
			pro.setId(rs.getInt(1));
			pro.setName(rs.getString(2));
			pro.setPrice(rs.getDouble(3));
			pro.setQuantity(rs.getInt(4));
			pro.setImage(rs.getString(5));
			pro.setDesc(rs.getString(6));
			pro.setCategory_id(rs.getInt(7));
			list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//GetInfoByName
		public Product getByID(int id){
			
			Product pro = null;
			Connection con = DBconnect.getConnection();
			String sql = "SELECT * FROM product WHERE id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				pro = new Product();

				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setPrice(rs.getDouble(3));
				pro.setQuantity(rs.getInt(4));
				pro.setImage(rs.getString(5));
				pro.setDesc(rs.getString(6));
				pro.setCategory_id(rs.getInt(7));
				pro.setStatus(rs.getString(8));
				pro.setSold(rs.getInt(9));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pro;
		}
//Search function
public List<Product> search(String text){
	List<Product> list = new ArrayList<Product>();
	Connection con = DBconnect.getConnection();
	if (text == "") {
		text = "?";
	}
	String sql = "SELECT * FROM product where `name` like '%"+text+"%';";
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

	while(rs.next()) {
		
		Product pro = new Product();
		pro.setId(rs.getInt(1));
		pro.setName(rs.getString(2));
		pro.setPrice(rs.getDouble(3));
		pro.setQuantity(rs.getInt(4));
		pro.setImage(rs.getString(5));
		pro.setDesc(rs.getString(6));
		pro.setCategory_id(rs.getInt(7));
		list.add(pro);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}		
//Check duplicate product name
public List<Product> searchProductName(String text){
	List<Product> list = new ArrayList<Product>();
	Connection con = DBconnect.getConnection();
	if (text == "") {
		text = "?";
	}
	String sql = "SELECT * FROM product where `name` like '%"+text+"%';";
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

	while(rs.next()) {
		
		Product pro = new Product();
		pro.setId(rs.getInt(1));
		pro.setName(rs.getString(2));
		pro.setPrice(rs.getDouble(3));
		pro.setQuantity(rs.getInt(4));
		pro.setImage(rs.getString(5));
		pro.setDesc(rs.getString(6));
		pro.setCategory_id(rs.getInt(7));
		list.add(pro);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
//Check update name product
//Check duplicate product name
public List<Product> checkNameProduct(String text, int id){
	List<Product> list = new ArrayList<Product>();
	Connection con = DBconnect.getConnection();
	if (text == "") {
		text = "?";
	}
	String sql = "SELECT * FROM product where `name` = '"+text+"' and not id=" + id;
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

	while(rs.next()) {
		
		Product pro = new Product();
		pro.setId(rs.getInt(1));
		pro.setName(rs.getString(2));
		pro.setPrice(rs.getDouble(3));
		pro.setQuantity(rs.getInt(4));
		pro.setImage(rs.getString(5));
		pro.setDesc(rs.getString(6));
		pro.setCategory_id(rs.getInt(7));
		list.add(pro);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

//Update product	
public boolean update (Product pd1) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update product set name =?, price = ?,  quantity=?, image=?, `desc`=?, category_id =?, `status` =? where id = ?";
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pd1.getName());
		ps.setDouble(2, pd1.getPrice());
		ps.setInt(3, pd1.getQuantity());
		ps.setString(4, pd1.getImage());
		ps.setString(5, pd1.getDesc());
		ps.setInt(6, pd1.getCategory_id());	
		ps.setString(7, pd1.getStatus());
		ps.setInt(8, pd1.getId());
		
		
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
//Insert new Product
public boolean insert(Product pd1) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "insert into product(id, name, price, quantity, image, `desc`, category_id) values (?,?,?,?,?,?,?)";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pd1.getId());
		ps.setString(2, pd1.getName());
		ps.setDouble(3, pd1.getPrice());
		ps.setInt(4, pd1.getQuantity());
		ps.setString(5, pd1.getImage());
		ps.setString(6, pd1.getDesc());
		ps.setInt(7, pd1.getCategory_id());

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

//Update sold
public boolean updateSold (int id) {
	boolean check = false;
	Connection conn = DBconnect.getConnection();
	String sql = "update product set sold = (select sum(quantity) from cart where product_id = id and `status` in ('In Delivery','Received')) WHERE id =?";
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
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

//Check dupilicate name


//Delete Product
public void DeleteP(int id) {
	Connection conn = DBconnect.getConnection();
	String sql = "delete from product where id=?";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
}
