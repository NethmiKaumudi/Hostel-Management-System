package lk.ijse.hostelmanagementsystem.dto;

import lk.ijse.hostelmanagementsystem.entity.Student;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class StudentDTO {
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;

    public Student toEntity() {
        Student student = new Student();
        student.setStudentId(this.studentId);
        student.setName(this.name);
        student.setAddress(this.address);
        student.setContactNo(this.contactNo);
        student.setDob(this.dob);
        student.setGender(this.gender);
        return student;
    }
}
