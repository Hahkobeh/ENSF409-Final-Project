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

    public OrderForm(Request request){
        this.originalRequest = request;
    }

    public void generateOrderFormat(){

        StringBuilder order = new StringBuilder();
        order.append("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n\nOriginal Request: ");
        order.append(originalRequest.getType() +" "+ originalRequest.getCategory() +", " + originalRequest.getNumberOfitemsDemanded());
        order.append("\n\nItems Ordered\n");
       
        String[] tempID = originalRequest.getChosenID();

        for(int i = 0 ; i < tempID.length; i++){
            order.append("ID: " + tempID[i] + "\n");
            
        }
        int[] temp = originalRequest.getChosenOptionsPrice();
        int b = 0;
        for(int i =0; i < temp.length; i++){
            b = b + temp[i];
        }

        order.append("\nTotal Price: $" + b);
        
        try{
            File obj = new File("orderform.txt");
            FileWriter fw = new FileWriter(obj);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.toString());
            bw.flush();
            bw.close();
        }    
        catch(FileNotFoundException ex){
            System.out.print("unable to open file");

        }
        catch(IOException ex){
            System.out.print("error reading file");
        }   
    }
}