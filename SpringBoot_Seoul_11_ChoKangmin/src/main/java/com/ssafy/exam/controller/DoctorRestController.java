package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
	
	// 의존성 주입
	private final DoctorService service;
	
	// 생성자
	public DoctorRestController(DoctorService service) {
		this.service = service;
	}

	@PostMapping // 의사 등록
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		if(service.addDoctor(doctor)) {
			return new ResponseEntity<String>("Doctor added successfully",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Failed to add doctor",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping // 의사 전체 목록
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list = service.getAllDoctors();
		
		if(list == null || list.size()==0) {
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}") // 의사 개인 정보 조회
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id) {
		Doctor d = service.getDoctorById(id);
		
		if(d != null) {
			return new ResponseEntity<Doctor>(d,HttpStatus.OK);
		}
		return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}") // 의사 정보 수정
	public ResponseEntity<String> updateDoctor(@PathVariable("id") int id, @RequestBody Doctor doctor) {
		if(service.updateDoctor(id, doctor)) {
			return new ResponseEntity<String>("Doctor updated successfully",HttpStatus.OK);
		};
		return new ResponseEntity<String>("Failed to update doctor",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{id}") // 의사 정보 삭제
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") int id) {
		if(service.deleteDoctor(id)) {
			return new ResponseEntity<String>("Doctor deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to delete doctor",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
