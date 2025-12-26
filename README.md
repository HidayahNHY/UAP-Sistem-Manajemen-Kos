# 🏠 Sistem Manajemen Kos Modern v1.0

Aplikasi berbasis Java Swing Desktop untuk mempermudah pengelola kos dalam mendata penghuni, mengatur kamar, dan memantau status hunian secara real-time dengan antarmuka yang modern dan responsif.

---

## 🚀 Fitur Utama

Aplikasi ini mencakup fungsi CRUD (Create, Read, Update, Delete) lengkap dengan navigasi antar halaman:

1.  **Sistem Login Keamanan**: Autentikasi admin untuk mencegah akses tidak sah.
2.  **Dashboard Interaktif**: Tabel ringkasan yang menampilkan seluruh data penghuni secara rapi.
3.  **Registrasi Penghuni**: Formulir input data penghuni baru (Nama, No. Kamar, Tipe Kamar, Telepon).
4.  **Manajemen Data (Update & Delete)**: Kemampuan untuk memperbarui nama penghuni atau menghapus data penghuni yang sudah keluar.
5.  **UI Modern**: Menggunakan font Segoe UI, skema warna material, dan tombol yang dirancang khusus untuk kenyamanan pengguna.

---

## 🛠️ Prasyarat (Prerequisites)

Sebelum menjalankan aplikasi, pastikan Anda telah menginstal:
* **Java Development Kit (JDK)** versi 11 atau yang lebih baru.
* **IntelliJ IDEA** (Disarankan) atau IDE Java lainnya.

---

## 📁 Struktur Project

Proyek ini menggunakan prinsip refactoring agar kode tetap bersih dan mudah dikelola:

* **Main.java**: Titik masuk (Entry point) aplikasi.
* **ManajemenKosApp.java**: Controller utama dan navigasi CardLayout.
* **OccupantTable.java**: Logika pengaturan Tabel dan Model data.
* **ButtonFactory.java**: Helper untuk styling komponen UI.

---

## 💻 Cara Menjalankan Aplikasi

1.  **Clone atau Copy Kode**: Pastikan semua file `.java` berada di dalam package `org.example`.
2.  **Buka di IntelliJ IDEA**: Pilih `File` > `Open` > pilih folder project.
3.  **Build Project**: Klik kanan pada file `Main.java` dan pilih **Run 'Main.main()'**.
4.  **Login**:
    * **Username**: `admin`
    * **Password**: `123`

---

## 📖 Panduan Penggunaan

1.  **Login**: Masukkan kredensial admin.
2.  **Menambah Data**: Klik tombol **+ Tambah**, isi formulir, lalu klik **Simpan**.
3.  **Mengubah Data**: Pilih baris di Dashboard, masuk ke **Menu Update**, pilih **Update Nama**.
4.  **Menghapus Data**: Pilih baris di Dashboard, masuk ke **Menu Update**, klik **Hapus Penghuni**.

---

© 2025 - Sistem Manajemen Kos Modern