package dbase.people;

import java.util.ArrayList;

public class People implements PeopleConstants {

  private ArrayList<Person> people = new ArrayList<Person>();

  public People() {
    this.people.add(
        new Person(getNewId(), "Mariana", "admin", "admin", ROLE_ADMIN, "")
      );
    this.people.add(
        new Person(
          getNewId(),
          "Doni Anggara",
          "123456",
          "",
          ROLE_USER,
          "doni@gmail.com"
        )
      );
    this.people.add(
        new Person(
          getNewId(),
          "Riki Sukmawijaya",
          "123457",
          "",
          ROLE_USER,
          "riki@gmail.com"
        )
      );
    this.people.add(
        new Person(
          getNewId(),
          "Nana Anggraini",
          "123458",
          "",
          ROLE_USER,
          "nana@gmail.com"
        )
      );
  }

  public Person get(Integer id) {
    if (id < 0 || id > this.people.size()) {
      return null;
    }

    return this.people.get(id - 1);
  }

  public Person get(String nameUsernameOrEmail) {
    for (Person person : this.people) {
      if (
        person.name().equals(nameUsernameOrEmail) ||
        person.username().equals(nameUsernameOrEmail) ||
        person.email().equals(nameUsernameOrEmail)
      ) {
        return person;
      }
    }

    return null;
  }

  private int getNewId() {
    return this.people.size() + 1;
  }
}
