package com.ssafy.hw;

public class UserAspect {
	
	 public void before() {
	 	System.out.println("애플리케이션을 시작합니다.");
	 }
	
	 public void afterReturn() {
	 	System.out.println("애플리케이션 사용을 끝냅니다.");
	 }
	
	 public void afterThrow(Throwable th) {
	 	System.out.println("애플리케이션에 문제가 생겨 점검합니다.");
	 	if(th instanceof ApplicationException) {
	 		((ApplicationException)th).toString();
	 		System.out.println(((ApplicationException)th).toString());
	 	}
	 }
	
	 public void after() {
	 	System.out.println("애플리케이션을 상태와 관련없이 종료합니다.");
	 }

}
