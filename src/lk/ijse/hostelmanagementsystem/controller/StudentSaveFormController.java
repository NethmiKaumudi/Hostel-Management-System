package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class StudentSaveFormController {
    @FXML
    private AnchorPane pane;


    @FXML
    private JFXTextField txtsId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtNo;

    @FXML
    private JFXTextField txtdob;

    @FXML
    private JFXComboBox<String> cmbGender;

    public void initialize(){


    }

    @FXML
    void savebtnOnAction(ActionEvent event) {
    String sId=txtsId.getText();
    String studentName=txtName.getText();
    String address=txtAddress.getText();
    String contactNo=txtNo.getText();
    String dob=txtdob.getText();
   // String gender=cmbGender.getGender();

    }
    public void getGender(){
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("FeMale");

    }

}
