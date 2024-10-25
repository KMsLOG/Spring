package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	// 의존성 주입
	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	@Transactional
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public User searchById(String id) {
		User user = userDao.searchById(id);
		return user;
	}

	@Override
	public List<User> selectAll() {
		List<User> list = userDao.selectAll();
		return list;
	}

	@Override
	public List<User> searchByCondition(SearchCondition con) {
		List<User> list = userDao.searchByCondition(con);
		return list;
	}

}
