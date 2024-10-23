package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 스프링 컨테이너 맛보기
// 의존관계 역전 맛보기
public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("/applicationContext.xml");
		
		Programmer p =  context.getBean("programmer",Programmer.class);
		Desktop desktop = context.getBean("desktop",Desktop.class);
		p.setComputer(desktop);
		p.coding();
	}
}
