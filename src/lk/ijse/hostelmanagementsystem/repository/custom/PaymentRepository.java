package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Custom;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.util.ArrayList;

public interface PaymentRepository extends CrudRepository<Reservation,String> {
//    public List<Object[]> getAll();
public ArrayList<Custom> getAllPendingPaymentStudent();
}
