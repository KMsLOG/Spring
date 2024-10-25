package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Tag(name="user-rest-controller", description = "User Rest Controller")
public class UserRestController {
	// 의존성 주입
	private final UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	// 삽입하기
	@PostMapping("/user")
	@Operation(summary = "사용자 정보를 삽입한다.")
	public ResponseEntity<?> insert(@ModelAttribute User user){
		userService.insert(user);
		
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	// 모든 사용자 조회
	@GetMapping("/user")
	@Operation(summary = "등록된 모든 사용자 정보를 반환한다.")
	public ResponseEntity<List<User>> list(){
		List<User> list = userService.selectAll();
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	// id에 해당하는 사용자 조회
	@GetMapping("/user/{id}")
	@Operation(summary = "{id}에 해당하는 사용자 정보를 반환한다.")
	public ResponseEntity<User> user(@PathVariable("id") String id){
		User user = userService.searchById(id);
		return ResponseEntity.ok(user);
	}
	
	
	// 조건에 부합하는 사용자 목록 조회
	@GetMapping("/user/search")
	@Operation(summary = "SearchCondition에 부합하는 조건을 가진 사용자 목록을 반환한다.")
	public ResponseEntity<?> conList(@ModelAttribute SearchCondition con){
		List<User> list = userService.searchByCondition(con);
		if(list == null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}

}
