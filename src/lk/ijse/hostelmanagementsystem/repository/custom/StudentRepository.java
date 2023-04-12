package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.io.IOException;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student,String> {
    List<Student> getAllStudents();
    public List<String> getNewId();
    public List<String> getAllStudentIds() throws IOException ;

    }
