package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ManajemenKosApp extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);
    private final OccupantTable occupantTable = new OccupantTable();

    // Field global agar bisa diakses oleh updateCounter()
    private JLabel lblTotal;

    // Form Fields
    private JTextField nameField, roomField, phoneField;
    private JComboBox<String> typeCombo;

    public ManajemenKosApp() {
        setTitle("Sistem Manajemen Kos Lowokwaru");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menambahkan halaman ke CardLayout
        mainPanel.add(createLoginPage(), "LoginPage");
        mainPanel.add(createInputPage(), "InputPage");
        mainPanel.add(createDashboardPage(), "DashboardPage");
        mainPanel.add(createUpdatePage(), "UpdatePage");

        add(mainPanel);
        cardLayout.show(mainPanel, "LoginPage");
    }

    // --- LOGIKA NAVIGASI ---
    public void switchPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
        // Memanggil fungsi otomatisasi angka setiap kali halaman berubah
        updateCounter();
    }

    private JPanel createLoginPage() {
        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(new Color(52, 73, 94));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblTitle = new JLabel("ADMIN KOS LOGIN");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        page.add(lblTitle, gbc);

        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        page.add(new JLabel("<html><font color='white'>Username:</font></html>"), gbc);
        gbc.gridx = 1;
        page.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        page.add(new JLabel("<html><font color='white'>Password:</font></html>"), gbc);
        gbc.gridx = 1;
        page.add(passField, gbc);

        JButton btnLogin = ButtonFactory.createStyledButton("LOGIN SEKARANG", new Color(46, 204, 113));
        btnLogin.addActionListener(e -> {
            // Logika Keamanan (Kriteria No. 6)
            if (userField.getText().equals("admin") && new String(passField.getPassword()).equals("123")) {
                switchPage("DashboardPage");
            } else {
                JOptionPane.showMessageDialog(this, "Akses Ditolak!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        page.add(btnLogin, gbc);
        return page;
    }

    private JPanel createInputPage() {
        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(new Color(245, 247, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField(20);
        roomField = new JTextField(20);
        typeCombo = new JComboBox<>(new String[]{"Reguler", "VIP", "Suite"});
        phoneField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel title = new JLabel("Registrasi Penghuni Baru");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        page.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        page.add(new JLabel("Nama Lengkap:"), gbc);
        gbc.gridx = 1;
        page.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        page.add(new JLabel("Nomor Kamar:"), gbc);
        gbc.gridx = 1;
        page.add(roomField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        page.add(new JLabel("Tipe Kamar:"), gbc);
        gbc.gridx = 1;
        page.add(typeCombo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        page.add(new JLabel("No. Telepon:"), gbc);
        gbc.gridx = 1;
        page.add(phoneField, gbc);

        JButton btnAdd = ButtonFactory.createStyledButton("SIMPAN DATA", new Color(39, 174, 96));
        btnAdd.addActionListener(e -> addOccupantData());
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        page.add(btnAdd, gbc);

        JButton btnBack = ButtonFactory.createStyledButton("KEMBALI", Color.GRAY);
        btnBack.addActionListener(e -> switchPage("DashboardPage"));
        gbc.gridy = 6;
        page.add(btnBack, gbc);
        return page;
    }

    private JPanel createDashboardPage() {
        JPanel page = new JPanel(new BorderLayout());
        page.setBorder(new EmptyBorder(25, 25, 25, 25));

        // Header Panel (Perbaikan Variabel yang Hilang)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(new EmptyBorder(0, 0, 15, 0));

        JLabel title = new JLabel("Daftar Penghuni Kos Aktif");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        lblTotal = new JLabel("Total Penghuni: 0");
        lblTotal.setFont(new Font("Segoe UI", Font.ITALIC, 16));

        headerPanel.add(title, BorderLayout.WEST);
        headerPanel.add(lblTotal, BorderLayout.EAST);

        page.add(headerPanel, BorderLayout.NORTH); // Gunakan headerPanel agar title & total muncul
        page.add(new JScrollPane(occupantTable.getTable()), BorderLayout.CENTER);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGoAdd = ButtonFactory.createStyledButton("+ Tambah", new Color(52, 152, 219));
        JButton btnGoEdit = ButtonFactory.createStyledButton("Menu Update", new Color(241, 196, 15));

        btnGoAdd.addActionListener(e -> switchPage("InputPage"));
        btnGoEdit.addActionListener(e -> switchPage("UpdatePage"));

        navPanel.add(btnGoAdd);
        navPanel.add(btnGoEdit);
        page.add(navPanel, BorderLayout.SOUTH);
        return page;
    }

    private JPanel createUpdatePage() {
        JPanel page = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        JButton btnUpdate = ButtonFactory.createStyledButton("UPDATE NAMA", new Color(230, 126, 34));
        btnUpdate.addActionListener(e -> updateProcess());
        JButton btnDelete = ButtonFactory.createStyledButton("HAPUS PENGHUNI", new Color(192, 57, 43));
        btnDelete.addActionListener(e -> deleteProcess());
        JButton btnBack = ButtonFactory.createStyledButton("KEMBALI", Color.DARK_GRAY);
        btnBack.addActionListener(e -> switchPage("DashboardPage"));

        gbc.gridy = 1;
        page.add(btnUpdate, gbc);
        gbc.gridy = 2;
        page.add(btnDelete, gbc);
        gbc.gridy = 3;
        page.add(btnBack, gbc);
        return page;
    }

    // --- LOGIKA CRUD (Create, Read, Update, Delete) ---
    private void addOccupantData() {
        // Validasi Input (Kriteria No. 2)
        if (nameField.getText().trim().isEmpty() || roomField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak lengkap!");
            return;
        }
        Object[] row = {
                occupantTable.getModel().getRowCount() + 1,
                nameField.getText(), roomField.getText(),
                typeCombo.getSelectedItem(), phoneField.getText()
        };
        occupantTable.getModel().addRow(row);

        // Reset Field
        nameField.setText("");
        roomField.setText("");
        phoneField.setText("");

        switchPage("DashboardPage");
    }

    private void updateProcess() {
        int row = occupantTable.getTable().getSelectedRow();
        if (row != -1) {
            String name = JOptionPane.showInputDialog(this, "Masukkan Nama Baru:");
            if (name != null && !name.trim().isEmpty()) {
                occupantTable.getModel().setValueAt(name, row, 1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris di Dashboard terlebih dahulu!");
        }
    }

    private void deleteProcess() {
        int row = occupantTable.getTable().getSelectedRow();
        if (row != -1) {
            occupantTable.getModel().removeRow(row);
            updateCounter(); // Otomatisasi angka setelah hapus
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris di Dashboard terlebih dahulu!");
        }
    }

    public void updateCounter() {
        // Mengambil data dari model di OccupantTable secara otomatis
        if (occupantTable != null && lblTotal != null) {
            int count = occupantTable.getModel().getRowCount();
            lblTotal.setText("Total Penghuni: " + count);
        }
    }

}