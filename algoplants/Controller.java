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

    }

    public void hop(ActionEvent actionEvent) {


        PerspectiveCamera camera = new PerspectiveCamera();
        camera.getTransforms().addAll (
                new Rotate(0, Rotate.Y_AXIS),
                new Rotate(0, Rotate.X_AXIS),
                new Translate(0, 0, -500));

        Branch vetev = new Branch();
        vetev.setLayoutX(100);
        vetev.setLayoutY(500);
        Sphere sfera = new Sphere(25);
        sfera.setLayoutY(0);
        sfera.setLayoutX(0);

        AmbientLight light = new AmbientLight();

        Stem stonek = new Stem();
        stonek.setLayoutX(200);
        stonek.setLayoutY(500);

        Leaf list = new Leaf(225,200);
        list.setLayoutX(300);
        list.setLayoutY(300);
        Rotate rotx = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
        Rotate roty = new Rotate(30, 0, 0, 0, Rotate.Y_AXIS);
        Rotate rotz = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
        Translate trans = new Translate(0, 0, 500);
        rotx.setAngle(0);
        roty.setAngle(0);
        rotz.setAngle(0);
        //list.setScaleX(0.2);
        //list.setScaleY(0.2);
        //list.setScaleZ(0.2);
        list.getTransforms().addAll(rotx, roty, rotz, trans);

        Group group = new Group();
        subs.setRoot(group);

        subs.setCamera(camera);
        subs.setFill(Color.BLUEVIOLET);
        group.getChildren().addAll(sfera, list, stonek, vetev);

        //subs.setRoot(reg);
        //reg.getChildren().addAll(sfera, list, stonek, vetev);





    }
}
