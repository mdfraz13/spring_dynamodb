package com.example.demo.controllers;

import com.example.demo.entity.Employee;
import com.example.demo.respository.EmployeeRespository;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRespository employeeRespository;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		logger.info("inside save {} ", employee);
		return employeeRespository.save(employee);
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") String empId) {
		logger.info("update for empid  {} ", empId);
		return employeeRespository.getEmployeeById(empId);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") String empId) {
		logger.info("update for empid  {}, employee {} ", empId, employee);
		return employeeRespository.updateEmployee(employee, empId);
	}
}
