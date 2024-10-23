package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

@Controller
public class UserController {
	
	@GetMapping("/regist")
	public String registform() {
		
		return "regist";
	}
	
//	@PostMapping("/regist")
//	public String regist(@RequestParam("id") String id,@RequestParam("pw") String pw) {
//		
//		User user = new User(id,pw);
//		System.out.println(user);
//		return "result"; // 에러방지용
//	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user,Model model) {
		System.out.println(user);
		model.addAttribute("user", user);
		return "result"; // 에러방지용
	}
}
