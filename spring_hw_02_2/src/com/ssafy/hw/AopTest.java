package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		User aUser = context.getBean("adminUser",User.class);
		User gUser = context.getBean("generalUser",User.class);
		
		System.out.println("****** 1. GeneralUser");
		try {
			gUser.useApp();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("****** 2. AdminUser");
		try {
			aUser.useApp();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
