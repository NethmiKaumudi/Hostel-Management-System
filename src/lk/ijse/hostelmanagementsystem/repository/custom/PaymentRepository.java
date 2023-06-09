package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Reservation, String> {
    List<StudentDTO> getAllPendingPaymentStudent();

    Long getAllPendingPaymentCount();
}
