package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {
	private final UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	// 유저 등록
	@PostMapping()
	@Operation(summary = "유저 등록")
	public ResponseEntity<?> regist(@RequestBody User user){
	    try {
	        userService.registUser(user);
	        return new ResponseEntity<String>("등록 완료", HttpStatus.CREATED);
	    } catch (IllegalArgumentException e) {
	        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	
	// 유저 전체 목록
	@GetMapping()
	@Operation(summary = "유저 전체 목록")
	public ResponseEntity<?> list(){
		List<User> list = userService.getUsers();
		
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	// id로 유저 찾기
	@GetMapping("/{id}")
	@Operation(summary = "id로 유저 찾기")
	public ResponseEntity<?> user(@PathVariable("id") String id){
		User user = userService.getUserById(id);
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<String>("해당 ID가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
	}
	
	// 유저 업데이트
	@PutMapping("/{id}")
	@Operation(summary = "유저 업데이트")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody User user){
		if(userService.getUserById(id)==null) {
			return new ResponseEntity<String>("해당 ID가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		}
		userService.modifyUser(user);
		return new ResponseEntity<String>("수정 완료",HttpStatus.OK);
	}
	
	// 유저 삭제
	@DeleteMapping("/{id}")
	@Operation(summary = "유저 삭제")
	public ResponseEntity<?> update(@PathVariable("id") String id){
		if(userService.getUserById(id)==null) {
			return new ResponseEntity<String>("해당 ID가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		}
		userService.removeUser(id);
		return new ResponseEntity<String>("삭제 완료",HttpStatus.OK);
	}
	
	// 로그인
	@PostMapping("/login")
	@Operation(summary = "로그인")
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session){
		User loggedInUser = userService.login(user.getId(), user.getPassword());
		
		if (loggedInUser != null) {
            session.setAttribute("loggedInUser", loggedInUser);
            return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
        }
		 return new ResponseEntity<String>("아이디 또는 비밀번호가 잘못되었습니다.", HttpStatus.UNAUTHORIZED);
	}
	
	//로그아웃
	@PostMapping("/logout")
	@Operation(summary = "로그아웃")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
        return new ResponseEntity<String>("로그아웃 완료", HttpStatus.OK);
    }
	
}
