package com.example.demo.respository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.controllers.EmployeeController;
import com.example.demo.entity.Employee;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRespository {

	Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	public Employee save(Employee employee) {
		logger.info("in respository {} ", employee);
		dynamoDBMapper.save(employee);
		return employee;
	}

	public Employee getEmployeeById(String empId) {
		logger.info("in empid  {} ", empId);
		return dynamoDBMapper.load(Employee.class, empId);
	}

	public Employee updateEmployee(Employee employee, String employeeId) {
		logger.info("update for empid  {} ", employeeId);
		dynamoDBMapper.save(employee, new DynamoDBSaveExpression()
			.withExpectedEntry("employeeId", new ExpectedAttributeValue(new AttributeValue().withS(employeeId))));

		return getEmployeeById(employeeId);
	}
}
