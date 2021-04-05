package edu.ucalgary.ensf409;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

/**
 * Code written by: Jacob Artuso, Colin Christophe, Nicholas Knapton, and Brian Kramer
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
        order.append("\n\nItems Ordered\n");
       
        String[] tempID = originalRequest.getChosenID(); // create temporary string[] to store the ID numbers of the objects that will be used to fufill the order.

        for(int i = 0 ; i < tempID.length; i++){     //goes through each ID in the temp array and appends it to the order stringBuilder. 
            order.append("ID: " + tempID[i] + "\n");
            
        }
        int[] price = originalRequest.getChosenOptionsPrice(); //creates an int[] that contains the price of each object of furniture it used to fufill the order.
        int totalPrice = 0;
        for(int i =0; i < price.length; i++){   //goes through the price array and adds all the prices together to get the total Price.
            totalPrice = totalPrice + price[i];
        }

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
