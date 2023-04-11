package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostelmanagementsystem.Service.custom.UserService;
import lk.ijse.hostelmanagementsystem.Service.custom.impl.UserServiceimpl;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;

import java.io.IOException;

import static javafx.scene.paint.Color.RED;

public class LoginFormController {
//    UserDTO userDTO = new UserDTO();
    UserService userService;
    @FXML
    private AnchorPane pane;

    @FXML
    private Label lbluserName;

    @FXML
    private Label lblPassWord;

    @FXML
    private JFXTextField txtUserName;


    @FXML
    private JFXTextField txtnShowPassword;

    @FXML
    private JFXTextField txtShowPassWord;

    @FXML
    private ImageView imgVisible;

    @FXML
    private ImageView imgInvisible;

    @FXML
    void LoginbtnOnAction(ActionEvent event) {
        String password = txtShowPassWord.getText();
        String userName = txtUserName.getText();
//        String pswdFildPassword = txtShowPassWord.getText();
        clearAll();
            try {
                UserDTO user = userService.get(userName);
                if (password.equals(user.getPassWord()) /*|| pswdFildPassword.equals(user.getPassWord())*/) {
                    if (userName.equals(user.getUserName())) {
                        Stage stage = (Stage) pane.getScene().getWindow();
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelmanagementsystem/view/DashBoardForm.fxml"))));
                        stage.centerOnScreen();
                    } else {
//                    txtUserName.requestFocus();
//                    txtUserName.setFocusColor(RED);
//                    lblUserName.setText("Username does not match");
                        txtUserName.requestFocus();
                        txtUserName.setFocusColor(RED);
                        lbluserName.setText("Username does not match");
                    }
                } else {

                    txtUserName.requestFocus();
                    txtUserName.setFocusColor(RED);
                    lbluserName.setText("Username does not match");
                }
                new Alert(Alert.AlertType.CONFIRMATION, "WELCOME!").show();

            } catch (Exception e) {

                    txtUserName.requestFocus();
                    txtUserName.setFocusColor(RED);
                    txtnShowPassword.requestFocus();
                    txtnShowPassword.setFocusColor(RED);
                    new Alert(Alert.AlertType.WARNING, "Please Enter Username and PassWord First").show();
                }
            }




    public void imgViewOnAction(MouseEvent mouseEvent) {
        imgVisible.setVisible(false);
        txtShowPassWord.setVisible(true);
        imgInvisible.setVisible(true);
        txtnShowPassword.setVisible(false);
        txtShowPassWord.setText(txtShowPassWord.getText());
        txtShowPassWord.requestFocus();
    }
    public void imginvisibleOnAction(MouseEvent mouseEvent) {
        imgVisible.setVisible(true);
        txtShowPassWord.setVisible(false);
        imgInvisible.setVisible(false);
        txtnShowPassword.setVisible(true);
        StringBuilder hiddenPass = new StringBuilder();
        for (char char1 : txtShowPassWord.getText().toCharArray()) {
            hiddenPass = new StringBuilder(hiddenPass.append("*"));
        }
        txtnShowPassword.setText(hiddenPass.toString());
        txtnShowPassword.requestFocus();

    }
    public void initialize() {
        userService = UserServiceimpl.getInstance();

        imgVisible.setVisible(false);
        txtShowPassWord.setVisible(true);
        imgInvisible.setVisible(true);
        txtnShowPassword.setVisible(false);
    }


    private void clearAll() {
        lblPassWord.setText("");
        lbluserName.setText("");
    }

    @FXML
    void SignUpbtnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelmanagementsystem/view/SignUpForm.fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void CancelbtnOnAction(ActionEvent event) {
        System.exit(0);
    }


}
