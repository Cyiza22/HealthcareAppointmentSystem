package org.example.authorisation.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.example.authorisation.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret_key}")
    private String SECRET_KEY;
    @Value("${jwt.expiration}")
    private Long EXPIRATION_TIME;

    // Generating A Token
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
                .verifyWith(getKey())
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


    public SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public Long getExpirationTime() {
        return EXPIRATION_TIME;
    }

    public boolean isTokenExpired(String token) {
        return getExpirationTime(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

}
