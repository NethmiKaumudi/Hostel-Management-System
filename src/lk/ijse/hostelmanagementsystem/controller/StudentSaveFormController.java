package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import lk.ijse.hostelmanagementsystem.Service.custom.StudentService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.StudentServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.StudentDTO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentSaveFormController implements Initializable {


    public JFXTextField txtstudentName;
    public JFXTextField txtCNo;
    public TableView<StudentDTO> tblStudent;
    StudentDTO studentDTO = new StudentDTO();
    StudentService studentService;
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtsId;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXDatePicker txtdob;
    @FXML
    private JFXComboBox<String> cmbGender;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableColumn<?, ?> colsId;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colAddress;
    @FXML
    private TableColumn<?, ?> colContactNo;
    @FXML
    private TableColumn<?, ?> coldob;
    @FXML
    private TableColumn<?, ?> colGender;
    @FXML
    private Label lblName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContactNo;
    //    private StudentDTO StudentDTO;
    private Matcher nameMatcher;
    private Matcher addressMatcher;
    private Matcher contctNoMatcher;

    public void getGender() {
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("FeMale");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getGender();
        setPatterns();
        initUi();
        loadAllData();
        try {
            generateId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        colsId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValuue, newValue) -> {
            setData(newValue);
        });
    }

    private void setPatterns() {

        Pattern namePattern = Pattern.compile("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$");
        nameMatcher = namePattern.matcher(txtstudentName.getText());
        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{1,10}$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());
        Pattern contactNoPattern = Pattern.compile("^(?:7|0|(?:\\\\+94))[0-9]{9,10}$");
        contctNoMatcher = contactNoPattern.matcher(txtCNo.getText());

    }

    private void setData(StudentDTO newValue) {
        if (newValue != null) {
            txtsId.setText(newValue.getStudentId());
            txtstudentName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtCNo.setText(newValue.getContactNo());
            txtdob.setValue(newValue.getDob());
            cmbGender.setValue(newValue.getGender());
        }
    }

    private void initUi() {
        txtsId.setDisable(false);
        txtstudentName.setDisable(true);
        txtAddress.setDisable(true);
        txtCNo.setDisable(true);
        txtdob.setDisable(true);
        cmbGender.setDisable(true);
        txtsId.setEditable(false);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);


    }


    public void SavebtnOnAction(ActionEvent actionEvent) {
        if (nameMatcher.matches()) {
            if (addressMatcher.matches()) {
                if (contctNoMatcher.matches()) {

                }
            }
        }
        String sId = txtsId.getText();
        String studentName = txtstudentName.getText();
        String address = txtAddress.getText();
        String contactNo = txtCNo.getText();
        LocalDate dob = txtdob.getValue();
        // String gender=cmbGender.getGender();
        String gender = cmbGender.getValue();
        studentDTO.setStudentId(sId);
        studentDTO.setName(studentName);
        studentDTO.setAddress(address);
        studentDTO.setContactNo(contactNo);
        studentDTO.setDob(dob);
        studentDTO.setGender(gender);
        studentService = StudentServiceimpl.getInstance();
        String save = studentService.save(studentDTO);
        if (save != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Saved!").showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Not Saved!").show();

        }
        loadAllData();
        clearFields();

    }

    public void UpdatebtnOnAction(ActionEvent actionEvent) {
        String sId = txtsId.getText();
        String studentName = txtstudentName.getText();
        String address = txtAddress.getText();
        String contactNo = txtCNo.getText();
        LocalDate dob = txtdob.getValue();

        // String gender=cmbGender.getGender();
        String gender = cmbGender.getValue();
        studentService = StudentServiceimpl.getInstance();
        boolean update = studentService.update(new StudentDTO(sId, studentName, address, contactNo, dob, gender));
        if (update) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Updated!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Not Updated!").show();

        }
        loadAllData();
        clearFields();
    }

    public void DeletebtnOnAction(ActionEvent actionEvent) {

        studentService = StudentServiceimpl.getInstance();
        studentDTO.setStudentId(txtsId.getText());
        boolean delete = studentService.delete(studentDTO);
        if (delete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Delete!").showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Not Deleted!").show();

        }
        loadAllData();
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
        txtdob.setValue(studentDTO.getDob());
        cmbGender.setValue(studentDTO.getGender());
    }

    public void clearFields() {
        txtsId.clear();
        txtstudentName.clear();
        txtAddress.clear();
        txtCNo.clear();
        txtdob.setValue(null);
        cmbGender.getSelectionModel().clearSelection();
    }

    public void addbtnOnAction(ActionEvent actionEvent) {
        txtsId.setDisable(false);
        txtstudentName.setDisable(false);
        txtAddress.setDisable(false);
        txtCNo.setDisable(false);
        txtdob.setDisable(false);
        cmbGender.setDisable(false);
        txtstudentName.clear();
        txtAddress.clear();
        txtCNo.clear();
        txtdob.setValue(null);
        cmbGender.getSelectionModel().clearSelection();
        txtstudentName.requestFocus();
        txtsId.setEditable(false);
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
    }

    private void generateId() throws IOException {
        txtsId.setText(studentService.generateNewId());
    }

    public void loadAllData() {
        studentService = StudentServiceimpl.getInstance();
        tblStudent.setItems(studentService.getAllStudents());
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
    void txtcontactNumberKeyTypedOnAction(KeyEvent event) {
        lblContactNo.setText("");
        txtCNo.setFocusColor(Paint.valueOf("Black"));

        Pattern contactNoPattern = Pattern.compile("^(?:7|0|(?:\\\\+94))[0-9]{9,10}$");
        contctNoMatcher = contactNoPattern.matcher(txtCNo.getText());

        if (!contctNoMatcher.matches()) {
            txtCNo.requestFocus();
            txtCNo.setFocusColor(Paint.valueOf("Red"));
            lblContactNo.setText("invalid contact Number");
        }
    }

    @FXML
    void txtsNameKeyTypedOnAction(KeyEvent event) {
        lblName.setText("");
        txtstudentName.setFocusColor(Paint.valueOf("Black"));

        Pattern namePattern = Pattern.compile("^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$");
        nameMatcher = namePattern.matcher(txtstudentName.getText());
        if (!nameMatcher.matches()) {
//            System.out.println(txtUserName.getText());
            txtstudentName.requestFocus();
            txtstudentName.setFocusColor(Paint.valueOf("Red"));
            lblAddress.setText("invalid Name");
        }
    }

}
