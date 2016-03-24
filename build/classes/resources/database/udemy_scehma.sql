create user 'udemyUser'@'localhost' identified by '123';

grant all privileges on *.* to 'udemyUser'@'localhost';

create database udemy;

use udemy;

create table users(
id int(10) primary key auto_increment,
user_name varchar(10) unique not null,
password varchar(20) not null,
first_name varchar(10) not null,
last_name varchar(10) not null,
gender tinyint(1) not null,
type tinyint(1) not null -- 0 for student, 1 for teacher
);

create table categories(
id int(10) primary key auto_increment,
name varchar(100) not null
);

create table courses(
id int(10) primary key auto_increment,
name varchar(100) not null,
category_id int(10) not null,
instructor_id int(10) not null,
foreign key (category_id) references categories(id),
foreign key (instructor_id) references users(id)
);

create table users_courses(
id int(10) primary key auto_increment,
user_id int(10) not null,
course_id int(10) not null,
foreign key (user_id) references users(id),
foreign key (course_id) references courses(id)
);