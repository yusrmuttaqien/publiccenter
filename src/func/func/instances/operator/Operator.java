package func.instances.operator;

import dbase.people.Person;
import func.instances.admin.Admin;
import func.instances.user.User;

public sealed class Operator permits Admin, User {

  public Person person;

  public Operator(Person person) {
    this.person = person;
  }

  public int getId() {
    return this.person.id();
  }

  public String getName() {
    return this.person.name();
  }

  public boolean isAdmin() {
    return this instanceof Admin;
  }

  public void cleanup() {}
}
