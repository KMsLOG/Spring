package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserDao dao;
	
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public void registUser(User user) {
		dao.insertUser(user);
	}

	@Override
	public List<User> getUsers() {
		return dao.selectAll();
	}

	@Override
	public User getUserById(String id) {
		return dao.selectById(id);
	}

	@Override
	@Transactional
	public void modifyUser(User user) {
		dao.updateUser(user);
	}

	@Override
	@Transactional
	public void removeUser(String id) {
		dao.deleteUser(id);
	}

}
