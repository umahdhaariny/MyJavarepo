package com.umalearn.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id ;
	private String description;
	private String rate;
	@ManyToOne
	private Courses course;

	
	//default constructor will not abe available .so you use a protected construtor
	protected Review() {
		
	}

	public Review(String name,String rate) {
		super();
		this.description = name;
		this.rate=rate;
	}



	public Long getId() {
		return id;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}
	
	

}
