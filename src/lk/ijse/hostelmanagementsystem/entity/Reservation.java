package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "reservation")
public class Reservation {
    @Id
    @Column( columnDefinition = "VARCHAR(64)")
    private String reservationId;
    private LocalDate date;
    private String status;

    @ManyToOne
    private Student students;

    @ManyToOne
    private Room rooms;

    public Reservation() {
    }

    public Reservation(String reservationId, LocalDate date, String status, Student students, Room rooms) {
        this.reservationId = reservationId;
        this.date = date;
        this.status = status;
        this.students = students;
        this.rooms = rooms;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Room getRooms() {
        return rooms;
    }

    public void setRooms(Room rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", students=" + students +
                ", rooms=" + rooms +
                '}';
    }

}
