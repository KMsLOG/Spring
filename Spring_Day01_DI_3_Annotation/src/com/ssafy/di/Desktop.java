package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
	public String getInfo() {
		return "데스크톱";
	}
}
