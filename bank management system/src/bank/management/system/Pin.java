package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2; // Fields to enter the new PIN and confirm it
    JButton b1, b2; // Buttons for changing PIN and going back
    JLabel l1, l2, l3;
    String pin;

    // Constructor that accepts the current PIN as a parameter
    Pin(String pin) {
        this.pin = pin; // Store the current PIN
        
        // Load and scale the ATM background image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080); // Position the background image on the frame
        add(l4);

        // Labels for instructions and PIN fields
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        // Password fields for entering new PIN
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        // Buttons for changing PIN and going back
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        // Positioning components
        l1.setBounds(280, 330, 800, 35);
        l4.add(l1);

        l2.setBounds(180, 390, 150, 35);
        l4.add(l2);

        l3.setBounds(180, 440, 200, 35);
        l4.add(l3);

        t1.setBounds(350, 390, 180, 25);
        l4.add(t1);

        t2.setBounds(350, 440, 180, 25);
        l4.add(t2);

        b1.setBounds(390, 588, 150, 35);
        l4.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l4.add(b2);

        setSize(960, 1080); // frame size
        setLocation(500, 0); // Position the frame on the screen
        setUndecorated(true); // Remove the title bar
        setVisible(true); // Make the frame visible
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = t1.getText(); // New PIN entered by the user
            String rpin = t2.getText(); // Re-entered PIN to confirm

            // Validate if both entered PINs match
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return; // Exit if PINs do not match
            }

            if (ae.getSource() == b1) { // If the "CHANGE" button is clicked
                if (npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }

                Conn c1 = new Conn();
                // Update PIN in all relevant tables
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + pin + "'";
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + pin + "'";
                String q3 = "update signup3 set pin = '" + rpin + "' where pin = '" + pin + "'";

                // Execute updates
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false); // Close the current window
                new Transactions(rpin).setVisible(true); // Open the Transactions screen with the new PIN

            } else if (ae.getSource() == b2) { // If the "BACK" button is clicked
                new Transactions(pin).setVisible(true); // Return to the Transactions screen with the old PIN
                setVisible(false); // Close the current window
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions encountered
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true); // Start the application with an empty PIN
    }
}
