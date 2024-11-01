package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Video;

public interface VideoService {
	// 비디오 등록
	public void registVideo(Video video);
	
	// 비디오 전체목록
	public List<Video> getVideos();
	
	// 비디오 운동부위별 목록
	public List<Video> getVideosByPart(String fitPartName);
	
	// id에 해당하는 비디오 조회 (클릭 시 조회수 증가)
	public Video getVideoById(int youtubeId);
	
	// 비디오 수정
	public void modifyVideo(Video video);
	
	// 비디오 삭제
	public void removeVideo(int youtubeId);
	
	// 조회수 내림차순 영상 목록
	public List<Video> getVideosOrderByView();
}
