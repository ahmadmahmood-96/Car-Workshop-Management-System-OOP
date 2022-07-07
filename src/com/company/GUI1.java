package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI1 extends JFrame {
    private JPanel contentPane;
    private JTextField userName;
    private JTextField password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI1 frame = new GUI1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    GUI1() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 503);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSuppliers = new JLabel("Admin Panel");
        lblSuppliers.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSuppliers.setBounds(250, 24, 209, 14);
        contentPane.add(lblSuppliers);

        JLabel lblAddTheSupplier = new JLabel("Enter your credentials");
        lblAddTheSupplier.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAddTheSupplier.setBounds(47, 54, 331, 14);
        contentPane.add(lblAddTheSupplier);

        JLabel lblSupplierId = new JLabel("Username: ");
        lblSupplierId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSupplierId.setBounds(157, 95, 84, 19);
        contentPane.add(lblSupplierId);

        JLabel lblNewLabel = new JLabel("Password: ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 148, 98, 14);
        contentPane.add(lblNewLabel);

        userName = new JTextField();
        userName.setBounds(335, 94, 109, 20);
        contentPane.add(userName);
        userName.setColumns(10);

        password = new JPasswordField();
        password.setBounds(335, 147, 109, 20);
        contentPane.add(password);
        password.setColumns(10);


        JButton btnAdd = new JButton("Login");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (userName.getText().equals("admin123") && password.getText().equals("Admin@123")) {
                    JOptionPane.showMessageDialog(btnAdd, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(btnAdd, "Login Unsuccessful");
                    userName.setText("");
                    password.setText("");
                }
            }

        });
        btnAdd.setBounds(258, 405, 89, 23);
        contentPane.add(btnAdd);


    }
}