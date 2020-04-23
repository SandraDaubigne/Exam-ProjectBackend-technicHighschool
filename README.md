##ProjectBackend  Teknikhögskolan 2020

#### Purpose:
This Read Me is supposed to explain my Repository that is an Exam Work in a cource called “Backend” from Teknikhögskolan Gothenburg 2020. 
The intent of the course is to learn Sping Boot, Maven, Spring MVC, Spring JDBC, Spring JPA, Hibernate, thymeleaf and databaseconnections. 

####Function of the application:
The project is a web application that is used to store things you have to do. So it stores todo’s. You can make a todo, delete a todo and check a todo. You can select only to see active todos or completed todos. You can delete every todos that is completed at once.  

####Technical terms: 
#####Frontend: 
The application is a web application in Spring Boot. Tomcat is the server in Spring MVC and Thymeleaf handles the Wiew in HTML and JavaScript. The requests is sent from HTML with thymeleaf, and in Javascript from fetch api. The API is a REST api. 

#####Backend: 
The Backend is build in Spring Boot (Sping MVC) with Maven. The database is MySQL and the program uses hibernate to communicate with the database. Spring Boots dispacherservlet functions will handle the incomming request and send it back with the model attribute from model class.

####Motivation of using Hibernate 
I choose hibernate because i was lucky to learn JDBC, Spring JDBC and Spring JPA + Hibernate in this course. And se the great benefit from experience rather than knowledge, how simple this was comparing to the other two options. I can se the benefits of clean code, avoiding boilerplate code, using CRUDrepository built-in functions to connect with the database and also the benefit of making my entity a table in the database right away. 

It will also give you the benefit of easy installation of the application if you want to try out the code on your machine. Just download the repository and change the values in application.mock.properties to your own databaseconnection settings and rename that file to application.properties and then you will get your own table in your MySQL database the first time you run the code. 

####Changes down the road: 
#####Changing the variable name from dateStamp to id in the model "Todo":
Since i now use an autogenerated id in my model, i renamed "dateStamp" to "id". Before using a database, this value was generated from javascript. JavaScript was creating a date and gave "dateStamp" its value. Therefore it was much more logic to call it "dateStamp" before and "id" now.

 
