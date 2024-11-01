package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.FollowDao;
import com.ssafy.mvc.model.dto.Follow;
import com.ssafy.mvc.model.dto.Video;

@Service
public class FollowServiceImpl implements FollowService {
	
	private final FollowDao dao;
	
	public FollowServiceImpl(FollowDao dao) {
		this.dao = dao;
	}
	
	
	@Override
	@Transactional
	public void follow(Follow follow) {
		dao.insertFollow(follow);
	}

	@Override
	@Transactional
	public void unfollow(String userId,String followingId) {
		Map<String,String> info = new HashMap<>();
		info.put("userId", userId);
		info.put("followingId", followingId);
		dao.deleteFollow(info);
	}

	@Override
	public List<Follow> getFollow(String userId) {
		return dao.selectAll(userId);
	}


	@Override
	public List<Video> getFollowWished(String userId) {
		return dao.selectWished(userId);
	}

}
