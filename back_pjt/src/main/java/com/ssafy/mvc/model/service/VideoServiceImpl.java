package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService{
	
	private final VideoDao dao;
	
	public VideoServiceImpl(VideoDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void registVideo(Video video) {
		dao.insertVideo(video);
	}

	@Override
	public List<Video> getVideos() {
		return dao.selectAll();
	}

	@Override
	public List<Video> getVideosByPart(String fitPartName) {
		return dao.selectByPart(fitPartName);
	}

	@Override
	public Video getVideoById(int youtubeId) {
		dao.updateViewCnt(youtubeId);
		return dao.selectOne(youtubeId);
	}

	@Override
	@Transactional
	public void modifyVideo(Video video) {
		dao.updateVideo(video);
	}

	@Override
	@Transactional
	public void removeVideo(int youtubeId) {
		dao.deleteVideo(youtubeId);
	}

}
