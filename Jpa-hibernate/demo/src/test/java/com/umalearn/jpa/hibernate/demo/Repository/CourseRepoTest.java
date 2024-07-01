package com.umalearn.jpa.hibernate.demo.Repository;

import static org.junit.jupiter.api.Assertions.*;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class CourseRepoTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepo cr ;
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
	public void playwithEntityManagerTest() {
		cr.playwithEntityManager();
	}
	@Test
	@Transactional
	public void  findById_firstLevelcacheDemo() {
		Courses course = cr.findById(1000L);
		log.info("first course" + course.getName());
		Courses course1 = cr.findById(1000L);
		log.info("first course--1" + course.getName());
		Courses course2 = cr.findById(1000L);
		log.info("first course--2" + course.getName());
	}
}
