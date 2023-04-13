package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.DashboardService;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.RoomRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.StudentRepository;

import java.io.IOException;
import java.util.ArrayList;

public class DashBoardServiceimpl implements DashboardService {
    StudentRepository studentRepository = (StudentRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.STUDENTREPOSITORY);
    RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOMREPOSITORY);


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
        int count = 0;
        for (Room r : rooms) {
            count += r.getQty();
        }
        System.out.println(count);
        return count;
    }
}
