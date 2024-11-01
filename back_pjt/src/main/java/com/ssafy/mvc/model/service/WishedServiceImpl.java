package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.WishedDao;
import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.dto.Wished;

@Service
public class WishedServiceImpl implements WishedService {
	
	private final WishedDao dao;
	
	public WishedServiceImpl(WishedDao dao) {
		this.dao=dao;
	}
	
	@Override
	@Transactional
	public void wished(Wished wished) {
		dao.insertWished(wished);
	}

	@Override
	@Transactional
	public void removeWished(Wished wished) {
		
		dao.deleteWished(wished);
	}

	@Override
	public List<Video> getWished(String userId) {
		return dao.selectAll(userId);
	}

}
