package com.demo.spring.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dto.EmpDTO;
import com.demo.spring.entities.Emp;
import com.demo.spring.services.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpResource {
	private EmpService empService;

	public EmpResource(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping(path="/{eid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EmpDTO> findEmp(@PathVariable("eid") Integer id){
		return ResponseEntity.ok(empService.findEmpById(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpDTO>> getList(){
		return ResponseEntity.ok(empService.findEmpList());
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpDTO> storeTorDb(@RequestBody EmpDTO empDto){
		return ResponseEntity.ok(empService.save(empDto));
	}
}
