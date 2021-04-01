package edu.ucalgary.ensf409;

import java.util.*;

public class Request {
    private List<Object> items;
    private int size;

    public Request(String category, String type){
        setSize(category);
        items = new ArrayList<>(size);

    }

    public void setSize(String category) {
        switch (category) {
            case "Chair" -> this.size = 4;
            case "Desk" -> this.size = 3;
            case "Lamp" -> this.size = 2;
            case "Filing" -> this.size = 3;
            default -> System.err.println("Invalid Category");
        }