package ui.menus;

import func.instances.admin.Admin;
import func.instances.user.User;
import func.method.Method;
import java.util.Scanner;
import ui.viewer.Viewer;

public class Menus {

  private Method activeMethod;

  public void boot(Method method) {
    this.activeMethod = method;

    int choice = 0;
    Scanner scanner = new Scanner(System.in);

    start(choice, scanner);
    scanner.close();
  }

  private void start(int choice, Scanner scanner) {
    do {
      System.out.println("\n===== SELAMAT DATANG DI PUBLIC CENTER =====");
      System.out.println("1. Login");
      System.out.println("3. Keluar Aplikasi");
      System.out.print("Masukkan pilihan: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          loginPortal(choice, scanner);
          break;
        case 3:
          System.out.println("\nKeluar dari Public Center...");
          break;
        default:
          System.out.println("\nInput tidak valid");
      }
    } while (choice != 3);
  }

  private void loginPortal(int choice, Scanner scanner) {
    System.out.println("\n===== LOGIN PORTAL =====");
    System.out.print("Masukkan username: ");

    String input = scanner.next();
    if (!activeMethod.loginUsername(input)) {
      System.out.println("\nUsername tidak ditemukan");
      return;
    }

    System.out.print("Masukkan password: ");

    input = scanner.next();
    if (!activeMethod.loginPassword(input)) {
      System.out.println("\nPassword salah");
      return;
    }

    System.out.println("\nLogin berhasil!");
    System.out.println(
      "Selamat datang, " + activeMethod.getInstance().getName() + "!"
    );

    if (activeMethod.getInstance().isAdmin()) {
      adminMenu(choice, scanner);
    } else {
      userMenu(choice, scanner);
    }
  }

  private void userMenu(int choice, Scanner scanner) {
    Viewer viewer = new Viewer();

    do {
      System.out.println("\n===== MENU USER =====");
      System.out.println("1. Booking Layanan");
      System.out.println("2. Lihat Data Booking");
      System.out.println("3. Logout");
      System.out.print("Masukkan pilihan: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          viewer.viewServices(activeMethod);
          System.out.print("\nMasukkan id layanan pilihan: ");
          int id = scanner.nextInt();
          User activeUser = (User) activeMethod.getInstance();

          // Cek apakah id layanan valid
          if (activeMethod.getServicesDaemon().getService(id) == null) {
            System.out.println("ID layanan " + id + " tidak valid.");
            break;
          }

          activeUser.selectService(id);
          viewer.viewLocations(activeMethod);
          System.out.print("\nMasukkan id lokasi layanan: ");
          id = scanner.nextInt();

          // Cek apakah id lokasi valid
          if (
            activeMethod
              .getLocationsDaemon()
              .getLocation(id, activeUser.getSelectedService()) ==
            null
          ) {
            System.out.println("ID lokasi layanan " + id + " tidak valid.");
            break;
          }

          // Verifikasi pengajuan
          viewer.viewPreviewSelected(activeMethod, id);
          System.out.print("\nLanjutkan pengajuan (ya/tidak): ");
          String input = scanner.next();

          // Cek apakah user tidak setuju untuk melanjutkan pengajuan
          if (input.equalsIgnoreCase("tidak")) {
            System.out.println("\nPengajuan dibatalkan.");
            break;
          }

          activeUser.commitSelected(activeMethod, id);
          System.out.println("\nPengajuan berhasil.");
          break;
        case 2:
          viewer.view(activeMethod);
          break;
        case 3:
          activeMethod.logout();
          break;
        default:
          System.out.println("\nInput tidak valid");
      }
    } while (choice != 3);
  }

  private void adminMenu(int choice, Scanner scanner) {
    Viewer viewer = new Viewer();

    do {
      System.out.println("\n===== MENU ADMIN =====");
      System.out.println("1. Lihat Data Permohonan Terbuka");
      System.out.println("2. Logout");
      System.out.print("Masukkan pilihan: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          viewer.view(activeMethod);
          System.out.print("\nMasukkan id permohonan yang ingin diubah: ");
          int id = scanner.nextInt();
          Admin activeUser = (Admin) activeMethod.getInstance();

          // Cek apakah id permohonan valid
          if (!activeUser.isBookInProcess(activeMethod, id)) {
            System.out.println("ID permohonan " + id + " tidak valid.");
            break;
          }

          activeUser.completeBook(activeMethod, id);
          System.out.println("\nPerubahan berhasil dilakukan.");
          break;
        case 2:
          activeMethod.logout();
          break;
        default:
          System.out.println("\nInput tidak valid");
      }
    } while (choice != 2);
  }
}
