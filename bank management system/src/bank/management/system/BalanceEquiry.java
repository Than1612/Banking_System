package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1;
    JLabel l1, l2, l3;
    String pin;

    // Constructor that accepts the user's PIN as a parameter
    BalanceEnquiry(String pin) {
        this.pin = pin; // PIN for balance lookup

        // Load and scale the ATM background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080); // Position the background image on the frame
        add(l3);

        // Label to display balance
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        // Button to go back to the previous screen
        b1 = new JButton("BACK");

        setLayout(null); // Set layout to null for absolute positioning

        // Position balance label and add to background image label
        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        // Position back button and add to background image label
        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);

        int balance = 0; // Initialize balance to zero

        try {
            Conn c1 = new Conn();
            // Query to fetch transactions for the given PIN
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
            
            // Calculate the balance based on deposit and withdrawal transactions
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount")); // Add deposit amounts
                } else {
                    balance -= Integer.parseInt(rs.getString("amount")); // Subtract withdrawal amounts
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exception encountered
        }
        
        // balance text for display
        l1.setText("Your Current Account Balance is Rs " + balance);

        // Add action listener for the back button
        b1.addActionListener(this);

        // frame properties
        setSize(960, 1080); // Set frame size
        setUndecorated(true); // Remove frame title bar
        setLocation(500, 0); // Set frame location on the screen
        setVisible(true); // Make the frame visible
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        setVisible(false); // Close BalanceEnquiry screen
        new Transactions(pin).setVisible(true); // Open Transactions screen
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true); // Start the application with an empty PIN
    }
}
