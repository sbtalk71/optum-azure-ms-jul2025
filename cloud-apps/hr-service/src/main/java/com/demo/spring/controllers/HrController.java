package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.feign.client.EmpClient;
import com.demo.spring.services.HrService;

@RestController
@RequestMapping("/hr")
public class HrController {

	private HrService hrService;
	private EmpClient empClient;

	public HrController(HrService hrService, EmpClient empClient) {
		this.hrService = hrService;
		this.empClient = empClient;
	}

	@GetMapping(path = "/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmpDetails(@PathVariable int id) {
		return ResponseEntity.ok(hrService.getEmpDetails(id));
	}

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmpList() {
		return empClient.getempList();
	}
}
