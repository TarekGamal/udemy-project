use udemy;

# table users
insert into users(user_name, password, first_name, last_name, gender, type)
values('Ahmed', 'a123', 'Ahmed', 'Ali', 0, 0);

insert into users(user_name, password, first_name, last_name, gender, type)
values('Mona', 'm123', 'Mona', 'Mohamed', 1, 0);

insert into users(user_name, password, first_name, last_name, gender, type)
values('Sherif', 's123', 'Sherif', 'Shady', 0, 0);

insert into users(user_name, password, first_name, last_name, gender, type)
values('Basma', 'b123', 'Basma', 'Bendary', 1, 0);

insert into users(user_name, password, first_name, last_name, gender, type)
values('Hassan', 'h123', 'Hassan', 'Haytham', 0 , 1);

insert into users(user_name, password, first_name, last_name, gender, type)
values('Radwa', 'r123', 'Radwa', 'Ramy', 1, 1);

#table categories
insert into categories(name)
values('Programming');

insert into categories(name)
values('Web Development');

insert into categories(name)
values('Mobile applications');

insert into categories(name)
values('Data mining');


#table courses
insert into courses(name, category_id, instructor_id)
values('Java', 1, 6);

insert into courses(name, category_id, instructor_id)
values('Android', 3, 6);

insert into courses(name, category_id, instructor_id)
values('Introduction to data mining', 4, 5);

#table users_courses
insert into users_courses(user_id, course_id)
values(1, 1);

insert into users_courses(user_id, course_id)
values(1,2);

insert into users_courses(user_id, course_id)
values(1,3);

insert into users_courses(user_id, course_id)
values(2,1);

insert into users_courses(user_id, course_id)
values(2,2);

insert into users_courses(user_id, course_id)
values(3,1);