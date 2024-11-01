package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.ReviewDao;
import com.ssafy.mvc.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewDao dao;
	
	public ReviewServiceImpl(ReviewDao dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public void writeReview(Review review) {
		dao.insertReview(review);
	}

	@Override
	public List<Review> getReviews(int youtubeId) {
		return dao.selectAll(youtubeId);
	}

	@Override
	@Transactional
	public void modifyReview(Review review) {
		dao.updateReview(review);
	}

	@Override
	@Transactional
	public void removeReview(int reviewId) {
		dao.deleteReview(reviewId);
	}

	@Override
	public Review getReview(int reviewId) {
		return dao.selectOne(reviewId);
	}

}
