package lk.ijse.hostelmanagementsystem.repository.impl;

import com.mysql.cj.xdevapi.Session;
import lk.ijse.hostelmanagementsystem.entity.Room;

public class RoomRepositoryimpl {
    private Session session;
    private static RoomRepositoryimpl roomRepositoryimpl;


    private RoomRepositoryimpl() {}
    public static RoomRepositoryimpl getInstance() {
        return null == roomRepositoryimpl
                ?roomRepositoryimpl= new RoomRepositoryimpl()
                : roomRepositoryimpl;
    }


    public void setSession(Session session) {
        this.session = session;
    }

//    public String save(Room room) {
//        return session.;
//    }

}
