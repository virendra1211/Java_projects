package vk.learning.important.interview;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PriceSubscriptionStratey {

	public static void main(String[] args) {
		Subscription sub = new Subscription("C1", "Jira", "Basic", LocalDate.of(2024, 3, 10));
		Map<String, Object> result = SubscriptionService.calculateCost(sub);

		System.out.println("Monthly Cost: " + Arrays.toString((double[]) result.get("monthly")));
		System.out.println("Yearly Cost: " + result.get("yearly"));
	}

}

// Abstract class that handles common functionality for pricing plans
abstract class AbstractPaymentStrategy implements PaymentStrategy {
	protected double price;

	// Abstract method to be implemented by specific pricing plan classes
	protected abstract double getPrice();

	// Common logic for all strategies to build monthly cost array
	public double[] calculateMonthlyCost(LocalDate startDate) {
		return buildMonthlyArray(startDate, getPrice());
	}

	// Common method for calculating yearly cost
	public double calculateYearlyCost(LocalDate startDate) {
		return Arrays.stream(calculateMonthlyCost(startDate)).sum();
	}

	// Method to build the monthly cost array, shared by all strategies
	private double[] buildMonthlyArray(LocalDate startDate, double value) {
		double[] cost = new double[12];
		int startMonth = startDate.getMonthValue();
		// Fill the monthly array from the start month to the end
		for (int i = startMonth - 1; i < 12; i++) {
			cost[i] = value;
		}
		return cost;
	}
}

// Concrete class for Basic Plan
class BasicPlanPayment extends AbstractPaymentStrategy {
	@Override
	protected double getPrice() {
		return 9.99; // Specific price for Basic plan
	}
}

// Concrete class for Standard Plan
class StandardPlanPayment extends AbstractPaymentStrategy {
	@Override
	protected double getPrice() {
		return 49.99; // Specific price for Standard plan
	}
}

// Concrete class for Premium Plan
class PremiumPlanPayment extends AbstractPaymentStrategy {
	@Override
	protected double getPrice() {
		return 249.99; // Specific price for Premium plan
	}
}

// Strategy interface
interface PaymentStrategy {
	double[] calculateMonthlyCost(LocalDate startDate);

	double calculateYearlyCost(LocalDate startDate);
}

// Factory to return appropriate strategy
class PaymentStrategyFactory {
	public static PaymentStrategy getStrategy(String plan) {
		switch (plan.toLowerCase()) {
		case "basic":
			return new BasicPlanPayment();
		case "standard":
			return new StandardPlanPayment();
		case "premium":
			return new PremiumPlanPayment();
		default:
			throw new IllegalArgumentException("Unknown Plan: " + plan);
		}
	}
}

// Subscription class to store customer information
class Subscription {
	String customerName;
	String productName;
	String planName;
	LocalDate startDate;

	public Subscription(String customerName, String productName, String planName,
			LocalDate startDate) {
		this.customerName = customerName;
		this.productName = productName;
		this.planName = planName;
		this.startDate = startDate;
	}
}

// Subscription Service to calculate cost
class SubscriptionService {
	public static Map<String, Object> calculateCost(Subscription subscription) {
		PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(subscription.planName);
		double[] monthlyCost = strategy.calculateMonthlyCost(subscription.startDate);
		double yearlyCost = strategy.calculateYearlyCost(subscription.startDate);

		Map<String, Object> result = new HashMap<>();
		result.put("monthly", monthlyCost);
		result.put("yearly", yearlyCost);
		return result;
	}
}
