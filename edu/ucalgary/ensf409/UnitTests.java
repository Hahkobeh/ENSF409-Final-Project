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
 Request trial = new Request(Chair, Task, 1, false,  "scm","ensf409");
 OrderForm trialOrder = new OrderForm(trial);
 assertTrue("orderform.txt".exists());
 assertTrue(trial.getNumberOfItemsDemanded() == trial.geAmountFilled());
 trial = new Request(Chair, Task, 1, true,  "scm","ensf409");
 assertTrue(trial.getNumberOfItemsDemanded() == trial.geAmountFilled());
 
 
 
 
 

}
