package com.test.java.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


//FIXME encontrar la alternativa para los metodos deprecados
/**
 * JWT service
 */
@Component
@SuppressWarnings("deprecation")
public class JwtService {

	@Value("${app.secret.secretKey}")
	private String secretKey;

	// Método para obtener los detalles del token (claims)
	private Claims extractClaims(String token) {
		return  Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
	}
	
    // Método para validar el token
    private boolean isTokenExpired(String token) {
    	Claims claims = this.extractClaims(token);
        return claims.getExpiration().before(new Date());
    }
    
    // Método para obtener el username del token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }
    
 // Método para validar un token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
    
	// Método para generar el token
	public String generateToken(String subject) {
		return Jwts.builder().setSubject(subject).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora de validez
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}
}
