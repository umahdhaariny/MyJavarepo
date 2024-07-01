package com.umalearn.jpa.hibernate.demo.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.umalearn.jpa.hibernate.demo.entity.Courses;
import com.umalearn.jpa.hibernate.demo.entity.Passport;
import com.umalearn.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
@Transactional//eif this annotation is given then entity manger takes care of hte transation
public class StudentRepo {
	@Autowired
	EntityManager em;//entity manager created 
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	public void deleteById(Long c) {
		em.remove(em.find(Student.class, c));
	}
	
	public Student insertstudent(Student c) {
		if(c.getId() == null)
			em.persist(c);//to save the value
		else 
			em.merge(c);//merge used to update in entitymanager
			return c;
	}
	public Student insertstudentwithpassport() {
		Passport p = new Passport("TESTING123");
		em.persist(p);
		Student s = new Student("student1");
		s.setPassport(p);
		if(s.getId() == null)
			em.persist(s);//to save the value
		else 
			em.merge(s);//merge used to update in entitymanager
			return s;
	}
	public void playwithEntityManager() {
		
		log.info("in entitymanager");
		Student course = new Student("test");
		em.persist(course);
		
		// entity manager update thsi also in the database as it tracks the object course and make sure all value gets updated for this
		
		Student course1 = new Student("test2");
		em.persist(course1);
		
		Student course2 = new Student("test3");
		em.persist(course2);
		em.flush();// saves the value to DB - must to use before a detach 
		em.detach(course1);//ask entity manager not trakc course1 ,so that it will not take care of any update for this object 
		// entity manager update thsi also in the database as it tracks the object course and make sure all value gets updated for this
		course1.setName("test1-updated"); 
		course.setName("test-updated"); 
		course2.setName("test1-updated"); //here it gets updated 
		em.refresh(course2);// no need to save the update made for course 2
		em.flush();
		
	}
	public void insertstudentandcourse() {
		//1-create student 
		Student student = new Student("student1");
		//create course
		Courses course = new Courses("Microservices in 100 ");
		//persist course and student in DB
		em.persist(course);
		em.persist(student);
		//Associate student wiht course and course wiht student
		course.addStudent(student);
		student.addCourses(course);
	}

}
