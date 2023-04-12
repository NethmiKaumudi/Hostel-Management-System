package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.QueryService;
import lk.ijse.hostelmanagementsystem.dto.CustomDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.projection.Custom;
import lk.ijse.hostelmanagementsystem.repository.custom.PaymentRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.RoomRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.StudentRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.impl.PaymentRepositoryimpl;
import lk.ijse.hostelmanagementsystem.repository.custom.impl.RoomRepositoryimpl;
import lk.ijse.hostelmanagementsystem.repository.custom.impl.StudentRepositoryimpl;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryServiceimpl implements QueryService {
    PaymentRepository paymentRepositor=PaymentRepositoryimpl.getInstance();

    private static QueryServiceimpl queryServiceimpl;
    //    RoomRepository roomRepository;

    private Session session;


    private QueryServiceimpl() {
    }

    public static QueryServiceimpl getInstance() {
        return queryServiceimpl == null
                ? queryServiceimpl = new QueryServiceimpl()
                : queryServiceimpl;
    }
    public ArrayList<CustomDTO> getAllPendingPaymentStudent() {
        ArrayList<Custom> customEntities = paymentRepositor.getAllPendingPaymentStudent();
        ArrayList<CustomDTO> customDTOS = new ArrayList<>();
        for (Custom c : customEntities) {
            customDTOS.add(
                    new CustomDTO(
                            c.getStudentId(),
                            c.getName(),
                            c.getAddress(),
                            c.getContactNo(),
                            c.getDob(),
                            c.getGender()
                    )
            );
        }
        return customDTOS;
    }
}
