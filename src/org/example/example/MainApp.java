package org.example.example;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private DataManager dataManager = new DataManager(); // Mengelola model tabel

    public MainApp() {
        setTitle("Sistem Manajemen Kos UMM");
        setSize(900, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Halaman
        mainPanel.add(new LoginPage(this), "Login");
        mainPanel.add(new InputPage(this, dataManager), "Input");
        mainPanel.add(new DashboardPage(this, dataManager), "Dashboard");
        mainPanel.add(new UpdatePage(this, dataManager), "Update");

        add(mainPanel);
    }

    public void switchPage(String pageName) {
        cardLayout.show(mainPanel, pageName);

        // Logika otomatisasi update angka total
        if (pageName.equals("Dashboard")) {
            for (Component comp : mainPanel.getComponents()) {
                if (comp instanceof DashboardPage) {
                    ((DashboardPage) comp).updateCounter(); // Panggil fungsi hitung
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}