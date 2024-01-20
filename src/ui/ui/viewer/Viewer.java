package ui.viewer;

import func.instances.admin.Admin;
import func.instances.user.User;
import func.method.Method;

public class Viewer {

  public void view(Method method) {
    System.out.println();
    System.out.println(
      "===================================   TABEL DATA BOOKING  ====================================="
    );
    System.out.printf(
      "%-15s%-48s%-30s%-20s%n",
      "ID Booking",
      "Layanan",
      "Lokasi",
      "Status"
    );
    System.out.println(
      "-----------------------------------------------------------------------------------------------"
    );

    if (method.getInstance() instanceof User user) {
      user
        .getSelfBookings(method)
        .forEach(book -> {
          System.out.printf(
            "%-15s%-48s%-30s%-20s%n",
            book.id(),
            book.service(),
            book.location(),
            book.status()
          );
        });
    } else if (method.getInstance() instanceof Admin admin) {
      admin
        .getIncompleteBookings(method)
        .forEach(book -> {
          System.out.printf(
            "%-15s%-48s%-30s%-20s%n",
            book.id(),
            book.service(),
            book.location(),
            book.status()
          );
        });
    }
  }

  public void viewServices(Method method) {
    System.out.println();
    System.out.println(
      "===================================   TABEL LAYANAN PUBLIK  ====================================="
    );

    System.out.printf(
      "%-15s%-25s%-15s%-25s%-25s%n",
      "ID Layanan",
      "Nama Layanan",
      "Kategori",
      "Persyaratan",
      "Prosedur"
    );
    System.out.println(
      "-----------------------------------------------------------------------------------------------"
    );

    method
      .getServicesDaemon()
      .getRegisteredService()
      .forEach(service -> {
        System.out.printf(
          "%-15d%-25s%-15s%-25s%-25s%n",
          service.id(),
          service.name(),
          service.category(),
          service.requirement(),
          service.procedure()
        );
      });
  }

  public void viewLocations(Method method) {
    User activeUser = (User) method.getInstance();

    System.out.println();
    System.out.println(
      "===================================   TABEL LOKASI LAYANAN PUBLIK  ====================================="
    );

    System.out.printf(
      "%-15s%-48s%-30s%-20s%-20s%n",
      "ID Lokasi",
      "Nama Tempat Layanan",
      "Alamat",
      "Jam Buka",
      "Kontak"
    );
    System.out.println(
      "-----------------------------------------------------------------------------------------------"
    );

    method
      .getLocationsDaemon()
      .getRegisteredLocation(activeUser.getSelectedService())
      .forEach(location -> {
        System.out.printf(
          "%-15s%-48s%-30s%-20s%-20s%n",
          location.id(),
          location.name(),
          location.address(),
          location.openHour(),
          location.contact()
        );
      });
  }

  public void viewPreviewSelected(Method method, int idLocation) {
    User activeUser = (User) method.getInstance();

    System.out.println();
    System.out.println(
      "===================================   LOKASI LAYANAN PUBLIK TERPILIH  ====================================="
    );

    System.out.printf(
      "%-15s%-48s%-30s%-20s%-20s%n",
      "ID Booking",
      "Status",
      "Dokumen",
      "Nama Layanan",
      "Lokasi Layanan"
    );
    System.out.println(
      "-----------------------------------------------------------------------------------------------"
    );

    System.out.printf(
      "%-15s%-48s%-30s%-20s%-20s%n",
      activeUser.getPreviewSelected(method, idLocation).id(),
      activeUser.getPreviewSelected(method, idLocation).status(),
      activeUser.getPreviewSelected(method, idLocation).document(),
      activeUser.getPreviewSelected(method, idLocation).service(),
      activeUser.getPreviewSelected(method, idLocation).location()
    );
  }
}
