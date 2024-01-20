package dbase.locations;

import java.util.ArrayList;

public class Locations {

  private ArrayList<Location> locations = new ArrayList<Location>();

  public Locations() {
    this.locations.add(
        new Location(
          getNewId(),
          "Puskesmas Malang",
          "Jl. Mawar No. 1, Malang",
          "08.00 - 20.00",
          "(0341) 123456",
          1
        )
      );
    this.locations.add(
        new Location(
          getNewId(),
          "RSUD Dr. Saiful Anwar",
          "Jl. Jaksa Agung Suprapto No.2, Malang",
          "Buka 24 jam",
          "(0341) 362101",
          1
        )
      );
    this.locations.add(
        new Location(
          getNewId(),
          "Puskesmas Surabaya",
          "Jl. Raya Arjowinangun No. 2, Surabaya",
          "08.00 - 17.00",
          "(0341) 751398",
          1
        )
      );
    this.locations.add(
        new Location(
          getNewId(),
          "Puskesmas Negeri Surabaya",
          "Jl. Raya No. 2, Surabaya",
          "08.00 - 20.00",
          "(0341) 751398",
          1
        )
      );
    this.locations.add(
        new Location(
          getNewId(),
          "Kantor Kependudukan dan Catatan Sipil Malang",
          "Jl. Melati No. 2, Malang",
          "08.00 - 15.00",
          "(0341) 789012",
          2
        )
      );
    this.locations.add(
        new Location(
          getNewId(),
          "Kantor Kependudukan dan Catatan Sipil Surabaya",
          "Jl. Melati No. 2, Surabaya",
          "08.00 - 15.00",
          "(0341) 789012",
          2
        )
      );
  }

  private int getNewId() {
    return this.locations.size() + 1;
  }

  public ArrayList<Location> getRegisteredLocation() {
    return this.locations;
  }

  public ArrayList<Location> getRegisteredLocation(int idService) {
    ArrayList<Location> locations = new ArrayList<Location>();

    for (Location location : this.locations) {
      if (location.idService().equals(idService)) {
        locations.add(location);
      }
    }

    return locations;
  }

  public Location getLocation(Integer id) {
    for (Location location : this.locations) {
      if (location.id().equals(id)) {
        return location;
      }
    }

    return null;
  }

  public Location getLocation(Integer id, Integer idService) {
    for (Location location : this.locations) {
      if (location.id().equals(id) && location.idService().equals(idService)) {
        return location;
      }
    }

    return null;
  }

  public void addService(
    String name,
    String address,
    String openHour,
    String contact,
    Integer idService
  ) {
    this.locations.add(
        new Location(getNewId(), name, address, openHour, contact, idService)
      );
  }
}
