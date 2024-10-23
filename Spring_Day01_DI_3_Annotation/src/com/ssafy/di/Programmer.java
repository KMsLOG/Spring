package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="p")
public class Programmer {
	private Computer computer;
	
	// 생성자 주입
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	public Programmer() {
	}

	// 설정자를 이용해서 주입
	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	// 메서드를 통해서 주입 할 수 있음

	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}
}
