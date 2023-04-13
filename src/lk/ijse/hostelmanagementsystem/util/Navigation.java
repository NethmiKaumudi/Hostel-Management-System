package lk.ijse.hostelmanagementsystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes routes, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (routes) {
            case DASHBOARDFORM:
                window.setTitle("Dashboard Form");
                initUI("DashboardForm.fxml");
                break;
            case STUDENTSAVEFORM:
                window.setTitle("Student Form");
                initUI("StudentSaveForm.fxml");
                break;
            case ROOMFORM:
                window.setTitle("Room Form");
                initUI("RoomForm.fxml");
                break;
            case RESERVATIONFORM:
                window.setTitle("Reservation Form");
                initUI("ReservationForm.fxml");
                break;
            case STUDENTADDFORM:
                window.setTitle("Student add Form");
                initUI("StudentAddForm.fxml");
                break;
            case SIGNUPFORM:
                window.setTitle("SignUp Form");
                initUI("SignUpForm.fxml");
                break;
            case SETTINGFORM:
                window.setTitle("Setting Form");
                initUI("Setting.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();

        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/hostelmanagementsystem/view" + location)));
    }
}
