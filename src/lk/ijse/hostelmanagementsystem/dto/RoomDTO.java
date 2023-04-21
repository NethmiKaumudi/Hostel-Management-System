package lk.ijse.hostelmanagementsystem.dto;

import lk.ijse.hostelmanagementsystem.entity.Room;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data

public class RoomDTO {
    private String RoomTypeId;
    private String type;
    private String keyMoney;
    private int qty;


    public Room toEntity() {
        Room room = new Room();
        room.setId(RoomTypeId);
        room.setType(this.type);
        room.setKeyMoney(this.keyMoney);
        room.setQty(this.qty);
        return room;
    }
}
