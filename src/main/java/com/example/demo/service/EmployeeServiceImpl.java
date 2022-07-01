package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository eRepository;
	

	
	@Override
	public List<Employee> getEmployees(){
		return eRepository.findAll();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}
	
	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Not found");
	}
	
	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {		
		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployesByName(String name) {
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> findByNameAndLocation(String name, String location) {
		return eRepository.findByNameAndLocation(name,location);
	}

	
}
