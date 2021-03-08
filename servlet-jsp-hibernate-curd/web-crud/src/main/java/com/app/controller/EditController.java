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

@WebServlet("/edit")
public class EditController extends HttpServlet{
	
	private EmployeeService employeeService;
	
	public EditController() {
		employeeService = new EmployeeServiceImpl();
	}

 
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
    
	Integer id= Integer.parseInt(req.getParameter("id"));
	         
	
	         req.setAttribute("employee", employeeService.findById(id));
	          
	         req.setAttribute("employees", employeeService.findAll());
	
	req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
}
}



