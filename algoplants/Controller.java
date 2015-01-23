package algoplants;

import com.sun.org.omg.CORBA.Initializer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.awt.*;
import java.awt.ScrollPane;

// bommry
public class Controller {
    @FXML Rectangle rect;
    @FXML AnchorPane kanvas;
    @FXML AnchorPane leftint;
    @FXML AnchorPane rightint;
    @FXML Parent root;
    @FXML AnchorPane platno;
    @FXML SubScene subs;
    @FXML AnchorPane reg;

    public void novy(ActionEvent actionEvent) {
        rect.setFill(Color.rgb(50, 10, 10));
        //Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //alert.showAndWait();
        rect.setHeight(300);
    }

    public void novacyl(ActionEvent actionEvent) {
        //Branch vetev = new Branch();
        //vetev.setLayoutX(200);
        //vetev.setLayoutY(100);
        //kanvas.getChildren().add(vetev);

        Branch vetev2 = new Branch();
        vetev2.setLayoutX(200);
        vetev2.setLayoutY(100);
        leftint.getChildren().add(vetev2);

        Branch vetev3 = new Branch();
        vetev3.setLayoutX(200);
        vetev3.setLayoutY(500);
        rightint.getChildren().add(vetev3);


    }

    public void hop(ActionEvent actionEvent) {


        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(-20, Rotate.X_AXIS),
                new Translate(-30, -30, -15));

        Branch vetev = new Branch();
        vetev.setLayoutX(100);
        vetev.setLayoutY(500);
        Sphere sfera = new Sphere(50);
        sfera.setLayoutY(100);
        sfera.setLayoutX(100);

        Sphere sfera2 = new Sphere(50);
        sfera2.setLayoutY(500);
        sfera2.setLayoutX(200);

        AmbientLight light = new AmbientLight();

        subs.setCamera(camera);
        subs.setFill(Color.BLUEVIOLET);

        //subs.setRoot(reg);
        reg.getChildren().add(sfera);





    }
}
