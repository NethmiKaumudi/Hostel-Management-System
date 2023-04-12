package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.hostelmanagementsystem.Service.custom.RoomService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.RoomServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomFormController implements Initializable {
    RoomDTO roomDTO = new RoomDTO();
    RoomService roomService;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<RoomDTO> tblRoom;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colKeyMoney;

    @FXML
    private TableColumn<?, ?> colQty;


    @FXML
    private JFXComboBox<String> cmbRoomType;
    @FXML
    private JFXComboBox<String> cmbRoomTypeId;

    @FXML
    private JFXTextField txtQuantity;
    @FXML
    private JFXTextField txtKeyMoney;
    @FXML
    private Label lblKeyMoney;

    @FXML
    private Label lblQuantity;
    private Matcher keyMoneyMatcher;
    private Matcher qtyMatcher;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getRoomIds();
        getRoomTypes();
        initUi();
        setPatterns();
        loadAlldata();
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("RoomTypeId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValuue, newValue) -> {
            setData(newValue);
        });
    }

    private void setPatterns() {
        Pattern KeyMoneyPattern = Pattern.compile("^(?!(?:^[-+]?[0.]+(?:[Ee]|$)))(?!(?:^-))(?:(?:[+-]?)(?=[0123456789.])(?:(?:(?:[0123456789]+)(?:(?:[.])(?:[0123456789]*))?|(?:(?:[.])(?:[0123456789]+))))(?:(?:[Ee])(?:(?:[+-]?)(?:[0123456789]+))|))$");
        keyMoneyMatcher = KeyMoneyPattern.matcher(txtKeyMoney.getText());
        Pattern qtyPattern = Pattern.compile("^[1-9]\\d*$");
        qtyMatcher = qtyPattern.matcher(txtQuantity.getText());
    }

    @FXML
    void txtkeyMoneyKeyTypedOnAction(KeyEvent event) {
        lblKeyMoney.setText("");
        txtKeyMoney.setFocusColor(Paint.valueOf("Black"));
        Pattern KeyMoneyPattern = Pattern.compile("^(?!(?:^[-+]?[0.]+(?:[Ee]|$)))(?!(?:^-))(?:(?:[+-]?)(?=[0123456789.])(?:(?:(?:[0123456789]+)(?:(?:[.])(?:[0123456789]*))?|(?:(?:[.])(?:[0123456789]+))))(?:(?:[Ee])(?:(?:[+-]?)(?:[0123456789]+))|))$");
        keyMoneyMatcher = KeyMoneyPattern.matcher(txtKeyMoney.getText());

        if (!keyMoneyMatcher.matches()) {
            txtKeyMoney.requestFocus();
            txtKeyMoney.setFocusColor(Paint.valueOf("Red"));
            lblKeyMoney.setText("invalid keymoney");
        }
    }

    @FXML
    void txtqtyKeyTypedOnAction(KeyEvent event) {
        lblQuantity.setText("");
        txtQuantity.setFocusColor(Paint.valueOf("Black"));
        Pattern qtyPattern = Pattern.compile("^[1-9]\\d*$");
        qtyMatcher = qtyPattern.matcher(txtQuantity.getText());
        if (!qtyMatcher.matches()) {
            txtQuantity.requestFocus();
            txtQuantity.setFocusColor(Paint.valueOf("Red"));
            lblQuantity.setText("invalid qty");
        }
    }
    private void setData(RoomDTO newValue) {
        if (newValue != null) {
            cmbRoomTypeId.setValue(newValue.getRoomTypeId());
            cmbRoomType.setValue(newValue.getType());
            txtKeyMoney.setText(newValue.getKeyMoney());
            txtQuantity.setText(String.valueOf(newValue.getQty()));
        }
    }


    private void loadAlldata() {
        roomService = RoomServiceimpl.getInstance();
        tblRoom.setItems(roomService.getAllRooms());
    }

    private void getRoomIds() {
        cmbRoomTypeId.getItems().add("RM-1324");
        cmbRoomTypeId.getItems().add("RM-5467");
        cmbRoomTypeId.getItems().add("RM-7896");
        cmbRoomTypeId.getItems().add("RM-0093");
    }

    private void clearFields() {
        cmbRoomTypeId.getSelectionModel().clearSelection();
        cmbRoomType.getSelectionModel().clearSelection();
        txtKeyMoney.clear();
        txtQuantity.clear();
    }

    @FXML
    void AddbtnOnAction(ActionEvent event) {

        cmbRoomTypeId.setDisable(false);
        cmbRoomType.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtQuantity.setDisable(false);
        txtKeyMoney.clear();
        txtQuantity.clear();
        cmbRoomType.getSelectionModel().clearSelection();
        cmbRoomTypeId.requestFocus();
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
    }

    @FXML
    void deletebtnOnAction(ActionEvent event) {
        roomService = RoomServiceimpl.getInstance();
        roomDTO.setRoomTypeId(cmbRoomTypeId.getValue());
        boolean delete = roomService.delete(roomDTO);
        if (delete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room Delete!").showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Not Deleted!").show();

        }
        loadAlldata();
        clearFields();
    }

    @FXML
    void savebtnOnAction(ActionEvent event) {
        if (keyMoneyMatcher.matches()){
            if (qtyMatcher.matches()){

            }
        }
        String rId = cmbRoomTypeId.getValue();
        String type = cmbRoomType.getValue();
        String KeyMoney = txtKeyMoney.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        roomDTO.setRoomTypeId(rId);
        roomDTO.setType(type);
        roomDTO.setKeyMoney(KeyMoney);
        roomDTO.setQty(quantity);
        roomService = RoomServiceimpl.getInstance();
        String save = roomService.save(roomDTO);
        if (save != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room Saved!").showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Not Saved!").show();

        }
        loadAlldata();
        clearFields();
    }

    @FXML
    void cmbRoomTypeIdOnAction(ActionEvent event) {
        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        roomService = RoomServiceimpl.getInstance();
        this.roomDTO = roomService.get(cmbRoomTypeId.getValue());
        fillData();
    }

    private void fillData() {
        cmbRoomTypeId.setValue(roomDTO.getRoomTypeId());
        cmbRoomType.setValue(roomDTO.getType());
        txtKeyMoney.setText(roomDTO.getKeyMoney());
        txtQuantity.setText(String.valueOf(roomDTO.getQty()));
    }
    private void initUi() {
        cmbRoomTypeId.setDisable(false);
        cmbRoomType.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtQuantity.setDisable(true);
        cmbRoomTypeId.setEditable(false);
        cmbRoomType.setEditable(false);
//        btnAdd.setDisable(true);


    }
    @FXML
    void updatebtnOnAction(ActionEvent event) {

        String rId = cmbRoomTypeId.getValue();
        String type = cmbRoomType.getValue();
        String KeyMoney = txtKeyMoney.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        roomService = RoomServiceimpl.getInstance();
        boolean update = roomService.update(new RoomDTO(rId, type, KeyMoney, quantity));
        if (update) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room Updated!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Updated!").show();

        }
        loadAlldata();
        clearFields();
    }

    public void getRoomTypes() {
        cmbRoomType.getItems().add("AC");
        cmbRoomType.getItems().add("NON-AC");
        cmbRoomType.getItems().add("AC & FOOD");
        cmbRoomType.getItems().add("NON-AC & FOOD");


    }

}
