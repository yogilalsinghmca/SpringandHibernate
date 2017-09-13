package com.willy;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.willy.dao.EmployeeDao;
import com.willy.entities.Employee;

public class ListEmployeeTest {
public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	EmployeeDao dao=(EmployeeDao)context.getBean("employeeDao");
	
	List<Employee> employees = dao.getFilteredData();
	
	for(Employee e:employees){
		System.out.println("employee name" +e.getName() );
	}
	context.close();
}
}
