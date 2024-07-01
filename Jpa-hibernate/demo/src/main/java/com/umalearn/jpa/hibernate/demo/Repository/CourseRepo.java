package com.umalearn.jpa.hibernate.demo.Repository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.umalearn.jpa.hibernate.demo.entity.Courses;
import com.umalearn.jpa.hibernate.demo.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional//eif this annotation is given then entity manger takes care of hte transation
public class CourseRepo {
	@Autowired
	EntityManager em;//entity manager created 
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Courses findById(Long id) {
		return em.find(Courses.class, id);
	}
	public void deleteById(Long c) {
		em.remove(em.find(Courses.class, c));
	}
	
	public Courses insertcourse(Courses c) {
		if(c.getId() == null)
			em.persist(c);//to save the value
		else 
			em.merge(c);//merge used to update in entitymanager
			return c;
	}
	public void playwithEntityManager() {
		
		log.info("in entitymanager");
		Courses course = new Courses("test");
		em.persist(course);
		
		// entity manager update thsi also in the database as it tracks the object course and make sure all value gets updated for this
		
		Courses course1 = new Courses("test2");
		em.persist(course1);
		
		Courses course2 = new Courses("test3");
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
	
	public void addharcodedreviewtocourse() {
		Courses c = em.find( Courses.class,1);
		Review r = new Review("great course" , "5");
		c.addReviews(r);
		r.setCourse(c);
		em.persist(r);
		Courses c1 = em.find( Courses.class,2);
		r.setCourse(c1);
		Review r1 = new Review("fantastic course" ,"5");
		c.addReviews(r1);
		em.persist(r1);
	}		
		
	
	public void addreviewtocourse(Long courseid, List<Review>reviews) {
		Courses c = em.find(Courses.class, courseid);
		
			
		 reviews.stream().forEach(r->{
			 r.setCourse(c);
			 c.addReviews(r);
			 em.persist(r);	
		
		 });
			 
		
			
		//});
		
		
	}

}
