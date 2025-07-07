package com.demo.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.spring.dto.EmpDTO;
import com.demo.spring.entities.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repositories.EmpRepository;

@Service
public class EmpService {

	private EmpRepository empRepository;

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	public EmpDTO findEmpById(Integer id) {

		// return empRepository.findById(id).orElseThrow(()->new
		// EmpNotFoundException("Emp Not Found"));

		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			Emp e = empOp.get();
			return new EmpDTO(e.getEmpId(), e.getName(), e.getCity(), e.getSalary());
		} else {
			throw new EmpNotFoundException("Emp Not Found..");
		}
	}

	public List<EmpDTO> findEmpList() {
		List<Emp> empList = empRepository.findAll();

		List<EmpDTO> list = empList.stream().map(e -> new EmpDTO(e.getEmpId(), e.getName(), e.getCity(), e.getSalary()))
				.collect(Collectors.toList());
		return list;
	}

	public EmpDTO save(EmpDTO empDto) {

		if (empRepository.existsById(empDto.id())) {
			throw new EmpExistsException("Emp Exists..");
		} else {
			Emp e = empRepository.save(new Emp(empDto.id(), empDto.name(), empDto.city(), empDto.salary()));
			return new EmpDTO(e.getEmpId(), e.getName(), e.getCity(), e.getSalary());
		}
	}

	public EmpDTO update(EmpDTO empDto) {

		if (empRepository.existsById(empDto.id())) {
			Emp e = empRepository.save(new Emp(empDto.id(), empDto.name(), empDto.city(), empDto.salary()));
			return new EmpDTO(e.getEmpId(), e.getName(), e.getCity(), e.getSalary());

		} else {
			throw new EmpNotFoundException("Emp Not Found..");
		}
	}

	public String delete(Integer id) {

		if (empRepository.existsById(id)) {
			empRepository.deleteById(id);
			return "deleted";
		} else {
			throw new EmpNotFoundException("Emp Not Found..");
		}
	}
}
