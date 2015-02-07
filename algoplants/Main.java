package algoplants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"),
                ResourceBundle.getBundle("Application", new Locale("cs", "CZ")));
        primaryStage.setTitle("Algoplants");
        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
