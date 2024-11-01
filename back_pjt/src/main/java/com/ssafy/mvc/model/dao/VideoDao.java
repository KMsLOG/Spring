package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Video;

public interface VideoDao {
	// 비디오 등록
	public void insertVideo(Video video);
	
	// 비디오 전체목록
	public List<Video> selectAll();
	
	// 비디오 운동부위별 목록
	public List<Video> selectByPart(String fitPartName);
	
	// id에 해당하는 비디오 조회
	public Video selectOne(int youtubeId);
	
	// 비디오 수정
	public void updateVideo(Video video);
	
	// 비디오 삭제
	public void deleteVideo(int youtubeId);
	
	// 비디오 id로 조회수 증가
	public void updateViewCnt(int youtubeId);
	
	// 조회수 내림차순 영상 목록
	public List<Video> selectOrderByView();
}
