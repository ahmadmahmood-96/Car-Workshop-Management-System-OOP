package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GUI extends JFrame {
    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public GUI(){
        setTitle("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 549, 468);
        contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
            contentPane.setLayout(null);

        JLabel lblMenu = new JLabel("MENU");
            lblMenu.setFont(new Font("Tahoma",Font.BOLD, 18));
            lblMenu.setBounds(226, 23, 76, 14);
            contentPane.add(lblMenu);

        JLabel lblWelcome = new JLabel("Welcome to Our Car Workshop Management System");
            lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblWelcome.setBounds(62, 59, 449, 14);
            contentPane.add(lblWelcome);

        JPanel panel = new JPanel();
            panel.setBackground(Color.LIGHT_GRAY);
            panel.setForeground(Color.WHITE);
            panel.setBounds(10, 81, 516, 287);
            contentPane.add(panel);
            panel.setLayout(null);

        JLabel lblActions = new JLabel("Log in as: ");
            lblActions.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblActions.setBounds(84, 9, 80, 14);
            panel.add(lblActions);

        JButton btnAdd = new JButton("Admin");
            btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI1 field = new GUI1();
                field.setVisible(true);
                setVisible(false);
            }
        });
            btnAdd.setBounds(192, 58, 121, 23);
            panel.add(btnAdd);

        JButton btnSearch = new JButton("Customer");
        btnSearch.setBounds(192, 105, 121, 23);
        panel.add(btnSearch);

    }

}