package dbase.people;

public record Person(
  Integer id,
  String name,
  String password,
  String username,
  String role,
  String email
) {}
