package edu.ucalgary.ensf409;

import java.util.*;
import java.sql.*;

public class Request {
    private Connection dbConnect;
    private List<Object> [] items;
    private String category;
    private String type;
    private int size;
    private String usernameMySQL;
    private String passwordMySQL;

    public Request(String category, String type, int numberOfItems, String usernameMySQL, String passwordMySQL) {
        this.category = category;
        this.type = type;

        this.usernameMySQL = usernameMySQL;
        this.passwordMySQL = passwordMySQL;

        items = new List[numberOfItems];


        setSize(category);

        for(int i = 0; i < items.length; i++){
            items[i] = new ArrayList<>(size);
        }
        getDatabase();

    }

    public void getDatabase() {
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", usernameMySQL, passwordMySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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