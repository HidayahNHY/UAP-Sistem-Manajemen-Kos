package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.*;

public class OccupantTable {
    private DefaultTableModel tableModel;
    private JTable table;
    private final String FILENAME = "data_penghuni.txt";

    public OccupantTable() {
        // Tambahkan kolom 'Tanggal Masuk' sesuai kriteria b
        String[] columns = {"ID", "Nama Penghuni", "No. Kamar", "Tipe Kamar", "No. Telepon", "Tanggal Masuk"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        table.setRowHeight(35);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(44, 62, 80));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 40));

        loadFromFile(); // Memuat data saat objek dibuat
    }

    public void saveToFile() {
        // Exception Handling menggunakan try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    Object val = tableModel.getValueAt(i, j);
                    row.append(val != null ? val.toString() : ""); // Cegah null
                    if (j < tableModel.getColumnCount() - 1) row.append(",");
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Simpan: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILENAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Validasi jumlah kolom sebelum menambah row
                if (data.length == tableModel.getColumnCount()) {
                    tableModel.addRow(data);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Muat: " + e.getMessage());
        }
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return tableModel; }
}