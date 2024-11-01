package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Follow;
import com.ssafy.mvc.model.dto.Video;

public interface FollowService {
	// 팔로우 등록
	public void follow(Follow follow);
		
	// 팔로우 취소
	public void unfollow(String userId,String followingId);
		
	// 나의 팔로우 전체 목록
	public List<Follow> getFollow(String userId); 
	
	// 팔로우한 외원들이 찜한 영상 조회
	public List<Video> getFollowWished(String userId);
}
