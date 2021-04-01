package edu.ucalgary.ensf409;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface {
   public static void main(String[] args) {    
       JFrame frame = new JFrame("Inventory Manager");
       frame.setSize(350, 220);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel panel = new JPanel();    

       frame.add(panel);

       placeComponents(panel);

       frame.setVisible(true);
   }

   private static void placeComponents(JPanel panel) {
       panel.setLayout(null);

       JLabel catLabel = new JLabel("Category");
       catLabel.setBounds(10,20,80,25);
       panel.add(catLabel);

       JTextField catText = new JTextField(20);
       catText.setBounds(130,20,165,25);
       panel.add(catText);

       JLabel typeLabel = new JLabel("Type");
       typeLabel.setBounds(10,50,80,25);
       panel.add(typeLabel);

       JTextField typeText = new JTextField(20);
       typeText.setBounds(130,50,165,25);
       panel.add(typeText);

       JLabel numberLabel = new JLabel("Number of Items");
       numberLabel.setBounds(10,80,120,25);
       panel.add(numberLabel);

       JTextField numberText = new JTextField(20);
       numberText.setBounds(130,80,60,25);
       panel.add(numberText);

       JButton loginButton = new JButton("Request");
       loginButton.setBounds(115, 130, 100, 25);
       panel.add(loginButton);
   }

}