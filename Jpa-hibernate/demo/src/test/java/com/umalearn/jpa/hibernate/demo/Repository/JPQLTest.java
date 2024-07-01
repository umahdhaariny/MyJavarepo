package com.umalearn.jpa.hibernate.demo.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.umalearn.jpa.hibernate.demo.DemoApplication;
import com.umalearn.jpa.hibernate.demo.entity.Courses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class JPQLTest {
	
	@Autowired
	EntityManager em;
	CourseRepo cr;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Test
	public void contextLoad() {
	log.info("test is running ");	
	Courses course = cr.findById(10001L);
	assertEquals("name",course.getName());
//	cr.deleteById(1000L);
	cr.deleteById(10001L);
	org.junit.Assert.assertNull(cr.findById(10001L));
	course = cr.insertcourse(new Courses("name5"));
	
	assertEquals("name5",cr.findById(course.getId()));
	}
	@Test
	@Transactional
	public void jpql_course_without_students() {
		TypedQuery<Courses>query = em.createQuery("Select c from Courses c where c.student is empty", Courses.class);
		List <Courses> course= query.getResultList();
		log.info("pring the course" + course);
	}

}
