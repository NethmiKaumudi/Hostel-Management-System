package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.DashboardService;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.PaymentRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.RoomRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.StudentRepository;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;

public class DashBoardServiceimpl implements DashboardService {
    private StudentRepository studentRepository = (StudentRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.STUDENTREPOSITORY);
    private RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOMREPOSITORY);
    private PaymentRepository paymentRepository= (PaymentRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.PAYMENTREPOSITORY);

    private Session session;

    @Override
    public Long getPendingPaymentCount() {
        session = SessionFactoryConfig.getInstance().getSession();
        //.setSession(session);
        paymentRepository.setSession(session);
        Long allPendingPaymentCount = paymentRepository.getAllPendingPaymentCount();
        if(allPendingPaymentCount ==null){
            return Long.valueOf(0);
        }else {
            return allPendingPaymentCount;
        }
    }

    @Override
    public int getRegisteredStudent() throws IOException {
        session = SessionFactoryConfig.getInstance().getSession();
        studentRepository.setSession(session);
        return studentRepository.getAllStudents().size();
    }

    @Override
    public int getRoomCount() {
        ArrayList<Room> rooms;
        session = SessionFactoryConfig.getInstance().getSession();
        roomRepository.setSession(session);
        rooms = roomRepository.getAllRooms();
        int count = 0;
        for (Room r : rooms) {
            count += r.getQty();
        }
        System.out.println(count);
        return count;
    }
}
