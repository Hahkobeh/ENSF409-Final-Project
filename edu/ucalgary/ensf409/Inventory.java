/**
 @author Colin Christophe <a href="mailto:colin.christophe@ucalgary.ca">colin.christophe@ucalgary.ca</a>
         Nicholas Knapton <a href="mailto:nicholas.knapton@ucalgary.ca">nicholas.knapton@ucalgary.ca</a>
         Brian Kramer <a href="mailto:brian.kramer@ucalgary.ca">brian.kramer@ucalgary.ca</a>
         Jacob Artuso <a href="mailto:jacob.artuso@ucalgary.ca">jacob.artuso@ucalgary.ca</a>
 @version       1.1
 @since         1.0
 */
package edu.ucalgary.ensf409;


/**         README
 * 
 *   ## To Compile on Windows
 *   Assuming in working directory
 *   ```
 *   javac -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Inventory.java
 *   ```
 *   ## To Run on Windows
 *   Assuming in working directory
 *   ```
 *   java -cp .;lib/mysql-connector-java-8.0.23.jar;. edu/ucalgary/ensf409/Inventory
 *   ```
 * 
 *   ## How to use
 *   Input Category, Type and how many items you want into the provided text fields. Then if you would like a partial order to be filled,
 *   select the checkbox. Finally press "Request". If successful, a new window will pop up with your order and upon closing a file named
 *   "orderform.txt" will be created. This contains the neccissary information for your order. If not successful a window will pop up saying
 *   so and depending on if you selected partial order or not the order may be fillled.
 *   
 *   Instructions on running unit tests are in UnitTests.java
 */


// Just holds main
public class Inventory {
    public static void main (String [] args){
        UserInterface ui = new UserInterface(); //Builds the UI
    }
}
