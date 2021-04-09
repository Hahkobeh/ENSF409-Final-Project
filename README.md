# ENSF409-Final-Project
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
java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu/ucalgary/ensf409/UnitTests
```
