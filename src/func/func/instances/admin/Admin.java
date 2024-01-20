package func.instances.admin;

import dbase.bookings.Book;
import dbase.bookings.BookingConstants;
import dbase.bookings.Bookings;
import dbase.locations.Locations;
import dbase.people.Person;
import dbase.services.Services;
import func.instances.operator.Operator;
import func.instances.user.SelfBookings;
import func.method.Method;
import java.util.ArrayList;

public final class Admin extends Operator implements BookingConstants {

  public Admin(Person person) {
    super(person);
  }

  public ArrayList<SelfBookings> getIncompleteBookings(Method method) {
    Bookings bookings = method.getBookingsDaemon();
    Locations locations = method.getLocationsDaemon();
    Services services = method.getServicesDaemon();
    ArrayList<Book> openBookings = bookings.getBookings(BOOKING_IN_PROCESS);
    ArrayList<SelfBookings> inCompleteBookingsList = new ArrayList<SelfBookings>();

    for (Book book : openBookings) {
      inCompleteBookingsList.add(
        new SelfBookings(
          book.id(),
          book.status(),
          book.document(),
          services.getService(book.idService()).name(),
          locations.getLocation(book.idLocation()).name()
        )
      );
    }

    return inCompleteBookingsList;
  }

  public boolean isBookInProcess(Method method, Integer id) {
    Bookings bookings = method.getBookingsDaemon();
    Book book = bookings.getBook(id);

    if (book == null) {
      return false;
    }

    return book.status().equals(BOOKING_IN_PROCESS);
  }

  public void completeBook(Method method, Integer id) {
    Bookings bookings = method.getBookingsDaemon();
    bookings.completeBook(id);
  }
}
