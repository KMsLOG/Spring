package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user,HttpSession session) {
		User tmp =userService.login(user.getId(), user.getPassword());
		
		// tmp : 정상 로그인 -> User 정보 / 비정상 로그인 -> null
		
		if(tmp == null) {
			return "redirect:login"; // 로그인 화면으로 보냄
		} 
		
		session.setAttribute("loginUser", tmp.getName());
		
		return "redirect:list";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	
	// 회원가입
	@GetMapping("/signup")
	public String signupForm() {
		return"/user/signupform";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);
		return "/board/list";
	}
	
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/adminPage";
	}
}
