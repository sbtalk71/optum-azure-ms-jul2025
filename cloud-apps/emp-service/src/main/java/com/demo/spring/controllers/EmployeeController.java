package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.services.EmployeeService;
import com.demo.spring.util.EmpList;
import com.demo.spring.util.EmployeeDTO;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmpList> getempList() {
		return ResponseEntity.ok(employeeService.getEmplList());
	}

	@GetMapping(path = "/{empId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable("empId") Integer id,@RequestHeader(required = false) String myname) {
		System.out.println("The Request header "+myname);
		return ResponseEntity.ok(employeeService.findEmpById(id));
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<EmployeeDTO> storeToDb(@RequestBody EmployeeDTO empDTO){
		return ResponseEntity.ok(employeeService.save(empDTO));
	}
}
