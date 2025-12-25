package org.example.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPage extends JPanel {
    public LoginPage(MainApp app) {
        // Layout utama agar form berada di tengah
        setLayout(new GridBagLayout());
        setBackground(new Color(44, 62, 80)); // Warna Midnight Blue yang elegan
        setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Ikon atau Header Visual ---
        JLabel lblIcon = new JLabel("🔑", JLabel.CENTER);
        lblIcon.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblIcon, gbc);

        // --- Judul Login ---
        JLabel lblTitle = new JLabel("ADMIN ACCESS", JLabel.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(lblTitle, gbc);

        // --- Form Input ---
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);

        // Username
        JLabel lblUser = new JLabel("Username");
        lblUser.setForeground(new Color(189, 195, 199));
        lblUser.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 2;
        add(lblUser, gbc);

        JTextField userField = new JTextField(15);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        userField.setBackground(new Color(52, 73, 94));
        userField.setForeground(Color.WHITE);
        userField.setCaretColor(Color.WHITE);
        userField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(127, 140, 141)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(userField, gbc);

        // Password
        JLabel lblPass = new JLabel("Password");
        lblPass.setForeground(new Color(189, 195, 199));
        lblPass.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
        add(lblPass, gbc);

        JPasswordField passField = new JPasswordField(15);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passField.setBackground(new Color(52, 73, 94));
        passField.setForeground(Color.WHITE);
        passField.setCaretColor(Color.WHITE);
        passField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(127, 140, 141)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(passField, gbc);

        // --- Tombol Login ---
        JButton btnLogin = new JButton("SECURE LOGIN");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBackground(new Color(46, 204, 113)); // Warna Emerald Green
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setPreferredSize(new Dimension(0, 45));
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridy = 6;
        gbc.insets = new Insets(30, 0, 10, 0);
        add(btnLogin, gbc);

        // --- Logika Login ---
        btnLogin.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            // Validasi Login sesuai ketentuan pendaftaran akun (TC_REG_001)
            if (username.equals("admin") && password.equals("123")) {
                app.switchPage("Dashboard");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password!",
                        "Authentication Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}