package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    // Constructor accepting the user's PIN as a parameter
    Withdrawl(String pin) {
        this.pin = pin; // Store the PIN for transaction purposes

        // Load and scale the ATM background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080); // Position the background image on the frame
        add(l3);

        // Labels to display messages and instructions
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        // Text field for entering the withdrawal amount
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        // Buttons for withdraw action and going back
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null); // Set layout to null for absolute positioning

        // Positioning and adding components
        l1.setBounds(190, 350, 400, 20);
        l3.add(l1);

        l2.setBounds(190, 400, 400, 20);
        l3.add(l2);

        t1.setBounds(190, 450, 330, 30);
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
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText(); // Amount entered by the user
            Date date = new Date(); // Current date for transaction timestamp

            if (ae.getSource() == b1) { // If "WITHDRAW" button is clicked
                if (amount.equals("")) { // Check if the amount is empty
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                } else {
                    Conn c1 = new Conn();

                    // Fetch current balance by iterating through all transactions for the user's PIN
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount")); // Add deposits
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount")); // Subtract withdrawals
                        }
                    }

                    // Check if the balance is sufficient for the withdrawal amount
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    // Record the withdrawal transaction in the database
                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                    setVisible(false); // Close the current window
                    new Transactions(pin).setVisible(true); // Open the Transactions screen
                }
            } else if (ae.getSource() == b2) { // If "BACK" button is clicked
                setVisible(false); // Close the current window
                new Transactions(pin).setVisible(true); // Open the Transactions screen
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions encountered
            System.out.println("error: " + e);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true); // Start the application with an empty PIN
    }
}
