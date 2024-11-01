package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserService {
	// 유저 등록
	public void registUser(User user);
	
	// 유저 전체 목록
	public List<User> getUsers();
	
	// id로 유저 찾기
	public User getUserById(String id);
	
	// 유저 업데이트
	public void modifyUser(User user);
	
	// 유저 삭제
	public void removeUser(String id);
	
	// 유저 로그인
	public User login(String id, String password);
}
