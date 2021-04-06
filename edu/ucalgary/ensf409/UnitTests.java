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
 private static String PASSWORD = "";
  private static String USERNAME = "";
 
  @Test
  public void testFileisMade(){
        Request trial = null;
        try{
            trial = new Request("chair", "Task", 1, false, USERNAME,PASSWORD); // full order
        }catch(Exception e){

        }
        OrderForm trialOrder = new OrderForm(trial); // orderform
        assertTrue(new File("orderform.txt").exists()); // check if orderform creates file 
  }
 
  @Test 
  public void testFullOrderIsFilled(){
        Request trial = new Request("chair", "task", 1, false,  USERNAME ,PASSWORD ); // full order
        OrderForm trialOrder = new OrderForm(trial); // orderform
        assertTrue(trial.getNumberOfItemsDemanded() == trial.geAmountFilled()); //if full order is filled
  
    }
  @Test
  public void testPartialOrderisFilled(){
        Request Trial = new Request("chair", "task", 16, true,  USERNAME ,PASSWORD ); 
        assertTrue(trial.getAmountFilled > 0 && trial.getPartialOrder());
 }
  @Test
  public void testFullOrderCannotBeFilled(){
        Request Trial = new Request("chair", "task", 16, false,  USERNAME ,PASSWORD ); 
        assertTrue(trial.getNumberOfItemsDemanded != trial.getAmountFilled();
  }
 
  @Test 
  public void testPartialOrderCannotBeFilled(){
  
  
  }
}
