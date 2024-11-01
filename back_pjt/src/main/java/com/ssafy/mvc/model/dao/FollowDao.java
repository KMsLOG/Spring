package com.ssafy.mvc.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.Follow;
import com.ssafy.mvc.model.dto.Video;

public interface FollowDao {
	// 팔로우 등록
	public void insertFollow(Follow follow);
	
	// 팔로우 취소
	public void deleteFollow(Map<String,String> info);
	// info는 유저아이디, 팔로우아이디
	
	// 나의 팔로우 전체 목록
	public List<Follow> selectAll(String userId);
	
	// 팔로우한 외원들이 찜한 영상 조회
	public List<Video> selectWished(String userId);	
}
