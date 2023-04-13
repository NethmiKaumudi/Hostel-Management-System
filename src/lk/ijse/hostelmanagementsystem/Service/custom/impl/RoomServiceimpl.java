package lk.ijse.hostelmanagementsystem.Service.custom.impl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.Service.custom.RoomService;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.RoomRepository;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class RoomServiceimpl implements RoomService {

    private  RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOMREPOSITORY);

    private Session session;


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
