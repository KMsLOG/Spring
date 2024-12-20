package com.ssafy.hw.model.service;

import java.util.List;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

public interface UserService {
	void insert(User user);
	
	User searchById(String id);
	
	List<User> selectAll();
	
	List<User> searchByCondition(SearchCondition con);

}
