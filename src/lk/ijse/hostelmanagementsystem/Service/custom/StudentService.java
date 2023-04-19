package lk.ijse.hostelmanagementsystem.Service.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.Service.SuperService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface StudentService extends SuperService {
    String save(StudentDTO studentDTO);

    boolean delete(StudentDTO studentDTO);

    boolean update(StudentDTO studentDTO);

    ObservableList<StudentDTO> getAllStudents();

    StudentDTO get(String id);

    String generateNewId();

    List<String> studentIdList() throws IOException;
}
