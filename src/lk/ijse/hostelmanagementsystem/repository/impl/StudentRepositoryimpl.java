package lk.ijse.hostelmanagementsystem.repository.impl;

import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepositoryimpl implements StudentRepository {
    private static StudentRepositoryimpl studentRepositoryimpl;
    private Session session;

    private StudentRepositoryimpl() {

    }

    public static StudentRepositoryimpl getInstance() {
        return studentRepositoryimpl == null ? studentRepositoryimpl = new StudentRepositoryimpl() : studentRepositoryimpl;
    }


    @Override
    public String Save(Student entity) {
        return (String) session.save(entity);
    }

    @Override
    public void delete(Student student) {
         session.delete(student);
    }

    @Override
    public void update(Student entity) {
        session.update(entity);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Student get(String sId) {
//        Student student = session.get(Student.class, sId);
//        return (List<Student>) student;
        return session.get(Student.class,sId);


    }
//    public void update(Customer customer) {
//        session.update(customer);
//    }

    @Override
    public List<Student> getAllStudents() {
        String sqlQuery = "FROM Student";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }
}
