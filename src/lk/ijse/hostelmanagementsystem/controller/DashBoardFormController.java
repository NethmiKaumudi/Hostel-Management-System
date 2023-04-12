package lk.ijse.hostelmanagementsystem.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelmanagementsystem.Service.custom.DashboardService;
import lk.ijse.hostelmanagementsystem.Service.custom.QueryService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.DashBoardServiceimpl;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.QueryServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.CustomDTO;
import lk.ijse.hostelmanagementsystem.util.Navigation;
import lk.ijse.hostelmanagementsystem.util.Routes;
import lk.ijse.hostelmanagementsystem.view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    DashboardService dashboardService;
    QueryService queryService;
    @FXML
    private AnchorPane pane2;
    @FXML
    private AnchorPane pane3;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblPendingPayment;
    @FXML
    private Label lblTotalStudents;
    @FXML
    private Label lblAvailableRooms;
    @FXML
    private TableView<StudentTM> tblKeyMoneyNotPaid;
    @FXML
    private TableColumn<?, ?> colsId;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colAddress;
    @FXML
    private TableColumn<?, ?> colContactNo;
    @FXML
    private TableColumn<?, ?> colDob;
    @FXML
    private TableColumn<?, ?> colGender;

    public void initialize(URL location, ResourceBundle resources) {
        dashboardService = DashBoardServiceimpl.getInstance();
        queryService= QueryServiceimpl.getInstance();
        setDate();
        runningTime();
        try {
            setLblRegisteredStudent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLblRoomCount();
        setLblPendingPayment();
        tblKeyMoneyNotPaid.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblKeyMoneyNotPaid.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblKeyMoneyNotPaid.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblKeyMoneyNotPaid.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblKeyMoneyNotPaid.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblKeyMoneyNotPaid.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
        loadAll();
    }


    private void loadAll() {
        tblKeyMoneyNotPaid.getItems().clear();
        ArrayList<CustomDTO> allStudent = queryService.getAllPendingPaymentStudent();
        for (CustomDTO c : allStudent) {
            tblKeyMoneyNotPaid.getItems().add(
                    new StudentTM(
                            c.getStudentId(),
                            c.getName(),
                            c.getAddress(),
                            c.getContactNo(),
                            c.getDob(),
                            c.getGender()
                    )
            );
        }
    }

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STUDENTSAVEFORM, pane);

    }

    private void runningTime() {
        final Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa ");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String times = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(times);
                });
            }
        });
        thread.start();
    }

        private void setLblPendingPayment() {
        lblPendingPayment.setText(String.valueOf(dashboardService.getPendingPaymentCount()));
    }

    private void setLblRegisteredStudent() throws IOException {
        lblTotalStudents.setText(String.valueOf(dashboardService.getRegisteredStudent()));
    }

    private void setLblRoomCount() {
        lblAvailableRooms.setText(String.valueOf(dashboardService.getRoomCount()));
    }
}
