package com.ssafy.exam.model.service;

import java.util.List;

import com.ssafy.exam.model.dto.Doctor;

public interface DoctorService {
	// 의사 추가
	boolean addDoctor(Doctor doctor);
	
	// 모든 의사 리스트
	List<Doctor> getAllDoctors();
	
	// id로 의사 찾기
	Doctor getDoctorById(int id);
	
	// 의사 업데이트
	boolean updateDoctor(int id, Doctor doctor);
	
	// 의사 삭제
	boolean deleteDoctor(int id);
}