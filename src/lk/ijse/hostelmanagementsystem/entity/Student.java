package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity

public class Student {
    @Id
    @Column(name = "sId", columnDefinition = "VARCHAR(64)")
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;
    @OneToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private List<Reservation> reservations = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String name, String address, String contactNo, LocalDate dob, String gender, List<Reservation> reservations) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
        this.setReservations(reservations);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }

    public StudentDTO toDto() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(this.studentId);
        studentDTO.setName(this.name);
        studentDTO.setAddress(this.address);
        studentDTO.setContactNo(this.contactNo);
        studentDTO.setDob(this.dob);
        studentDTO.setGender(this.gender);

        return studentDTO;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
