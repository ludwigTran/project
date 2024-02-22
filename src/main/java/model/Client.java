package model;

public class Client {
	

// 7 column
	
private int id;
private String username;
private String password;
private String fullname;
private String email;
private String phonenumber;
private String address;




public Client() {
	super();
}


public Client(String username, String password, String fullname, String email, String phonenumber, String address) {
	super();
	
	this.username = username;
	this.password = password;
	this.fullname = fullname;
	this.email = email;
	this.phonenumber = phonenumber;
	this.address = address;

}




public Client(int id, String password, String fullname, String email, String phonenumber, String address) {
	super();
	this.id = id;
	this.password = password;
	this.fullname = fullname;
	this.email = email;
	this.phonenumber = phonenumber;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}





}
