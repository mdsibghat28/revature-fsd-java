package com.revature.springlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.springlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByName(String name);
}
