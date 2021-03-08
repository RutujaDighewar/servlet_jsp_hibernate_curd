package com.app.repo;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeRepository {
	
	public Boolean saveOrUpdateEmployee(Employee employee);
	public Boolean updateEmployee(Employee employee);
	public Employee findById(Integer id);
	public List<Employee> findAll();
	public Boolean deleteEmployee(Integer id);
	
	

}
