package lk.ijse.hostelmanagementsystem.repository.custom.impl;

import lk.ijse.hostelmanagementsystem.entity.Custom;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.repository.custom.PaymentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryimpl implements PaymentRepository {

    private Session session;


//    public List<Object[]> getAll() {
//        Query query = session.createQuery("SELECT R FROM reservation AS R");
//        return query.list();
//
//    }
//
//
//    public ArrayList<Custom> getAllPendingPaymentStudent() {
//        ArrayList<Custom> customEntities = .getAllPendingPaymentStudent();
//        ArrayList<Custom> customDTOS = new ArrayList<>();
//        for (Custom c : customEntities) {
//            customDTOS.add(
//                    new Custom(
//                            c.getStudent_id(),
//                            c.getName(),
//                            c.getAddress(),
//                            c.getContact_no(),
//                            c.getDob(),
//                            c.getGender()
//                    )
//            );
//        }
//        return customDTOS;
//    }

    @Override
    public String Save(Reservation entity) {
        return null;
    }

    @Override
    public void delete(Reservation entity) {

    }

    @Override
    public void update(Reservation entity) {

    }

    @Override
    public Reservation get(String Id) {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public ArrayList<Custom> getAllPendingPaymentStudent() {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
        try {


            Query query = session.createQuery("SELECT s.studentId,s.name,s.address,s.contactNo,s.dob,s.gender FROM\n" +
                    "Student s INNER JOIN reservation r ON s.studentId=r.Student.studentId WHERE r.status=:status");
            query.setParameter("status", "Pending payment");
            List<Object[]> list = query.list();
//            transaction.commit();
            session.close();
            ArrayList<Custom> customEntities = new ArrayList();
            for (Object[] o : list) {
                customEntities.add(
                        new Custom(
                                (String) o[0],
                                (String) o[1],
                                (String) o[2],
                                (String) o[3],
                                (LocalDate) o[4],
                                (String) o[5])
                );
            }

            return customEntities;
        } catch (Exception e) {
//            transaction.rollback()
            e.printStackTrace();
            return null;
        }
    }
}
