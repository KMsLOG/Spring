package com.ssafy.ws;

public class HairFoundException extends RuntimeException {
	public void handleException() {
		System.out.println("주방장이 나와서 머리카락에 대해 사과합니다.");
	}
}
