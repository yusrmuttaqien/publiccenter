package dbase.bookings;

import java.util.ArrayList;

public class Bookings implements BookingConstants {

  private ArrayList<Book> bookLists = new ArrayList<Book>();

  public void addBook(
    String document,
    Integer idUser,
    Integer idService,
    Integer idLocation
  ) {
    this.bookLists.add(
        new Book(
          getNewId(),
          BOOKING_IN_PROCESS,
          document,
          idUser,
          idService,
          idLocation
        )
      );
  }

  private int getNewId() {
    return this.bookLists.size() + 1;
  }

  public ArrayList<Book> getBookings() {
    return this.bookLists;
  }

  public ArrayList<Book> getBookings(String status) {
    ArrayList<Book> statusBookings = new ArrayList<Book>();

    for (Book book : this.bookLists) {
      if (book.status().equals(status)) {
        statusBookings.add(book);
      }
    }
    return statusBookings;
  }

  public Book getBook(Integer id) {
    for (Book book : this.bookLists) {
      if (book.id() == id) {
        return book;
      }
    }

    return null;
  }

  public ArrayList<Book> getBookings(Integer idUser) {
    ArrayList<Book> userBookings = new ArrayList<Book>();

    for (Book book : this.bookLists) {
      if (book.idUser() == idUser) {
        userBookings.add(book);
      }
    }
    return userBookings;
  }

  public void completeBook(Integer id) {
    Book oldBook = this.bookLists.get(id - 1);
    Book newBook = new Book(
      id,
      BOOKING_PROCESSED,
      oldBook.document(),
      oldBook.idUser(),
      oldBook.idService(),
      oldBook.idLocation()
    );
    bookLists.set(id - 1, newBook);
  }
}
