package com.project.FocusFlow.security;

import com.project.FocusFlow.config.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expirationMs}")
    private int expirationMs;

    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userDetails.getUsername()))
                .claim("id", userDetails.getId())      // Добавляем ID
                .claim("email", userDetails.getEmail()) // Добавляем email
                .claim("role", userDetails.getRole())   // Добавляем роль
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() + expirationMs)))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Claims getAllClaimsFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmailFromJwtToken(String token) {
        return getAllClaimsFromJwtToken(token).get("email", String.class);
    }

    public String getRoleFromJwtToken(String token) {
        return getAllClaimsFromJwtToken(token).get("role", String.class);
    }

    public Integer getIdFromJwtToken(String token) {
        return getAllClaimsFromJwtToken(token).get("id", Integer.class);
    }
}