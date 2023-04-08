package lk.ijse.hostelmanagementsystem.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private VBox vBox;
    private Parent fxml;

    public void initialize() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vBox);
        transition.setToX(vBox.getLayoutX()*20
        );
        transition.play();
        transition.setOnFinished((e)->{
            try {

                fxml= FXMLLoader.load(getClass().getResource("/lk/ijse/hostelmanagementsystem/view/LoginForm.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vBox);
        transition.setToX(780);
        transition.play();
        transition.setOnFinished((e)->{
            try {

                fxml= FXMLLoader.load(getClass().getResource("/lk/ijse/hostelmanagementsystem/view/SignInForm.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vBox);
        transition.setToX(40);
        transition.play();
        transition.setOnFinished((e)->{
            try {

                fxml= FXMLLoader.load(getClass().getResource("/lk/ijse/hostelmanagementsystem/view/SignupForm.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

}
