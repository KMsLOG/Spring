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

import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoRestController {
	
	private final VideoService service;
	
	public VideoRestController(VideoService service) {
		this.service=service;
	}
	
	// 비디오 등록
	@PostMapping()
	public ResponseEntity<?> addVideo(@RequestBody Video video){
		service.registVideo(video);
		return new ResponseEntity<String>("등록 완료",HttpStatus.CREATED);
	}
	
	// 비디오 전체목록
	@GetMapping
	public ResponseEntity<?> list(){
		List<Video> list = service.getVideos();
		
		if(list==null || list.size()==0) {
			return new ResponseEntity<String>("비디오 목록이 없습니다.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
	// 비디오 운동부위별 목록
	@GetMapping("/part/{fitPartName}")
	public ResponseEntity<?> partList(@PathVariable("fitPartName") String fitPartName){
		List<Video> list = service.getVideosByPart(fitPartName);
		if(list==null || list.size()==0) {
			return new ResponseEntity<String>("비디오 목록이 없습니다.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
	// 조회수 내림차순 영상 목록
	@GetMapping("/viewCnt/desc")
	public ResponseEntity<?> descList(){
		List<Video> list = service.getVideosOrderByView();
		if(list==null || list.size()==0) {
			return new ResponseEntity<String>("비디오 목록이 없습니다.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
	// id에 해당하는 비디오 조회
	@GetMapping("/id/{youtubeId}")
	public ResponseEntity<?> video(@PathVariable("youtubeId") int youtubeId){
		Video video = service.getVideoById(youtubeId);
		if(video == null) {
			return new ResponseEntity<String>("비디오가 존재하지 않습니다.",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Video>(video,HttpStatus.OK);
	}
	
	// 비디오 수정
	@PutMapping("{youtubeId}")
	public ResponseEntity<?> update(@PathVariable("youtubeId") int youtubeId,@RequestBody Video video){
		if(service.getVideoById(youtubeId)==null) {
			return new ResponseEntity<String>("비디오가 존재하지 않습니다.",HttpStatus.NOT_FOUND);
		}
		service.modifyVideo(video);
		return new ResponseEntity<String>("수정 완료", HttpStatus.OK);
	}
	
	// 비디오 삭제
	@DeleteMapping("{youtubeId}")
	public ResponseEntity<?> delete(@PathVariable("youtubeId") int youtubeId){
		if(service.getVideoById(youtubeId)==null) {
			return new ResponseEntity<String>("비디오가 존재하지 않습니다.",HttpStatus.NOT_FOUND);
		}
		service.removeVideo(youtubeId);
		return new ResponseEntity<String>("삭제 완료", HttpStatus.OK);
	}
	
}
