package lk.ijse.hostelmanagementsystem.Service.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    public String save(StudentDTO studentDTO);

    public boolean delete(StudentDTO studentDTO);

    public boolean update(StudentDTO studentDTO);

    public ObservableList<StudentDTO> getAllStudents();

    StudentDTO get(String id);

    String generateNewId();

    public List<String> studentIdList() throws IOException;
}
