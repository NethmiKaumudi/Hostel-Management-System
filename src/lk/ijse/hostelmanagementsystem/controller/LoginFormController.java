package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelmanagementsystem.Service.ServiceFactory;
import lk.ijse.hostelmanagementsystem.Service.custom.UserService;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lk.ijse.hostelmanagementsystem.util.Navigation;
import lk.ijse.hostelmanagementsystem.util.Routes;

import java.io.IOException;

import static javafx.scene.paint.Color.RED;

public class LoginFormController {
    String password = null;
    //    UserDTO userDTO = new UserDTO();
//    UserService userService;
    private UserService userService = (UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USERSERVICE);
    @FXML
    private AnchorPane pane2;
    @FXML
    private Label lbluserName;
    @FXML
    private Label lblPassWord;
    @FXML
    private JFXTextField txtUserName;
    //    @FXML
//    private JFXTextField txtnShowPassword;
    @FXML
    private JFXPasswordField txtnShowPassword;
    @FXML
    private JFXTextField txtShowPassWord;
    @FXML
    private ImageView imgVisible;
    @FXML
    private ImageView imgInvisible;

    @FXML
    void LoginbtnOnAction(ActionEvent event) {
        String password = txtnShowPassword.getText();
        String userName = txtUserName.getText();
//        String pswdFildPassword = txtShowPassWord.getText();
        clearAll();
        try {
            System.out.println(userName);
            UserDTO user = userService.get(userName);
            if (txtnShowPassword.getText().equals("") && txtUserName.getText().equals("")) {
                txtUserName.requestFocus();
                txtUserName.setFocusColor(RED);
                txtnShowPassword.requestFocus();
                txtnShowPassword.setFocusColor(RED);
                new Alert(Alert.AlertType.WARNING, "Please Enter Username and PassWord First").show();
            } else {
                if (user == null) {
                    txtUserName.requestFocus();
                    txtUserName.setFocusColor(RED);
                    lbluserName.setText("Username does not match");
                } else {
                    if (password.equals(user.getPassWord()) /*|| pswdFildPassword.equals(user.getPassWord())*/) {
                        if (userName.equals(user.getUserName())) {

                            Navigation.navigate(Routes.DASHBOARDFORM, pane2);
                            new Alert(Alert.AlertType.CONFIRMATION, "WELCOME!").show();

                        } else {
                            txtUserName.requestFocus();
                            txtUserName.setFocusColor(RED);
                            lbluserName.setText("Username does not match");
                        }
                    } else {

                        txtnShowPassword.requestFocus();
                        txtnShowPassword.setFocusColor(RED);
                        lblPassWord.setText("Password does not match");
                    }
                }
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void imgViewOnAction(MouseEvent mouseEvent) {
        imgVisible.setVisible(false);
        imgInvisible.setVisible(true);
        txtShowPassWord.setVisible(true);
        txtnShowPassword.setVisible(false);
        password = txtnShowPassword.getText();
        txtShowPassWord.setText(password);

    }

    public void imginvisibleOnAction(MouseEvent mouseEvent) {

        imgVisible.setVisible(true);
        imgInvisible.setVisible(false);
        txtShowPassWord.setVisible(false);
        txtnShowPassword.setVisible(true);
        password = txtShowPassWord.getText();
        txtnShowPassword.setText(password);


    }

    public void initialize() {

        imgInvisible.setVisible(false);
        imgVisible.setVisible(true);
        txtShowPassWord.setVisible(false);

    }


    private void clearAll() {
        lblPassWord.setText("");
        lbluserName.setText("");
    }

    @FXML
    void SignUpbtnOnAction(ActionEvent event) throws IOException {

        Navigation.navigate(Routes.SIGNUPFORM, pane2);
    }

    @FXML
    void CancelbtnOnAction(ActionEvent event) {
        System.exit(0);
    }


}
