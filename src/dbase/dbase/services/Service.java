package dbase.services;

public record Service(
  Integer id,
  String name,
  String category,
  String requirement,
  String procedure
) {}
