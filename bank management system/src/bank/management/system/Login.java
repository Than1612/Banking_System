package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;

    // Constructor for the Login class
    Login() {
        setTitle("AUTOMATED TELLER MACHINE"); // title for the JFrame window
        
        // Load and scale the logo image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100); // Position of the logo on the frame
        add(l11);
        
        // Main title label
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38)); // font and size
        l1.setBounds(200, 40, 450, 40); // Position of the title
        add(l1);
        
        // Card Number label and text field
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30); // Position of the Card No label
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300, 150, 230, 30); // Position of the text field for card number
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        // PIN label and password field
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30); // Position of the PIN label
        add(l3);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 220, 230, 30); // Position of the password field
        add(pf2);

        // buttons for Sign In, Clear, and Sign Up
        b1 = new JButton("SIGN IN");
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CLEAR");
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("SIGN UP");
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        setLayout(null); // layout to null for absolute positioning

        // positions for buttons and add them to the frame
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 300, 100, 30); // Sign In button
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 300, 100, 30); // Clear button
        add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300, 350, 230, 30); // Sign Up button
        add(b3);

        // Register action listeners for buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setBackground(Color.WHITE); // background color of the frame

        setSize(800, 480); // frame size
        setLocation(550, 200); // frame location on the screen
        setVisible(true); // Make the frame visible
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) { // Sign In button clicked
                Conn c1 = new Conn();
                String cardno = tf1.getText();
                String pin = pf2.getText();
                
                // SQL query to verify card number and pin
                String q = "select * from login where cardno = '" + cardno + "' and pin = '" + pin + "'";

                ResultSet rs = c1.s.executeQuery(q); // Execute query
                if (rs.next()) { // If matching record is found
                    setVisible(false); // Close login window
                    new Transactions(pin).setVisible(true); // Open Transactions window
                } else { // If no matching record is found
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN"); // Show error message
                }
            } else if (ae.getSource() == b2) { // Clear button clicked
                tf1.setText(""); // Clear Card Number field
                pf2.setText(""); // Clear PIN field
            } else if (ae.getSource() == b3) { // Sign Up button clicked
                setVisible(false); // Close login window
                new Signup().setVisible(true); // Open Signup window
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions encountered
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true); // Start the application by displaying the login window
    }
}
