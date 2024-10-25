package com.ssafy.ws;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class JapaneseRestaurant implements Restaurant{

	private String[] menu = new String[] {"초밥","우동","돈까스"};
	
	@Override
	public void open() {
		StringBuilder sb = new StringBuilder();
		sb.append("영업 중 : ");
		for(int i = 0 ;i<menu.length;i++) {
			if(i==menu.length-1) {
				sb.append(menu[i]);
			} else {
				sb.append(menu[i]+", ");
			}
		}
		sb.append("를 팔고 있습니다.");
		
		// 예외 발생 코드 
		if(new Random().nextBoolean()) {
			throw new HairFoundException();
		}
	}

	@Override
	public String getInfo() {
		
		return "일식";
	}
}
