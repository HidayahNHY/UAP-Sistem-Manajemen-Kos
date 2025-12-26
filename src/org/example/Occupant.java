package org.example;

public abstract class Occupant {
    protected String nama, kamar, tipe, telepon, tanggal;

    public Occupant(String nama, String kamar, String tipe, String telepon, String tanggal) {
        this.nama = nama;
        this.kamar = kamar;
        this.tipe = tipe;
        this.telepon = telepon;
        this.tanggal = tanggal;
    }

    // Mengonversi objek menjadi array untuk baris JTable
    public Object[] toRow(int id) {
        return new Object[]{id, nama, kamar, tipe, telepon, tanggal};
    }
}

// Subclass untuk penghuni VIP
class VIPOccupant extends Occupant {
    public VIPOccupant(String nama, String kamar, String telepon, String tanggal) {
        super(nama, kamar, "VIP", telepon, tanggal);
    }
}

// Subclass untuk penghuni Reguler
class RegulerOccupant extends Occupant {
    public RegulerOccupant(String nama, String kamar, String telepon, String tanggal) {
        super(nama, kamar, "Reguler", telepon, tanggal);
    }
}