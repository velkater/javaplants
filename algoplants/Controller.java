package algoplants;

import com.sun.org.omg.CORBA.Initializer;
import javafx.application.Platform;
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
import javafx.scene.shape.Box;
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

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (
                new Rotate(-30, Rotate.Y_AXIS),
                new Rotate(-30, Rotate.X_AXIS),
                new Rotate(0, Rotate.Z_AXIS),
                new Translate(0, 0, -300));
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(60);

        Branch vetev = new Branch();
        vetev.setTranslateX(-50);
        Sphere sfera = new Sphere(25);
        sfera.setLayoutY(0);
        sfera.setLayoutX(0);

        AmbientLight light = new AmbientLight();

        Stem stonek = new Stem();
        stonek.setTranslateX(50);

        Leaf list = new Leaf(32,36);
        list.setLayoutX(0);
        list.setLayoutY(0);
        Rotate rotx = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
        Rotate roty = new Rotate(90, 0, 0, 0, Rotate.Y_AXIS);
        Rotate rotz = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);
        Translate trans = new Translate(0, 0, 0);
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

        System.out.println("buildAxes()");
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);

        final Box xAxis = new Box(240.0, 1, 1);
        final Box yAxis = new Box(1, 240.0, 1);
        final Box zAxis = new Box(1, 1, 240.0);

        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);

        group.getChildren().addAll(xAxis, yAxis, zAxis);





    }

    public void quit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
