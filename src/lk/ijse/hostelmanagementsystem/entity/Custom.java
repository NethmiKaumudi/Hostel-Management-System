package lk.ijse.hostelmanagementsystem.entity;

import java.time.LocalDate;

public class Custom {
    private String res_id;
    private LocalDate date;
    private Student student;
    private Room room;
    private String status;
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;
    private String userName;
    private String password;

    public Custom() {
    }

    public Custom(String res_id, LocalDate date, Student student, Room room, String status, String room_type_id, String type, String key_money, int qty, String student_id, String name, String address, String contact_no, LocalDate dob, String gender, String userName, String password) {
        this.res_id = res_id;
        this.date = date;
        this.student = student;
        this.room = room;
        this.status = status;
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
    }
}
