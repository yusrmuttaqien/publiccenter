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
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // membuat objek dari class yang kemudian dipanggil dimain class
        // objek adalah sebuah variabel yang merupakan instance atau perwujudan dari
        // Class.
        User user = new User(); // Buat objek User
        Admin admin = new Admin();
        LayananPublik layananPublik = new LayananPublik(); // Buat objek User
        LokasiLayananPublik lokasi = new LokasiLayananPublik();
        PermohonanLayananPublik permohonanLayanan = new PermohonanLayananPublik();
        DatabasePermohonan databasePermohonan = new DatabasePermohonan();

        MethodUser method = new MethodUser();
        TampilData tampil1 = new TampilData();

        // Display menu
        int choice;
        Scanner scanner = new Scanner(System.in);

        outerLoop: do {
            System.out.println("\n===== SELAMAT DATANG DI APLIKASI LAYANAN PUBLIK =====");
            System.out.println("1. Login User");
            System.out.println("2. Login Admin");
            System.out.println("3. Keluar Aplikasi");
            System.out.print("Masukkan pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int userChoice;
                    // Login as user
                    method.login(user);

                    // Nested switch for user-specific actions

                    do {
                        System.out.println("\n===== MENU USER =====");
                        System.out.println("1. Booking Layanan");
                        System.out.println("2. Lihat Data Booking");
                        System.out.println("3. Logout");
                        System.out.print("Masukkan pilihan: ");
                        userChoice = scanner.nextInt();

                        switch (userChoice) {
                            case 1:
                                // Booking Layanan
                                System.out.println("===== Booking Layanan =====");
                                System.out.println("1. Booking Layanan Baru");
                                System.out.println("2. Lihat Data Layanan Publik");
                                System.out.print("Masukkan pilihan: ");
                                int bookingChoice = scanner.nextInt();

                                switch (bookingChoice) {
                                    case 1:
                                        tampil1.tampil(layananPublik);
                                        method.cariLayananPublik(layananPublik, lokasi);
                                        tampil1.tampil(lokasi, method.getIdLayananPublikTerpilih());
                                        method.cariLokasiLayananPublik(user, layananPublik, lokasi);
                                        method.mengajukanPermohonanLayananPublik(user, layananPublik, lokasi,
                                                permohonanLayanan, databasePermohonan);
                                        break;
                                    case 2:
                                        // Lihat Data Layanan Publik
                                        System.out.println("\nSeluruh Data Layanan Publik:");
                                        // tampil1.tampilDataPermohonan( permohonanLayanan);
                                        tampil1.tampilKumpulanDataPermohonan(user);

                                        break;
                                    default:
                                        System.out.println("\nInputan tidak valid");
                                }
                                break;
                            case 2:
                                tampil1.tampilKumpulanDataPermohonan(user);
                                break;
                            case 3:
                                // Logout
                                System.out.println("\nUser logout...");

                                continue outerLoop;

                            default:
                                System.out.println("\nInputan tidak valid");
                        }
                    } while (userChoice != 3);

                    break;
                case 2:
                    int adminChoice;
                    method.loginAdmin(admin);

                    do {
                        System.out.println("\n===== MENU ADMIN =====");
                        System.out.println("1. Ubah Data Permohonan");
                        System.out.println("2. Logout");
                        System.out.print("Masukkan pilihan: ");
                        adminChoice = scanner.nextInt();

                        switch (adminChoice) {
                            case 1:
                                method.ubahStatusPermohonan(databasePermohonan, user);
                                break;
                            case 2:
                                // Logout
                                System.out.println("\nAdmin logout...");
                                continue outerLoop; // Keluar dari loop admin dan kembali ke loop utama
                            default:
                                System.out.println("\nInputan tidak valid");
                        }
                    } while (adminChoice != 2);
                    break;
                case 3:
                    System.out.println("\nKeluar dari aplikasi Layanan Publik...");
                    break;
                default:
                    System.out.println("\nInputan tidak valid");
            }
        } while (choice != 3);

        scanner.close();
    }

}
