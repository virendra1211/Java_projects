package com.org.aws;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * To optimize AWS Lambda usage and cost when you have multiple functions (e.g., xl, l, s) with different memory configurations, 
 * the key is to route workloads based on size/complexity.
 *  Here's a structured approach to minimize cost while maximizing performance:a
 *  
 *  1. Define Clear Routing Logic Based on Input Size
		You must decide what constitutes a small, medium, or large job. This could be:
		Payload size (e.g., image size, file size)
		Complexity (e.g., number of records to process)
		Execution time or computational complexity
	2. Create a Dispatcher Lambda (Router)
	3. Assign Lambda Memory Strategically
	4. Monitor and Adjust Over Time

 */
public class RouterHandler implements RequestHandler<Map<String, Object>, String> {

	private final AWSLambda lambdaClient = AWSLambdaClientBuilder.defaultClient();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public String handleRequest(Map<String, Object> input, Context context) {
		String payload;
		try {
			payload = mapper.writeValueAsString(input);
		} catch (Exception e) {
			return "Failed to serialize input: " + e.getMessage();
		}

		int size = estimatePayloadSize(payload);
		String functionName;

		if (size < 1000) {
			functionName = "service-s";
		} else if (size < 10000) {
			functionName = "service-l";
		} else {
			functionName = "service-xl";
		}

		InvokeRequest request = new InvokeRequest().withFunctionName(functionName)
				.withPayload(payload).withInvocationType("Event"); // async

		lambdaClient.invoke(request);
		return "Dispatched to: " + functionName;
	}

	private int estimatePayloadSize(String payload) {
		return payload.getBytes(StandardCharsets.UTF_8).length;
	}

}
