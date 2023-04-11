package lk.ijse.hostelmanagementsystem.repository.impl;

import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.RoomRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomRepositoryimpl implements RoomRepository {

    private static RoomRepositoryimpl roomRepositoryimpl;
    private Session session;


    private RoomRepositoryimpl() {
    }

    public static RoomRepositoryimpl getInstance() {
        return null == roomRepositoryimpl
                ? roomRepositoryimpl = new RoomRepositoryimpl()
                : roomRepositoryimpl;
    }


    @Override
    public String Save(Room entity) {

        return (String) session.save(entity);
    }

    @Override
    public void delete(Room entity) {
        session.delete(entity);
    }

    @Override
    public void update(Room entity) {
        session.update(entity);
    }

    @Override
    public Room get(String rId) {
        return session.get(Room.class, rId);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    public List<Room> getAllRooms() {
        String sqlQuery = "FROM room";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }
}
