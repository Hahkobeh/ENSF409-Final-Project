/**
 @author Colin Christophe <a href="mailto:colin.christophe@ucalgary.ca">colin.christophe@ucalgary.ca</a>
         Nicholas Knapton <a href="mailto:nicholas.knapton@ucalgary.ca">nicholas.knapton@ucalgary.ca</a>
         Brian Kramer <a href="mailto:brian.kramer@ucalgary.ca">brian.kramer@ucalgary.ca</a>
         Jacob Artuso <a href="mailto:jacob.artuso@ucalgary.ca">jacob.artuso@ucalgary.ca</a>
 @version       1.1
 @since         1.0
 */
package edu.ucalgary.ensf409;

// Just holds main


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
 *   Instructions on running unit tests are in UnitTests.java
 */

public class Inventory {
    public static void main (String [] args){
        UserInterface ui = new UserInterface();
    }
}
