package algoplants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.RotateEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.Hashtable;
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
        launch();
    }
}

/* Dobré substituce

B to B[+BSl]B[-BlS][^BlS]B[&BSl]
S to B
L to Lf
f to F
F to Ff
l to F
 */
