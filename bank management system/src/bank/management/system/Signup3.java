package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    // Constructor that accepts the form number of the user
    Signup3(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        // Load and set the logo image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        // Labels for account details and service information
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));

        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));

        // "Submit" and "Cancel" buttons
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        // Checkboxes for selecting additional services
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));

        // Radio buttons for account type selection
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(r1);
        accountTypeGroup.add(r2);
        accountTypeGroup.add(r3);
        accountTypeGroup.add(r4);

        setLayout(null);

        // Positioning the components
        l11.setBounds(700, 10, 70, 30);
        add(l11);

        l12.setBounds(770, 10, 40, 30);
        add(l12);

        l1.setBounds(280, 40, 400, 40);
        add(l1);

        l2.setBounds(100, 140, 200, 30);
        add(l2);

        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4.setBounds(350, 220, 250, 30);
        add(r4);

        l3.setBounds(100, 300, 200, 30);
        add(l3);

        l4.setBounds(330, 300, 250, 30);
        add(l4);

        l5.setBounds(100, 330, 200, 20);
        add(l5);

        l6.setBounds(330, 330, 500, 20);
        add(l6);

        l7.setBounds(100, 370, 200, 30);
        add(l7);

        l8.setBounds(330, 370, 200, 30);
        add(l8);

        l9.setBounds(100, 400, 200, 20);
        add(l9);

        l10.setBounds(100, 450, 200, 30);
        add(l10);

        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7.setBounds(100, 680, 600, 20);
        add(c7);

        b1.setBounds(250, 720, 100, 30);
        add(b1);

        b2.setBounds(420, 720, 100, 30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 850);
        setLocation(500, 120);
        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        String accountType = null;
        if (r1.isSelected()) {
            accountType = "Saving Account";
        } else if (r2.isSelected()) {
            accountType = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            accountType = "Current Account";
        } else if (r4.isSelected()) {
            accountType = "Recurring Deposit Account";
        }

        // Generate card number and PIN
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardNumber = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        // Gather selected facilities
        String facility = "";
        if (c1.isSelected()) facility += " ATM Card";
        if (c2.isSelected()) facility += " Internet Banking";
        if (c3.isSelected()) facility += " Mobile Banking";
        if (c4.isSelected()) facility += " EMAIL Alerts";
        if (c5.isSelected()) facility += " Cheque Book";
        if (c6.isSelected()) facility += " E-Statement";

        // Validate required fields
        if (accountType == null || !c7.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please fill all the required fields and accept the declaration.");
            return;
        }

        try {
            if (ae.getSource() == b1) {
                Conn c1 = new Conn();
                String q1 = "insert into signup3 values('" + formno + "','" + accountType + "','" + cardNumber + "','" + pin + "','" + facility + "')";
                String q2 = "insert into login values('" + formno + "','" + cardNumber + "','" + pin + "')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: " + pin);
                new Deposit(pin).setVisible(true);
                setVisible(false);

            } else if (ae.getSource() == b2) {
                System.exit(0);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("").setVisible(true);
    }
}
