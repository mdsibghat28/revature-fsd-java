package com.revature.app;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Employee;

public class GetAllEmployeesDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        String sql = "select e from Employee e inner join fetch e.department inner join fetch e.skillList";
		Set<Employee> employeeList = session.createQuery(sql, Employee.class).getResultStream().collect(Collectors.toSet());
		for (Employee employee : employeeList) {
			System.out.println(employee.getName());
			System.out.println(employee.getDepartment());
			System.out.println(employee.getSkillList());
		}

        session.getTransaction().commit();
        
        session.close();

	}

}
