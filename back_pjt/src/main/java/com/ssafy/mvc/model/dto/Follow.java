package com.ssafy.mvc.model.dto;

public class Follow {
	String userId;
	String followingId;
	
	public Follow() {}

	public Follow(String userId, String followingId) {
		super();
		this.userId = userId;
		this.followingId = followingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFollowingId() {
		return followingId;
	}

	public void setFollowingId(String followingId) {
		this.followingId = followingId;
	}
	
	
}
