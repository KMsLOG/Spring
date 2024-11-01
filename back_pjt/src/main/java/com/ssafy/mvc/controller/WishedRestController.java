package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.dto.Wished;
import com.ssafy.mvc.model.service.UserService;
import com.ssafy.mvc.model.service.VideoService;
import com.ssafy.mvc.model.service.WishedService;

@RestController
@RequestMapping("/wished")
public class WishedRestController {
	private final WishedService service;
	private final UserService userService;
	private final VideoService videoService;
	
	public WishedRestController(WishedService service,UserService userService,VideoService videoService) {
		this.service =service;
		this.userService = userService;
		this.videoService = videoService;
	}
	
	// 찜 영상 등록
	@PostMapping()
	public ResponseEntity<?> add(@RequestBody Wished wished){
		if(userService.getUserById(wished.getUserId())==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		if(videoService.getVideoById(wished.getVideoId())==null) {
			return new ResponseEntity<String>("영상이 없습니다.",HttpStatus.NOT_FOUND);
		}
		
		service.wished(wished);
		return new ResponseEntity<String>("영상 찜!",HttpStatus.OK);
	}
	// 찜 영상 삭제
	@DeleteMapping()
	public ResponseEntity<?> remove(@RequestBody Wished wished){
		if(userService.getUserById(wished.getUserId())==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		if(videoService.getVideoById(wished.getVideoId())==null) {
			return new ResponseEntity<String>("영상이 없습니다.",HttpStatus.NOT_FOUND);
		}
		
		service.removeWished(wished);;
		return new ResponseEntity<String>("찜 삭제!",HttpStatus.OK);
	}
	
	// 전체 찜 영상 목록
	@GetMapping("/{userId}")
	public ResponseEntity<?> list(@PathVariable("userId") String userId){
		if(userService.getUserById(userId)==null) {
			return new ResponseEntity<String>("유저가 없습니다.",HttpStatus.NOT_FOUND);
		}
		List<Video> list = service.getWished(userId);
		if(list==null|| list.size()==0) {
			list = new ArrayList<>();
		}
		
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
}
