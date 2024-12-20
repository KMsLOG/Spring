package com.ssafy.hw.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

@Repository
public interface UserDao {
	
	int insert(User user);
	
	User searchById(String id);
	
	List<User> selectAll();
	
	List<User> searchByName(String name);

	List<User> searchByCondition(SearchCondition con);
}
