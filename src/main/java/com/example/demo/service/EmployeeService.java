package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();
	Employee saveEmployee(Employee employee);
	Employee getSingleEmployee(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee(Employee employee);
	List<Employee> getEmployesByName(String name);
	List<Employee> findByNameAndLocation(String name,String location);
}
