SETUP

To check out and work on this project you must have the following requirements met:

1. Install JBoss 5
   1a. Add the JBoss server to your eclipse servers panel (right-click select new. etc.)
   
2. Install MySQL
   2a. Create a new database in your mysql server named "ccjudge"
   
3. Checkout all of the projects from SVN
   3a. CCJudge is the EAR project... all other projects belong to this ear
	3a.i. Project facets - EAR 5.0
	3a.ii. Java EE Module Dependencies - CCJudgeEJB.jar, CCJudgeEJBClient.jar, CCJudgeWeb.war, NeumontAuth.jar
   3b. CCJudgeEJB is the EJB project.  It is the business logic tier.
	3b.i Project Facets - Java 6.0, EJB Module 3.0
	3b.ii. Project References - CCJudgeEJBClient
	3b.iii. Java EE Module Dependencies - CCJudgeEJBClient.jar
   3c. CCJudgeEJBClient is a client library project that has all of the external
       interfaces and entities that the web project and other projects will need
	3.c.i Project Facets - Java 6.0, Utility Module
   3d. CCJudgeWeb is the web client interface
	3.d.i. Project Facets - Java 6.0, Dynamic Web Module 2.5
	3.d.ii. Project References - CCJudge, CCJudgeEJB, CCJudgeEJBClient
	3.d.iii. Java EE Module Dependencies - NeumontAuth.jar
	3.d.iv. There will probably be some EL syntax errors on this project.  They aren't really errors and are safe to ignore.
   
4. Update the JBoss datasource XML file
   4a. edit the ccjudge-ds.xml file found in the META-INF of the CCJudgeEJB project
   4b. set all of the mysql connection properties that you need to connect to your database
   4c. add the mysql connector jar to the JBoss_home/server/default/lib directory
   
5. Update the deployment context path
	5a. edit CCJudge/EarContent/META-INF/application.xml and set the <Context-Root> element for CCJudgeWeb.war to 
	    the deployment path that you would like. "/CCJudge" is a good default
	5b. Update the "baseURL" context parameter in the CCJudgeWeb deployment descriptor to be the same
	    as the context root your set in the EAR application.xml deployment descriptor.
	    "/CCJudge" is a good default.
   
6. Deploy the project to JBoss and point your browser to http://localhost:8080/CCJudge
	6a. Resolve any errors in the server log

7. Add an admin user for yourself
	7a. Insert a user into the newly created teammember table
	7b. set the role to admin set the username to your neumont username
	
8. Login using your neumont username and password

9. Click on admin to add contests etc.
	

------------------------------------------------------
RUNNING THE PROJECT

1. Add the CCJudge EAR project to the JBoss server using eclipse
2. Start the server
3. Open a browser to http://localhost:8080/CCJudge
4. To test changes, republish to the server in eclipse (you don't have to restart, republishing is good enough)
