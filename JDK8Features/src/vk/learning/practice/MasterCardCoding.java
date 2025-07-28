package vk.learning.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MasterCardCoding {
	List<Consumer> consumers = Arrays.asList(new Consumer("Alice", 1200), new Consumer("Bob", 800),
			new Consumer("Charlie", 1500), new Consumer("Diana", 950), new Consumer("Eve", 2200),
			new Consumer("Frank", 400), new Consumer("Grace", 1300), new Consumer("Heidi", 3000),
			new Consumer("Ivan", 1700), new Consumer("Judy", 900), new Consumer("Mallory", 2000),
			new Consumer("Niaj", 600));

	public static void main(String[] args) {
		MasterCardCoding obj = new MasterCardCoding();
		obj.findTopTenAndsicountapply();

	}

	private void findTopTenAndsicountapply() {
		// Find the top 10 highest-spending consumers and give them a 10% discount.
		int discount = 10;
		consumers.stream().sorted(Comparator.comparingDouble(Consumer::getSpending).reversed())
				.limit(10)
				.peek(c -> c.setSpending(c.getSpending() - (c.getSpending() * discount / 100)))
				.collect(Collectors.toList());
		consumers.forEach(System.out::println);

		// Print the consumers along with their discounts.

		List<String> top10WithDiscounts = consumers.stream()
				.sorted(Comparator.comparingDouble(Consumer::getSpending).reversed()).limit(10)
				.map(c -> {
					double originalSpending = c.getSpending();
					double discountAmount = (originalSpending * discount) / 100;
					double discountedSpending = originalSpending - discountAmount;
					return String.format(
							"Name: %s | Original Spending:%.2f | Discount: %.2f | After Discount : %.2f",
							c.getName(), originalSpending, discountAmount, discountedSpending);
				}).collect(Collectors.toList());

		top10WithDiscounts.forEach(System.out::println);

	}

}

class Consumer {
	String name;
	double spending;

	Consumer(String name, double spending) {
		this.name = name;
		this.spending = spending;
	}

	double applyDiscount(double percentage) {
		return spending - (spending * percentage / 100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpending() {
		return spending;
	}

	public void setSpending(double spending) {
		this.spending = spending;
	}

	@Override
	public String toString() {
		return "Consumer: " + name + ", Spending: " + spending;
	}
}
