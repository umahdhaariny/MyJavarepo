package com.umalearn.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id ;
	
	@Column(nullable=false)
	private String passport_number;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passport")
	private Student student;
	//default constructor will not abe available .so you use a protected construtor
	protected Passport() {
		
	}

	public Passport(String num) {
		super();
		this.passport_number = num;
	}



	public Long getId() {
		return id;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passport_number=" + passport_number + "]";
	}



	
	

}
