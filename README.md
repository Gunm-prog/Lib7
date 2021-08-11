# Lib7
Project carried out as part of the JAVA OpenClassrooms application developer training course.
Creation of a city library management site.
Context :
You work in the Information System Department (ISD) of the town hall of a large city, under the direction of Patricia, the head of the service. The IT department is in charge of all digital processing for the town hall and the structures attached to it, such as managing the town's website for example. As such, Patricia was contacted by the city's cultural service, which wanted to modernize the management of its libraries. John, software architect, will be responsible for the technical validation of the project.


The project :

The website will allow users to follow their book loans through the web interface:

Search for books and see the number of available copies.
View their current loans.
The loan of a book can be extended only once. The extension adds a new loan period (4 weeks) to the initial period.
A batch:
This software for automated processing will send reminder emails to users who have not returned the books at the end of the loan period. The sending will be automatic at the frequency of one per day.



The web API
The website as well as the batch will communicate with this software in REST in order to know the information related to the Database.

Les contraintes fonctionnelles
- Application web avec un framework MVC.
- API web en microservices REST (Les clients (site web, batch) communiqueront avec cette API web) 
	-> factorisation de la logique métier.
- Packaging avec Maven.
Développement
Cette application a été développé avec :
- Intellij IDEA
- Java 8 (version 1.8u241)
- Tomcat 9
- MySQL Workbench(version 8.0 C.E.)
- le framework Spring (version 5.2.1)
- Spring boot
- Proxy Feign
- LOMBOK
- Spring DATA JPA
L'application a été développée suivant une architecture microservice




Installation:

Install Tomcat(9).

Make a git clone of the following repositories:

	- Lib7, API (https://github.com/GunmProg/Lib7);
	- library7WebClient, web application (https://github/GunmProg/library7WebClient);
	- SpringBatch, batch (https://github/GunmProg/SpringBatch).
	
Open these microservices in Intellij Idea.


In the Lib7 project, go to the application.properties file, in line "spring.jpa.hibernate.ddl-auto =", put configuration mode on "create".

Create a database via an SQL editor (I used MySQLWorkbench), use the datas given in the Dump folder, then go in the application.properties file: "spring.datasource.url =" 
and enter your database's link "spring.datasource.username =" your username and "spring.datasource.password =" your password.

In the terminal, enter the following commands: 

 mvn clean package spring-boot: repackage, then java -jar target\Lib7-0.0.1-SNAPSHOT.jar
 
To see what the logged-in user can do (see their book loans' details and book loans' list in their dashboard), here are the necessary identifiers (username and password) when connecting:
username = lily@hotmail.com     password = password
username = neo@hotmail.com      password = password
username = chris@hotmail.com    password = password

Launch:

First run Lib7, then library7WebClient and finally SpringBatch.

You can access the web application at port localhost:/8080 from your browser if you have not changed the "server.port.properties" in application.properties'file.

You will find each microservices's properties configuration in:
 
	src/main/resources/application.properties
	

Author:

Emilie Balsen - as part of my training as a java application developer at OpenClassrooms.
