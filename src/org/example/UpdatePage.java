package org.example;

import javax.swing.*;
import java.awt.*;

public class UpdatePage extends JPanel {
    public UpdatePage(MainApp app, DataManager dataManager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        JLabel title = new JLabel("Pusat Kontrol Data");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        // Tombol Update
        JButton btnUpdate = new JButton("Update Nama");
        btnUpdate.setBackground(new Color(241, 196, 15));
        btnUpdate.addActionListener(e -> {
            // Read data yang dipilih dari Dashboard dilakukan melalui JTable di DashboardPage
            // Untuk tugas ini, kita asumsikan user memilih baris di Dashboard sebelum ke sini
            JOptionPane.showMessageDialog(this, "Gunakan fitur ini untuk mengubah data yang dipilih di Dashboard.");
        });

        // Tombol Delete
        JButton btnDelete = new JButton("Hapus Penghuni");
        btnDelete.setBackground(new Color(192, 57, 43));
        btnDelete.setForeground(Color.WHITE);

        JButton btnBack = new JButton("Kembali ke Dashboard");

        gbc.gridwidth = 2;
        gbc.gridy = 1; add(btnUpdate, gbc);
        gbc.gridy = 2; add(btnDelete, gbc);
        gbc.gridy = 3; add(btnBack, gbc);

        btnBack.addActionListener(e -> app.switchPage("Dashboard"));
    }
}