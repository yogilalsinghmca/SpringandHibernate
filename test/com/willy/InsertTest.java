package com.willy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.willy.dao.EmployeeDao;
import com.willy.entities.Address;
import com.willy.entities.Certificate;
import com.willy.entities.Employee;  

public class InsertTest{	
	static ClassPathXmlApplicationContext context;

	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});		
	}

	@After
	public void tearDown() throws Exception {
		context.close();
	}
	
	@Test
	@Ignore
	public void testemployeeInsertTest(){		
		EmployeeDao dao=(EmployeeDao)context.getBean("employeeDao");
		Employee e = new Employee();
		e.setName("varun");  
		e.setSalary(50000);
		Set<Certificate> certificates = new HashSet<>();    
		Certificate certificate = new Certificate("OCJP");
		certificates.add(certificate);
		Address address = dao.addAddress("Kondapur","Hyderabad","AP","532");
		int id = dao.addEmployee("Yogi", 20000, certificates,address);
		Employee emp = dao.load(id);
		Set<Certificate> dbCertificates = emp.getCertificates();
		for(Certificate c:dbCertificates){
			System.out.println("certificate name" +c.getName() );
		}
	}
	@Test
	public void testCretirea(){
		EmployeeDao dao=(EmployeeDao)context.getBean("employeeDao");
		
		List<Employee> employees = dao.getFilteredData();
		
		for(Employee e:employees){
			System.out.println("employee name" +e.getName() );
		}
	}
} 
