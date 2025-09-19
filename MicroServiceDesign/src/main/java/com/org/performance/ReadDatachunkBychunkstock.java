package com.org.performance;

import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDatachunkBychunkstock {
	StockService service;

	@GetMapping("/stream")
	public StreamingResponseBody streamStocks(HttpServletResponse response) {
		response.setContentType("text/event-stream");
		return outputStream -> {
			service.getAllStocks().forEach(stock -> {
				try {
					String json = new ObjectMapper().writeValueAsString(stock) + "\n";
					outputStream.write(json.getBytes());
					outputStream.flush();
				} catch (Exception e) {
				}
			});
		};
	}

	// if want to send 20 updates at a time
	/*
	 * How we can live the dash boardh in interview question
	 */
	@GetMapping("/live")
	public StreamingResponseBody streamStocks1(HttpServletResponse response) {
		response.setContentType("text/event-stream"); // browser/clients tream
		return (OutputStream outputStream) -> {
			try {
				for (int i = 0; i < 20; i++) {
					double price = 100 + new Random().nextDouble() * 10;
					String update = "Stock Price: " + price + "\n";
					outputStream.write(update.getBytes());
					outputStream.flush();
					Thread.sleep(1000);
				}
			} catch (Exception e) {
			}
		};
	}
	// other approach stream reactive, grpc, webflux
}

class StockService {
	public List<String> getAllStocks() {
		return null;
	}
}
