package com.willy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.willy.entities.Certificate;
import com.willy.entities.Employee;

public class EmployeeDao {
	
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  
	//method to save employee  
	public void saveEmployee(Employee e){  
		template.save(e);  
	}
	/* Method to add an employee record in the database */
	public Integer addEmployee(String name, int salary, Set<Certificate> cert){
		Integer employeeID = null;
		try{      
			Employee employee = new Employee(name, salary);
			employee.setCertificates(cert);
			employeeID = (Integer) template.save(employee);     
		}catch (HibernateException e) {      
			e.printStackTrace(); 
		}
		return employeeID;
	}
	//method to update employee  
	public void updateEmployee(Employee e){  
		template.update(e);  
	}  
	//method to delete employee  
	public void deleteEmployee(Employee e){  
		template.delete(e);  
	}  
	//method to return one employee of given id
	@Transactional
	public Employee getById(int id){  
		Employee e=(Employee)template.get(Employee.class,id);  
		return e;  
	}
	public Employee load(int id){  
		Employee e=(Employee)template.load(Employee.class,id);  
		return e;  
	} 
	//method to return all employees  
	public List<Employee> getEmployees(){  
		List<Employee> list=new ArrayList<Employee>();  
		list=template.loadAll(Employee.class);  
		return list;  
	}  
}  
