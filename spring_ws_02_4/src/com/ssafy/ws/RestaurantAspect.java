package com.ssafy.ws;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RestaurantAspect {
	
	private Restaurant restaurant;
	
	@Pointcut("execution(* com.ssafy.ws.*.open())")
	public void mypt() {} // 여기 메서드명이 ID가 된다.
	
	@Before("mypt()")
	public void before() {
		System.out.println(restaurant.getInfo()+"을 위해 재료를 준비합니다.");
	}
	
	@AfterReturning(value = "mypt()",returning = "num")
	public void afterReturning(int num) {
		System.out.println("직원들에게 보너스 지급!! : "+num+"원");
	}
}
