package com.example.demo.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
//	@RequestMapping(value="/employees",method=RequestMethod.GET)
	@Value("${app.name: Employy Tracker}")
	private String appName;
	
	@Value("${app.version: version1}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		return appName+"-"+appVersion;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(),HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return eService.getSingleEmployee(id);
	}
	
	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestParam("id") Long id) {
		eService.deleteEmployee(id);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(eService.getEmployesByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,@RequestParam String location){
		return new ResponseEntity<List<Employee>>(eService.findByNameAndLocation(name,location),HttpStatus.OK);
	}
}
