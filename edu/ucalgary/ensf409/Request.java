package edu.ucalgary.ensf409;

import java.util.*;
import java.sql.*;

public class Request {
    private Connection database;
    private List<Object> [] items;
    private String category;
    private String type;
    private int size;

    public Request(String category, String type, int numberOfItems) {
        setSize(category);
        this.category = category;
        this.type = type;
        items = new List[numberOfItems];
        for(int i = 0; i < items.length; i++){
            items[i] = new ArrayList<>(size);
        }
        getLowestPrice();
    }

    public void setSize(String category) {
        switch (category) {
            case "Chair": this.size = 4;
            break;
            case "Desk": this.size = 3;
            break;
            case "Lamp": this.size = 2;
            break;
            case "Filing": this.size = 3;
            break;
            default: System.err.println("Invalid Category");
        }
    }

    public void getLowestPrice(){



    }
}