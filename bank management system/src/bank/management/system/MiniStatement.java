package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;

    // Constructor that accepts the user's PIN
    MiniStatement(String pin) {
        super("Mini Statement"); // Set the title of the window
        getContentPane().setBackground(Color.WHITE); // Set background color
        setSize(400, 600); // Set the window size
        setLocation(20, 20); // Position the window on the screen

        l1 = new JLabel();
        add(l1);

        // Bank name label
        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        // Label to display the masked card number
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        // Label to display the total balance
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        // Fetch and display masked card number
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");
            while (rs.next()) {
                // Display the card number with masking for security
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fetch and display transaction history and calculate the balance
        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pin + "'");
            while (rs.next()) {
                // Display each transaction with date, type, and amount
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                
                // Calculate balance based on transaction type
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null); // Use null layout for absolute positioning
        b1 = new JButton("Exit"); // Exit button
        add(b1);

        // Set positions for the components
        l1.setBounds(20, 140, 400, 200); // Position transaction history label
        b1.setBounds(20, 500, 100, 25); // Position exit button
        b1.addActionListener(this); // Add action listener for the exit button
    }

    // Action listener for button click
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false); // Close the mini statement window
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true); // Start the application with an empty PIN
    }
}
