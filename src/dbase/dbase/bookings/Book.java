package dbase.bookings;

public record Book(
  Integer id,
  String status,
  String document,
  Integer idUser,
  Integer idService,
  Integer idLocation
) {}
