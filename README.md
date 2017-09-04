# SpringBootWebApp
Spring Security+Spring MVC+Spring JPA+Spring Booot

Here is the complete template of Spring boot web application. Just configure your relational database and add your html pages then deploy your application.

Steps:

1) Download the zip file and import it as a maven project.

2) Update the database configurations in application.properties

3) Create the user Table and add one default User

Sample:

Mysql User Creation

CREATE TABLE user (
    userId varchar(255) NOT NULL,
    firstName varchar(255) NOT NULL,
    lastName varchar(255),
	password varchar(255),
    Age int,
    PRIMARY KEY (userId)
);


INSERT INTO user(user_id, first_name, last_name, password) VALUES("admin","admin","admin","admin");


4) Run your application

http://localhost:8080/freebies/login

![Alt text](/screens/login.JPG?raw=true "Login")

Dashboard

![Alt text](/screens/dashboard.JPG?raw=true "Dashboard")

Logout

![Alt text](/screens/logout.JPG?raw=true "Logout")











