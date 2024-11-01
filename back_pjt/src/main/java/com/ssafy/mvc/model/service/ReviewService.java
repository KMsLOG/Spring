package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Review;

public interface ReviewService {
	// 리뷰 등록
	public void writeReview(Review review);
	
	// 리뷰 id로 리뷰 조회
	public Review getReview(int reviewId);
	
	// 유튜브 id에 맞는 리뷰 전체 목록
	public List<Review> getReviews(int youtubeId);
	
	// 리뷰 수정
	public void modifyReview(Review review);
	
	// 리뷰 삭제
	public void removeReview(int reviewId);
}
