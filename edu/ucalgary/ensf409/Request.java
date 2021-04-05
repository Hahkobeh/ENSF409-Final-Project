package edu.ucalgary.ensf409;

/**
 * Code written by: Jacob Artuso, Colin Christophe, Nicholas Knapton, and Brian Kramer
 */

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

public class Request {
    private Connection dbConnect;
    private String category;
    private String type;
    private int size;
    private int numberOfEntries = 0;
    private String usernameMySQL;
    private String passwordMySQL;
    private char [][] data;
    private int [] priceData;
    private String [] dataID;
    private int numberOfitemsDemanded;
    private int possibleNumberOfItems;
    private int [][] chosenOptions;
    private int [] chosenOptionsPrice;
	private String [] chosenID;

    public Request(String category, String type, int numberOfitemsDemanded, String usernameMySQL, String passwordMySQL) {
        this.category = category;
        this.type = type;
        this.numberOfitemsDemanded = numberOfitemsDemanded;
        this.usernameMySQL = usernameMySQL;
        this.passwordMySQL = passwordMySQL;
        setSize(category);
        getDatabase();
        storeData();
        totalItemsThatCanBeMade();


        if(possibleNumberOfItems == 0){
            System.out.println("failed");

            //FIX THIS
        }else if(possibleNumberOfItems < numberOfitemsDemanded){
            chosenOptions = new int[possibleNumberOfItems][size];
            chosenOptionsPrice = new int[numberOfitemsDemanded];
            JOptionPane.showMessageDialog(new JFrame(), "Not enough components only "+ possibleNumberOfItems + "could be made");
            for(int z = 0; z < possibleNumberOfItems; z++){
                searchForLowest(z);
            }
        }else if(possibleNumberOfItems >= numberOfitemsDemanded){
            chosenOptions = new int[numberOfitemsDemanded][size];
            chosenOptionsPrice = new int[numberOfitemsDemanded];
            System.out.println("order passed using ");
            for(int z = 0; z < numberOfitemsDemanded; z++){
                searchForLowest(z);
            }

        }

		
		int countItems = 0;
		
		for(int i = 0;i<chosenOptions.length;i++){
			for(int j=0;j<chosenOptions[i].length;j++){
				if(chosenOptions[i][j] != 0){
					countItems++;
				}
			}
		}
		
		int [] itemList = new int[countItems];
		chosenID = new String[countItems];
		countItems = 0;
		for(int i = 0;i<chosenOptions.length;i++){
			for(int j=0;j<chosenOptions[i].length;j++){
				if(chosenOptions[i][j] != 0){
					itemList[countItems] = chosenOptions[i][j]-1;
					countItems++;
				}
			}
		}	

		
		for(int i = 0;i<itemList.length;i++){
			chosenID[i] = dataID[itemList[i]];
			
			
			
				}

				
			Remove();
	}
		
        //NEED TO ADD A REMOVE FUNCTION THAT TAKES ALL THE USED ITEMS AND GETS RID OF THEM
        //CHANGE CHOSENOPTIONS TO A STRING ARRAY THAT HOLDS THE USED DATAIDS




    public int[] getChosenOptionsPrice() {
        return chosenOptionsPrice;
    }

    public int[][] getChosenOptions() {
        return chosenOptions;
    }
	
    public String getCategory() {
        return category;
    }
	

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getNumberOfitemsDemanded() {
        return numberOfitemsDemanded;
    }

    public int getPossibleNumberOfItems() {
        return possibleNumberOfItems;
    }


    public String[] getChosenID() {
        return chosenID;
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

    public void storeData(){
        String query1 = "SELECT COUNT(*) FROM " + category + " WHERE type = '" + type + "';";

        try{
            Statement statement = dbConnect.createStatement();

            ResultSet result = statement.executeQuery(query1);
            result.next();
            numberOfEntries = result.getInt("COUNT(*)");
            result.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        data = new char[numberOfEntries][size];
        priceData = new int[numberOfEntries];
        dataID = new String[numberOfEntries];


        String query2 = "SELECT * FROM " + category + " WHERE type = '" + type + "';";

        try{
            Statement statement = dbConnect.createStatement();
            ResultSet results = statement.executeQuery(query2);
            int row = 0;
            while(results.next()){
                switch (category) {
                    case "Chair":
                        data[row][0] = results.getString("Legs").charAt(0);
                        data[row][1] = results.getString("Arms").charAt(0);
                        data[row][2] = results.getString("Seat").charAt(0);
                        data[row][3] = results.getString("Cushion").charAt(0);
                        priceData[row] = results.getInt("Price");
                        dataID[row] = results.getString("ID");
                        break;
                    case "Desk":
                        data[row][0] = results.getString("Legs").charAt(0);
                        data[row][1] = results.getString("Top").charAt(0);
                        data[row][2] = results.getString("Drawer").charAt(0);
                        priceData[row] = results.getInt("Price");
                        dataID[row] = results.getString("ID");
                        break;
                    case "Filing":
                        data[row][0] = results.getString("Rails").charAt(0);
                        data[row][1] = results.getString("Drawers").charAt(0);
                        data[row][2] = results.getString("Cabinet").charAt(0);
                        priceData[row] = results.getInt("Price");
                        dataID[row] = results.getString("ID");
                        break;
                    case "Lamp":
                        data[row][0] = results.getString("Base").charAt(0);
                        data[row][1] = results.getString("Bulb").charAt(0);
                        priceData[row] = results.getInt("Price");
                        dataID[row] = results.getString("ID");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + category);
                }
                row++;
            }
            System.out.println("finished");

        }catch(SQLException e){
            e.printStackTrace();
        }



    }

    //need a function that checks if possible (enough Y-s in each column)

    public void totalItemsThatCanBeMade(){
        int possibleNumberOfItems = 10000;
        int temp;
        int row;
        for(int column = 0; column < size; column++){
            temp = 0;
            row = 0;
            while(row < data.length){
                if(data[row][column]== 'Y'){
                    temp += 1;
                }
                row++;
            }
            if(temp < possibleNumberOfItems){
                possibleNumberOfItems = temp;
            }

        }
        this.possibleNumberOfItems = possibleNumberOfItems;
    }

    public void searchForLowest(int itemNumber){
        int [] chosenOption = new int[numberOfEntries];
        int [] options = new int[numberOfEntries];
        for(int i = 0; i < options.length; i++){
            options[i] = i + 1;
        }

        int numberOfPossibleCombinations = 0;
        for(int temp = numberOfEntries; temp > 0; temp--){
            numberOfPossibleCombinations += ( factorial(numberOfEntries) )/( factorial(temp)*factorial(numberOfEntries - temp));
        }



        int [][] allPossible = new int[numberOfPossibleCombinations][numberOfEntries];
        fillCombinationArray(allPossible, options);


        //need a function that will be called at the end to remove all used database members




        //I need to find cheapest combination (make note of which
        //furniture items have been used), then set used parts to N and set price of the furniture item
        //that has been used to 0 then find next cheapest again.


        chosenOptionsPrice[itemNumber] = findPrice(allPossible, numberOfPossibleCombinations, chosenOption, itemNumber);

    }

    public int findPrice(int  [][] allPossible, int numberOfPossibleCombinations, int [] chosenOption, int itemNumber ){
        int price = 99999;
        for(int m = 0; m < numberOfPossibleCombinations; m++){
            if(possibleChoice(allPossible[m])){
                int e = priceOfCombination(allPossible[m]);
                if(e < price){
                    price = e;
                    chosenOption = allPossible[m];
                }
            }
        }
        chosenOptions[itemNumber] = chosenOption;

        removePriceFromUsed(chosenOption);
        removeTakenComponents(chosenOption);

        return price;

    }

    public void removeTakenComponents(int [] array){
        for(int u = 0; u < size; u++){
            int q = 0;
            while(q < array.length && array[q] != 0){
                if(data[array[q] - 1][u] == 'Y'){
                    data[array[q] - 1][u] = 'N';
                    break;
                }
                q++;
            }
        }

    }

    public void removePriceFromUsed(int [] array){
        int q = 0;
        while(q < array.length && array[q] != 0){
            priceData[array[q] - 1] = 0;
            q++;
        }
    }

    public boolean possibleChoice(int [] array){
        boolean [] test = new boolean[size];
        int q = 0;



        while(q < array.length && array[q] != 0) {
            for(int l = 0; l < size; l++){
                if(data[array[q] - 1][l] == 'Y'){
                    test[l] = true;
                }
            }


            q++;

        }
        for(int y = 0; y < size; y++){
            if(test[y] == false){
                return false;
            }
        }
        return true;

    }
    public int priceOfCombination(int [] array){
        int price = 0;
        int q = 0;
        while(q < array.length && array[q] != 0){
            price += priceData[array[q] - 1];
            q++;
        }
        return price;
    }





    public void fillCombinationArray(int [][] allPossible, int [] options){
        int position = 0;
        for(int r = 1; r <= size; r++){
            int data [] = new int[r];
            position = combinationGenerator(allPossible, options,data, 0, options.length - 1 , 0, r, position);
        }

    }

    public int combinationGenerator(int [][] allPossible, int [] options, int [] toAdd, int first, int last, int index, int r, int position) {
        if (index == r) {
            for (int j = 0; j < r; j++) {
                allPossible[position][j] = toAdd[j];

            }
            position++;
            return position;

        }
        for (int i = first; i <= last && last - i + 1 >= r - index; i++) {
            toAdd[index] = options[i];
            position = combinationGenerator(allPossible, options, toAdd, i+1, last, index+1, r, position);
        }
        return position;
    }

    public int factorial(int n){
        int temp = 1;
        for (int i = 2; i <= n; i++) {
            temp = temp * i;
        }
        return temp;
    }

    public void Remove(){
        
        for(int i=0;i < chosenID.length;i++){
         String query = "DELETE FROM " + category + " WHERE ID = '" + chosenID[i] + "';";
         
        try{
            PreparedStatement statement = dbConnect.prepareStatement(query);

            int result = statement.executeUpdate(query);  
        }catch(SQLException e){
            e.printStackTrace();
        }


        }
        
    }

    //need a function that will be called at the end to remove all used database members

    //I need to find cheapest combination (make note of which
    //furniture items have been used), then set used parts to N and set price of the furniture item
    //that has been used to 0 then find next cheapest again.

}

