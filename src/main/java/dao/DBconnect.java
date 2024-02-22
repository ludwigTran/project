package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/finalProject";
		String user = "root";
		String pass = "Ankngok?97";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
//			System.out.println("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		DBconnect.getConnection();
	}
}
