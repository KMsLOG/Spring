package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.dto.Wished;

public interface WishedService {
	// 찜 영상 등록
	public void wished(Wished wished);
	
	// 찜 영상 삭제
	public void removeWished(Wished wished);
	
	// 전체 찜 영상 목록
	public List<Video> getWished(String userId);
}
