package com.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
