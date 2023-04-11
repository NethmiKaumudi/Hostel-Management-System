package lk.ijse.hostelmanagementsystem.Service.custom.impl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.Service.custom.RoomService;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.RoomRepository;
import lk.ijse.hostelmanagementsystem.repository.impl.RoomRepositoryimpl;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class RoomServiceimpl implements RoomService {

    private static RoomServiceimpl roomServiceimpl;
    RoomRepository roomRepository;
    private Session session;

    private RoomServiceimpl() {
        roomRepository = RoomRepositoryimpl.getInstance();
    }

    public static RoomServiceimpl getInstance() {
        return roomServiceimpl == null ? roomServiceimpl = new RoomServiceimpl() : roomServiceimpl;
    }

    @Override
    public String save(RoomDTO roomDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomRepository.setSession(session);
            String save = roomRepository.Save(roomDTO.toEntity());
            transaction.commit();
            session.close();

            return save;


        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();


            return null;
        }
    }

    @Override
    public boolean delete(RoomDTO roomDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomRepository.setSession(session);
            roomRepository.delete(roomDTO.toEntity());
            transaction.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean update(RoomDTO roomDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomRepository.setSession(session);
            roomRepository.update(roomDTO.toEntity());
            transaction.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public RoomDTO get(String rId) {
        session = SessionFactoryConfig.getInstance().getSession();
        roomRepository.setSession(session);
        Room room = roomRepository.get(rId);
        session.close();
        return room.toDto();
    }

    public ObservableList<RoomDTO> getAllRooms() {
        session = SessionFactoryConfig.getInstance().getSession();
        roomRepository.setSession(session);
        List<Room> allRooms = roomRepository.getAllRooms();
        ObservableList<RoomDTO> roomDTOObservableList = FXCollections.observableArrayList();
        for (Room room : allRooms) {
            roomDTOObservableList.add(room.toDto());
        }
        return roomDTOObservableList;
    }
}
