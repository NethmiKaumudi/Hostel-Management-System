package lk.ijse.hostelmanagementsystem.entity;

import java.util.Date;

public class Reservation {
    private String reservationId;
    private Date date;
    private String studentId;
    private String roomTypeId;
    private String status;

    public Reservation() {
    }

    public Reservation(String reservationId, Date date, String studentId, String roomTypeId, String status) {
        this.reservationId = reservationId;
        this.date = date;
        this.studentId = studentId;
        this.roomTypeId = roomTypeId;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", date=" + date +
                ", studentId='" + studentId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
