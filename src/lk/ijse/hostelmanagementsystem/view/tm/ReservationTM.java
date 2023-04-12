package lk.ijse.hostelmanagementsystem.view.tm;


import javafx.scene.control.Button;

import java.time.LocalDate;

public class ReservationTM {
    private LocalDate date;
    private String sId;
    private String rId;
    private String resNo;
    private String status;
    private Button delete;

    public ReservationTM() {
    }

    public ReservationTM(LocalDate date, String sId, String rId, String resNo, String status, Button delete) {
        this.date = date;
        this.sId = sId;
        this.rId = rId;
        this.resNo = resNo;
        this.status = status;
        this.delete = delete;
    }

    public ReservationTM(LocalDate date,  String student_id, String room_id,String res_id, String status) {
        this.date=date;
        this.sId=student_id;
        this.rId=room_id;
        this.resNo=res_id;
        this.status=status;
    }

    //    public ReservationTM(String resNo, LocalDate date, String getrId, String getsId, String status) {
//    }

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

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "ReservationTM{" +
                "resNo='" + resNo + '\'' +
                ", sId='" + sId + '\'' +
                ", rId='" + rId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", delete=" + delete +
                '}';
    }
}
