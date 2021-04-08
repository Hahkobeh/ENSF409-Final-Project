/**
 @author Colin Christophe <a href="mailto:colin.christophe@ucalgary.ca">colin.christophe@ucalgary.ca</a>
         Nicholas Knapton <a href="mailto:nicholas.knapton@ucalgary.ca">nicholas.knapton@ucalgary.ca</a>
         Brian Kramer <a href="mailto:brian.kramer@ucalgary.ca">brian.kramer@ucalgary.ca</a>
         Jacob Artuso <a href="mailto:jacob.artuso@ucalgary.ca">jacob.artuso@ucalgary.ca</a>
 @version       1.3
 @since         1.0
 */
package edu.ucalgary.ensf409;


import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * Unit tests for the Inventory Manager Program. Ensure before running
 */
public class UnitTests {

 private static String PASSWORD = "password";
  private static String USERNAME = "Nick";
 

      /**
       * 
       *  These First tests test indavidual methods
       * 
       * 
       */


  @Test
 //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //getDatabase() to connect database 
 //ManuSuggest() to retrieve value of out, which is the suggestion
  public void testManuSuggestChairs(){
      this.resetTable();
      Request trial = null;
      String ans = null;
   //create a String
      String correct = "Order cannot be fulfilled with current inventory. 0 could be made." +
                       " Suggested Manufacturers for chairs are: \n" +
                       "Office Furnishings\nChairs R Us\nFurniture Goods\nFine Office Supplies\n";
      try{
            trial = new Request();
            trial.setCategory("chair");
            trial.setType("NotAType");
            trial.setNumberOfItemsDemanded(70);
            trial.setUsernameMySQL(USERNAME);
            trial.setPasswordMySQL(PASSWORD);
            trial.getDatabase();
       //retrieve String 
            ans = trial.ManuSuggest();
      }catch(Exception er){

      }
   //see if the Strings are the same
      assertTrue("The incorrect manufacturers were given", correct.equals(ans));
  }

  @Test
 //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //getDatabase() to connect database 
 //ManuSuggest() to retrieve value of out, which is the suggestion
  public void testManuSuggestDesk(){
      this.resetTable();
      Request trial = null;
      String ans = null;
   //Create a String
      String correct = "Order cannot be fulfilled with current inventory. 0 could be made." +
                       " Suggested Manufacturers for desks are: \n" +
                       "Academic Desks\nOffice Furnishings\nFurniture Goods\nFine Office Supplies\n";
      try{
            trial = new Request();
            trial.setCategory("desk");
            trial.setType("NotAType");
            trial.setNumberOfItemsDemanded(70);
            trial.setUsernameMySQL(USERNAME);
            trial.setPasswordMySQL(PASSWORD);
            trial.getDatabase();
       //Retrieve String
            ans = trial.ManuSuggest();
      }catch(Exception er){

      }
   //See if Strings are the same
      assertTrue("The incorrect manufacturers were given", correct.equals(ans));
  }

  @Test
 //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //getDatabase() to connect database 
 //ManuSuggest() to retrieve value of out, which is the suggestion
  public void testManuSuggestLamp(){
      this.resetTable();
      Request trial = null;
      String ans = null;
   //Create a String
      String correct = "Order cannot be fulfilled with current inventory. 0 could be made." +
                       " Suggested Manufacturers for lamps are: \n" +
                       "Office Furnishings\nFurniture Goods\nFine Office Supplies\n";
      try{
            trial = new Request();
            trial.setCategory("lamp");
            trial.setType("NotAType");
            trial.setNumberOfItemsDemanded(70);
            trial.setUsernameMySQL(USERNAME);
            trial.setPasswordMySQL(PASSWORD);
            trial.getDatabase();
           //Retrieve String
            ans = trial.ManuSuggest();
      }catch(Exception er){

      }
   //See if Strings are the same
      assertTrue("The incorrect manufacturers were given", correct.equals(ans));
  }

  @Test
  //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //getDatabase() to connect database 
 //ManuSuggest() to retrieve value of out, which is the suggestion
  public void testManuSuggestFiling(){
      this.resetTable();
      Request trial = null;
      String ans = null;
   //create a String
      String correct = "Order cannot be fulfilled with current inventory. 0 could be made." +
                       " Suggested Manufacturers for filings are: \n" +
                       "Office Furnishings\nFurniture Goods\nFine Office Supplies\n";
      try{
            trial = new Request();
            trial.setCategory("filing");
            trial.setType("NotAType");
            trial.setNumberOfItemsDemanded(70);
            trial.setUsernameMySQL(USERNAME);
            trial.setPasswordMySQL(PASSWORD);
            trial.getDatabase();
           //Retrieve String
            ans = trial.ManuSuggest();
      }catch(Exception er){

      }
   //See if Strings ae the same
      assertTrue("The incorrect manufacturers were given", correct.equals(ans));
  }

  @Test
 //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //getDatabase() to connect database
 //remove() with zero arguments
 //checkDataBaseForValue() with two arguments to retrive value
  //checkDataBaseForValue() with two arguments to retrive value
  //checkDataBaseForValue() with two arguments to retrive value
  public void testRemoveFilings(){
      this.resetTable();
      Request trial = null; 
   //Create and array and add the lines
      String[] testIDs = {"L132","L208","L096"}; 
      try{
            trial = new Request();
            trial.setCategory("filing");
            trial.setUsernameMySQL(USERNAME);
            trial.setPasswordMySQL(PASSWORD);
            trial.setChosenID(testIDs);
            trial.getDatabase();
            trial.remove();
      }catch(Exception er){

      }
     // retrieve boolean values 
      boolean test1 = this.checkDataBaseForValue("filing", "L132");
      boolean test2 = this.checkDataBaseForValue("filing", "L208");
      boolean test3 = this.checkDataBaseForValue("filing", "L096");
      //check that the booleans test1, test2, test3 are all false
      assertTrue("DataBase was incorrectly updated after remove() was called", (!test1 && !test2 && !test3));
  }

  @Test
  //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //getDatabase() to connect database
 //remove() with zero arguments
 //checkDataBaseForValue() with two arguments to retrive value
  //checkDataBaseForValue() with two arguments to retrive value
  //checkDataBaseForValue() with two arguments to retrive value
  public void testRemoveDesks(){
      this.resetTable();
      Request trial = null; 
      //Create and array and add the lines
      String[] testIDs = {"D3820","D1927","D1030"}; 
      try{
            trial = new Request();
            trial.setCategory("desk");
            trial.setUsernameMySQL(USERNAME);
            trial.setPasswordMySQL(PASSWORD);
            trial.setChosenID(testIDs);
            trial.getDatabase();
            trial.remove();
      }catch(Exception er){

      }
     // retrieve boolean values 
      boolean test1 = this.checkDataBaseForValue("desk", "D3820");
      boolean test2 = this.checkDataBaseForValue("desk", "D1927");
      boolean test3 = this.checkDataBaseForValue("desk", "D1030");
    //check that the booleans test1, test2, test3 are all false
      assertTrue("DataBase was incorrectly updated after remove() was called", (!test1 && !test2 && !test3));
  }

  @Test
   //Constructor created with 0 arguments
  //factorial() with one argument to retrieve value
 //factorial() with one argument to retrieve value
 //factorial() with one argument to retrieve value
  public void testFactorial(){
      Request trial = null; 
      try{
            trial = new Request();
      }catch(Exception er){

      }
      //set ints to the retrieved values
      int test1 = trial.factorial(5);
      int test2 = trial.factorial(9);
      int test3 = trial.factorial(2);
      // check that values are the same as the factorial value
      assertTrue("Incorrect factorial for test1", test1 == 120);
      assertTrue("Incorrect factorial for test2", test2 == 362880);
      assertTrue("Incorrect factorial for test3", test3 == 2);
  }

  @Test
 //Consructor created with zero arguments
 //setSize() with one argument
 //setData() with one argument
 //totalItemsThatCanBeMade
 //use getPossibleNumberOfItems() to retrieve values
  public void testTotalItemsThatCanBeMade(){
      Request trial = null; 
   //crerate a double array and add the elements
      char[][] testArray = {{'Y','N','N'},
                           {'Y','Y','Y'},
                           {'N','Y','Y'},
                           {'N','Y','Y'},
                           {'Y','Y','Y'}};
      try{
            trial = new Request();
            trial.setSize(3);
            trial.setData(testArray);
            trial.totalItemsThatCanBeMade();
      }catch(Exception er){

      }
   // retrieve int
   int check = trial.getPossibleNumberOfItems();
   //check that that values are the same
      assertTrue("The incorrect amount of items were calculated.", check == 3);
  }


  /**
   * 
   * 
   *  This next part tests full program functionality as opposed to indavidual methods.
   * 
   * 
   * 
   */


  @Test
   //Constructor created with 0 arguments
 //setCategory() with one argument
 //setType() with one argument
 //setNumberOfItemsDemanded() with one argument
 //setPartialOrder() with one argument
 //setUsernameMySQL() with one argument
 //setPasswordMySQL() with one argument
 //setSize() with one argument
 //getDatabase() to connect database
 //storeData() to retrieve database
 //totalItemsThatCanBeMade() 
 //getPossibleNumberOfItems() to retrieve values
  public void testCorrectNumberOfItems(){
        this.resetTable();
        Request trial = null;
        try{
              trial = new Request();
              trial.setCategory("chair");
              trial.setType("Mesh");
              trial.setNumberOfItemsDemanded(1);
              trial.setPartialOrder(false);
              trial.setUsernameMySQL(USERNAME);
              trial.setPasswordMySQL(PASSWORD);
              trial.setSize("chair");
              trial.getDatabase();
              trial.storeData();
              trial.totalItemsThatCanBeMade();
        }catch(Exception e){

        }
    //Retrieve int
   int check = trial.getPossibleNumberOfItems();
   //check that the calues are the same
        assertTrue("Incorrect number of items", check == 1);
  }
  
  @Test
  //constructor with 7 arguments
 //getChosenID() to retrieve values
  
  public void testCorrectItems(){
        this.resetTable();
   //create two arrays and add lines to each
        String[] answer = {"D0890","D8675"};
        String[] answer2 = {"D8675","D0890"};
        Request trial = null;
        try{
              trial = new Request("Desk", "traditional", 1, false, USERNAME, PASSWORD, "test");
        }catch(Exception e){

        }
   //retrieve String array
   String[] ans = trial.getChosenID();
   //checks that ans is the same as answer or answer2
        assertTrue("Incorrect combination of items", (Arrays.equals(ans, answer2) || Arrays.equals(ans,answer)));
  }

  @Test
  //Constructor created with 7 arguments
  //use getPrice() to retreive value
  public void testCorrectPrice(){
      this.resetTable();
      Request trial = null;
      try{
            trial = new Request("lamp", "swing arm", 2, false, USERNAME, PASSWORD, "test");
      }catch(Exception e){

      }
   //Retrieve int
   int check = trial.getPrice();
   //check that the values are the same
      assertTrue("Incorrect price for items", check == 60);
  }

  @Test
 //Constructor created with 7 arguments
  //use getPossibleNumberOfItems() to retreive value
  public void testCorrectItems4(){
        this.resetTable();
        Request trial = null;
        try{
            trial = new Request("lamp", "Desk", 3, true, USERNAME, PASSWORD, "test");
        }catch(Exception e){

        }
   //Retrieve int
   int check = trial.getPossibleNumberOfItems();
   //Check the ints to make sure they are the same
        assertTrue("Incorrect combination of items", check == 3);
  }

  @Test
 //Constructor created with 7 arguments
  public void testInvalidInputTypeNotInTable(){
      this.resetTable();
      Request trial = null;
      Exception e = null;
      try{
            trial = new Request("Chair", "NotARealType", 2, true, USERNAME, PASSWORD, "test");
      }catch(Exception er){
       //set e to the exception that was thrown
       e = er;
      }
   //check to make sure an e isn't null
      assertTrue("Error was not thrown",e != null);
  }

  @Test
 //Constructor created with 7 arguments
  public void testInvalidInputCategoryNotInTable(){
      this.resetTable();
      Request trial = null;
      Exception e = null;
      try{
            trial = new Request("NotAChair", "Mesh", 2, true, USERNAME, PASSWORD, "test");
      }catch(Exception er){
            e = er; //set e to the exception that was thrown
      }
     //check to make sure an e isn't null
      assertTrue("Error was not thrown",e != null);
  }

  @Test
 //Constructor created with 7 arguments
  //use getPrice() to retreive value
  public void testWierdCasingOnCategory(){
      this.resetTable();
      Request trial = null;
      Exception e = null;
      try{
            trial = new Request("ChAiR", "Mesh", 1, true, USERNAME, PASSWORD, "test");
      }catch(Exception er){
            e = er; //set e to the exception that was thrown
      }
   //retrieve int
   int check = trial.getPrice();
   //make sure that the ints are the same and the e isn't null
      assertTrue("Error was not thrown", check == 150 && e == null);
  }

  @Test
 //Constructor created with 6 arguments
  //use getPrice() to retreive value
  public void testWierdCasingOnType(){
      this.resetTable();
      Request trial = null;
      Exception e = null;
      try{
            trial = new Request("chair", "mEsH", 1, true, USERNAME, PASSWORD, "test");
      }catch(Exception er){
            e = er; //set e to the exception that was thrown
      }
    //retrieve int
   int check = trial.getPrice();
   //make sure that the ints are the same and the e isn't null
      assertTrue("Error was not thrown", check == 150 && e == null);
  }

  @Test
 //Constructor created with 7 arguments
  //use getdataBaseForValue(category, ID) with two arguments to see if item is in database 
  public void testDataBaseIsUpdatedAfterSuccessOrder(){
      this.resetTable();
      Request trial = null;
      try{
            trial = new Request("Chair", "mesh", 1, true, USERNAME, PASSWORD, "test");
      }catch(Exception er){

      }
      //retrieve booleans
      boolean firstCheck = this.checkDataBaseForValue("chair", "C0942");
      boolean secondCheck = this.checkDataBaseForValue("chair", "C9890");
      //confirm that both firstCheck and secondCheck are false
      assertTrue("DataBase not succesfully updated.",(!firstCheck && !secondCheck));
  }

  @Test
 //Constructor created with 7 arguments
  //use new File().exists uses an argument to confirm the existence of an orderform 
  public void testFileisMade(){
        this.resetTable();
        Request trial = null;
        try{
            trial = new Request("chair", "Task", 1, false, USERNAME,PASSWORD, "test"); // full order
        }catch(Exception e){

        }
        OrderForm trialOrder = new OrderForm(trial); // orderform
        // retrieve boolean
        boolean check = new File("orderform.txt").exists();
        // make sure that check is true
        assertTrue("An order form wasnt made.", check); // check if orderform creates file 
  }
 
  @Test 
  //Constructor created with 7 arguments
  //use getNumberOfItemsDemanded() to retrieve a value
  //use getAmountFilled() to retrieve a value
  public void testFullOrderIsFilled(){
      this.resetTable();
      Request trial = null;
      try {
            trial = new Request("desk", "Standing", 2, false,  USERNAME ,PASSWORD, "test");
      } catch (Exception e) {
          
      } 
        // full order
        OrderForm trialOrder = new OrderForm(trial); // orderform
        //retrieve ints
        int amount = trial.getAmountFilled();
        int demanded = trial.getNumberOfItemsDemanded();
        // check that amount and demanded are the same
        assertTrue(demanded == amount); //if full order is filled
    }

  @Test
 //Constructor created with 7 arguments
 //use new File().exists uses an argument to confirm the existence of an orderform
  public void testPartialOrderisFilled(){
      this.resetTable();
      Request trial = null;
      try {
            trial = new Request("chair", "mesh", 16, true,  USERNAME ,PASSWORD, "test");
            OrderForm form = new OrderForm(trial); 
      } catch (Exception e) {
           
      }
       // retrieve boolean
       boolean check = new File("orderform.txt").exists();
       // make sure that check is true
      assertTrue("No orderform for a partial order was made.", check); // If a partial order was filled it should make a orderform
  }
   @Test
  //Constructor created with 7 arguments
 //use getChosenID() to get values
 //getcategory() to retrieve values
  public void testItemsDeletedSuccessfully(){
    this.resetTable();
    Request trial = null;
    boolean checkIfDeleted = true;
    try {
        trial = new Request("chair", "task", 1, true,  USERNAME ,PASSWORD, "test");
        String [] orderedFurniture = trial.getChosenID();
        
        for(int i = 0; i < orderedFurniture.length; i++){
            if(checkDataBaseForValue(trial.getCategory(), orderedFurniture[i])){
                checkIfDeleted = false;
            }

        }
    } catch (Exception e) {
       
    }
    assertTrue("Item was not successfully deleted after it was sold.", checkIfDeleted); // If the furniture is sold it should be removed from the datatbase
  }

  @Test 
 //Constructor created with 7 arguments
 
  public void testOrderEmpty(){
      this.resetTable();
      Request trial = null;
      Exception e = null;
      try{
          trial = new Request("chair", "mesh", 0, false, USERNAME, PASSWORD, "test");

      }catch(Exception er){
            //set e to the exception thrown
            e = er;
      }
      //check that e is not null
      assertTrue("Error was not thrown", e != null);
  }



  /**
   * Resets the example table provided everytime the tests are run to ensure values are not deleted in one test then tried to be used in another test and fail.
   */
  public void resetTable(){
      Connection dbConnect = null;
      try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", USERNAME, PASSWORD);
      } catch (SQLException e) {
            e.printStackTrace();
      }
      String query = "DROP DATABASE IF EXISTS INVENTORY;";
      String query1 = "CREATE DATABASE INVENTORY;";
      String query2 = "USE INVENTORY;";
      String query3 = "DROP TABLE IF EXISTS MANUFACTURER;";
      String query4 = "CREATE TABLE MANUFACTURER (" + 
            "ManuID			char(3) not null,"+
            "Name			varchar(25),"+
            "Phone			char(12),"+
          "Province		char(2),"+
            "primary key (ManuID)"+
      ");";
      String query4andhalf = "INSERT INTO MANUFACTURER (ManuID, Name, Phone, Province)VALUES('001',	'Academic Desks',	'236-145-2542',	'BC'),('002',	'Office Furnishings',	'587-890-4387',	'AB'),('003',	'Chairs R Us',	'705-667-9481',	'ON'),('004',	'Furniture Goods',	'306-512-5508',	'SK'),('005',	'Fine Office Supplies',	'403-980-9876',	'AB');";
      String query5 = "DROP TABLE IF EXISTS CHAIR;";
      String query5andhalf = "CREATE TABLE CHAIR (ID				char(5)	not null,Type			varchar(25),Legs			char(1),Arms			char(1),Seat			char(1),Cushion			char(1),Price			integer,	ManuID			char(3),	primary key (ID),	foreign key (ManuID) references MANUFACTURER(ManuID) ON UPDATE CASCADE);";
      String query6 = "INSERT INTO CHAIR (ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID)VALUES('C1320',	'Kneeling',	'Y',	'N',	'N',	'N',	50,	'002'),('C3405',	'Task',	'Y',	'Y',	'N',	'N',	100,	'003'),('C9890',	'Mesh',	'N',	'Y',	'N',	'Y',	50,	'003'),('C7268',	'Executive',	'N',	'N',	'Y',	'N',	75,	'004'),('C0942',	'Mesh',	'Y',	'N',	'Y',	'Y',	100,	'005'),('C4839',	'Ergonomic',	'N',	'N',	'N',	'Y',	50,	'002'),('C2483',	'Executive',	'Y',	'Y',	'N',	'N',	175,	'002'),('C5789',	'Ergonomic',	'Y',	'N',	'N',	'Y',	125,	'003'),('C3819',	'Kneeling',	'N',	'N',	'Y',	'N',	75,	'005'),('C5784',	'Executive',	'Y',	'N',	'N',	'Y',	150,	'004'),('C6748',	'Mesh',	'Y',	'N',	'N',	'N',	75,	'003'),('C0914',	'Task',	'N',	'N',	'Y',	'Y',	50,	'002'),('C1148',	'Task',	'Y',	'N',	'Y',	'Y',	125,	'003'),('C5409',	'Ergonomic',	'Y',	'Y',	'Y',	'N',	200,	'003'),('C8138',	'Mesh',	'N',	'N',	'Y',	'N',	75,	'005');";
      String query7 = "DROP TABLE IF EXISTS DESK;";
      String query8 = "CREATE TABLE DESK (	ID				char(5)	not null,	Type			varchar(25),	Legs			char(1),	Top			char(1),	Drawer			char(1),    Price			integer,	ManuID			char(3),	primary key (ID),	foreign key (ManuID) references MANUFACTURER(ManuID) ON UPDATE CASCADE);";
      String query9 = "INSERT INTO DESK (ID, Type, Legs, Top, Drawer, Price, ManuID)VALUES('D3820',	'Standing',	'Y',	'N',	'N',	150,	'001'),('D4475',	'Adjustable',	'N',	'Y',	'Y',	200,	'002'),('D0890',	'Traditional',	'N',	'N',	'Y',	25,	'002'),('D2341',	'Standing',	'N',	'Y',	'N',	100,	'001'),('D9387',	'Standing',	'Y',	'Y',	'N',	250,	'004'),('D7373',	'Adjustable',	'Y',	'Y',	'N',	350,	'005'),('D2746',	'Adjustable',	'Y',	'N',	'Y',	250,	'004'),('D9352',	'Traditional',	'Y',	'N',	'Y',	75,	'002'),('D4231',	'Traditional',	'N',	'Y',	'Y',	50,	'005'),('D8675',	'Traditional',	'Y',	'Y',	'N',	75,	'001'),('D1927',	'Standing',	'Y',	'N',	'Y',	200,	'005'),('D1030',	'Adjustable',	'N',	'Y',	'N',	150,	'002'),('D4438',	'Standing',	'N',	'Y',	'Y',	150,	'004'),('D5437',	'Adjustable',	'Y',	'N',	'N',	50,	'001'),('D3682',	'Adjustable',	'N',	'N',	'Y',	50,	'005');      ";
      String query10 = "DROP TABLE IF EXISTS LAMP;";
      String query11 = "CREATE TABLE LAMP (	ID				char(4)	not null,	Type			varchar(25),	Base			char(1),	Bulb			char(1),    Price			integer,	ManuID			char(3),	primary key (ID),	foreign key (ManuID) references MANUFACTURER(ManuID) ON UPDATE CASCADE);";
      String query12 = "INSERT INTO LAMP (ID, Type, Base, Bulb, Price, ManuID)VALUES('L132',	'Desk',	'Y',	'N',	18,	'005'),('L980',	'Study',	'N',	'Y',	2,	'004'),('L487',	'Swing Arm',	'Y',	'N',	27,	'002'),('L564',	'Desk',	'Y',	'Y',	20,	'004'),('L342',	'Desk',	'N',	'Y',	2,	'002'),('L982',	'Study',	'Y',	'N',	8,	'002'),('L879',	'Swing Arm',	'N',	'Y',	3,	'005'),('L208',	'Desk',	'N',	'Y',	2,	'005'),('L223',	'Study',	'N',	'Y',	2,	'005'),('L928',	'Study',	'Y',	'Y',	10,	'002'),('L013',	'Desk',	'Y',	'N',	18,	'004'),('L053',	'Swing Arm',	'Y',	'N',	27,	'002'),('L112',	'Desk',	'Y',	'N',	18,	'005'),('L649',	'Desk',	'Y',	'N',	18,	'004'),('L096',	'Swing Arm',	'N',	'Y',	3,	'002');";
      String query13 = "DROP TABLE IF EXISTS FILING;";
      String query14 = "CREATE TABLE FILING (	ID				char(4)	not null,	Type			varchar(25),	Rails			char(1),	Drawers			char(1),	Cabinet			char(1),    Price			integer,	ManuID			char(3),	primary key (ID),	foreign key (ManuID) references MANUFACTURER(ManuID) ON UPDATE CASCADE);";
      String query15 = "INSERT INTO FILING (ID, Type, Rails, Drawers, Cabinet, Price, ManuID)VALUES('F001',	'Small',	'Y',	'Y',	'N',	50,	'005'),('F002',	'Medium',	'N',	'N',	'Y',	100,	'004'),('F003',	'Large',	'N',	'N',	'Y',	150,	'002'),('F004',	'Small',	'N',	'Y',	'Y',	75,	'004'),('F005',	'Small',	'Y',	'N',	'Y',	75,	'005'),('F006',	'Small',	'Y',	'Y',	'N',	50,	'005'),('F007',	'Medium',	'N',	'Y',	'Y',	150,	'002'),('F008',	'Medium',	'Y',	'N',	'N',	50,	'005'),('F009',	'Medium',	'Y',	'Y',	'N',	150,	'004'),('F010',	'Large',	'Y',	'N',	'Y',	225,	'002'),('F011',	'Large',	'N',	'Y',	'Y',	225,	'005'),('F012',	'Large',	'N',	'Y',	'N',	75,	'005'),('F013',	'Small',	'N',	'N',	'Y',	50,	'002'),('F014',	'Medium',	'Y',	'Y',	'Y',	200,	'002'),('F015',	'Large',	'Y',	'N',	'N',	75,	'004');";

      try{
          PreparedStatement statement = dbConnect.prepareStatement(query);
          statement.executeUpdate();
          statement = dbConnect.prepareStatement(query1);
          statement.executeUpdate();
          statement = dbConnect.prepareStatement(query2);
          statement.executeUpdate();
          statement = dbConnect.prepareStatement(query3);
          statement.executeUpdate();
          statement = dbConnect.prepareStatement(query4);
          statement.executeUpdate();  
          statement = dbConnect.prepareStatement(query4andhalf);
          statement.executeUpdate();  
          statement = dbConnect.prepareStatement(query5);
          statement.executeUpdate();
          statement = dbConnect.prepareStatement(query5andhalf);
          statement.executeUpdate(query5andhalf);
          statement = dbConnect.prepareStatement(query6);
          statement.executeUpdate(query6);
          statement = dbConnect.prepareStatement(query7);
          statement.executeUpdate(query7);
          statement = dbConnect.prepareStatement(query8);
          statement.executeUpdate(query8);
          statement = dbConnect.prepareStatement(query9);
          statement.executeUpdate(query9);
          statement = dbConnect.prepareStatement(query10);
          statement.executeUpdate(query10);
          statement = dbConnect.prepareStatement(query11);
          statement.executeUpdate(query11);
          statement = dbConnect.prepareStatement(query12);
          statement.executeUpdate(query12);
          statement = dbConnect.prepareStatement(query13);
          statement.executeUpdate(query13);
          statement = dbConnect.prepareStatement(query14);
          statement.executeUpdate(query14);
          statement = dbConnect.prepareStatement(query15);
          statement.executeUpdate(query15);
      }catch(SQLException e){
          e.printStackTrace();
      }
  }

  /**
   * Checks the database for an element given by the parameters
   * @param category 
   * @param id
   * @return True if item is in database
   */
  private boolean checkDataBaseForValue(String category, String id){
      Connection dbConnect = null;
      PreparedStatement statement = null;
      try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", USERNAME, PASSWORD);
      } catch (SQLException e) {
            e.printStackTrace();
      }
      try {
            statement = dbConnect.prepareStatement("SELECT * FROM " + category + " where ID = \"" + id + "\";");

            ResultSet res = statement.executeQuery();

            if(res.next()){
                  return true;
            }else{
                  return false;
            }

      } catch (SQLException e) {
            e.printStackTrace();
      }
      return false;
  }
}
