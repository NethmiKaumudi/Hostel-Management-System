package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.util.ArrayList;

public interface RoomRepository extends CrudRepository<Room,String> {
    public ArrayList<Room> getAllRooms() ;

    }
