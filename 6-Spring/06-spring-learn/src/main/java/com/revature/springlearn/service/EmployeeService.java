package com.revature.springlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springlearn.model.Employee;
import com.revature.springlearn.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getByName(String name){
		return employeeRepository.findByName(name);
	}

}
