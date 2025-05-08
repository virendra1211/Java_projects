package vk.learning.thread.interview.ecommerce;

import java.util.List;

public class Review1 {
	private double averageRating;
	private List<String> comments;

	public Review1(double averageRating, List<String> comments) {
		super();
		this.averageRating = averageRating;
		this.comments = comments;
	}

	// constructors, getters, setters
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
}