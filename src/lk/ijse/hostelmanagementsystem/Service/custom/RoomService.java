package lk.ijse.hostelmanagementsystem.Service.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

public interface RoomService extends SuperService {
    String save(RoomDTO roomDTO);

    boolean delete(RoomDTO roomDTO);

    boolean update(RoomDTO roomDTO);

    RoomDTO get(String id);

    ObservableList<RoomDTO> getAllRooms();


}
