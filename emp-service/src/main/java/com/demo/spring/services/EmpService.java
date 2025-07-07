package com.demo.spring.services;

import org.springframework.stereotype.Service;

import com.demo.spring.entities.Emp;
import com.demo.spring.repositories.EmpRepository;

@Service
public class EmpService {

	private EmpRepository empRepository;

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}
	
public Emp findEmpById(Integer id) {
	return empRepository.findById(id).orElseThrow(()->new RuntimeException("EMp Not Found"));
}
	
}
