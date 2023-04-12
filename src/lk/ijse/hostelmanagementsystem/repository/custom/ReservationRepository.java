package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
     List<String> getNewId();
     Long getNotAvailableRoomCount(String rid);
    List<Reservation> getAll() ;
//    public Room get(String rId);
}
