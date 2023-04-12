package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.projection.Custom;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface PaymentRepository extends CrudRepository<Reservation,String> {
//    public List<Object[]> getAll();
public ArrayList<Custom> getAllPendingPaymentStudent();
}
