package lk.ijse.hostelmanagementsystem.repository;

import lk.ijse.hostelmanagementsystem.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student,String> {
    List<Student> getAllStudents();
    public List<String> getNewId();
    public List<String> getAllStudentIds() throws IOException ;

    }
