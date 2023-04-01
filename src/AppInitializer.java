import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {
    public static void main(String[] args) {
launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

            URL resource = this.getClass().getResource("/lk/ijse/hostelmanagementsystem/view/DashBoardForm.fxml");
            Parent window = FXMLLoader.load(resource);
            Scene scene = new Scene(window);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login Form");
            primaryStage.centerOnScreen();

            primaryStage.show();

    }
}
