package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Follow;
import com.ssafy.mvc.model.service.FollowService;
import com.ssafy.mvc.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/follow")
public class FollowRestController {
	private final FollowService service;
	private final UserService userService;
	
	public FollowRestController(FollowService service,UserService userService) {
		this.service = service;
		this.userService = userService;
	}
	
	// 팔로우 등록
	@PostMapping("/{userId}")
	@Operation(summary = "팔로우")
	public ResponseEntity<?> follow(@PathVariable("userId") String userId,@RequestBody Follow follow){
		if(userService.getUserById(userId)==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		
		if(userService.getUserById(follow.getFollowingId())==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		
		service.follow(follow);
		return new ResponseEntity<String>("팔로우!",HttpStatus.OK);
	}
	// 팔로우 취소
	@DeleteMapping("/{userId}/{followingId}")
	@Operation(summary = "언팔로우")
	public ResponseEntity<?> unfollow(@PathVariable("userId") String userId, @PathVariable("followingId") String followingId) {
		if(userService.getUserById(userId)==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		
		if(userService.getUserById(followingId)==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		
		service.unfollow(userId, followingId);
		return new ResponseEntity<String>("언팔로우",HttpStatus.OK);
	}
		
	// info는 유저아이디, 팔로우아이디
		
	// 나의 팔로우 전체 목록
	@GetMapping("/{userId}")
	@Operation(summary = "나의 팔로우 전체 목록")
	public ResponseEntity<?> list(@PathVariable("userId") String userId){
		if(userService.getUserById(userId)==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		List<Follow> list = service.getFollow(userId);
		return new ResponseEntity<List<Follow>>(list,HttpStatus.OK);
	}
}
