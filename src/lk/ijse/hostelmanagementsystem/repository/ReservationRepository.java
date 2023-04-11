package lk.ijse.hostelmanagementsystem.repository;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import org.hibernate.query.Query;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,String>{
    public List<String> getNewId();
    public Query getNotAvailableRoomCount(String rid);
    public List<Reservation> getAll();
}
