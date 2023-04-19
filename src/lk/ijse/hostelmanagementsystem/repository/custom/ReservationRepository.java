package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, String> {
    List<String> getNewId();

    Long getNotAvailableRoomCount(String rid);

    List<Reservation> getAll();
}
