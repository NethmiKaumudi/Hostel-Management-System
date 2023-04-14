package lk.ijse.hostelmanagementsystem.view.tm;


import javafx.scene.control.Button;

import java.time.LocalDate;

public class ReservationTM {
    private LocalDate date;
    private String student_Id;
    private String room_Id;
    private String resNo;
    private String status;
    private Button delete;

    public ReservationTM() {
    }

    public ReservationTM(LocalDate date, String sId, String rId, String resNo, String status, Button delete) {
        this.date = date;
        this.student_Id = sId;
        this.room_Id = rId;
        this.resNo = resNo;
        this.status = status;
        this.delete = delete;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    public String getRoom_Id() {
        return room_Id;
    }

    public void setRoom_Id(String room_Id) {
        this.room_Id = room_Id;
    }

    public String getResNo() {
        return resNo;
    }

    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "ReservationTM{" +
                "date=" + date +
                ", sId='" + student_Id + '\'' +
                ", rId='" + room_Id + '\'' +
                ", resNo='" + resNo + '\'' +
                ", status='" + status + '\'' +
                ", delete=" + delete +
                '}';
    }
}
