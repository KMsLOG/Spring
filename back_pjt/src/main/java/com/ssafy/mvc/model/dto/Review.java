package com.ssafy.mvc.model.dto;

public class Review {
	int reviewId;
	int youtubeId;
	String writer;
	String content;
	
	
	public Review() {}

	public Review(int reviewId, int youtubeId, String writer, String content) {
		this.reviewId = reviewId;
		this.youtubeId = youtubeId;
		this.writer = writer;
		this.content = content;
	}
	

	public Review(int youtubeId, String writer, String content) {
		super();
		this.youtubeId = youtubeId;
		this.writer = writer;
		this.content = content;
	}

	public Review(String writer, String content) {
		super();
		this.writer = writer;
		this.content = content;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(int youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", youtubeId=" + youtubeId + ", writer=" + writer + ", content="
				+ content + "]";
	}
	
	
}
