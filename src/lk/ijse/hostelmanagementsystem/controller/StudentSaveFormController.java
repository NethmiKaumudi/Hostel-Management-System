package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelmanagementsystem.Service.StudentService;
import lk.ijse.hostelmanagementsystem.Service.impl.StudentServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentSaveFormController implements Initializable {


    public JFXTextField txtstudentName;
    public JFXTextField txtCNo;
    StudentDTO studentDTO = new StudentDTO();
    StudentService studentService;
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtsId;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtdob;
    @FXML
    private JFXComboBox<String> cmbGender;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    private StudentDTO StudentDTO;


    public void getGender() {
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("FeMale");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getGender();
        initUi();
    }

    private void initUi() {
        txtsId.setDisable(true);
        txtstudentName.setDisable(true);
        txtAddress.setDisable(true);
        txtCNo.setDisable(true);
        txtdob.setDisable(true);
        cmbGender.setDisable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);


    }


    public void SavebtnOnAction(ActionEvent actionEvent) {
        String sId = txtsId.getText();
        String studentName = txtstudentName.getText();
        String address = txtAddress.getText();
        String contactNo = txtCNo.getText();
        LocalDate dob = LocalDate.parse(txtdob.getText());
        // String gender=cmbGender.getGender();
        String gender = cmbGender.getValue();
        studentDTO.setStudentId(sId);
        studentDTO.setName(studentName);
        studentDTO.setAddress(address);
        studentDTO.setContactNo(contactNo);
        studentDTO.setDob(dob);
        studentDTO.setGender(gender);
        studentService = StudentServiceimpl.getInstance();
        studentService.save(studentDTO);
        clearFields();

    }

    public void UpdatebtnOnAction(ActionEvent actionEvent) {
        String sId = txtsId.getText();
        String studentName = txtstudentName.getText();
        String address = txtAddress.getText();
        String contactNo = txtCNo.getText();
        LocalDate dob = LocalDate.parse(txtdob.getText());
        // String gender=cmbGender.getGender();
        String gender = cmbGender.getValue();
        studentService = StudentServiceimpl.getInstance();
        boolean update = studentService.update(new StudentDTO(sId, studentName, address, contactNo, dob, gender));
        if (update) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Updated!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Updated!").show();

        }
        clearFields();
    }

    public void DeletebtnOnAction(ActionEvent actionEvent) {

        studentService = StudentServiceimpl.getInstance();
        studentDTO.setStudentId(txtsId.getText());
        studentService.delete(studentDTO);
        clearFields();

    }

    public void txtsIdOnAction(ActionEvent actionEvent) {
        btnSave.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        studentService = StudentServiceimpl.getInstance();
        this.studentDTO = studentService.get(txtsId.getText());
        fillData();

    }

    private void fillData() {
        txtsId.setText(studentDTO.getStudentId());
        txtstudentName.setText(studentDTO.getName());
        txtAddress.setText(studentDTO.getAddress());
        txtCNo.setText(studentDTO.getContactNo());
        txtdob.setText(String.valueOf(studentDTO.getDob()));
        cmbGender.setValue(studentDTO.getGender());
    }

    public void clearFields() {
        txtsId.clear();
        txtstudentName.clear();
        txtAddress.clear();
        txtCNo.clear();
        txtdob.clear();
        cmbGender.getSelectionModel().clearSelection();
    }

    public void addbtnOnAction(ActionEvent actionEvent) {
        txtsId.setDisable(false);
        txtstudentName.setDisable(false);
        txtAddress.setDisable(false);
        txtCNo.setDisable(false);
        txtdob.setDisable(false);
        cmbGender.setDisable(false);
        txtsId.clear();
        txtstudentName.clear();
        txtAddress.clear();
        txtCNo.clear();
        txtdob.clear();
        cmbGender.getSelectionModel().clearSelection();
        txtsId.requestFocus();
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
    }
}
