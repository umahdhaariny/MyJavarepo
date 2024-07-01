package com.umalearn.jpa.hibernate.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.umalearn.jpa.hibernate.demo.Repository.CourseRepo;
import com.umalearn.jpa.hibernate.demo.Repository.EmployeeRepo;
import com.umalearn.jpa.hibernate.demo.Repository.StudentRepo;
import com.umalearn.jpa.hibernate.demo.entity.Courses;
import com.umalearn.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.umalearn.jpa.hibernate.demo.entity.ParttimeEmployee;
import com.umalearn.jpa.hibernate.demo.entity.Review;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private CourseRepo cr;
	@Autowired
	private StudentRepo studentrepo;
	@Autowired
	private EmployeeRepo ER;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Courses c = cr.findById(10001L);
		logger.info("printing my id" +c.getName()+c.getId());
		
		cr.deleteById(10001L);
		cr.insertcourse(new Courses("name2"));
		cr.insertcourse(new Courses("name3"));
		cr.playwithEntityManager();
		studentrepo.insertstudentwithpassport();
		cr.addharcodedreviewtocourse();
		List<Review> reviews = new ArrayList();
		reviews.add(new Review("200","excellen"));
		reviews.add(new Review("400","excellen updated"));
		cr.addreviewtocourse(1L, reviews);
		studentrepo.insertstudentandcourse();
		ER.saveemp(new ParttimeEmployee("FutureEmp",new BigDecimal(124334234)));
		ER.saveemp(new FullTimeEmployee("Employee",new BigDecimal(11122434)));
		ER.saveemp(new FullTimeEmployee("Emplyee1",new BigDecimal(123343434)));
		
		
	}

}
