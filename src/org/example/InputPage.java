package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InputPage extends JPanel {
    // Menambahkan 'final' agar sesuai saran IDE kamu
    private final JTextField nameField;
    private final JTextField roomField;
    private final JTextField phoneField;
    private final JComboBox<String> typeCombo;

    public InputPage(MainApp app, DataManager dataManager) {
        setLayout(new GridBagLayout());
        setBackground(new Color(245, 247, 250));
        setBorder(new EmptyBorder(30, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Header
        JLabel title = new JLabel("Registrasi Penghuni Baru", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(44, 62, 80));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 35, 0);
        add(title, gbc);

        // Form Fields
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        nameField = new JTextField(15);
        roomField = new JTextField(15);
        phoneField = new JTextField(15);
        typeCombo = new JComboBox<>(new String[]{"Reguler", "VIP", "Suite"});

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Nama Lengkap:"), gbc);
        gbc.gridx = 1; add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("No. Kamar:"), gbc);
        gbc.gridx = 1; add(roomField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Tipe Kamar:"), gbc);
        gbc.gridx = 1; add(typeCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("No. Telepon:"), gbc);
        gbc.gridx = 1; add(phoneField, gbc);

        // Tombol Simpan
        JButton btnSave = new JButton("SIMPAN DATA");
        btnSave.setBackground(new Color(39, 174, 96));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSave.setPreferredSize(new Dimension(0, 45));

        btnSave.addActionListener(e -> {
            // 1. Validasi: Syarat semua input wajib diisi
            if (nameField.getText().trim().isEmpty() || roomField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 2. Memanggil Fungsi Simpan (Ini yang tadi hilang/salah)
            // Pastikan mengirimkan 3 String sesuai parameter addOccupant di DataManager
            dataManager.addOccupant(
                    nameField.getText(),
                    roomField.getText(),
                    typeCombo.getSelectedItem().toString()
            );

            // 3. Reset field dan pindah halaman
            nameField.setText("");
            roomField.setText("");
            phoneField.setText("");

            // Pindah ke Dashboard
            app.switchPage("Dashboard");

            // Tampilkan konfirmasi sukses
            JOptionPane.showMessageDialog(this, "Data berhasil tersimpan!");
        });

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 0, 10, 0);
        add(btnSave, gbc);
    }
}