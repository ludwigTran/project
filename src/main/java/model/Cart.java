package model;

public class Cart{
	// 6 column
	private int client_id;
	private int product_id;
	private String product_name;
	private double price;
	private int quantity;
	private String product_image;
	private String status;
	private int order_id;
	
	public Cart() {
		super();
	}

	public Cart(int client_id, int product_id, String product_name, double price, int quantity, String product_image) {
		super();
		this.client_id = client_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.product_image = product_image;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity > 0) {
			this.quantity = quantity;
		} else quantity = 0;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	
	
}	
