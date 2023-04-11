package lk.ijse.hostelmanagementsystem.repository;

import lk.ijse.hostelmanagementsystem.entity.Room;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room,String>{
    public List<Room> getAllRooms() ;

    }
