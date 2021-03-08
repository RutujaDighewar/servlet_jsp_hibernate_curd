package com.app.repo;

import java.util.List;

import org.hibernate.Session;

import com.app.entity.Employee;
import com.app.utility.HibernateUtility;

public class EmployeeRepsitoryImpl implements EmployeeRepository {

     private Boolean flag=Boolean.FALSE;
	
	@Override
	public Boolean saveOrUpdateEmployee(Employee employee) {
            Session session=HibernateUtility.getSession().openSession();
            session.saveOrUpdate(employee);
            session.beginTransaction().commit();
            flag=Boolean.TRUE;
		return flag;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
      Session session=HibernateUtility.getSession().openSession();
      session.update(employee);
      session.beginTransaction().commit();
      flag=Boolean.TRUE;
		return flag;
	}

	@Override
	public Employee findById(Integer id) {
     Session session = HibernateUtility.getSession().openSession();
		return (Employee) session.get(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
      Session session=HibernateUtility.getSession().openSession();
		return session.createCriteria(Employee.class).list();
	}

	@Override
	public Boolean deleteEmployee(Integer id) {
       Session session=HibernateUtility.getSession().openSession();
       session.delete(findById(id));
       session.beginTransaction().commit();
       flag=Boolean.TRUE;
		return flag;
	}

}
