package lk.ijse.hostelmanagementsystem.Service.impl;

import javafx.scene.control.Alert;
import lk.ijse.hostelmanagementsystem.Service.StudentService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.StudentRepository;
import lk.ijse.hostelmanagementsystem.repository.impl.StudentRepositoryimpl;
import lk.ijse.hostelmanagementsystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceimpl implements StudentService {
    private static StudentServiceimpl studentServiceimpl;
    StudentRepository studentRepository;
    private Session session;

    private StudentServiceimpl() {
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
            new Alert(Alert.AlertType.CONFIRMATION, "Student Saved!").showAndWait();

            return save;


        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            new Alert(Alert.AlertType.ERROR, "Not Saved!").show();


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
            new Alert(Alert.AlertType.CONFIRMATION, "Student Delete!").showAndWait();


            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Not Deleted!").showAndWait();

            return false;
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
//        session = SessionFactoryConfig.getInstance()
//                .getSession();
//        customerRepository.setSession(session);
//        List<Customer> allCustomers = customerRepository.getAllCustomers(); // Here we're getting Entity type object result
//        List<CustomerDto> customerDtoList = new ArrayList<>();
//        for (Customer customer : allCustomers) {
//            customerDtoList.add(customer.toDto()); // We convert the Entity back to a dto type before return to the controller
//        }
//        return customerDtoList;
        session = SessionFactoryConfig.getInstance().getSession();
        studentRepository.setSession(session);
        List<Student> allStudents = studentRepository.getAllStudents();
        List<StudentDTO> studentDTOList = new ArrayList<>();
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
            new Alert(Alert.AlertType.CONFIRMATION, "Student Updated!").showAndWait();

            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "not Updated!").showAndWait();

            return false;
        }
    }
}
