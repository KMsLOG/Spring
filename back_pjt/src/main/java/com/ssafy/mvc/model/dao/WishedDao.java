package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.dto.Wished;

public interface WishedDao {
	// 찜 영상 등록
	public void insertWished(Wished wished);
	
	// 찜 영상 삭제
	public void deleteWished(Wished wished);
	
	// 전체 찜 영상 목록
	public List<Video> selectAll(String userId);
}
