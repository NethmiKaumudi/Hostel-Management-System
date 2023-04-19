package lk.ijse.hostelmanagementsystem.repository.custom;

import lk.ijse.hostelmanagementsystem.entity.Student;
import lk.ijse.hostelmanagementsystem.repository.CrudRepository;

import java.io.IOException;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {
    List<Student> getAllStudents();

    List<String> getNewId();

    List<String> getAllStudentIds() throws IOException;

}
