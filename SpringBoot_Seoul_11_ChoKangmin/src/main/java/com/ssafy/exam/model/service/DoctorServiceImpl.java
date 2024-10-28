package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	// 의존성 주입
	private final DoctorDao dao;
	
	// 생성자
	public DoctorServiceImpl(DoctorDao dao) {
		this.dao = dao;
	}

	@Override // 의사 추가
	@Transactional
	public boolean addDoctor(Doctor doctor) {
		if(dao.insertDoctor(doctor)>0) return true;
		return false;
	}

	@Override // 모든 의사 리스트
	public List<Doctor> getAllDoctors() {
		return dao.selectAllDoctors();
	}

	@Override // id로 의사 찾기
	public Doctor getDoctorById(int id) {
		return dao.selectDoctorById(id);
	}

	@Override // 의사 업데이트
	@Transactional
	public boolean updateDoctor(int id, Doctor doctor) {
		if(dao.selectDoctorById(id) == null) {
			return false;
		}
		if(dao.updateDoctor(doctor)>0) return true;
		return false;
	}

	@Override // 의사 삭제
	@Transactional
	public boolean deleteDoctor(int id) {
		if(dao.deleteDoctor(id)>0) return true;
		return false;
	}

}
