package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.DashboardService;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.custom.RoomRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.StudentRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.impl.RoomRepositoryimpl;
import lk.ijse.hostelmanagementsystem.repository.custom.impl.StudentRepositoryimpl;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;

public class DashBoardServiceimpl implements DashboardService {
    StudentRepository studentRepository= StudentRepositoryimpl.getInstance();
    RoomRepository roomRepository= RoomRepositoryimpl.getInstance();
    private static DashBoardServiceimpl dashBoardServiceimpl;
    //    RoomRepository roomRepository;

    private Session session;


    private DashBoardServiceimpl() {
    }

    public static DashBoardServiceimpl getInstance() {
        return dashBoardServiceimpl == null
                ? dashBoardServiceimpl = new DashBoardServiceimpl()
                : dashBoardServiceimpl;
    }

    @Override
    public int getPendingPaymentCount() {
        return 0;
    }

    @Override
    public int getRegisteredStudent() throws IOException {
      return studentRepository.getAllStudents().size();
    }

    @Override
    public int getRoomCount() {
        ArrayList<Room> rooms;
        rooms = roomRepository.getAllRooms();
        int count=0;
        for (Room r:rooms) {
            count+=r.getQty();
        }
        System.out.println(count);
        return count;
    }
}
