package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JTextField t1, t2;
    JComboBox c1, c2, c3, c4, c5;
    String formno;

    // Constructor that accepts the form number of the user
    Signup2(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Load and set the logo image
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        // Labels for additional details
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Educational Qualification:");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        // "Next" button to proceed to the next page
        b = new JButton("Next");
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        // Text fields for PAN and Aadhar number input
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        // Radio buttons for Senior Citizen and Existing Account options
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        // Combo boxes for dropdown selections
        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String income[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        setLayout(null); // Use null layout for absolute positioning

        // Positioning the components
        l12.setBounds(700, 10, 60, 30);
        add(l12);

        l13.setBounds(760, 10, 60, 30);
        add(l13);

        l1.setBounds(280, 30, 600, 40);
        add(l1);

        l2.setBounds(100, 120, 100, 30);
        add(l2);

        c1.setBounds(350, 120, 320, 30);
        add(c1);

        l3.setBounds(100, 170, 100, 30);
        add(l3);

        c2.setBounds(350, 170, 320, 30);
        add(c2);

        l4.setBounds(100, 220, 100, 30);
        add(l4);

        c3.setBounds(350, 220, 320, 30);
        add(c3);

        l5.setBounds(100, 270, 200, 30);
        add(l5);

        c4.setBounds(350, 270, 320, 30);
        add(c4);

        l6.setBounds(100, 340, 150, 30);
        add(l6);

        c5.setBounds(350, 340, 320, 30);
        add(c5);

        l7.setBounds(100, 390, 150, 30);
        add(l7);

        t1.setBounds(350, 390, 320, 30);
        add(t1);

        l8.setBounds(100, 440, 180, 30);
        add(l8);

        t2.setBounds(350, 440, 320, 30);
        add(t2);

        l9.setBounds(100, 490, 150, 30);
        add(l9);

        r1.setBounds(350, 490, 100, 30);
        add(r1);

        r2.setBounds(460, 490, 100, 30);
        add(r2);

        l10.setBounds(100, 540, 180, 30);
        add(l10);

        r3.setBounds(350, 540, 100, 30);
        add(r3);

        r4.setBounds(460, 540, 100, 30);
        add(r4);

        b.setBounds(570, 640, 100, 30);
        add(b);

        b.addActionListener(this); // Action listener for the "Next" button

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(500, 120);
        setVisible(true);
    }

    // Action for when the "Next" button is clicked
    public void actionPerformed(ActionEvent ae) {
        // Collect form inputs
        String religion = (String) c1.getSelectedItem();
        String category = (String) c2.getSelectedItem();
        String income = (String) c3.getSelectedItem();
        String education = (String) c4.getSelectedItem();
        String occupation = (String) c5.getSelectedItem();
        String pan = t1.getText();
        String aadhar = t2.getText();
        String scitizen = r1.isSelected() ? "Yes" : r2.isSelected() ? "No" : null;
        String eaccount = r3.isSelected() ? "Yes" : r4.isSelected() ? "No" : null;

        // Validate required fields
        if (pan.isEmpty() || aadhar.isEmpty() || scitizen == null || eaccount == null) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            return; // Stop the process if any field is empty
        }

        // Insert data into the database
        try {
            Conn c1 = new Conn();
            String q1 = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" +
                        education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eaccount + "')";
            c1.s.executeUpdate(q1);

            new Signup3(formno).setVisible(true); // Proceed to the next part of the signup process
            setVisible(false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}
