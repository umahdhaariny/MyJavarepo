package com.umalearn.jpa.hibernate.demo.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.umalearn.jpa.hibernate.demo.entity.Employee;

import jakarta.persistence.EntityManager;


@Repository
@Transactional
public class EmployeeRepo {
	
	
	@Autowired
	EntityManager em;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void saveemp(Employee e) {
		em.persist(e);
		
	}
	public List<Employee> retrieveAllEmployees(){
		//using JPL below
		return em.createQuery("select e from Employee e" , Employee.class).getResultList();
		
	}

}
