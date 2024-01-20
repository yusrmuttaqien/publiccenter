package dbase.services;

import java.util.ArrayList;

public class Services {

  private ArrayList<Service> services = new ArrayList<Service>();

  public Services() {
    this.services.add(
        new Service(
          getNewId(),
          "Layanan Kesehatan",
          "Kesehatan",
          "Memiliki KTP",
          "Mendaftar di Puskesmas"
        )
      );
    this.services.add(
        new Service(
          getNewId(),
          "Layanan Pendidikan",
          "Pendidikan",
          "Memiliki Kartu Keluarga",
          "Mendaftar di Sekolah"
        )
      );
    // this.services.add(
    //     new Service(
    //       getNewId(),
    //       "Layanan Transportasi",
    //       "Transportasi",
    //       "Memiliki KTP",
    //       "Membeli Tiket"
    //     )
    //   );
  }

  private int getNewId() {
    return this.services.size() + 1;
  }

  public Service getService(int id) {
    for (Service service : this.services) {
      if (service.id().equals(id)) {
        return service;
      }
    }

    return null;
  }

  public ArrayList<Service> getRegisteredService() {
    return this.services;
  }

  public void addService(
    String name,
    String category,
    String requirement,
    String procedure
  ) {
    this.services.add(
        new Service(getNewId(), name, category, requirement, procedure)
      );
  }
}
