package lk.ijse.hostelmanagementsystem.repository.custom.impl;

import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.custom.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationRepositoryimpl implements ReservationRepository {
    private static ReservationRepositoryimpl reservationRepositoryimpl;

    //    ReservationService reservationService;
    private Session session;

    private ReservationRepositoryimpl() {
    }

    public static ReservationRepositoryimpl getInstance() {
        return reservationRepositoryimpl == null ? reservationRepositoryimpl = new ReservationRepositoryimpl() : reservationRepositoryimpl;
    }


    @Override
    public String Save(Reservation entity) {

        return (String) session.save(entity);
    }

    @Override
    public void delete(Reservation entity) {

    }

    @Override
    public void update(Reservation entity) {

    }

    @Override
    public Reservation get(String Id) {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<String> getNewId() {
        String sql = "SELECT reservationId FROM reservation ORDER BY reservationId DESC LIMIT 1";
        return session.createSQLQuery(sql).list();
    }

    public Long getNotAvailableRoomCount(String rid) {
//        return reservationDAO.getNotAvailableRoomCount(rid);
        Query query = session.createQuery("SELECT COUNT(R) FROM reservation AS R WHERE R.rooms.id=:room_id");
        query.setParameter("room_id", rid);
        return (Long) query.uniqueResult();
    }


    public List<Reservation> getAll() {
        Query query = session.createQuery("SELECT R FROM reservation AS R");
        return query.list();

    }
   // public RoomDTO getRoom(String room_type_id) {
//        Room room = session.get(room_type_id);
//        return new RoomDTO(
//                room.getRoomTypeId(),
//                room.getType(),
//                room.getKeyMoney(),
//                room.getQty()
//        );
   // }
//   public Room get(String rId) {
//        return session.get(Room.class, rId);
//   }

}
