package model;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String image;
	private String desc;
	private int category_id;
	private String status;
	private String categoryName;
	private int sold;
	public Product() {
		super();
	}
	public Product( int id, String name, double price, int quantity, String image, String desc,
			int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.desc = desc;
		this.category_id = category_id;
	}
	

	public Product(int id, int sold) {
		super();
		this.id = id;
		this.sold = sold;
	}
	public Product(int id, String name, double price, int quantity, String image, String desc, int category_id,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.desc = desc;
		this.category_id = category_id;
		this.status = status;
	}
	public Product(String name, double price, int quantity, String image, String desc, int category_id) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.desc = desc;
		this.category_id = category_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCategoryName() {
		if(getCategory_id()==1) categoryName = "Phone";
		else if(getCategory_id()==2) categoryName = "Watch";
		else categoryName = "Speaker";
		return categoryName;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
	
	
	
}
	