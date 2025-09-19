package com.org.performance;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Flux;

@Controller
public class ReactiveStockController {

	StockService1 stockService;

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Stock> streamStocks() {
		return stockService.sttreamStocks();
	}

	public Flux<String> streamStockPrice() {
		return Flux.interval(Duration.ofSeconds(1)).take(20).map(i -> {
			double price = 100 + new Random().nextDouble() * 100;
			return "Stock price:" + price;
		});
	}

}

class StockService1 {
	List<Stock> getAllStocks() {
		return null;
	}

	public Flux<Stock> sttreamStocks() {
		return Flux.fromIterable(getAllStocks()).delayElements(Duration.ofSeconds(1));
	}

}

class Stock {

}