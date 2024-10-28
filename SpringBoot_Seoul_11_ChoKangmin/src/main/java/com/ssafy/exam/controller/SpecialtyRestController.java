package com.ssafy.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {
	// 의존성 주입
	private final SpecialtyService service;
	
	// 생성자
	public SpecialtyRestController(SpecialtyService service) {
		this.service=service;
	}
	
	@PostMapping // 전공 등록
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
    	if (service.addSpecialty(specialty)) {
    		return new ResponseEntity<String>("Specialty added successfully",HttpStatus.OK);
    	}
    	return new ResponseEntity<String>("Failed to add specialty",HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@GetMapping("/{code}") // 전공 조회
    public ResponseEntity<Specialty> getSpecialty(@PathVariable("code") int code) {
		
		Specialty sp = service.getSpecialtyByCode(code);
		if(sp != null) {
			return new ResponseEntity<Specialty>(sp,HttpStatus.CREATED);
		}
		
    	return new ResponseEntity<Specialty>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/{code}") // 삭제
    public ResponseEntity<String> deleteSpecialty(@PathVariable("code") int code) {
		if (service.deleteSpecialty(code)) {
    		return new ResponseEntity<String>("Specialty deleted successfully",HttpStatus.OK);
    	}
    	return new ResponseEntity<String>("Failed to delete specialty",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}