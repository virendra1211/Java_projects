package vk.learning.thread.interview.ecommerce;

import java.util.List;

//ProductDetails.java (aggregated response)
public class ProductDetails {
	private int id;
	private String name;
	private String description;
	private double price;
	private boolean inStock;
	private double averageRating;

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

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", inStock=" + inStock + ", averageRating=" + averageRating
				+ ", comments=" + comments + "]";
	}

	private List<String> comments;

	public ProductDetails(Product1 p, Inventory1 i, Review1 r) {
		this.id = p.getId();
		this.name = p.getName();
		this.description = p.getDescription();
		this.price = p.getPrice();
		this.inStock = i.isInStock();
		this.averageRating = r.getAverageRating();
		this.comments = r.getComments();
	}

	// getters and toString() for debug/logging
}