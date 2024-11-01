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

@RestController
@RequestMapping("/user")
public class UserRestController {
	private final UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	// 유저 등록
	@PostMapping()
	public ResponseEntity<?> regist(@RequestBody User user){
		userService.registUser(user);
		return new ResponseEntity<String>("등록 완료",HttpStatus.CREATED);
	}
	
	// 유저 전체 목록
	@GetMapping()
	public ResponseEntity<?> list(){
		List<User> list = userService.getUsers();
		
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	// id로 유저 찾기
	@GetMapping("/{id}")
	public ResponseEntity<?> user(@PathVariable("id") String id){
		User user = userService.getUserById(id);
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<String>("해당 ID가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
	}
	
	// 유저 업데이트
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody User user){
		if(userService.getUserById(id)==null) {
			return new ResponseEntity<String>("해당 ID가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		}
		userService.modifyUser(user);
		return new ResponseEntity<String>("수정 완료",HttpStatus.OK);
	}
	
	// 유저 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id){
		if(userService.getUserById(id)==null) {
			return new ResponseEntity<String>("해당 ID가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		}
		userService.removeUser(id);
		return new ResponseEntity<String>("삭제 완료",HttpStatus.OK);
	} 
}
