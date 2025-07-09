package com.demo.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.spring.entities.Employee;
import com.demo.spring.exceptions.EmployeeExistsException;
import com.demo.spring.exceptions.EmployeeNotFoundException;
import com.demo.spring.repositories.EmployeeRepository;
import com.demo.spring.util.EmpList;
import com.demo.spring.util.EmployeeDTO;

import io.micrometer.observation.annotation.Observed;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Observed(name = "emp.list")
	public EmpList getEmplList() {
		List<EmployeeDTO> theList=employeeRepository.findAll().stream()
				.map(emp->new EmployeeDTO(emp.getEmpId(), emp.getName(), emp.getCity(), emp.getSalary())).collect(Collectors.toList());
		return new EmpList(theList);
	}
	@Observed(name = "emp.find.one")
	public EmployeeDTO findEmpById(Integer id) {
		Employee emp= this.employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Emp not found.."));
		return new EmployeeDTO(emp.getEmpId(), emp.getName(), emp.getCity(), emp.getSalary());
	}
	
	@Observed(name = "emp.store.one")
	public EmployeeDTO save(EmployeeDTO empDto) {
		
		if(employeeRepository.existsById(empDto.getEmpId())) {
			throw new EmployeeExistsException("Employee Exists..");
		}else {
			Employee emp=employeeRepository.save(new Employee(empDto.getEmpId(), empDto.getName(), empDto.getCity(), empDto.getSalary()));
			return new EmployeeDTO(emp.getEmpId(), emp.getName(), emp.getCity(), emp.getSalary());
		}
			
			
			
	}
}
