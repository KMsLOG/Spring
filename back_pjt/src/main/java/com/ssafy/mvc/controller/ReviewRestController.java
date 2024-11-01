package com.ssafy.mvc.controller;

import java.util.ArrayList;
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

import com.ssafy.mvc.model.dto.Review;
import com.ssafy.mvc.model.service.ReviewService;
import com.ssafy.mvc.model.service.VideoService;


@RestController
@RequestMapping("/review")
public class ReviewRestController {
	
	private final ReviewService service;
	
	private final VideoService videoService;
	
	public ReviewRestController(ReviewService service,VideoService videoService) {
		this.service = service;
		this.videoService=videoService;
	}
	
	// 리뷰 등록
	@PostMapping("/{youtubeId}")
	public ResponseEntity<?> addReview(@PathVariable("youtubeId") int youtubeId,@RequestBody Review review){
		if(videoService.getVideoById(youtubeId)==null) {
			return new ResponseEntity<String>("비디오가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		}
		
		service.writeReview(review);
		return new ResponseEntity<String>("리뷰 등록", HttpStatus.CREATED);
	}
	
	// 리뷰 상세
	@GetMapping("/{reviewId}")
	public ResponseEntity<?> detailReview(@PathVariable("reviewId") int reviewId){
		Review review = service.getReview(reviewId);
		if(review == null) {
			return new ResponseEntity<String>("리뷰가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	// 유튜브 id에 맞는 리뷰 전체 목록
	@GetMapping("/{youtubeId}")
	public ResponseEntity<?> getReviews(@PathVariable("youtubeId") int youtubeId){
		List<Review> list = service.getReviews(youtubeId);
		if(list==null || list.size()==0) {
			list = new ArrayList<>();
		}
		return new ResponseEntity<List<Review>>(list,HttpStatus.OK);
	}
	
	// 리뷰 수정
	@PutMapping("{reviewId}")
	public ResponseEntity<?> updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review){
		if(service.getReview(reviewId)==null) {
			return new ResponseEntity<String>("리뷰가 없습니다.",HttpStatus.NOT_FOUND);
		}
		service.modifyReview(review);
		return new ResponseEntity<String>("리뷰 수정 완료.",HttpStatus.OK);
	}
	
	// 리뷰 삭제
	@DeleteMapping("{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable("reviewId") int reviewId){
		if(service.getReview(reviewId)==null) {
			return new ResponseEntity<String>("리뷰가 없습니다.",HttpStatus.NOT_FOUND);
		}
		service.removeReview(reviewId);;
		return new ResponseEntity<String>("리뷰 삭제 완료.",HttpStatus.OK);
	}
	
}
