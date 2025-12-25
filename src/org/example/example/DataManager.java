package org.example.example;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataManager {
    private final DefaultTableModel tableModel;

    public DataManager() {
        // Kolom ditambahkan "Tanggal Masuk" dan "Status" agar lebih informatif
        String[] columns = {"ID", "Nama Penghuni", "Kamar", "Tipe", "Tanggal Masuk", "Status Sewa"};

        // Mengatur agar ID tidak bisa diedit secara manual di tabel
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // Kolom ID (indeks 0) dikunci
            }
        };
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    // Fungsi Create yang menarik: Otomatis menambah Tanggal dan Status
    public void addOccupant(String name, String room, String type) {
        String dateNow = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        Object[] row = {
                tableModel.getRowCount() + 1, // ID Otomatis
                name,
                room,
                type,
                dateNow,        // Tanggal Masuk Otomatis
                "🔴 Belum Bayar" // Status Awal
        };
        tableModel.addRow(row);
    }

    // Fungsi Update Status Pembayaran (Menambah interaksi CRUD)
    public void updatePaymentStatus(int rowIndex) {
        if (rowIndex != -1) {
            tableModel.setValueAt("🟢 LUNAS", rowIndex, 5);
        }
    }

    // Fungsi Delete
    public void removeOccupant(int rowIndex) {
        if (rowIndex != -1) {
            tableModel.removeRow(rowIndex);
        }
    }
}
