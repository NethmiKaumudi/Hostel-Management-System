package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.QueryService;
import lk.ijse.hostelmanagementsystem.entity.Custom;
import lk.ijse.hostelmanagementsystem.projection.CustomDTO;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.PaymentRepository;

import java.util.ArrayList;

public class QueryServiceimpl implements QueryService {

    PaymentRepository paymentRepository = (PaymentRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.PAYMENTREPOSITORY);

//    private Session session;

    public ArrayList<CustomDTO> getAllPendingPaymentStudent() {
        ArrayList<Custom> customEntities = paymentRepository.getAllPendingPaymentStudent();
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
