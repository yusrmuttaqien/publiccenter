/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publiccenter;

/**
 *
 * @author Nisa Amelia Putri
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;//menyimpan beberapa objek list/ data /semacam arraylist_menampung data harga dari para pelelang yang ditawar dan disini ada fungsi yang memudahkan untuk mencari nilai tertinggi Collections.max
import java.util.Scanner;

public class MethodUser {
    private int idLayananPublikTerpilih;
    private int idUserLogin;
    private boolean loginBerhasil = false;

    private ArrayList<Integer> idLokasiDitemukan = new ArrayList<>();

    static String emailUser = "";

    public void login(User user) {
        Scanner scanner = new Scanner(System.in);
        int x = user.getJmlUser();
        loginBerhasil = false;

        System.out.println("SILAHKAN LAKUKAN LOG IN TERLEBIH DAHULU");
        while (!loginBerhasil) {
            System.out.print("Masukkan email: ");
            String email = scanner.nextLine();

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            for (int i = 0; i < x; i++) {
                if (email.equals(user.getEmail(i)) && password.equals(user.getPassword(i))) {
                    System.out.println("Login berhasil!");
                    loginBerhasil = true;
                    // Set idUserLogin after successful login
                    idUserLogin = user.getId(i);

                    // Tampilkan ucapan selamat dan nama user yang login
                    System.out.println("Selamat datang, " + user.getNama(i));
                    break;
                }
            }

            if (!loginBerhasil) {
                System.out.println("Email atau password salah!");
            }
        }
    }

    public static void loginAdmin(Admin admin) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SILAHKAN LAKUKAN LOG IN ADMIN TERLEBIH DAHULU");

        boolean loginBerhasil = false;

        while (!loginBerhasil) {
            System.out.print("Masukkan username admin: ");
            String username = scanner.nextLine();

            System.out.print("Masukkan password admin: ");
            String password = scanner.nextLine();

            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                System.out.println("Login admin berhasil!");
                loginBerhasil = true;
                // Additional admin-specific actions can be added here
                System.out.println("Selamat datang, " + admin.getNameAdmin());
            } else {
                System.out.println("Username atau password admin salah!");
            }
        }
    }

    public void cariLayananPublik(LayananPublik layanan, LokasiLayananPublik lokasi) {

        System.out.println();

        boolean ditemukan = false;

        // Melakukan pencarian layanan publik
        do {
            System.out.print("Masukkan kata kunci (nama atau kategori layanan): ");
            Scanner scanner = new Scanner(System.in);
            String kataKunci = scanner.nextLine();

            for (int i = 0; i < layanan.getJmlLayanan(); i++) {
                String namaLayanan = layanan.getNamaLayanan(i);
                String kategoriLayanan = layanan.getKategori(i);

                if (namaLayanan.toLowerCase().contains(kataKunci.toLowerCase()) ||
                        kategoriLayanan.toLowerCase().contains(kataKunci.toLowerCase())) {
                    System.out.println("ID Layanan Publik: " + layanan.getIdLayanan(i));
                    System.out.println("Nama Layanan: " + namaLayanan);
                    System.out.println("Kategori: " + kategoriLayanan);
                    System.out.println("Persyaratan: " + layanan.getPersyaratan(i));
                    System.out.println("Prosedur: " + layanan.getProsedur(i));
                    System.out.println();

                    // Memberikan pilihan untuk menyimpan data yang sesuai
                    System.out.print("Apakah ini layanan yang dicari? (ya/tidak): ");
                    String jawaban = scanner.nextLine();
                    if (jawaban.equalsIgnoreCase("ya")) {
                        System.out.println("Data layanan berhasil disimpan.");
                        idLayananPublikTerpilih = layanan.getIdLayanan(i);
                        ditemukan = true;
                        break;
                    }
                }
            }

            if (!ditemukan) {
                System.out.println("Layanan Publik dengan kata kunci '" + kataKunci + "' tidak ditemukan.");
                System.out.print("Apakah ingin mencari lagi? (ya/tidak): ");
                String pilihan = scanner.nextLine();
                if (!pilihan.equalsIgnoreCase("ya")) {
                    break;
                }
            }
        } while (!ditemukan);

    }

    // ethod looping table hasil di method cari lokasi layanan publik

    public void cariLokasiLayananPublik(User user, LayananPublik layanan, LokasiLayananPublik lokasi) {

        System.out.println();

        // Membersihkan ID yang ditemukan setiap kali memulai pencarian baru
        idLokasiDitemukan.clear();

        boolean ditemukan = false;

        // Melakukan pencarian lokasi layanan publik
        do {
            System.out.print("Masukkan kata kunci (lokasi layanan): ");
            // System.out.println();
            Scanner scanner = new Scanner(System.in);
            String kataKunci = scanner.nextLine();

            for (int i = 0; i < lokasi.getJmlLokasi(); i++) {
                // Memeriksa apakah lokasi terkait dengan ID Layanan Publik terpilih
                if (lokasi.getIdLayananPublik(i) == getIdLayananPublikTerpilih()) {
                    String alamat = lokasi.getAlamat(i);

                    if (alamat.toLowerCase().contains(kataKunci.trim().toLowerCase())) {
                        System.out.println("ID Lokasi Layanan Publik: " + lokasi.getIdLokasi(i));
                        System.out.println("Nama Tempat Layanan: " + lokasi.getNamaTempat(i));
                        System.out.println("Alamat: " + alamat);
                        System.out.println("Jam Buka: " + lokasi.getJamBuka(i));
                        System.out.println("Kontak: " + lokasi.getKontak(i));
                        System.out.println();

                        // Menyimpan ID lokasi yang cocok
                        idLokasiDitemukan.add(lokasi.getIdLokasi(i));

                        ditemukan = true;
                    }
                }
            }

            if (!ditemukan) {
                System.out.println("Lokasi Layanan Publik dengan kata kunci '" + kataKunci + "' tidak ditemukan.");
                System.out.print("Apakah ingin mencari lokasi lain ? (ya/tidak): ");
                String pilihan = scanner.nextLine();
                if (!pilihan.equalsIgnoreCase("ya")) {
                    break;
                }
            }
        } while (!ditemukan);

        // Jika ada lebih dari satu lokasi yang cocok, minta pengguna untuk memilih satu
        if (idLokasiDitemukan.size() > 1) {
            System.out.print("Masukkan ID Lokasi yang dipilih: ");
            Scanner scanner = new Scanner(System.in);
            int idLokasiTerpilih = scanner.nextInt();

            // Simpan ID yang dipilih oleh pengguna
            setIdLokasiTerpilih(idLokasiTerpilih);
        } else if (idLokasiDitemukan.size() == 1) {
            // Jika hanya ada satu lokasi yang cocok, langsung simpan ID tersebut
            setIdLokasiTerpilih(idLokasiDitemukan.get(0));
        }

        // Di luar loop, gunakan indexLokasiDitemukan
        if (ditemukan) {
            // Menampilkan informasi tambahan
            int idLayananPublikTerpilih = getIdLayananPublikTerpilih();
            int idLokasiTerpilih = getIdLokasiTerpilih();
            String namaUserLogin = user.getNama(getIdUserLogin());
            String namaLayananTerpilih = layanan.getNamaLayanan(idLayananPublikTerpilih);

            // Mendapatkan nama tempat layanan terpilih berdasarkan ID Lokasi Terpilih
            String namaTempatLayananTerpilih = lokasi.getNamaTempat(idLokasiTerpilih);

            // Menampilkan informasi dalam bentuk tabel
            System.out.println(
                    "=================================== INFORMASI DATA LAYANAN ===================================");
            System.out.printf("%-25s%-25s%-25s%n", "Nama User Login", "Nama Layanan Terpilih", "Nama Tempat Layanan");
            System.out.println(
                    "----------------------------------------------------------------------------------------");
            System.out.printf("%-25s%-25s%-25s%n",
                    namaUserLogin,
                    namaLayananTerpilih,
                    namaTempatLayananTerpilih);
            System.out.println(
                    "========================================================================================");
            System.out.println();

        }
    }

    // METHOD MENGAJUKAN PERMOHONAN

    public void mengajukanPermohonanLayananPublik(User user, LayananPublik layanan, LokasiLayananPublik lokasi,
            PermohonanLayananPublik permohonan, DatabasePermohonan databasePermohonan) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan informasi pengguna, layanan publik, dan lokasi layanan publik
        // terpilih
        int idLayananPublikTerpilih = getIdLayananPublikTerpilih();
        int idLokasiTerpilih = getIdLokasiTerpilih();
        String namaUserLogin = user.getNama(getIdUserLogin());
        String namaLayananTerpilih = layanan.getNamaLayanan(idLayananPublikTerpilih);
        String namaTempatLayananTerpilih = lokasi.getNamaTempat(idLokasiTerpilih);

        // Menyimpan permohonan ke database
        // PermohonanLayananPublik permohonan = new PermohonanLayananPublik();
        // Set atribut permohonan
        permohonan.setnamaUserLogin(user.getNama(getIdUserLogin()));
        permohonan.setnamaLayananTerpilih(layanan.getNamaLayanan(idLayananPublikTerpilih));
        permohonan.setnamaTempatLayananTerpilih(lokasi.getNamaTempat(idLokasiTerpilih));
        permohonan.setIdPermohonan(databasePermohonan.getPermohonanList().size() + 1);
        permohonan.setDokumenDukung("File Dokumen");
        permohonan.setStatus();

        // Minta konfirmasi dari pengguna untuk mengajukan permohonan
        System.out.print("Apakah Anda ingin mengajukan permohonan? (ya/tidak): ");
        String jawaban = scanner.nextLine();

        if (jawaban.equalsIgnoreCase("ya")) {
            // Add the booked data to the user's list
            user.addBookedData(permohonan);
            // Tambahkan permohonan ke database
            databasePermohonan.tambahPermohonan(permohonan);
            // Menampilkan informasi bahwa permohonan telah diajukan
            System.out.println("Permohonan berhasil diajukan!");
        } else {
            System.out.println("Permohonan tidak diajukan.");
        }

        // Menampilkan informasi dalam bentuk tabel
        System.out.println(
                "=================================== Informasi Permohonan =============================================================================");
        System.out.printf("%-25s%-25s%-48s%-20s%-25s%n", "Nama User Login", "Nama Layanan Terpilih",
                "Nama Tempat Layanan", "Status", "Dukungan Dokumen");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s%-25s%-48s%-20s%-25s%n",
                namaUserLogin,
                namaLayananTerpilih,
                namaTempatLayananTerpilih,
                permohonan.getStatus(),
                "File Dokumen"); // Dokumen dukungan default saat mengajukan permohonan
        System.out.println("========================================================================================");

        // DETAIL INFORMASI
        // Menampilkan informasi pengguna, layanan publik, dan lokasi layanan publik
        System.out.println();
        System.out.println(
                "=================================== DETAIL INFORMASI PENGAJUAN PERMOHONAN ===================================");
        System.out.println("ID Pengguna: " + user.getId(getIdUserLogin()));
        System.out.println("Nama Pengguna: " + user.getNama(getIdUserLogin()));
        System.out.println("Email Pengguna: " + user.getEmail(getIdUserLogin()));
        System.out.println();
        // System.out.printf("%-25s%-25s%-25s%-25s%n", "ID Pengguna", "Nama Pengguna",
        // "Email Pengguna", "Password Pengguna");
        System.out.println("----------------------------------------------------------------------------------------");
        // System.out.printf("%-25d%-25s%-25s%-25s%n",
        // user.getId(getIdUserLogin()),
        // user.getNama(getIdUserLogin()),
        // user.getEmail(getIdUserLogin()),
        // user.getPassword(getIdUserLogin()));

        // System.out.println("========================================================================================");

        System.out.println(
                "============================================== INFORMASI LAYANAN =============================================================");
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%n", "ID Layanan", "Nama Layanan", "Kategori Layanan",
                "Persyaratan", "Prosedur");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-25d%-25s%-25s%-25s%-25s%n",
                layanan.getIdLayanan(getIdLayananPublikTerpilih()),
                layanan.getNamaLayanan(getIdLayananPublikTerpilih()),
                layanan.getKategori(getIdLayananPublikTerpilih()),
                layanan.getPersyaratan(getIdLayananPublikTerpilih()),
                layanan.getProsedur(getIdLayananPublikTerpilih()));
        System.out.println(
                "=============================================================================================================================");

        System.out.println(
                "========================================================= INFORMASI LOKASI =============================================================");
        System.out.printf("%-15s%-48s%-40s%-20s%-20s%n", "ID Lokasi", "Nama Tempat Layanan", "Alamat", "Jam Buka",
                "Kontak");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-48s%-40s%-20s%-20s%n",
                lokasi.getIdLokasi(getIdLokasiTerpilih()),
                lokasi.getNamaTempat(getIdLokasiTerpilih()),
                lokasi.getAlamat(getIdLokasiTerpilih()),
                lokasi.getJamBuka(getIdLokasiTerpilih()),
                lokasi.getKontak(getIdLokasiTerpilih()));
        System.out.println(
                "========================================================================================================================================");

    }

    public void ubahStatusPermohonan(DatabasePermohonan databasePermohonan, User user) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan informasi permohonan yang masih diproses
        System.out.println(
                "======================================== List Permohonan yang Masih Diproses ==========================================");
        System.out.printf("%-25s%-25s%-48s%-20s%-25s%n", "Nama User Login", "Nama Layanan Terpilih",
                "Nama Tempat Layanan", "Status", "Dukungan Dokumen");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------");
        ArrayList<PermohonanLayananPublik> bookedData = user.getBookedData();
        for (PermohonanLayananPublik permohonan : bookedData) {
            if (permohonan.getStatus().equalsIgnoreCase("Sedang Diproses")) {
                System.out.printf("%-25s%-25s%-48s%-20s%-25s%n",
                        permohonan.getIdPermohonan(),
                        permohonan.getNamaUserLogin(),
                        permohonan.getnamaLayananTerpilih(),
                        permohonan.getnamaTempatLayananTerpilih(),
                        permohonan.getStatus(),
                        permohonan.getDokumenDukung());
            }
        }
        System.out.println(
                "=======================================================================================================================");

        // Meminta input ID Permohonan yang ingin diubah statusnya
        System.out.print("Masukkan ID Permohonan yang ingin diubah statusnya menjadi 'Selesai': ");
        int idPermohonanToUpdate = scanner.nextInt();

        // Melakukan validasi ID Permohonan yang dimasukkan
        boolean validId = false;
        for (PermohonanLayananPublik permohonan : bookedData) {
            if (permohonan.getIdPermohonan() == idPermohonanToUpdate
                    && permohonan.getStatus().equalsIgnoreCase("Sedang Diproses")) {
                validId = true;
                break;
            }
        }

        if (validId) {
            // Mengubah status permohonan menjadi "Selesai"
            for (PermohonanLayananPublik permohonan : bookedData) {
                if (permohonan.getIdPermohonan() == idPermohonanToUpdate) {
                    permohonan.setStatusSelesai();
                    System.out.println("Status Permohonan berhasil diubah menjadi 'Selesai'.");
                    break;
                }
            }
        } else {
            System.out.println(
                    "ID Permohonan tidak valid atau status bukan 'Sedang Diproses'. Tidak dapat mengubah status.");
        }

        // Menampilkan informasi permohonan setelah perubahan status
        System.out.println(
                "============================================== List Permohonan Setelah Perubahan ===============================================");
        System.out.printf("%-25s%-25s%-48s%-20s%-25s%n", "Nama User Login", "Nama Layanan Terpilih",
                "Nama Tempat Layanan", "Status", "Dukungan Dokumen");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------");

        for (PermohonanLayananPublik permohonan : bookedData) {
            System.out.printf("%-25s%-25s%-48s%-20s%-25s%n",
                    permohonan.getNamaUserLogin(),
                    permohonan.getnamaLayananTerpilih(),
                    permohonan.getnamaTempatLayananTerpilih(),
                    permohonan.getStatus(),
                    permohonan.getDokumenDukung());
        }
        System.out.println(
                "===============================================================================================================================");
    }

    //
    // public void ubahStatusPermohonanSelesai(DatabasePermohonan
    // databasePermohonan) {
    // Scanner scanner = new Scanner(System.in);
    //
    // // Menampilkan daftar permohonan yang sedang diproses
    // System.out.println("Daftar Permohonan Sedang Diproses:");
    // List<PermohonanLayananPublik> permohonanList =
    // databasePermohonan.getPermohonanList();
    // for (PermohonanLayananPublik permohonan : permohonanList) {
    // if (permohonan.getStatus().equalsIgnoreCase("Sedang diproses")) {
    // System.out.println("ID Permohonan: " + permohonan.getIdPermohonan());
    // }
    // }
    //
    // // Meminta input ID permohonan yang ingin diubah statusnya menjadi "Selesai"
    // System.out.print("Masukkan ID permohonan yang ingin diubah statusnya menjadi
    // 'Selesai': ");
    // int idPermohonanSelesai = scanner.nextInt();
    //
    // // Memeriksa apakah ID permohonan yang dimasukkan oleh pengguna valid
    // boolean isValidId = false;
    // for (PermohonanLayananPublik permohonan : permohonanList) {
    // if (permohonan.getIdPermohonan() == idPermohonanSelesai &&
    // permohonan.getStatus().equalsIgnoreCase("Sedang diproses")) {
    // isValidId = true;
    // break;
    // }
    // }
    //
    // if (isValidId) {
    // // Mengubah status permohonan menjadi "Selesai"
    // for (PermohonanLayananPublik permohonan : permohonanList) {
    // if (permohonan.getIdPermohonan() == idPermohonanSelesai) {
    // permohonan.setStatusSelesai();
    // System.out.println("Status permohonan dengan ID " + idPermohonanSelesai + "
    // berhasil diubah menjadi 'Selesai'.");
    // return;
    // }
    // }
    // } else {
    // System.out.println("ID permohonan tidak valid atau permohonan telah selesai
    // diubah statusnya.");
    // }
    //
    // }

    // Getter method for idUserLogin
    public int getIdUserLogin() {
        return idUserLogin;
    }

    // Metode untuk mendapatkan ID lokasi yang dipilih
    public int getIdLokasiTerpilih() {
        // Mengembalikan ID terakhir yang dipilih, bisa dimodifikasi sesuai kebutuhan
        return idLokasiDitemukan.isEmpty() ? -1 : idLokasiDitemukan.get(idLokasiDitemukan.size() - 1);
    }

    // Metode untuk mengatur ID lokasi yang dipilih
    public void setIdLokasiTerpilih(int idLokasiTerpilih) {
        idLokasiDitemukan.add(idLokasiTerpilih);
        System.out.println("ID Lokasi Layanan Publik yang dipilih: " + idLokasiTerpilih);
    }

    public int getIdLayananPublikTerpilih() {
        return idLayananPublikTerpilih;
    }

}
