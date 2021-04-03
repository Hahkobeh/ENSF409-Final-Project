package edu.ucalgary.ensf409;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

/**
 * Code written by: Jacob Artuso, Colin Christophe, Nicholas Knapton, and Brian Kramer
 */

public class OrderForm {
    private Request originalRequest;
    private  FurnitureItem[] itemsOrdered;
    public FurnitureItem[] getItemsOrdered() {
        return itemsOrdered;
    }
    public Request getOriginalRequest() {
        return originalRequest;
    }
    public void setOriginalRequest(Request originalRequest) {
        this.originalRequest = originalRequest;
    }
    public void setItemsOrdered(FurnitureItem[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }
    private int getTotalPrice(){
        return 5;
    }
    /*
    public void generateOrderFormat(){

        StringBuilder order = new StringBuilder();
        order.append("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n\nOriginal Request:");
        order.append(originalRequest.getType() +" "+ originalRequest.getCategory() +", " + originalRequest.getNumberOfItems());
        order.append("\n\nItems Ordered\n");
       
        for(int i = 0 ; i < originalRequest.getNumberOfItems(); i++){
            order.append("ID: " + this.itemsOrdered[i].getIDNumber()+ "\n");
            
        }
        order.append("\nTotalPrice: $" + getTotalPrice());
        
        try{
            File obj = new File("orderForm.txt");
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
    */
/*
}
*/
