package lk.ijse.hostelmanagementsystem.Service.custom;

import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;

public interface ReservationService {
    public String generateNewId();
    public boolean save(ReservationDTO reservationDTO) ;
    public int getNotAvailableRoomCount(String rid);
}
