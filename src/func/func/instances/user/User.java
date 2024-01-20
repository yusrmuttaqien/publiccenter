package func.instances.user;

import dbase.bookings.Book;
import dbase.bookings.Bookings;
import dbase.locations.Locations;
import dbase.people.Person;
import dbase.services.Services;
import func.instances.operator.Operator;
import func.method.Method;
import java.util.ArrayList;

public final class User extends Operator {

  private int selectedService;

  public User(Person person) {
    super(person);
  }

  public ArrayList<SelfBookings> getSelfBookings(Method method) {
    Bookings bookings = method.getBookingsDaemon();
    Locations locations = method.getLocationsDaemon();
    Services services = method.getServicesDaemon();
    ArrayList<Book> selfBookings = bookings.getBookings(this.person.id());
    ArrayList<SelfBookings> selfBookingsList = new ArrayList<SelfBookings>();

    for (Book book : selfBookings) {
      selfBookingsList.add(
        new SelfBookings(
          book.id(),
          book.status(),
          book.document(),
          services.getService(book.idService()).name(),
          locations.getLocation(book.idLocation()).name()
        )
      );
    }

    return selfBookingsList;
  }

  public void selectService(int idService) {
    this.selectedService = idService;
  }

  public int getSelectedService() {
    return this.selectedService;
  }

  public SelfBookings getPreviewSelected(Method method, int idLocation) {
    Locations locations = method.getLocationsDaemon();
    Services services = method.getServicesDaemon();

    return new SelfBookings(
      0,
      "-",
      "-",
      services.getService(selectedService).name(),
      locations.getLocation(idLocation).name()
    );
  }

  public void commitSelected(Method method, int idLocation) {
    Bookings bookings = method.getBookingsDaemon();

    bookings.addBook("-", this.person.id(), this.selectedService, idLocation);
  }

  public void cleanup() {
    this.selectedService = 0;
  }
}
