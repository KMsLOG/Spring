package com.ssafy.exam.model.service;

import com.ssafy.exam.model.dto.Specialty;

public interface SpecialtyService {
	
	// 전공 등록
	boolean addSpecialty(Specialty specialty);
	
	// 코드로 전공 찾기
	Specialty getSpecialtyByCode(int code);
	
	// 전공 삭제
	boolean deleteSpecialty(int code);
}