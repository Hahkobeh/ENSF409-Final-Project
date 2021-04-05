package edu.ucalgary.ensf409;

/**
 * Code written by: Jacob Artuso, Colin Christophe, Nicholas Knapton, and Brian Kramer
 */


import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

public class Request{
    private Connection dbConnect;
    private String category;
    private String type;
    private int size;
    private int numberOfEntries = 0;
    private Boolean partialOrder;
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

    /**
     *
     * @param category Category is the type of object being requested. (e.g. chair, lamp, etc...)
     * @param type Type is the type of furniture item that is being requested. (e.g. mesh)
     * @param numberOfitemsDemanded Number of items that are being demanded.
     * @param partialOrder If this can be a partial order or not.
     * @param usernameMySQL
     * @param passwordMySQL
     * @throws Exception
     */


    public Request(String category, String type, int numberOfitemsDemanded, Boolean partialOrder, String usernameMySQL, String passwordMySQL) throws Exception {

        this.category = category;
        this.type = type;
        this.numberOfitemsDemanded = numberOfitemsDemanded;
        this.partialOrder = partialOrder;
        this.usernameMySQL = usernameMySQL;
        this.passwordMySQL = passwordMySQL;
        setSize(category);
        getDatabase();
        storeData();
        totalItemsThatCanBeMade();


        if(possibleNumberOfItems == 0){
            JOptionPane.showMessageDialog(new JFrame(), ManuSuggest());
            throw new Exception(" ");
        }else if(possibleNumberOfItems < numberOfitemsDemanded){
            chosenOptions = new int[possibleNumberOfItems][size];
            chosenOptionsPrice = new int[numberOfitemsDemanded];

            if(!this.partialOrder){
                JOptionPane.showMessageDialog(new JFrame(), ManuSuggest());
                throw new Exception(" ");
            }else{
                JOptionPane.showMessageDialog(new JFrame(), "Unfortunately only " + possibleNumberOfItems + " could be made, we will fill partial order.");
            }
            
            for(int z = 0; z < possibleNumberOfItems; z++){
                searchForLowest(z);
            }
            
        }else if(possibleNumberOfItems >= numberOfitemsDemanded){
            chosenOptions = new int[numberOfitemsDemanded][size];
            chosenOptionsPrice = new int[numberOfitemsDemanded];
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

    /**
     * Connects to database
     */
    public void getDatabase() {
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", usernameMySQL, passwordMySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets size, which is the number of parts that an item will need. (e.g. 4 parts for a chair)
     */
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

    /**
     * Reads from the database and stores the Y/N values into a 2D array for the item that is being ordered.
     */
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

    /**
     * Calculates the total amount of items that can be made by checking the amount of Y's in each column.
     */
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

    /**
     * Searches for the lowest possible price to make one item.
     * @param itemNumber itemNumber is the number of item of the item that is currently being made.
     */
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

        chosenOptionsPrice[itemNumber] = findPrice(allPossible, numberOfPossibleCombinations, chosenOption, itemNumber);

    }

    /**
     * findPrice contains the algorithm which finds the lowest possible price for a given amount of combinations.
     * @param allPossible 2D array of all the possible combinations.
     * @param numberOfPossibleCombinations The number of possible combinations, how many rows in the allPossible array.
     * @param chosenOption The chosen choice for one item that the order will fulfill.
     * @param itemNumber itemNumber is the number of item of the item that is currently being made.
     * @return Returns the price of the item.
     */

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

    /**
     * Removes the used components from the 2D array (used when multiple items are being produced).
     * @param array An array which contains the furniture items that will be used.
     */

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

    /**
     * Sets the price of the used items to zero. (used when multiple items are being produced).
     * @param array An array which contains the furniture items that will be used.
     */

    public void removePriceFromUsed(int [] array){
        int q = 0;
        while(q < array.length && array[q] != 0){
            priceData[array[q] - 1] = 0;
            q++;
        }
    }

    /**
     * Determines whether the chosen combination can produce a furniture item.
     * @param array An array which contains a combination of furniture items.
     * @return returns true if an item can be more, false otherwise
     */

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

    /**
     * Determines the price of a specific combination.
     * @param array An array which contains a combination of furniture items.
     * @return Returns price of that item.
     */
    public int priceOfCombination(int [] array){
        int price = 0;
        int q = 0;
        while(q < array.length && array[q] != 0){
            price += priceData[array[q] - 1];
            q++;
        }
        return price;
    }

    /**
     * Creates the 2D array containing all possible combinations of furniture items.
     * @param allPossible A 2D array of all the possible combinations.
     * @param options A list of the furniture items that can be used.

     */
    public void fillCombinationArray(int [][] allPossible, int [] options){
        int position = 0;
        for(int r = 1; r <= size; r++){
            int data [] = new int[r];
            position = combinationGenerator(allPossible, options,data, 0, options.length - 1 , 0, r, position);
        }

    }

    /**
     * Fill the 2D array allPossible with all the possible combinations listed in options.
     * @param allPossible A 2D array of all the possible combinations.
     * @param options A list of the furniture items that can be used.
     * @param toAdd Option that will be added next to the array.
     * @param first Option that will added first.
     * @param last The last option that will be added
     * @param index Where the toAdd option will be added.
     * @param r r is the size of the combination that is currently being made.
     * @param position position is the position that is being used in the 2D array.
     * @return Returns the position value so that it can be reused for higher r levels.
     */
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

    /**
     * Calculates the factorial of a given number n.
     * @param n n is the number that the factorial is being calculated from
     * @return Returns the value of the factorial.
     */

    public int factorial(int n){
        int temp = 1;
        for (int i = 2; i <= n; i++) {
            temp = temp * i;
        }
        return temp;
    }

 /**
 * this function removes the purchased  entries from
 * the sql inventory
 * 
 * 
 */
    public void Remove(){
        
        for(int i=0;i < chosenID.length;i++){
         String query = "DELETE FROM " + category + " WHERE ID = '" + chosenID[i] + "';";
         
        try{
            PreparedStatement statement = dbConnect.prepareStatement(query);

            statement.executeUpdate(query);  
        }catch(SQLException e){
            e.printStackTrace();
        }


        }
        
    }
/**
 * ManuSuggest suggests manufacturers in the event an order cannot be fulfilled
 * @return return the formatted string containing suggested manufacturers
 */

public String ManuSuggest(){
    {
         String out = possibleNumberOfItems+" could be made. Order cannot be fulfilled with current inventory. Suggested Manufacturers for "+ category+"s are: \n";
         String query2 = "SELECT DISTINCT ManuID FROM " + category;
         String [] manuID = new String[200];
         try{
             Statement statement = dbConnect.createStatement();
             ResultSet results = statement.executeQuery(query2);
             int row = 0;
             while(results.next()){
                 manuID[row] = results.getString("ManuID");              //get relevant ManuIDs from requested category
                 row++;
             }
             for(int i=0;i < row;i++){                                      //use ManuIDs to get manufacturer names
                 
             
                 String query = "SELECT * FROM MANUFACTURER WHERE ManuID = '" + manuID[i]+"';";
                 statement = dbConnect.createStatement();
                 results = statement.executeQuery(query);
                 results.next();
                 out += results.getString("Name");  //format string
                 out += "\n";
             }
             
         results.close();
     
         }catch(SQLException e){
             e.printStackTrace();
         }
         
         
         return out;
 
         
        }
    }
}

