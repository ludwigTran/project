package model;

import java.util.Date;

public class OrderAd {
	private int order_id;
	private int client_id;
	private double totalPrice;
	private Date create_date;
	private String status;
	private String address;
	private String note;
	public OrderAd() {
		super();
	}
	public OrderAd(int client_id, double totalPrice) {
		super();
		
		this.client_id = client_id;
		this.totalPrice = totalPrice;
	
	}
	
	
	public OrderAd(int client_id, double totalPrice, String address, String note) {
		super();
		this.client_id = client_id;
		this.totalPrice = totalPrice;
		this.address = address;
		this.note = note;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

	
}
