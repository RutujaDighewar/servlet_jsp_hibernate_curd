package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.Employee;
import com.app.service.EmployeeService;
import com.app.service.impl.EmployeeServiceImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	private EmployeeService employeeService=null;
	
	public DeleteController() {
		employeeService = new EmployeeServiceImpl();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id= (Integer.parseInt(req.getParameter("id")));
		
	Boolean flag=employeeService.deleteEmplyee(id);
	if(flag) {
	req.setAttribute("employees" , employeeService.findAll() );
	req.setAttribute("success", "Employee deleted with id = " +id);
	}else {
		req.setAttribute("error" , "Employee does not deleted with id = " +id+ ", please try again!");
	}
	
	req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
	
}
