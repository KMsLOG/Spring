package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Review;

public interface ReviewDao {
	// 리뷰 등록
	public void insertReview(Review review);
	
	// 리뷰 id로 리뷰 조회
	public Review selectOne(int reviewId);
	
	// 유튜브 id에 맞는 리뷰 전체 목록
	public List<Review> selectAll(int youtubeId);
	
	// 리뷰 수정
	public void updateReview(Review review);
	
	// 리뷰 삭제
	public void deleteReview(int reviewId);
}
