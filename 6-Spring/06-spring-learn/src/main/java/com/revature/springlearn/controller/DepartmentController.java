package com.revature.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springlearn.exception.NotFoundException;
import com.revature.springlearn.model.Department;
import com.revature.springlearn.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public List<Department> getDepartmentList() {
        return departmentService.list();
    }
    
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) throws NotFoundException {
    	LOGGER.debug("Department Id: {}", id);
    	
    	return departmentService.getById(id);
    }
    
    @PostMapping
    public void create(@RequestBody Department department) {
    	LOGGER.debug("Department: {}", department);
    		departmentService.save(department);
    }
    
    @PutMapping
    public void Update(@RequestBody Department department) {
    	LOGGER.debug("Department: {}", department);
    		departmentService.save(department);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	departmentService.delete(id);
    }
    

}