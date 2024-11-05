package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    // Constructor accepting the user's PIN
    FastCash(String pin) {
        this.pin = pin;

        // Load and scale the ATM background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080); // Position background image on the frame
        add(l3);

        // Label for withdrawal selection prompt
        l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        // Buttons for different withdrawal amounts and the back option
        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        // Positioning components
        l1.setBounds(235, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l3.add(b7);

        // Adding action listeners for each button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        // Frame properties
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Get amount from button label text (e.g., "100" from "Rs 100")
            Conn c = new Conn();

            // Retrieve current balance by summing deposits and subtracting withdrawals
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount")); // Add deposit amounts
                } else {
                    balance -= Integer.parseInt(rs.getString("amount")); // Subtract withdrawal amounts
                }
            }

            // If not "BACK" button and insufficient balance, show error and exit action
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // Handle "BACK" button click to return to the Transactions screen
            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                // Record the transaction if balance is sufficient
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false); // Close current window
                new Transactions(pin).setVisible(true); // Return to Transactions screen
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true); // Start the application with an empty PIN
    }
}
