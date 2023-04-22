package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.hostelmanagementsystem.Service.ServiceFactory;
import lk.ijse.hostelmanagementsystem.Service.custom.StudentService;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentAddFormController {

    StudentDTO studentDTO = new StudentDTO();
    //    StudentService studentService = null;
    private StudentService studentService = (StudentService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.STUDENTSERVICE);

    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtsId;
    @FXML
    private JFXComboBox<String> cmbGender;
    @FXML
    private JFXDatePicker txtDOB;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtContactNo;


    @FXML
    private Button btnAdd;
    @FXML
    private Label lblName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblcNo;
    private Matcher nameMatcher;
    private Matcher addressMatcher;
    private Matcher contctNoMatcher;

    public void initialize() {
//        studentService = StudentServiceimpl.getInstance();
        initUi();
        generateId();
        setPatterns();
        cmbGender.getItems().addAll("Male", "Female");

    }

    private void setPatterns() {
        Pattern namePattern = Pattern.compile("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$");
        nameMatcher = namePattern.matcher(txtName.getText());
        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{1,10}$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());
        Pattern contactNoPattern = Pattern.compile("^(?:7|0|(?:\\\\+94))[0-9]{9,10}$");
        contctNoMatcher = contactNoPattern.matcher(txtContactNo.getText());

    }

    @FXML
    void txtNameKeyTypedOnAction(KeyEvent event) {
        lblName.setText("");
        txtName.setFocusColor(Paint.valueOf("Black"));

        Pattern namePattern = Pattern.compile("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$");
        nameMatcher = namePattern.matcher(txtName.getText());
        if (!nameMatcher.matches()) {
//            System.out.println(txtUserName.getText());
            txtName.requestFocus();
            txtName.setFocusColor(Paint.valueOf("Red"));
            lblName.setText("invalid Name");
        }
    }

    @FXML
    void txtaddressKeyTypedOnAction(KeyEvent event) {
        lblAddress.setText("");
        txtAddress.setFocusColor(Paint.valueOf("Black"));
        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{1,10}$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());


        if (!addressMatcher.matches()) {
            txtAddress.requestFocus();
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddress.setText("invalid address");
        }
    }

    @FXML
    void txtcNoKeyTypedOnAction(KeyEvent event) {
        lblcNo.setText("");
        txtContactNo.setFocusColor(Paint.valueOf("Black"));

        Pattern contactNoPattern = Pattern.compile("^(?:7|0|(?:\\\\+94))[0-9]{9,10}$");
        contctNoMatcher = contactNoPattern.matcher(txtContactNo.getText());

        if (!contctNoMatcher.matches()) {
            txtContactNo.requestFocus();
            txtContactNo.setFocusColor(Paint.valueOf("Red"));
            lblcNo.setText("invalid contact Number");
        }
    }

    private void generateId() {
        txtsId.setText(studentService.generateNewId());
    }

    @FXML
    void addbtnOnAction(ActionEvent event) {
        if (nameMatcher.matches()) {
            if (addressMatcher.matches()) {
                if (contctNoMatcher.matches()) {

                }
            }
        }
        String sId = txtsId.getText();
        String studentName = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        LocalDate dob = txtDOB.getValue();
        // String gender=cmbGender.getGender();
        String gender = cmbGender.getValue();
        studentDTO.setStudentId(sId);
        studentDTO.setName(studentName);
        studentDTO.setAddress(address);
        studentDTO.setContactNo(contactNo);
        studentDTO.setDob(dob);
        studentDTO.setGender(gender);
        String save = studentService.save(studentDTO);
        if (save != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "New Student Added!").showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Not Saved!").show();

        }

        clearFields();
    }

    private void clearFields() {
        txtsId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDOB.setValue(null);
        cmbGender.getSelectionModel().clearSelection();
    }

    @FXML
    void addnewStudentbtnOnAction(ActionEvent event) {
        txtsId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        txtContactNo.setDisable(false);
        txtDOB.setDisable(false);
        cmbGender.setDisable(false);
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDOB.setValue(null);
        cmbGender.getSelectionModel().clearSelection();
        txtName.requestFocus();
        txtsId.setEditable(false);
        btnAdd.setDisable(false);

    }

    private void initUi() {
        txtsId.setDisable(false);
        txtName.setDisable(true);
        txtAddress.setDisable(true);
        txtContactNo.setDisable(true);
        txtDOB.setDisable(true);
        cmbGender.setDisable(true);
        txtsId.setEditable(false);
        btnAdd.setDisable(true);


    }
}
