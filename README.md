# ENSF409-Final-Project
Final Project for java class, we had to implement a inventory management system whereby furniture components are reused in order to fill orders. Inventory is stored in a MySQL database.
I was responsible for the main algorithm that reads from the database and determines which components should be chosen in order to minimize price.


Group Members:

Jacob Artuso
Nicholas Knapton
Brian Kramer
Colin Christophe


# Info
Note: database username is "scm" and password is "ensf409", and the URL is "jdbc:mysql://localhost/inventory" as per the requirements.
If you need to change, the password and username variables are at the top of 
UnitTests.java and UserInterface.java
<br>

 The Unit tests have been designed to work with the original database given (before it got updated with the typo for prices on a few items),
 if you change the tests, make sure you put the correct values into whats expected. 
<br>

 The tests all start with reseting the table with the original table (see methoid resetTable() at the bottom of UnitTests.java). So be aware that if you use a different database IT WILL BE CHANGED!
 This is because when any unit test starts (that uses the db) it connects and resets the table to the original! So please if you change the
 tests, put values and expected answers that are allowed in the original provided table!
 <br>
 
 So please, final warning, when you run the UnitTests, your db will be changed to the original supplied db (also attached)! This is not the case for the application, it can run on any database (any valid db as per project requirements).
 

## Folder Structure:
* All .java files in .edu/ucalgary/ensf409.
* UML Diagram in root.
* Video in root.
* All library packages etc. are in ./lib.
* Original db used for UnitTests in root.

## To Compile on Windows
Assuming in working directory
```
javac -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Inventory.java
```
## To Run on Windows
Assuming in working directory
```
java -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Inventory
```
## To Compile Tests on Window
Assuming in working directory
```
javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar;edu/ucalgary/ensf409 edu/ucalgary/ensf409/*.java
```
## To Run Tests on Windows
Assuming in working directory
```
java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.UnitTests
```
