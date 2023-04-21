package lk.ijse.hostelmanagementsystem.dto;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.entity.Student;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ReservationDTO {
    private String resNo;
    private String sId;
    private String rId;
    private LocalDate date;
    private String status;

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setReservationId(this.resNo);
        reservation.setDate(this.date);
        Student student = new Student();
        student.setStudentId(sId);
        reservation.setStudents(student);
        Room room = new Room();
        room.setId(rId);
        reservation.setRooms(room);
        reservation.setStatus(this.status);
        return reservation;
    }
}
