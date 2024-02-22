package model;

public class ClientInfo {

	private int id;
	private String fullname;
	private String username;
	private String password;
	private int phonenumber;
	private String email;
	private String address;
	public ClientInfo() {
		super();
	}
	public ClientInfo(int id, String fullname, String username, String password, int phonenumber, String email,
			String address) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
