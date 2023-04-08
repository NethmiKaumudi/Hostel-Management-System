package lk.ijse.hostelmanagementsystem.repository;

import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,String> {
    List<Student> getAllStudents();

}
