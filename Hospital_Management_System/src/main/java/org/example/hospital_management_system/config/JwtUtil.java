package org.example.hospital_management_system.config;


import io.jsonwebtoken.*;
import org.example.hospital_management_system.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;


@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private Key secret;

    @Value("${jwt.expiration}")
    private Long EXPIRATION;


    public String generateToken(UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = (User) userDetails;
        return Jwts.builder()
                .subject(username)
                .claim("full_name", user.getFullName())
                .claim("email", user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date( System.currentTimeMillis()+ getExpirationTime()))
                .signWith(getKey())
                .compact();
    }

    // Used to get All Claims from  a Token
    public Claims getClaims (String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    // Extracting a single claim from the token
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    // This method extracts the username from token using getClaim method
    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // This method extracts the expirationTime from token using getClaim method
    public Date getExpirationTime(String token) {
        return getClaim(token, Claims::getExpiration);
    }


    public Key getKey() {
        return secret;
    }

    public Long getExpirationTime() {
        return EXPIRATION;
    }

    public boolean isTokenExpired(String token) {
        return getExpirationTime(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
}
