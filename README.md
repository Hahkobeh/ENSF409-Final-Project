# ENSF409-Final-Project
<br>
Document as you go

CHANGE db USERNAME AND PASSWORD BEFORE HANDING IN!

<br>

After creating every class write a unit test in the UnitTests.java file.

<br>

## Discussions:
https://d2l.ucalgary.ca/d2l/le/356747/discussions/threads/1339806/View?filters=unread
https://d2l.ucalgary.ca/d2l/le/356747/discussions/threads/1337111/View
https://d2l.ucalgary.ca/d2l/le/356747/discussions/threads/1336397/View
https://d2l.ucalgary.ca/d2l/le/356747/discussions/threads/1336998/View
https://d2l.ucalgary.ca/d2l/le/356747/discussions/threads/1333416/View

<br>

## Folder Structure:
* Use the package edu.ucalgary.ensf409 for all .java files.
* UML Diagram in root.
* All library packages etc. to go in ./lib.

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
