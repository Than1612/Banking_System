package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    JLabel l1;
    String pin;

    // Constructor that accepts the user's PIN
    Deposit(String pin) {
        this.pin = pin; // Store the PIN for transaction purposes

        // Load and scale the ATM background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080); // Position the background image on the frame
        add(l3);

        // Label for deposit prompt
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        // Text field to enter the deposit amount
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        // Buttons for deposit action and going back
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null); // Set layout to null for absolute positioning

        // Positioning components
        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        t1.setBounds(190, 420, 320, 25);
        l3.add(t1);

        b1.setBounds(390, 588, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l3.add(b2);

        // Add action listeners to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Frame properties
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText(); // Amount entered by the user
            Date date = new Date(); // Current date for transaction timestamp

            if (ae.getSource() == b1) { // If "DEPOSIT" button is clicked
                if (amount.equals("")) { // Check if amount field is empty
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                } else {
                    Conn c1 = new Conn();

                    // Record the deposit transaction in the database
                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");

                    setVisible(false); // Close current window
                    new Transactions(pin).setVisible(true); // Open the Transactions screen
                }
            } else if (ae.getSource() == b2) { // If "BACK" button is clicked
                setVisible(false); // Close current window
                new Transactions(pin).setVisible(true); // Return to the Transactions screen
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions encountered
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true); // Start the application with an empty PIN
    }
}
