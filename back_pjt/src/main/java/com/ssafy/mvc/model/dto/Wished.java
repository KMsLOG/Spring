package com.ssafy.mvc.model.dto;

public class Wished {
	String userId;
	int videoId;
	
	public Wished() {}

	public Wished(String userId, int videoId) {
		super();
		this.userId = userId;
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
	
}
