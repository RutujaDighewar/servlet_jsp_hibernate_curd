package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeService {

	public Boolean saveOrUpdateEmployee(Employee employee);
	
	public Boolean updateEmployee(Employee employee);
	
	public Employee findById(Integer id);
	
	public List<Employee> findAll();
	
	public Boolean deleteEmplyee(Integer id);
	
	
}
