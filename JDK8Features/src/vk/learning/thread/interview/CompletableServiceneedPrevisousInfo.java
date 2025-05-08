package vk.learning.thread.interview;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableServiceneedPrevisousInfo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// 1. Start Flight and Loyalty services in parallel
		CompletableFuture<Flight> flightFuture = CompletableFuture
				.supplyAsync(() -> flightService.getFlight(from, to), executor);

		CompletableFuture<Loyalty> loyaltyFuture = CompletableFuture
				.supplyAsync(() -> loyaltyService.getLoyalty(userId, from + "-" + to), executor);

		// 2. Pricing depends on Flight info
		CompletableFuture<Price> priceFuture = flightFuture.thenApply(
				flight -> pricingService.getPrice(flight.getAirline(), flight.getDuration()));

		// 3. Wait for all
		CompletableFuture.allOf(flightFuture, priceFuture, loyaltyFuture).join();

		// 4. Aggregate result
		return new FlightResult(flightFuture.join(), priceFuture.join(), loyaltyFuture.join());
	}

	class Flight {
	}

	class Loyalty {
	}

	class Price {
	}

	class FlightResult {

	}

}
