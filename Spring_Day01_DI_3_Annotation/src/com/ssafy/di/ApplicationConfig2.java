package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ssafy.di"})
public class ApplicationConfig2 {
	
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean
	public Programmer programmer() {
		// 생성자 주입
		Programmer p = new Programmer(desktop());
		return p;
	}
}
