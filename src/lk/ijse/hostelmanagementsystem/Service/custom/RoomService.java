package lk.ijse.hostelmanagementsystem.Service.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

public interface RoomService {
    public String save(RoomDTO roomDTO);

    public boolean delete(RoomDTO roomDTO);

    public boolean update(RoomDTO roomDTO);

    RoomDTO get(String id);

    public ObservableList<RoomDTO> getAllRooms();


}
