/**
 @author Colin Christophe <a href="mailto:colin.christophe@ucalgary.ca">colin.christophe@ucalgary.ca</a>
         Nick Knapton <a href="mailto:nicholas.knapton@ucalgary.ca">nicholas.knapton@ucalgary.ca</a>
         Brian Kramer <a href="mailto:brian.kramer@ucalgary.ca">brian.kramer@ucalgary.ca</a>
         Jacob Artuso <a href="mailto:jacob.artuso@ucalgary.ca">jacob.artuso@ucalgary.ca</a>
 @version       1.5
 @since         1.0
 */

package edu.ucalgary.ensf409;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;


/*
OrderForm is a program which will make a file using information in a request object
*/

public class OrderForm {
    private Request originalRequest;

    /**
     * This function sets originalRequest to the request sent in then it calls generateOrderFormat() to generate an order form
     * @param request is an object of type Request
     */
    public OrderForm(Request request){
        this.originalRequest = request;
        generateOrderFormat();
    }
    /**
     * This function uses the information found in the originalRequest to construct an order form. 
     */
    public void generateOrderFormat(){

        StringBuilder order = new StringBuilder();
        order.append("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n\nOriginal Request: "); 
        order.append(originalRequest.getType() +" "+ originalRequest.getCategory() +", " + originalRequest.getNumberOfitemsDemanded());
     
        order.append("\nNumber of items filled: " + originalRequest.getAmountFilled());
        order.append("\n\nItems Ordered\n");
       
        String[] tempID = originalRequest.getChosenID(); // create temporary string[] to store the ID numbers of the objects that will be used to fufill the order.

        for(int i = 0 ; i < tempID.length; i++){     //goes through each ID in the temp array and appends it to the order stringBuilder. 
            order.append("ID: " + tempID[i] + "\n");
            
        }
    
       int totalPrice = originalRequest.getPrice();
        order.append("\nTotal Price: $" + totalPrice);
        
        try{
            File obj = new File("orderform.txt"); //creates a new File called orderform.txt
            FileWriter fw = new FileWriter(obj); 
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.toString()); // writes the order string to the orderform file
            bw.flush();
            bw.close();
        }    
        catch(FileNotFoundException ex){ // throws exception if it is unable to open the orderform file
            System.out.print("unable to open file");

        }
        catch(IOException ex){ // throws error if it is unable to write to orderform.txt
            System.out.print("error writing to file");
        }   
    }
}
