package com.umalearn.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id ;
	@Column(nullable=false)
	private String name;
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	@ManyToMany
	//given to change table name 
	@JoinTable(name="student_course",joinColumns=@JoinColumn(name="Stu_id"),inverseJoinColumns = @JoinColumn(name="co_id"))
	private List<Courses>courses = new ArrayList();

	
	//default constructor will not abe available .so you use a protected construtor
	protected Student() {
		
	}

	public Student(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	

	public void removeCourses(Courses c) {
		 courses.remove(c);
	}

	public void addCourses(Courses courses) {
		this.courses.add(courses);
	}
	
	public List<Courses> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
	
	

}
