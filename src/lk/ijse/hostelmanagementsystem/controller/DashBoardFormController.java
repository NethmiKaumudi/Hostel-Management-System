package lk.ijse.hostelmanagementsystem.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.hostelmanagementsystem.util.Navigation;
import lk.ijse.hostelmanagementsystem.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane slider;

    @FXML
    private Label lblMenu;

    @FXML
    private Label lblBack;

    public void initialize(URL location, ResourceBundle resources) {

        slider.setTranslateX(-363);
        lblMenu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();
            slider.setTranslateX(-363);

            slide.setOnFinished(event1 -> {
                lblMenu.setVisible(false);
                lblBack.setVisible(true);
            });


        });
        lblBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-363);
            slide.play();
            slider.setTranslateX(0);

            slide.setOnFinished(event1 -> {
                lblMenu.setVisible(true);
                lblBack.setVisible(false);
            });


        });

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        slider.setOnMouseClicked(event1 -> {
            System.exit(0);
        });
        Navigation.navigate(Routes.STUDENTSAVEFORM,pane);

    }
}
