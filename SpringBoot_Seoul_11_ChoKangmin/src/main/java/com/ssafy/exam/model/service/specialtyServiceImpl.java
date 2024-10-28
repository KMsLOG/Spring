package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class specialtyServiceImpl implements SpecialtyService{
	
	// 의존성 주입
	private final SpecialtyDao dao;
	
	// 생성자
	public specialtyServiceImpl(SpecialtyDao dao) {
		this.dao = dao;
	}
	
	@Override // 전공 추가
	@Transactional
	public boolean addSpecialty(Specialty specialty) {
		int result = dao.insertSpecialty(specialty);
		
		if(result >0 ) return true;
		return false;
	}

	@Override // 코드로 전공 얻기
	public Specialty getSpecialtyByCode(int code) {
		return dao.selectSpecialtyByCode(code);
	}

	@Override // 전공 삭제
	@Transactional
	public boolean deleteSpecialty(int code) {
		int result = dao.deleteSpecialty(code);
		if(result>0) return true;
		return false;
	}

}
