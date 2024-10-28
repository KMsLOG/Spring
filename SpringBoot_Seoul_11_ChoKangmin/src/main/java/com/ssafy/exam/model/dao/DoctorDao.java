package com.ssafy.exam.model.dao;

import java.util.List;

import com.ssafy.exam.model.dto.Doctor;

public interface DoctorDao {
	// 의사 추가
    int insertDoctor(Doctor doctor);
    
    // 모든 의사 리스트
    List<Doctor> selectAllDoctors();
    
    // id로 의사 찾기
    Doctor selectDoctorById(int id);
    
    // 의사 업데이트
    int updateDoctor(Doctor doctor);
    
    // 의사 삭제
    int deleteDoctor(int id);
}
