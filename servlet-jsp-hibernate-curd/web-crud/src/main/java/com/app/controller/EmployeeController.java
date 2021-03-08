package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.Employee;
import com.app.service.EmployeeService;
import com.app.service.impl.EmployeeServiceImpl;

@WebServlet("/register")
public class EmployeeController extends HttpServlet  {

	private static final long serialVersionId=1L;
	
	private EmployeeService employeeService=null;

	public EmployeeController() {
		employeeService = new EmployeeServiceImpl();
	}
	
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
		List<Employee> list=employeeService.findAll();
		req.setAttribute("employees", list);
		req.getRequestDispatcher("dashboard.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest reqt , HttpServletResponse rest) throws ServletException, IOException {
		Employee employee=new Employee();
		String eid=reqt.getParameter("id");
		if(eid!=null && eid!="") {
			employee.setId(Integer.parseInt(eid));
		}
		employee.setName(reqt.getParameter("name"));
		employee.setMobile(reqt.getParameter("mobile"));
		employee.setSalary(Double.parseDouble(reqt.getParameter("salary")));
		employee.setAge(Integer.parseInt(reqt.getParameter("age")));
		Boolean flag=employeeService.saveOrUpdateEmployee(employee);
		if(flag) {
			reqt.setAttribute("success", "employee saved successfully");
		}else {
			reqt.setAttribute("error", "employee not saved");
		}
		reqt.getRequestDispatcher("index.jsp").forward(reqt, rest);
		
		
		
	}
}
