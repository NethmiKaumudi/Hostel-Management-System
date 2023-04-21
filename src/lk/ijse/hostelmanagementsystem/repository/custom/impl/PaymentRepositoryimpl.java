package lk.ijse.hostelmanagementsystem.repository.custom.impl;

import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.repository.custom.PaymentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentRepositoryimpl implements PaymentRepository {

    private Session session;
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

    public List<StudentDTO> getAllPendingPaymentStudent() {
        try {
            Query query = session.createQuery("SELECT new  lk.ijse.hostelmanagementsystem.dto.StudentDTO(s.studentId,s.name,s.address,s.contactNo,s.dob,s.gender)\n" +
                    "FROM Student AS s INNER JOIN reservation AS r ON s.studentId=r.students.studentId\n" +
                    "WHERE r.status=:status");
            query.setParameter("status", "Pending payment");
            List<StudentDTO> list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Long getAllPendingPaymentCount() {
        try {
            Query query = session.createQuery("SELECT COUNT(r)\n" +
                    "FROM reservation AS r\n" +
                    "WHERE r.status=:status");
            query.setParameter("status", "Pending payment");
            Long count = (Long) query.uniqueResult();
            session.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
