package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostelmanagementsystem.Service.custom.ReservationService;
import lk.ijse.hostelmanagementsystem.Service.custom.StudentService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.ReservationServiceimpl;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.StudentServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class ReservationFormController {
    ReservationDTO reservationDTO = new ReservationDTO();
    ReservationService reservationService;
    StudentService studentService;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtDate;

//    @FXML
//    private JFXComboBox<String> cmbsId;

    @FXML
    private JFXComboBox<String> cmbrId;

    @FXML
    private JFXTextField txtRoomsAvailability;

    @FXML
    private TableView<?> tblReservation;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colsId;

    @FXML
    private TableColumn<?, ?> colrId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> ColQty;

    @FXML
    private TableColumn<?, ?> colOption;

    @FXML
    private JFXTextField txtReservationNo;

    @FXML
    private JFXComboBox<String> cmbStatus;
    @FXML
    private JFXTextField txtStudentId;


    public void initialize() throws IOException {
        reservationService = ReservationServiceimpl.getInstance();
        studentService = StudentServiceimpl.getInstance();
        cmbrId.getItems().addAll(new String[]{"RM-1324", "RM-5467", "RM-7896", "RM-0093"});
        cmbStatus.getItems().addAll(new String[]{"Paid", "Pending payment"});
        setDate();
//        getStudentsId();
        generateId();

    }

    @FXML
    void AddbtnOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) {

    }

    @FXML
    void cmbrIdOnAction(ActionEvent event) {
//        String value = cmbrId.getValue();
//        RoomDTO room = reservationBO.getRoom(value);
//        int notAvailableRoomCount = reservationBO.getNotAvailableRoomCount(value);
//        lblAvailableRoomQTY.setText(String.valueOf(room.getQty() - notAvailableRoomCount));
    }

//    private void getStudentsId() throws IOException {
//        List<String> allStudentIds = studentService.studentIdList();
//        cmbsId.setItems((ObservableList<String>) allStudentIds);
//    }

    @FXML
    void newStudentbtnOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/lk/ijse/hostelmanagementsystem/view/StudentAddForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }


    void setDate() {
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    private void generateId() {
        txtReservationNo.setText(reservationService.generateNewId());
    }

}
