package com.umalearn.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private BigDecimal salary;

	
	protected  FullTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public FullTimeEmployee(String s,BigDecimal salary) {
		super(s);
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	

}
