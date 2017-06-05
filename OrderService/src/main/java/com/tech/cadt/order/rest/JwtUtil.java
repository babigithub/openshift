package com.tech.cadt.order.rest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletResponse;

public class JwtUtil {
	
	public static String getSubject(HttpServletResponse httpServletResponse,String token, String signingKey) {
		Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
		String username = claims.getBody().getSubject();
		return username;
	}

	
	public static String getPassword(HttpServletResponse httpServletResponse,String token, String signingKey) {
		Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
		Object password = claims.getBody().get("password");
		return password.toString();
	}


	}
