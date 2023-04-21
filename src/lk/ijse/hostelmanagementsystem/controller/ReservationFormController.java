package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostelmanagementsystem.Service.ServiceFactory;
import lk.ijse.hostelmanagementsystem.Service.custom.ReservationService;
import lk.ijse.hostelmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostelmanagementsystem.dto.RoomDTO;
import lk.ijse.hostelmanagementsystem.util.Navigation;
import lk.ijse.hostelmanagementsystem.util.Routes;
import lk.ijse.hostelmanagementsystem.view.tm.ReservationTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class ReservationFormController {

   private ReservationService reservationService = (ReservationService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.RESERVATIONSERVICE);
//    StudentService studentService = (StudentService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.STUDENTSERVICE);

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
    private TableView<ReservationTM> tblReservation;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colSId;

    @FXML
    private TableColumn<?, ?> colRId;

    @FXML
    private TableColumn<?, ?> colStatus;
//
//    @FXML
//    private TableColumn<?, ?> ColQty;

    @FXML
    private TableColumn<?, ?> colOption;
    @FXML
    private TableColumn<?, ?> colResNo;
    @FXML
    private JFXTextField txtReservationNo;

    @FXML
    private JFXComboBox<String> cmbStatus;
    @FXML
    private JFXTextField txtStudentId;

    private ObservableList<ReservationTM> obList = FXCollections.observableArrayList();

    public void initialize() {
        cmbrId.getItems().addAll(new String[]{"RM-1324", "RM-5467", "RM-7896", "RM-0093"});
        cmbStatus.getItems().addAll(new String[]{"Paid", "Pending payment"});
        setDate();
//        getStudentsId();
        generateId();
        setCellValueFactory();
//
    }


    private void setCellValueFactory() {
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        colSId.setCellValueFactory(new PropertyValueFactory("student_Id"));
        colRId.setCellValueFactory(new PropertyValueFactory("room_Id"));
        colResNo.setCellValueFactory(new PropertyValueFactory("resNo"));
        colStatus.setCellValueFactory(new PropertyValueFactory("status"));
        colOption.setCellValueFactory(new PropertyValueFactory("delete"));
        tblReservation.setItems(obList);

    }

    @FXML
    void AddbtnOnAction(ActionEvent event) {
        String res_id = txtReservationNo.getText();
        String student_id = txtStudentId.getText();
        LocalDate date = LocalDate.parse(txtDate.getText());
        String status = cmbStatus.getValue();
        String room_id = cmbrId.getValue();
        javafx.scene.control.Button btnDelete = new Button("Delete");

        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?");
            Optional<ButtonType> result = alert1.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                System.out.println("ok");
                ReservationTM tm = tblReservation.getSelectionModel().getSelectedItem();

                tblReservation.getItems().remove(tm);
            }
        });
        obList.add(new ReservationTM(date, student_id, room_id, res_id, status, btnDelete));
        System.out.println(obList);
        setCellValueFactory();
//        clearAll();

    }

    @FXML
    void ReservationbtnOnAction(ActionEvent event) {
        String res_id = txtReservationNo.getText();
        String student_id = txtStudentId.getText();
        LocalDate date = LocalDate.parse(txtDate.getText());
        String status = cmbStatus.getValue();
        String room_id = cmbrId.getValue();
        javafx.scene.control.Button btnDelete = new Button("Delete");

        boolean save = reservationService.save(new ReservationDTO(res_id, student_id,room_id,date,status));
        Alert alert;
        if (save) {
            alert = new Alert(Alert.AlertType.INFORMATION, "Registration has been successful");
            clearAll();
//            txtReservationNo.setText(generateId());
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Error");
        }
        alert.show();

    }

    private void clearAll() {
        txtReservationNo.setText(null);
        txtStudentId.setText(null);
        cmbrId.getSelectionModel().clearSelection();
        cmbStatus.getSelectionModel().clearSelection();
    }


    @FXML
    void cmbrIdOnAction(ActionEvent event) {
        String value = cmbrId.getValue();
        RoomDTO room = reservationService.getRoom(value);
        int notAvailableRoomCount = reservationService.getNotAvailableRoomCount(value);
        txtRoomsAvailability.setText(String.valueOf(room.getQty() - notAvailableRoomCount));
    }

//    private void getStudentsId() throws IOException {
//        List<String> allStudentIds = studentService.studentIdList();
//        cmbsId.setItems((ObservableList<String>) allStudentIds);
//    }

    @FXML
    void newStudentbtnOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STUDENTADDFORM,pane);
    }


    void setDate() {
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    private void generateId() {
        txtReservationNo.setText(reservationService.generateNewId());
    }

    @FXML
    void BackbtnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelmanagementsystem/view/DashBoardForm.fxml"))));
        stage.centerOnScreen();    }
}
