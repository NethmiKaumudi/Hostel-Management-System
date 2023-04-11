package lk.ijse.hostelmanagementsystem.repository.impl;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.ReservationRepository;
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
        String sql="SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1";
        return session.createSQLQuery(sql).list();
    }
    public Query getNotAvailableRoomCount(String rid) {
//        return reservationDAO.getNotAvailableRoomCount(rid);
                  return session.createQuery("SELECT COUNT(*) FROM reservation r WHERE r.room.room_id=:room_id");

    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }
//    public NativeQuery getAll() {
//        return session.createSQLQuery("SELECT * FROM reservation");
//
//    }
}
