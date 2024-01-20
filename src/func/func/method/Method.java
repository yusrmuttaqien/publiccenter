package func.method;

import dbase.bookings.Bookings;
import dbase.locations.Locations;
import dbase.people.People;
import dbase.people.PeopleConstants;
import dbase.people.Person;
import dbase.services.Services;
import func.instances.admin.Admin;
import func.instances.operator.Operator;
import func.instances.user.User;

public class Method implements PeopleConstants {

  private Person selectedPerson;
  private Operator instance;
  private Services servicesDaemon = new Services();
  private Bookings bookingsDaemon = new Bookings();
  private Locations locationsDaemon = new Locations();
  private People peopleDaemon = new People();

  public boolean loginUsername(String nameUsernameOrEmail) {
    this.selectedPerson = peopleDaemon.get(nameUsernameOrEmail);

    return this.selectedPerson != null;
  }

  public boolean loginPassword(String password) {
    if (!this.selectedPerson.password().equals(password)) {
      return false;
    }

    if (this.selectedPerson.role() == ROLE_ADMIN) {
      this.instance = new Admin(this.selectedPerson);
    } else if (this.selectedPerson.role() == ROLE_USER) {
      this.instance = new User(this.selectedPerson);
    }

    return true;
  }

  public void logout() {
    this.instance.cleanup();
    String name = this.instance.getName();
    this.selectedPerson = null;
    this.instance = null;

    System.out.println("\n" + name + ", anda berhasil logout.");
  }

  public Operator getInstance() {
    return this.instance;
  }

  public Services getServicesDaemon() {
    return this.servicesDaemon;
  }

  public Bookings getBookingsDaemon() {
    return this.bookingsDaemon;
  }

  public Locations getLocationsDaemon() {
    return this.locationsDaemon;
  }

  public People getPeopleDaemon() {
    return this.peopleDaemon;
  }
}
