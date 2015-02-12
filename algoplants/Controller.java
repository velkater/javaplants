package algoplants;

import com.sun.org.omg.CORBA.Initializer;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import java.util.Hashtable;
import java.util.Observable;

// bommry
public class Controller {
    @FXML AnchorPane kanvas;
    @FXML AnchorPane leftint;
    @FXML SubScene subs;
    @FXML AnchorPane reg;

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @FXML
    protected void initialize() {
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (
                new Rotate(-30, Rotate.Y_AXIS),
                new Rotate(10, Rotate.X_AXIS),
                new Rotate(0, Rotate.Z_AXIS),
                new Translate(0, -500, -1300));
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(60);

        this.group = new Group();
        subs.setRoot(group);

        subs.setCamera(camera);
        subs.setFill(Color.DEEPSKYBLUE);

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

        Box grass = new Box(3000, 3, 3000);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.SADDLEBROWN);
        grass.getTransforms().add(new Rotate(0, Rotate.X_AXIS));
        grass.getTransforms().add(new Translate(0,10,0));
        grass.setMaterial(material);


        group.getChildren().addAll(xAxis, yAxis, zAxis, grass);

        System.out.println("inicializovano");
    }

    public void novy(ActionEvent actionEvent) {
        //rect.setFill(Color.rgb(50, 10, 10));
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "neimplementovano");
        alert.showAndWait();
        //rect.setHeight(300);
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
        int delka = group.getChildren().size();
        group.getChildren().remove(delka-1);
        System.out.println(group.getChildren());

    }

    public void hop(ActionEvent actionEvent) {

        Hashtable<Character,String> hash = new Hashtable<>();
        hash.put('B', "B[+B]B[-B]B");
        System.out.println(hash);
        Substitution subs = new Substitution(hash, 3, "B");
        System.out.println(subs.getCode());

        String code = subs.getCode();
        Turtle turtle = new Turtle(45, 50);
        System.out.println(turtle);

        String r = "";
        for (int i = 0; i <code.length(); i++) {
            if (code.charAt(i)=='B')
                r = r + "gBg";
            else
                r = r + code.charAt(i);
        }
        System.out.println(r);

        String s = "Bg[+gBg-gBg++++gg++gB----ggBg]S";
        //String s = "Bg[+gB]gSg![+gB][-gB]gSg";
        Group gr2 = turtle.read(r);

        group.getChildren().add(gr2);



    }

    public void quit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
