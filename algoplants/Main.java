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
        /* Nahrání FXML souboru */
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

seed:B
B to B[+BSl]B[-BlS][^BlS]B[&BSl]
S to B
L to Lf
f to F
F to Ff
l to F

seed:S
B to B[-BlfS][+BlfS]B
S to B
L to Lf
f to F
F to FlF nebo Flf
l to L

seed:S
B to B[-BSlf][+BSlf][&BSlf]
S to B
L to Lf
f to F
F to FlF nebo Flf
l to L

seed:S
B to B[-/BlfSl]B[+\BlfSl]Bl
S toB
L to Lf
f to F
F to Flf
l to ll

seed:S
B to B[+BL[-Bl]][-BL]
S to B
L to ^L&L&L^
F to F
l to LF

seed: S
S to S[-S[+Sf]]S[+S[-Sf]]S
f to f nebo F
 */
