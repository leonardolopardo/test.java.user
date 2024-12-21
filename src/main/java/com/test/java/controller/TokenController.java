package com.test.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.jwt.JwtService;


/**
 * Controlador para el comportamiento de token JWT
 */
@RequestMapping("/token")
@RestController
public class TokenController {
	
	@Autowired
	JwtService jwtUtil;
	
    @GetMapping("/generate")
    public String generateToken() {
        return "Tu Token es: " + jwtUtil.generateToken("admin");
    }

    @GetMapping("/protected")
    public String protectedEndpoint(@RequestHeader("Authorization") String token) {
        
    	//if(jwtUtil.validateToken(token, )) {}
	
    	return "Acceso permitido con token válido: " + token;
    }
}
