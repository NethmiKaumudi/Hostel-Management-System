package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.ReservationService;
import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.ReservationRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.RoomRepository;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationServiceimpl implements ReservationService {
    private RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOMREPOSITORY);
    private ReservationRepository reservationRepository = (ReservationRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.RESERVATIONREPOSITORY);

    private Session session;

    public boolean save(ReservationDTO reservationDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(reservationDTO.toEntity());
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
        String newId = "R001";
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        String sql="SELECT reservation_id FROM reservation ORDER BY reservation_id DESC LIMIT 1";
//        List<String> list = session.createSQLQuery(sql).list();

        reservationRepository.setSession(session);
        List<String> list = reservationRepository.getNewId();

        for (String resId : list) {
            if (resId != null) {
                int num = Integer.valueOf(resId.substring(1));
                num++;

                if (num <= 9) {
                    newId = "R00" + num;
                } else if (num > 9 && num < 100) {
                    newId = "R0" + num;
                } else if (num >= 100) {
                    newId = "R" + num;
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
        try {
//            Query query = session.createQuery("SELECT COUNT(*) FROM Reservation r WHERE r.room.room_type_id=:room_type_id");
            reservationRepository.setSession(session);
            Long count = reservationRepository.getNotAvailableRoomCount(rid);
            session.close();
            return Math.toIntExact(count);
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return 0;
        }
    }

    public List<ReservationDTO> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        try {
            reservationRepository.setSession(session);
            List<Reservation> reservations = reservationRepository.getAll();
            List<ReservationDTO> list = new ArrayList<>();
            for (Reservation reservation : reservations) {
                list.add(new ReservationDTO(reservation.getReservationId(), reservation.getStudents().getStudentId(), reservation.getRooms().getRoomTypeId(), reservation.getDate(), reservation.getStatus()));
            }

            session.close();
            return list;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    public RoomDTO getRoom(String room_type_id) {
        session = SessionFactoryConfig.getInstance().getSession();
        roomRepository.setSession(session);
        Room room = roomRepository.get(room_type_id);
        session.close();
        return room.toDto();
    }

}
