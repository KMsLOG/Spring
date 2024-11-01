package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	// 유저 등록
	public void insertUser(User user);
	
	// 유저 전체 목록
	public List<User> selectAll();
	
	// id로 유저 찾기
	public User selectById(String id);
	
	// 유저 업데이트
	public void updateUser(User user);
	
	// 유저 삭제
	public void deleteUser(String id);
}
