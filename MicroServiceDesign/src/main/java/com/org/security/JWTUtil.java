package com.org.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    private String SECRET_KEY = "mysecret";

    public String extractUsername(String token) {
	return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	final Claims claims = extractAllClaims(token);
	return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
	return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
	final String username = extractUsername(token);
	return (username.equals(userDetails.getUsername()));
    }

    public String generateToken(UserDetails userDetails) {
	return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
		.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
}
