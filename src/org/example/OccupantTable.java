package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class OccupantTable {
    private DefaultTableModel tableModel;
    private JTable table;

    public OccupantTable() {
        String[] columns = {"ID", "Nama Penghuni", "No. Kamar", "Tipe Kamar", "No. Telepon"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        table.setRowHeight(35);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(44, 62, 80));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 40));
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return tableModel; }
}