package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	
	// 정석 -> Service를 의존성 주입 받아야 한다.
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		//userService라는 친구를 통해서 실제로 id / pw 를 이용하여 DB까지 확인하고 실제 유저가 맞는지 확인 해야함.
		//세션에 정보를 저장해야됨.
		System.out.println(user.toString());
		
		// 지금 서비스를 구현하지 않아서 넘겨받은 user의 id를 냅다 넣었다.
		// 실제로 구현하고 난 뒤 인증 받은 정보만 넣어야 함
		session.setAttribute("loginUser", user.getId());
		
		return "redirect:hello";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 로그아웃을 하는 방법 2가지
		// 1. 세션에서 유저 속성을 지우는 작업
		session.removeAttribute("loginUser");
		
		// 2. 세션 자체를 초기화
//		session.invalidate();
		
		
		return "redirect:/";
	}
}
