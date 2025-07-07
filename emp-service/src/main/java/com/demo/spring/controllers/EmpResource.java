package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entities.Emp;
import com.demo.spring.services.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpResource {
	private EmpService empService;

	public EmpResource(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping(path="/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emp> findEmp(@PathVariable("eid") Integer id){
		return ResponseEntity.ok(empService.findEmpById(id));
	}
}
