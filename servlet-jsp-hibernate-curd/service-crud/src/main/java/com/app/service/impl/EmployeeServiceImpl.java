package com.app.service.impl;

import java.util.List;

import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;
import com.app.repo.EmployeeRepsitoryImpl;
import com.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository=null;
	
	public EmployeeServiceImpl() {
		employeeRepository = new EmployeeRepsitoryImpl();
	}
	
	@Override
	public Boolean saveOrUpdateEmployee(Employee employee) {
		return employeeRepository.saveOrUpdateEmployee(employee);
		}

	@Override
	public Boolean updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Boolean deleteEmplyee(Integer id) {
		return employeeRepository.deleteEmployee(id);
	}

}
