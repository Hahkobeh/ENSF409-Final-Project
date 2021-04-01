package edu.ucalgary.ensf409;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public static void main(String[] args){
    UserInterface gui = new UserInterface();  
    gui.showItems();     
   }

   public UserInterface(){
     buildGUI();
   }

   private void buildGUI(){
       this.mainFrame = new JFrame("Order Manager");
       mainFrame.setSize(900,300);
       mainFrame.setLayout(new GridLayout(3,1));

       headerLabel = new JLabel("",JLabel.CENTER );
       statusLabel = new JLabel("",JLabel.CENTER);        
       statusLabel.setSize(350,100);
       
       mainFrame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent windowEvent){
             System.exit(0);
          }        
       });  

       controlPanel = new JPanel();
       controlPanel.setLayout(new FlowLayout());
 
       mainFrame.add(headerLabel);
       mainFrame.add(controlPanel);
       mainFrame.add(statusLabel);
       mainFrame.setVisible(true);  
    }

    private void showItems(){
       JLabel categoryLabel = new JLabel("Category:", JLabel.RIGHT);
       JLabel typeLabel = new JLabel("Type:", JLabel.CENTER);
       JLabel numberOfItemsLabel = new JLabel("Number of Items:", JLabel.LEFT);
       final JTextField CATEGORY = new JTextField(10);
       final JTextField TYPE = new JTextField(10);
       final JTextField NUMBER = new JTextField(4);

       JButton sendRequest = new JButton("Send Request");
       sendRequest.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
                Request theRequest = new Request();
           }
       });
 
       controlPanel.add(categoryLabel);
       controlPanel.add(CATEGORY);
       controlPanel.add(typeLabel);
       controlPanel.add(TYPE);
       controlPanel.add(numberOfItemsLabel);
       controlPanel.add(NUMBER);
       controlPanel.add(sendRequest);
       
       mainFrame.setVisible(true);  
    }
}