package lk.ijse.hostelmanagementsystem.Service.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.Service.custom.StudentService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.custom.StudentRepository;
import lk.ijse.hostelmanagementsystem.repository.custom.impl.StudentRepositoryimpl;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class StudentServiceimpl implements StudentService {
    private static StudentServiceimpl studentServiceimpl;
    StudentRepository studentRepository;
    private Session session;

    public StudentServiceimpl() {
        studentRepository = StudentRepositoryimpl.getInstance();
    }


    public static StudentServiceimpl getInstance() {
        return studentServiceimpl == null ? studentServiceimpl = new StudentServiceimpl() : studentServiceimpl;
    }


    @Override
    public String save(StudentDTO studentDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentRepository.setSession(session);
            String save = studentRepository.Save(studentDTO.toEntity());
            transaction.commit();
            session.close();

            return save;


        } catch (Exception ex) {
            transaction.rollback();
            session.close();


            return null;
        }

    }

    @Override
    public boolean delete(StudentDTO studentDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentRepository.setSession(session);
            studentRepository.delete(studentDTO.toEntity());
            transaction.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public ObservableList<StudentDTO> getAllStudents() {
        session = SessionFactoryConfig.getInstance().getSession();
        studentRepository.setSession(session);
        List<Student> allStudents = studentRepository.getAllStudents();
        ObservableList<StudentDTO> studentDTOList = FXCollections.observableArrayList();
        for (Student student : allStudents) {
            studentDTOList.add(student.toDto());
        }
        return studentDTOList;
    }

    @Override
    public StudentDTO get(String sId) {
        session = SessionFactoryConfig.getInstance().getSession();
        studentRepository.setSession(session);
        Student student = studentRepository.get(sId);
        session.close();
        return student.toDto();
    }

    public boolean update(StudentDTO studentDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentRepository.setSession(session);
            studentRepository.update(studentDTO.toEntity());
            transaction.commit();
            session.close();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();

            return false;
        }
    }
    public String generateNewId() {
        String newStudentId ="S001";
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        String sql="SELECT sId FROM student ORDER BY sId DESC LIMIT 1";
//        List<String> list = session.createSQLQuery(sql).list();
        studentRepository.setSession(session);
        List<String> list = studentRepository.getNewId();

        for (String id : list) {
            if (id!=null){
                int num = Integer.valueOf(id.substring(1));
                num++;

                if (num<=9){
                    newStudentId="S00"+num;
                }else if (num>9&&num<100){
                    newStudentId="S0"+num;
                }else if (num>=100){
                    newStudentId="S"+num;
                }
            }
        }

        transaction.commit();
        session.close();
        return  newStudentId;
    }
    public ObservableList<String> studentIdList() throws IOException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ObservableList<String> idList =FXCollections.observableArrayList();

//        String hql="SELECT studentId FROM Student";
//        List<String> list = session.createQuery(hql).list();
        studentRepository.setSession(session);
        List<String> list = studentRepository.getAllStudentIds();
        for (String id : list) {
            idList.add(id);
        }

        transaction.commit();
        session.close();
        return idList;
    }
}
