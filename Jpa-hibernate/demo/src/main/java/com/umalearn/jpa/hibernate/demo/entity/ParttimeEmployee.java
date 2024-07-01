package com.umalearn.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class ParttimeEmployee extends Employee {
	private BigDecimal hourlywage;
	protected ParttimeEmployee() {
		
	}
	public ParttimeEmployee(String name,BigDecimal r) {
		super(name);
		this.hourlywage=r;
	}
	public BigDecimal getHourlywage() {
		return hourlywage;
	}
	public void setHourlywage(BigDecimal hourlywage) {
		this.hourlywage = hourlywage;
	}
	

}
