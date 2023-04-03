package lk.ijse.hostelmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelmanagementsystem.dto.KeyMoney;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.dto.RoomTypes;

public class RoomFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    void addbtnOnAction(ActionEvent event) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setRoomTypeId("RM-1324");
        roomDTO.setType(String.valueOf(RoomTypes.AC));
        roomDTO.setKeyMoney(String.valueOf(KeyMoney.PAID_ALREADY));
        roomDTO.setQty(1);
    }


}
