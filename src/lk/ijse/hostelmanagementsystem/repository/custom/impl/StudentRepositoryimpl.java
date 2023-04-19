package lk.ijse.hostelmanagementsystem.repository.custom.impl;

import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.custom.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class StudentRepositoryimpl implements StudentRepository {
    private Session session;


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
        return session.get(Student.class, sId);


    }

    @Override
    public List<Student> getAllStudents() {
        String q = "FROM Student";
        Query query = session.createQuery(q);
        List list = query.list();
        return list;
    }

    public List<String> getNewId() {
        String sql="SELECT sId FROM student ORDER BY sId DESC LIMIT 1";
        return session.createSQLQuery(sql).list();
    }


    public List<String> getAllStudentIds() throws IOException {
        String hql="SELECT studentId FROM Student";
        return session.createQuery(hql).list();

    }
}
