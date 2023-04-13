package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.hostelmanagementsystem.Service.ServiceFactory;
import lk.ijse.hostelmanagementsystem.Service.custom.UserService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.StudentServiceimpl;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.UserServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingController {
    UserDTO userDTO=new UserDTO();
//    UserService userService;
UserService userService = (UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USERSERVICE);

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtnewUserName;

    @FXML
    private JFXTextField txtNewPassWord;

    @FXML
    private JFXTextField txtReNewPassWord;

    @FXML
    private Label lblnewUserName;

    @FXML
    private Label lblnewPassWord;

    @FXML
    private Label lblrenewPassword;

    public void initialize(){
    }

    @FXML
    void btnchangeOnAction(ActionEvent event) {
        String userName = txtnewUserName.getText();
        String password = txtNewPassWord.getText();
        String rePassword = txtReNewPassWord.getText();

        lblnewUserName.setText(null);
        lblnewPassWord.setText(null);
        lblrenewPassword.setText(null);
        if (password.equals(rePassword)) {
            boolean isUpdated = userService.update(new UserDTO(userName,password));
//            userService.save(userDTO);
            Alert alert;
            if (isUpdated) {
                alert = new Alert(Alert.AlertType.INFORMATION, "Password and UserName has been successfully Update");
                txtnewUserName.setText(null);
                txtNewPassWord.setText(null);
                txtReNewPassWord.setText(null);
            } else {
                alert = new Alert(Alert.AlertType.ERROR, "Error");
            }
            alert.show();
        } else {
            lblrenewPassword.setText("Is not matched");
            txtNewPassWord.requestFocus();
            txtReNewPassWord.setText(null);
        }

    }
    @FXML
    void txtUserNameOnAction(ActionEvent event) {
//        studentService = StudentServiceimpl.getInstance();
//        this.studentDTO = studentService.get(txtsId.getText());
        userDTO=userService.get(txtnewUserName.getText());
//        txtsId.setText(studentDTO.getStudentId());
        txtnewUserName.setText(userDTO.getUserName());
        txtNewPassWord.setText(userDTO.getPassWord());

    }


    @FXML
    void txtrePassWordKeyTypeOnAction(KeyEvent event) {

    }

}
