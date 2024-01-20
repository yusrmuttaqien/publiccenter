package dbase.locations;

public record Location(
  Integer id,
  String name,
  String address,
  String openHour,
  String contact,
  Integer idService
) {}
