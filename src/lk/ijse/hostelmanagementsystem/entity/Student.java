package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.StudentDTO;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
