Framework Development
=====================

Framework - maintain all project related files.

Objectives:
-----------

1) Re-Usability

2) Maintainability

3) Readability

Hybrid Driven
-------------

Phases of design and development of framework.
------------------------------------------------

1) Understanding requirement
	- Functional specifications (static)
	- Swagger
	
2) Choose automation tool - Rest Assured Library

3) Design your framework 
	 -	Decide about folder structure.
	 -  Decide coding format and other policies.
	 -  Decide Configuration and utility classes.

4) Development
    - Develop all decided design

5) Execution + CI     


Rest Assured Framework Design
=============================

Development
-----------
   - Endpoints   -  Routers, UserEndPoints, StoreEndPoints, PetEndPoints
   - Test Cases -   User Tests, Store Tests, Pet Tests
   
   - Payloads(POJO) - User, Store, Pet
   - Utilities   -  DataProviders, Extent Report, XL Utility
   - Test Data  -  Userdata.xlsx, StoreData.xlsx, PetData.xlsx
   
 

Execution
---------
  - TestNG.XML
  - POM.xml - Dependencies, Plugins
  - Reports - TestNG Reports, Extent Reports
  
  
CI
----
   - Git
   - GitHub
   - Jenkins

==========================================================

Step 1: Create Maven Project

Step 2: Update pom.xml with required dependencies

Step 3: Basic structure we need to create - Create folder Structure

Step 4: Create Endpoints.java which contain's url

Step 5: Create UserEndPoint.java  =====> CRUD method implementation

Step 6: Create UserServiceHelper and read config files and creating reusable https methods.

Step 7: Create Data driven test - need data in excel sheet - need apache poi to read and write data -       excelUtility file

Step 8: Generate extent reports - extent report utility. - testng.xml file

Step 9: Add execution logs to track log of execution. Add logs - log4j2 dependancy, 









