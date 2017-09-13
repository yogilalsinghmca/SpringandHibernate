package com.willy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.willy.entities.Address;
import com.willy.entities.Certificate;
import com.willy.entities.Employee;

@EnableTransactionManagement
@Repository
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
	public Integer addEmployee(String name, int salary, Set<Certificate> cert,Address address){
		Integer employeeID = null;
		try{
			Employee employee = new Employee(name, salary,address);
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
	public HibernateTemplate getTemplate() {
		return template;
	}
	
	@Transactional
	public List<Employee> getFilteredData(){
		Session session = template.getSessionFactory().getCurrentSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Employee> employees = session.createCriteria(Employee.class)
				.add(Restrictions.like("name", "yogi") )
				.add(Restrictions.eq("salary", 2000)) 
				.addOrder(Order.asc("name") ) .list();
		return employees;
		
	}
	/* Method to add an address record in the database */
	public Address addAddress(String street, String city, String state, String zipcode) {
		Integer addressID = null;
		Address address = null;
		try{
			address = new Address(street, city, state, zipcode);
			addressID = (Integer) template.save(address); 

		}catch (HibernateException e) {

			e.printStackTrace(); 
		}finally {

		}
		return address;
	}
}  
