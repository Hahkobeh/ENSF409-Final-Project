package edu.ucalgary.ensf409;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Code written by: Jacob Artuso, Colin Christophe, Nicholas Knapton, and Brian Kramer
*/

/**
 *  UserInterface creates a UI using java swing with three text boxes to input information for Category, Type and Number of items wanted. It then creates a
 *  Request object which trys to complete this request and if successful it hands it to OrderForm to have a order form created. If not successful then it
 *  opens small dialog box with suggested manufacturers to order from.
 */
public class UserInterface {

    // Username and password for the database to be connected to.
    private static String USERNAME="User1";
    private static String PASSWORD="password";
    private JFrame frame;

    /**
     * Creates a window using java.swing library, then places all components on the window.
     */
   public UserInterface(){
        this.frame = new JFrame("Inventory Manager"); // open window
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
        frame.setLocationRelativeTo(null); // Makes window open in middle of screen

        JPanel panel = new JPanel();    

        frame.add(panel);

        placeComponents(panel); // Place components on the window

        frame.setVisible(true); 
   }

   /**
    * Places Components onto a given java.swing panel. Places a Header, three text fields for category, Type and number of items and also places a button 
    * labeled "Request" that upon pressing creates a new Request and deals with it, creating a order form if the request is successful, opening an error 
    * dialog if not.
    * @param panel The java swing panel to place components on.
    */
   private static void placeComponents(JPanel panel) {
       panel.setLayout(null);

       // Places Header
       JLabel header = new JLabel("IKEA INVENTORY", JLabel.CENTER);
       header.setForeground(Color.BLUE);
       header.setBounds(125,20,340,40);
       header.setFont(new Font("Courier", Font.PLAIN, 40));
       panel.add(header);

       // Places Category Label
       JLabel catLabel = new JLabel("Category");
       catLabel.setBounds(10,80,160,40);
       catLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       panel.add(catLabel);

       // Places Text field for Category field
       JTextField catText = new JTextField(20);
       catText.setBounds(270,80,165,40);
       catText.setFont(new Font("Courier", Font.PLAIN, 22));
       panel.add(catText);

       // Places Label for Type
       JLabel typeLabel = new JLabel("Type");
       typeLabel.setBounds(10,135,80,40);
       typeLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       panel.add(typeLabel);

       JTextField typeText = new JTextField(20);
       typeText.setBounds(270,135,165,40);
       panel.add(typeText);
       typeText.setFont(new Font("Courier", Font.PLAIN, 22));

       JLabel numberLabel = new JLabel("Number of Items");
       numberLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       numberLabel.setBounds(10,190,230,40);
       panel.add(numberLabel);

       JTextField numberText = new JTextField(20);
       numberText.setBounds(270,190,60,40);
       numberText.setFont(new Font("Courier", Font.PLAIN, 22));
       panel.add(numberText);

       JLabel fillLabel = new JLabel("Fill Partial Order?");
       fillLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       fillLabel.setBounds(10,245,240,40);
       panel.add(fillLabel);

       JCheckBox fillBox = new JCheckBox();
       fillBox.setBounds(270,245,40,40);
       panel.add(fillBox);

       JButton requestButton = new JButton("Request");
       requestButton.setFont(new Font("Courier", Font.PLAIN, 22));
       requestButton.setBounds(220, 295, 160, 50);
       panel.add(requestButton);
       
       requestButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if(Integer.parseInt(numberText.getText()) >= 0){
                try{
                    Request newRequest;
                    if(fillBox.isSelected()){
                        newRequest = new Request(catText.getText(), typeText.getText(), Integer.parseInt(numberText.getText()), true, USERNAME,PASSWORD);
                    }else{
                        newRequest = new Request(catText.getText(), typeText.getText(), Integer.parseInt(numberText.getText()), false, USERNAME,PASSWORD);
                    }
                     
                    OrderForm newOrderForm = new OrderForm(newRequest);
                }catch(Exception error){

                }
            }
            
           
        }
       });
   }
}
