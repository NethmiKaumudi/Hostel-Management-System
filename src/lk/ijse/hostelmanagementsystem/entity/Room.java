package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "room")
public class Room {
    @Id
    @Column(name = "room_id", columnDefinition = "VARCHAR(64)")
    private String id;
    @Column(name = "room_type")
    private String type;
    @Column(name = "key_money")
    private String keyMoney;
    @Column(name = "quantity")
    private int qty;

    @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(String roomTypeId, String type, String keyMoney, int qty) {
        id = roomTypeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public String getRoomTypeId() {
        return id;
    }

    public void setRoomTypeId(String roomTypeId) {
        id = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomTypeId='" + id + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney='" + keyMoney + '\'' +
                ", qty=" + qty +
                '}';
    }

    public RoomDTO toDto() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomTypeId(this.id);
        roomDTO.setType(this.type);
        roomDTO.setKeyMoney(this.keyMoney);
        roomDTO.setQty(this.qty);
        return roomDTO;
    }
}