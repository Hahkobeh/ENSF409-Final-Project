/**
 @author Colin Christophe <a href="mailto:colin.christophe@ucalgary.ca">colin.christophe@ucalgary.ca</a>
         Nick Knapton <a href="mailto:nick.knapton@ucalgary.ca">nick.knapton@ucalgary.ca</a>
         Brian Kramer <a href="mailto:brian.kramer@ucalgary.ca">brian.kramer@ucalgary.ca</a>
         tucan jake <a href="mailto:tucan.jake@ucalgary.ca">tucan.jake@ucalgary.ca</a>
 @version       1.5
 @since         1.0
 */
package edu.ucalgary.ensf409;


import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class UnitTests {
 
 @Test
 public void testFileisMade(){
   Request trial = new Request(Chair, Task, 1, false,  "scm","ensf409"); // full order
 OrderForm trialOrder = new OrderForm(trial); // orderform
 assertTrue("orderform.txt".exists()); // check if orderform creates file
 }
 

 assertTrue(trial.getNumberOfItemsDemanded() == trial.geAmountFilled()); //if full order is filled
 trial = new Request(Chair, Task, 1, true,  "scm","ensf409"); // new order of task chairs
 assertTrue(trial.getNumberOfItemsDemanded() == trial.geAmountFilled()); // check is partial order is filled
 trial = new Request(Desk, Standing, 2, false,  "scm","ensf409");
 assertTrue(trial.getPrice() == 600);
 trial = new Request(Lamp, Swing Arm, 3, true,  "scm","ensf409");
 assertTrue(trial.getAmountFilled > 0 && trial.getPartialOrder());
 

}
