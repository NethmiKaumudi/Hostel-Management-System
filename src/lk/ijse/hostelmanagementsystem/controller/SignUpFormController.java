package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.hostelmanagementsystem.Service.ServiceFactory;
import lk.ijse.hostelmanagementsystem.Service.custom.UserService;
import lk.ijse.hostelmanagementsystem.dto.UserDTO;
import lk.ijse.hostelmanagementsystem.util.Navigation;
import lk.ijse.hostelmanagementsystem.util.Routes;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpFormController {
    UserDTO userDTO = new UserDTO();
    private UserService userService = (UserService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.USERSERVICE);
    @FXML
    private AnchorPane pane2;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtPassWord;
    @FXML
    private Label lblUserName;
    @FXML
    private Label lblPassWord;
    private Matcher userNameMatcher;
    private Matcher pwMatcher;

    public void initialize() {
        setPatterns();
    }

    private void setPatterns() {


        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());

        Pattern pwPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        pwMatcher = pwPattern.matcher(txtPassWord.getText());


    }

    @FXML
    void SignUpbtnOnAction(ActionEvent event) throws IOException {
        if (userNameMatcher.matches()) {
            if (pwMatcher.matches()) {
            }
        }

        String UserName = txtUserName.getText();
        String PassWord = txtPassWord.getText();
        userDTO.setUserName(UserName);
        userDTO.setPassWord(PassWord);
        String save = userService.save(userDTO);
        if (save != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Added!").showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Not Added!").show();

        }

        Navigation.navigate(Routes.DASHBOARDFORM,pane2);

        clearFields();
    }

    private void clearFields() {
        txtUserName.clear();
        txtPassWord.clear();
    }

    @FXML
    void txtPasWordKeyTypedOnAction(KeyEvent event) {
        lblPassWord.setText("");
        txtPassWord.setFocusColor(Paint.valueOf("Blue"));

        Pattern pwPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        pwMatcher = pwPattern.matcher(txtPassWord.getText());

        if (!pwMatcher.matches()) {
            txtPassWord.requestFocus();
            txtPassWord.setFocusColor(Paint.valueOf("Red"));
            lblPassWord.setText("invalid PassWord");
        }
    }

    @FXML
    void txtUserNameKeyTypedOnAction(KeyEvent event) {
        lblUserName.setText("");
        txtUserName.setFocusColor(Paint.valueOf("Blue"));

        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());
        if (!userNameMatcher.matches()) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            lblUserName.setText("invalid user name");
        }
    }

}