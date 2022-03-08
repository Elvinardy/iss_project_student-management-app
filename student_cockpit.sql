DROP DATABASE IF EXISTS studentapp;

CREATE DATABASE studentapp;

USE studentapp;

CREATE TABLE student (
  id bigint NOT NULL AUTO_INCREMENT,
  class_info varchar(255),
  email varchar(255),
  image_url varchar(255),
  name varchar(255),
  phone varchar(255),
  remarks varchar(255),
  student_code varchar(255) NOT NULL,
  teach_id bigint NOT NULL,
  PRIMARY KEY (id),
  constraint fk_teacher_id foreign key(teach_id) references teacher(id)
);

CREATE TABLE attendance (
atd_id bigint NOT NULL AUTO_INCREMENT,
atd_info varchar(64),
date datetime(6),
stud_id bigint NOT NULL,
PRIMARY KEY(atd_id),
constraint fk_stud_id foreign key(stud_id) references student(id)
);

CREATE TABLE teacher (
teacher_id bigint NOT NULL AUTO_INCREMENT,
username varchar(64),
email varchar(64),
PRIMARY KEY(teacher_id)
);

CREATE TABLE email (
  id bigint NOT NULL AUTO_INCREMENT,
  email_address varchar(255),
  message varchar(255),
  name varchar(255),
  subject varchar(255),
  email varchar(255),
  PRIMARY KEY (id)
);



