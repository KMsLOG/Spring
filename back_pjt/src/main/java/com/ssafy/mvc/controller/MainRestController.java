package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.service.FollowService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class MainRestController {
	
	private final FollowService followService;
	
	public MainRestController(FollowService followService) {
		this.followService = followService;
	}
	
	// 팔로우한 외원들이 찜한 영상 조회
	@GetMapping("/{userId}")
	@Operation(summary = "팔로우한 회원들이 찜한 영상 조회")
	public ResponseEntity<?> getFollowWished(@PathVariable("userId") String userId){
		List<Video> list = followService.getFollowWished(userId);
		
		if(list == null) {
			list = new ArrayList<>();
		}
		
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
		
		
	}
}
