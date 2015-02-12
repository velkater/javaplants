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
        //launch(args);
        Hashtable<Character,String> hash = new Hashtable<>();
        hash.put('0', "01");
        hash.put('1', "0");
        System.out.println(hash);
        Substitution subs = new Substitution(hash, 4, "0");
        System.out.println(subs.getCode());
        /*Point3D point = new Point3D(0,-1,0);
        System.out.println(point.toString());
        Rotate rot =  new Rotate(-45,0,0,0, Rotate.Z_AXIS);
        Rotate roty = new Rotate(180,0,0,0,Rotate.Y_AXIS);
        point = rot.transform(point);
        System.out.println(point);
        point = roty.transform(point);
        System.out.println(point);
        point = rot.transform(point);
        System.out.println(point);*/

    }
}
