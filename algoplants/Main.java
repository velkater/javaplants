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
        launch(args);


        /*double x = 0;
        double z = 1;
        System.out.println(Math.toDegrees(Math.atan2(z,x)));

        Point3D point = new Point3D(1,0,0);
        Point3D axis = new Point3D(0,-1,0);
        System.out.println(point.toString());
        Rotate rot =  new Rotate(90, axis);

        point = rot.transform(point);
        System.out.println(point);*/

        /*Rotate rotz =  new Rotate(-90,0,0,0, Rotate.Z_AXIS);

        point = rotz.transform(point);
        System.out.println(point);
        */

    }
}

/* Dobra subs

B to B[+BSl]B[-BlS][^BlS]B[&BSl]
S to B
L to Lf
f to F
F to Ff
l to F
 */
