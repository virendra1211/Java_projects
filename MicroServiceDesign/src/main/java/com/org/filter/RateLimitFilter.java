package com.org.filter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;

import org.springframework.stereotype.Component;

import com.org.model.Bucket;

//import io.github.bucket4j.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RateLimitFilter implements Filter {

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    private Bucket resolveBucket(String ip) {
	return buckets.computeIfAbsent(ip, k -> Bucket4j.builder()
		.addLimit(Bandwidth.classic(5, Refill.intervally(5, Duration.ofMinutes(1)))).build());
    }

    private Bucket resolveBucket(String ip) {
	return buckets.computeIfAbsent(ip, k -> Bucket4j.builder()
		.addLimit(Bandwidth.classic(5, Refill.intervally(5, Duration.ofMinutes(1)))).build());
    }

    @Override
    public void init(FilterConfig filterConfig) throws javax.servlet.ServletException {
	// TODO Auto-generated method stub

    }

    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response,
	    javax.servlet.FilterChain chain) throws IOException, javax.servlet.ServletException {
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	String ip = httpRequest.getRemoteAddr();
	Bucket bucket = resolveBucket(ip);

	if (bucket.tryConsume(1)) {
	    chain.doFilter(request, response);
	} else {
	    ((HttpServletResponse) response).setStatus(429);
	    response.getWriter().write("Too Many Requests");
	}

    }

    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }
}
