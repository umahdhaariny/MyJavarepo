package com.umalearn.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

/*@UpdateTimestamp//hibernate provided timestamp to store updated timestamp
private LocalDateTime lastupdatedDate;
@CreationTimestamp//hibernate provided timestamp to save creation timestamp
private LocalDateTime createdDate;*/
//one course will have many review so use OneToMany relationship ,
//this is not owning side so give mappedby

@Entity
public class Courses {
	
	@Id
	@GeneratedValue
	private Long id ;
		
	private String name;
	
	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List <Student> student = new ArrayList<>();
	
	//default constructor will not be available .so you use a protected construtor

	protected Courses() {
		
	}

	public Courses(String name) {
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
	public void removeReviews(Review r) {
		this.reviews.remove(r);
	}
	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	

	public void  removeStudent(Student s) {
		student.remove(s);
	}

	public void addStudent(Student student) {
		this.student.add(student);
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + "]";
	}
	
	

}
