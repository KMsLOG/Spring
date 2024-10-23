package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AInterceptor;
import com.ssafy.mvc.interceptor.BInterceptor;
import com.ssafy.mvc.interceptor.CInterceptor;
import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	// 의존성 주입 (필드 주입, 생성자 주입, 설정자 주입)
	@Autowired
	AInterceptor aInterceptor;
	@Autowired
	BInterceptor bInterceptor;
	@Autowired
	CInterceptor cInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
//		registry.addInterceptor(aInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(bInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(cInterceptor).addPathPatterns("/hello");
		registry.addInterceptor(loginInterceptor).addPathPatterns("/regist");	
	}
}
