--insert into Courses (id,name,lastupdated_Date,created_Date) values(10001,'name',SYSDATE(),sysdate());
--insert into Courses (id,name,lastupdatedDate,createdDate) values(1000,'name1',sysdate(),sysdate());

insert into Passport (id,passport_number) values(10001,'N12345');
insert into Passport (id,passport_number) values(1000,'N23456');

insert into Passport (id,passport_number) values(10002,'N123451');
insert into Passport (id,passport_number) values(1002,'N234562');

insert into Student (id,name,passport_id) values(10001,'ranga',10001);
insert into Student (id,name,passport_id) values(1000,'ram',1000);
insert into Student (id,name,passport_id) values(80001,'ranga',10002);
insert into Student (id,name,passport_id) values(8000,'ram',1002);

insert into Courses (id,name) values(10001,'name');
insert into Courses (id,name) values(1000,'name1');
insert into Courses (id,name) values(80001,'name2');
insert into Courses (id,name) values(7000,'name3');
insert into Courses (id,name) values(60001,'name4');
insert into Courses (id,name) values(5000,'name5');
insert into Review (id,rate,description,course_id) values(50001,'5','good',80001);
insert into Review (id,rate,description,course_id) values(50002,'6','the course is ',7000);

insert into student_course(stu_id,co_id) values(80001,60001);
insert into student_course(stu_id,co_id) values(8000,5000);