package com.umalearn.jpa.hibernate.demo.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.umalearn.jpa.hibernate.demo.DemoApplication;
import com.umalearn.jpa.hibernate.demo.entity.Courses;
import com.umalearn.jpa.hibernate.demo.entity.Passport;
import com.umalearn.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class StudentRepoTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepo sr;
	
	@Autowired
	EntityManager em;
	@Test
	@Transactional
	public void retrieveStudentandPassportDetails() {
		//DB operation -1 -retrive student
		Student student = em.find(Student.class, 10001);
		log.info("value"+student);// here student fetches passport as well
		//DB operation -2 retrieve passport
		Passport p = student.getPassport();
	//	log.info("value"+p.getPassport());
		//DB operation -3 update passpor
		p.setPassport_number("testing");
		//DB operation -4 update name
		student.setName("persistence testing");
		
	//execute query at the end ,make sure all changes reflectedx
		
	}
	@Test
	@Transactional
	public void retrivestudentandcourses() {
		Student student = em.find(Student.class, 80001);
		log.info("value of student" + student);
		log.info("course for student"+student.getCourses());
		
	}
	//print the course that has no students
	@Test
	@Transactional
	public void jpql_course_without_students() {
		TypedQuery<Courses>query = em.createQuery("Select c from Courses c where c.student is empty", Courses.class);
		List <Courses> course= query.getResultList();
		log.info("pring the course in jpql" + course);
	}
	//print course that has more than two student 
	@Test
	@Transactional
	public void jpql_course_withmorethan2_students() {
		TypedQuery<Courses>query = em.createQuery("Select c from Courses c where size(c.student) > 2", Courses.class);
		List <Courses> course= query.getResultList();
		log.info("pring the course in jpql" + course);
	}


	
}
