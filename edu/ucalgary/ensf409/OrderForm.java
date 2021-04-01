package edu.ucalgary.ensf409;

import java.io.File;

public class OrderForm {
    private Request originalRequest;
    private FurnitureItem[] itemsOrdered;
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
    public File generateOrderFormat(){
        
    }
}
