package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public interface ReservationService extends SuperService {
    public String generateNewId();
    public boolean save(ReservationDTO reservationDTO) ;
    public int getNotAvailableRoomCount(String rid);
    public RoomDTO getRoom(String room_type_id);
    public List<ReservationDTO> getAll();
}
