package lk.ijse.hostelmanagementsystem.Service;

import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public String save(StudentDTO studentDTO);

    public boolean delete(StudentDTO studentDTO);

    public boolean update(StudentDTO studentDTO);

    public List<StudentDTO> getAllStudents();

    StudentDTO get(String id);
}
