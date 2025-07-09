package com.demo.spring.util;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class EmployeeDTO {

	
	private Integer empId;
	
	private String name;
	
	
	private String city;
	
	private double salary;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Integer empId, String name, String city, double salary) {
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}
	
	
	
	
}
