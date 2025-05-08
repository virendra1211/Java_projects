package vk.learning.thread.interview.ecommerce;

//Product.java
public class Product1 {
	private int id;
	private String name;
	private String description;

	public Product1(int id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product1 [id=" + id + ", name=" + name + ", description=" + description + ", price="
				+ price + "]";
	}

	private double price;
	// constructors, getters, setters

}

//Inventory.java
