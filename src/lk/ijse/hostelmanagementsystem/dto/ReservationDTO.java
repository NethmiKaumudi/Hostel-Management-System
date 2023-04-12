package lk.ijse.hostelmanagementsystem.dto;

import lk.ijse.hostelmanagementsystem.entity.Reservation;
import lk.ijse.hostelmanagementsystem.entity.Room;
import lk.ijse.hostelmanagementsystem.entity.Student;

import java.time.LocalDate;

public class ReservationDTO {
    private String resNo;
    private String sId;
    private String rId;
    private LocalDate date;
    private String status;
//    private Button delete;

    public ReservationDTO() {
    }

    public ReservationDTO(String resNo, String sId, String rId, LocalDate date, String status) {
        this.resNo = resNo;
        this.sId = sId;
        this.rId = rId;
        this.date = date;
        this.status = status;

    }

    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
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

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "resNo='" + resNo + '\'' +
                ", sId='" + sId + '\'' +
                ", rId='" + rId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setReservationId(this.resNo);
//        Date date = reservation.getDate();
//        reservation. LocalDate.of(date.getYear(), date.getMonth(), date.getDate());
        reservation.setDate(this.date);
        Student student = new Student();
        student.setStudentId(sId);
        reservation.setStudents(student);
        Room room = new Room();
        room.setRoomTypeId(rId);
        reservation.setRooms(room);
        reservation.setStatus(this.status);
        return reservation;
    }
}
