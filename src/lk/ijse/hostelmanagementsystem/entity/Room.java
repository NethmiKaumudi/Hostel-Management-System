package lk.ijse.hostelmanagementsystem.entity;

import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lombok.*;
import org.hibernate.annotations.Cache;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
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


    public RoomDTO toDto() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomTypeId(this.id);
        roomDTO.setType(this.type);
        roomDTO.setKeyMoney(this.keyMoney);
        roomDTO.setQty(this.qty);
        return roomDTO;
    }
}