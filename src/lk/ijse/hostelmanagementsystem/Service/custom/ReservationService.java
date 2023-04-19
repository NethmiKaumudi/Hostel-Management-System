package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

import java.util.List;

public interface ReservationService extends SuperService {
    String generateNewId();

    boolean save(ReservationDTO reservationDTO);

    int getNotAvailableRoomCount(String rid);

    RoomDTO getRoom(String room_type_id);

    List<ReservationDTO> getAll();
}
