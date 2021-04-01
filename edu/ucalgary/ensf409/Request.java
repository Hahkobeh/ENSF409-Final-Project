package edu.ucalgary.ensf409;

public class Request {
    private String category;
    private String type;
    private int numberOfItems;

    public int getNumberOfItems() {
        return numberOfItems;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
    public boolean checkRequests(){

    }
}
