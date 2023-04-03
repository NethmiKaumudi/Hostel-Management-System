package lk.ijse.hostelmanagementsystem.Service.impl;

import com.mysql.cj.Session;
import lk.ijse.hostelmanagementsystem.repository.impl.RoomRepository;
import lk.ijse.hostelmanagementsystem.repository.impl.RoomRepositoryimpl;

public class RoomServiceimpl {
//    private static CustomerService customerService;
//    private Session session;
//
//    private final CustomerRepository customerRepository;
//
//    private CustomerServiceImpl() {
//        customerRepository = CustomerRepositoryImpl.getInstance();
//    }
//
//    public static CustomerService getInstance() {
//        return null == customerService
//                ? customerService = new CustomerServiceImpl()
//                : customerService;
//    }
//
//    public Long saveCustomer(CustomerDto customerDto) { // We're getting a DTO type from the controller
//        session = SessionFactoryConfig.getInstance()
//                .getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            customerRepository.setSession(session);
//            Long id = customerRepository.save(customerDto.toEntity()); // We pass it to the repository by converting it to an entity
//            transaction.commit();
//            session.close();
//            return id;
//        } catch (Exception ex) {
//            transaction.rollback();
//            session.close();
//            ex.printStackTrace();
//            return -1L;
//        }
//    }
    private static RoomServiceimpl roomServiceimpl;
    private Session session;
//    private  final RoomRepositoryimpl roomRepositoryimpl;

    private RoomServiceimpl(){

    }
}
