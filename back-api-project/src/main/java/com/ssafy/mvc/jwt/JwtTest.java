package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTest {
	public static void main(String[] args) throws InterruptedException {
		// 비밀키가 하나 필요하다
		String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
		
		
		Map<String,String> headers = new HashMap<>();
		headers.put("typ", "JWT");
		
		// JWT 3가지 헤더 / 페이로드 (데이터) / 서명
		String Token = Jwts.builder() 	// JWT를 만들 수 있는 빌더
						.header()		// 빌더 헤더를 만드는 객체가 되었음
						.add("name","choi").add(headers).and() // JWT 빌더로 돌아갔다
						.subject("ssafy").expiration(new Date(System.currentTimeMillis()+3000)) // 현재 시간 기준 3초 유효
						.signWith(secretKey) // 서명 완료
						.compact();
		
		Thread.sleep(4000);
		
		Jws<Claims> jwsClaims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(Token);
		System.out.println(jwsClaims.getHeader());
		System.out.println(jwsClaims.getPayload());
	}
}
