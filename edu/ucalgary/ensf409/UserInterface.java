package edu.ucalgary.ensf409;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Code written by: Jacob Artuso, Colin Christophe, Nicholas Knapton, and Brian Kramer
 */

public class UserInterface {
    private static String USERNAME="User1";
    private static String PASSWORD="password";
    private JFrame frame;

   public UserInterface(){
    this.frame = new JFrame("Inventory Manager");
    frame.setSize(600, 350);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();    

    frame.add(panel);

    placeComponents(panel);

    frame.setVisible(true);
   }

   private static void placeComponents(JPanel panel) {
       panel.setLayout(null);

       JLabel header = new JLabel("IKEA INVENTORY", JLabel.CENTER);
       header.setForeground(Color.BLUE);
       header.setBounds(125,20,340,40);
       header.setFont(new Font("Courier", Font.PLAIN, 40));
       panel.add(header);

       JLabel catLabel = new JLabel("Category");
       catLabel.setBounds(10,80,160,40);
       catLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       panel.add(catLabel);

       JTextField catText = new JTextField(20);
       catText.setBounds(260,80,165,40);
       catText.setFont(new Font("Courier", Font.PLAIN, 22));
       panel.add(catText);

       JLabel typeLabel = new JLabel("Type");
       typeLabel.setBounds(10,135,80,40);
       typeLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       panel.add(typeLabel);

       JTextField typeText = new JTextField(20);
       typeText.setBounds(260,135,165,40);
       panel.add(typeText);
       typeText.setFont(new Font("Courier", Font.PLAIN, 22));

       JLabel numberLabel = new JLabel("Number of Items");
       numberLabel.setFont(new Font("Courier", Font.PLAIN, 30));
       numberLabel.setBounds(10,190,230,40);
       panel.add(numberLabel);

       JTextField numberText = new JTextField(20);
       numberText.setBounds(260,190,60,40);
       numberText.setFont(new Font("Courier", Font.PLAIN, 22));
       panel.add(numberText);

       JButton requestButton = new JButton("Request");
       requestButton.setFont(new Font("Courier", Font.PLAIN, 22));
       requestButton.setBounds(215, 245, 160, 50);
       panel.add(requestButton);
       
       requestButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(new JFrame("Something went wrong"), "Shittt u cant do that");            
            Request newRequest = new Request(catText.getText(), typeText.getText(), Integer.parseInt(numberText.getText()), USERNAME,PASSWORD);
            OrderForm newOrderForm = new OrderForm(newRequest);
        }
       });
   }
}