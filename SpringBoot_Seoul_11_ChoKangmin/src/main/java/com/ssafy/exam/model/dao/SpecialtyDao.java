package com.ssafy.exam.model.dao;

import com.ssafy.exam.model.dto.Specialty;

public interface SpecialtyDao {
    int insertSpecialty(Specialty specialty); // 전공 추가
    Specialty selectSpecialtyByCode(int code); // 전공 얻기
    int deleteSpecialty(int code); // 전공 삭제
}
