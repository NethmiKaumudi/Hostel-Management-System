package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import lk.ijse.hostelmanagementsystem.Service.custom.QueryService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.repository.RepositoryFactory;
import lk.ijse.hostelmanagementsystem.repository.custom.PaymentRepository;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.List;

public class QueryServiceimpl implements QueryService {

    private PaymentRepository paymentRepository = (PaymentRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.PAYMENTREPOSITORY);

    private Session session;

    public List<StudentDTO> getAllPendingPaymentStudent() {
        session = SessionFactoryConfig.getInstance().getSession();
        paymentRepository.setSession(session);
        return paymentRepository.getAllPendingPaymentStudent();
    }
}
