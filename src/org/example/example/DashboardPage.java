package org.example.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class DashboardPage extends JPanel {
    private JLabel lblTotal;
    private DataManager dataManager;

    public DashboardPage(MainApp app, DataManager dataManager) {
        this.dataManager = dataManager;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(25, 25, 25, 25));

        // --- 1. HEADER & STATISTIC PANEL ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        JLabel title = new JLabel("Monitoring Penghuni Kos");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(44, 62, 80));
        headerPanel.add(title, BorderLayout.WEST);

        // Card Statistik Sederhana
        lblTotal = new JLabel("Total Penghuni: 0");
        lblTotal.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        headerPanel.add(lblTotal, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        // --- 2. JTABLE AREA (READ DATA) ---
        JTable table = new JTable(dataManager.getTableModel());

        // Styling Tabel sesuai kriteria No. 6
        table.setRowHeight(40);
        table.setSelectionBackground(new Color(235, 245, 251));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setGridColor(new Color(236, 240, 241));

        // Styling Header Tabel
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(52, 152, 219)); // Biru Cerah
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setPreferredSize(new Dimension(0, 45));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        add(scrollPane, BorderLayout.CENTER);

        // --- 3. NAVIGATION PANEL (CRUD BUTTONS) ---
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 20));
        navPanel.setOpaque(false);

        JButton btnAdd = createStyledButton("+ Tambah Penghuni", new Color(46, 204, 113));
        JButton btnManage = createStyledButton("Pusat Kontrol", new Color(52, 73, 94));
        JButton btnRefresh = createStyledButton("Refresh", new Color(149, 165, 166));

        btnAdd.addActionListener(e -> app.switchPage("Input"));
        btnManage.addActionListener(e -> app.switchPage("Update"));
        btnRefresh.addActionListener(e -> updateCounter());

        navPanel.add(btnRefresh);
        navPanel.add(btnManage);
        navPanel.add(btnAdd);
        add(navPanel, BorderLayout.SOUTH);
    }

    // Update jumlah penghuni secara real-time
    public void updateCounter() {
        // Menghitung jumlah baris yang ada di tabel saat ini
        int count = dataManager.getTableModel().getRowCount();
        // Menuliskan hasilnya ke label di pojok kanan atas secara otomatis
        lblTotal.setText("Total Penghuni: " + count);
    }

    private JButton createStyledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setPreferredSize(new Dimension(180, 40));
        btn.setFocusPainted(false);
        return btn;
    }
}