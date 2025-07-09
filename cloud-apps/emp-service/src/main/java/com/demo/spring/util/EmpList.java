package com.demo.spring.util;

import java.util.List;

import com.demo.spring.entities.Employee;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpList {
	
	
	private List<EmployeeDTO> empList;

	@XmlElement(name="emp")
	public List<EmployeeDTO> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDTO> empList) {
		this.empList = empList;
	}
	
	public EmpList() {
		// TODO Auto-generated constructor stub
	}

	public EmpList(List<EmployeeDTO> empList) {
		super();
		this.empList = empList;
	}
	
	

}
