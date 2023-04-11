package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.Service.custom.ReservationService;
import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.ReservationRepository;
import lk.ijse.hostelmanagementsystem.repository.impl.ReservationRepositoryimpl;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReservationServiceimpl implements ReservationService {
    private static ReservationService reservationServiceimpl;
//    RoomRepository roomRepository;
    ReservationRepository reservationRepository;
    private Session session;

    private ReservationServiceimpl() {
        reservationRepository= ReservationRepositoryimpl.getInstance();
    }

    public static ReservationService getInstance() {
        return reservationServiceimpl == null
                ? reservationServiceimpl = new ReservationServiceimpl()
                : reservationServiceimpl;
    }
    public boolean save(ReservationDTO reservationDTO) {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(reservationDTO);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public String generateNewId() {
        String newId="R001";
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        String sql="SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1";
//        List<String> list = session.createSQLQuery(sql).list();

        reservationRepository.setSession(session);
        List<String> list = reservationRepository.getNewId();

        for (String resId : list) {
            if (resId!=null){
                int num = Integer.valueOf(resId.substring(1));
                num++;

                if (num<=9){
                    newId="R00"+num;
                }else if (num>9&&num<100){
                    newId="R0"+num;
                }else if (num>=100){
                    newId="R"+num;
                }
            }
        }

        transaction.commit();
        session.close();

        return newId;
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        String sqlQuery = "SELECT r.res_id FROM reservation AS r ORDER BY res_id DESC";
//        Query query = session.createQuery(sqlQuery);
//        List list = query.list();
//        session.close();
//        if (list.size() > 0) {
//            return (String) list.get(0);
//        }
//        return null;
    }
    public int getNotAvailableRoomCount(String rid) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
//            Query query = session.createQuery("SELECT COUNT(*) FROM Reservation r WHERE r.room.room_type_id=:room_type_id");
            reservationRepository.setSession(session);
            Query query = reservationRepository.getNotAvailableRoomCount(rid);
            query.setParameter("room_type_id", rid);
            Long count = (Long) query.uniqueResult();
            transaction.commit();
            session.close();
            return Math.toIntExact(count);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return 0;
        }
    }
    public ArrayList<Reservation> getAll() {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            NativeQuery nativeQuery = session.createSQLQuery("SELECT * FROM reservation");
            nativeQuery.addEntity(Reservation.class);
            List<Reservation> reservationList=nativeQuery.list();
            transaction.commit();
            session.close();
            return (ArrayList<Reservation>) reservationList;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return null;
        }
    }

}
