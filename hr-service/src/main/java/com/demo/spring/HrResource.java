package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dto.EmpDTO;
import com.demo.spring.services.HrService;

@RestController
@RequestMapping("/hr")
public class HrResource {
	
	private HrService hrService;
	

	public HrResource(HrService hrService) {
		this.hrService = hrService;
	}


	@GetMapping(path="/emp/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpDTO> getEmpDetails(@PathVariable Integer id){
		return ResponseEntity.ok(this.hrService.getDetails(id));
	}
}
