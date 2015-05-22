package algoplants;


import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import java.util.Hashtable;


public class Controller {
    @FXML AnchorPane kanvas;
    @FXML SubScene subs;
    @FXML AnchorPane reg;
    @FXML GridPane gridpane;
    @FXML VBox rulesbox;
    @FXML TextField seedfield;
    @FXML TextField stepfield;
    @FXML TextField anglefield;

    private Group group;
    private Group treegroup;
    private PerspectiveCamera camera;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Hashtable<Character,String> rules;

    @FXML
    protected void initialize() {
        this.rules = new Hashtable<>();
        this.camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (
                new Rotate(-30, Rotate.Y_AXIS),
                new Rotate(10, Rotate.X_AXIS),
                new Rotate(0, Rotate.Z_AXIS),
                new Translate(0, -500, -1300));
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(60);

        this.treegroup = new Group();
        this.group = new Group();
        subs.setRoot(group);

        subs.setCamera(camera);
        subs.setFill(Color.DEEPSKYBLUE);


        // Osy x, y a z
        /*final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);

        final Box xAxis = new Box(500.0, 2, 2);
        final Box yAxis = new Box(2, 500.0, 2);
        final Box zAxis = new Box(2, 2, 500.0);

        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);
        group.getChildren().addAll(xAxis, yAxis, zAxis);*/


        // Zem
        Box grass = new Box(3000, 3, 3000);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.SADDLEBROWN);
        grass.getTransforms().add(new Rotate(0, Rotate.X_AXIS));
        grass.getTransforms().add(new Translate(0,10,0));
        grass.setMaterial(material);
        group.getChildren().addAll(grass);
    }

    public void test(ActionEvent actionEvent) throws InterruptedException {
        treegroup.getChildren().clear();

        Hashtable<Character,String> hash = new Hashtable<>();
        hash.put('B', "B[+B]B[-B]B");
        Substitution subs = new Substitution(hash, 3, "B");
        System.out.println(subs.getCode());
        String code = subs.getCode();

        // Kód za účelem testování
        // String code = "SLBFSlBf";

        Turtle turtle = new Turtle(35, 50);
        treegroup = turtle.read(code);
        group.getChildren().add(treegroup);
        System.gc();
    }

    public void quit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void drawButton(ActionEvent actionEvent) {
        treegroup.getChildren().clear();
        ObservableList<Node> list = rulesbox.getChildren();
        Hashtable<Character,String> hash = new Hashtable<>();

        for (Object rule: list)
        {
            if(((Rule) rule).getKey() != null
                    && !((Rule) rule).getCode().equals(""))
            {
                if(hash.containsKey(((Rule) rule).getKey()))
                {
                    System.out.println("Chyba");
                    hash.put(((Rule) rule).getKey()
                            ,((Rule) rule).getCode());
                }
                else
                {
                    hash.put(((Rule) rule).getKey()
                            ,((Rule) rule).getCode());
                }
            }
            else
            {
                System.out.println("nastala chyba, neco spatne vyplneno");
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Néco nebylo vyplnéno");
                alert.showAndWait();
            }
        }
        System.out.println(hash.toString());
        String seedfieldtext;
        int stepnumber;
        int angle;
        if( !seedfield.getText().equals("") && !stepfield.getText().equals("")
                && !anglefield.getText().equals("")) {
            seedfieldtext = seedfield.getText();
            stepnumber = Integer.parseInt(stepfield.getText());
            angle = Integer.parseInt(anglefield.getText());
            Substitution subs = new Substitution(hash, stepnumber, seedfieldtext);
            String code = subs.getCode();
            Turtle turtle = new Turtle(angle, 50);
            System.out.println(turtle);
            System.out.println(code);
            treegroup = turtle.read(code);
            group.getChildren().add(treegroup);
        }
        else
        {
            System.out.println("nastala chyba, neco nebylo vyplneno");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Néco nebylo vyplnéno");
            alert.showAndWait();
        }
    }

    public void plusButton(ActionEvent actionEvent) {
        Rule rule = new Rule();
        rulesbox.getChildren().add(rule);
    }

    public void helpfunction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Algoplants -- for D0L plants \n FJFI \n 2014/2015");
        alert.showAndWait();
    }

    // Pohyb kamery
    // Dozadu
    public void minusCam(ActionEvent actionEvent) {
        double camy = this.camera.getTransforms().get(3).getTy();
        double camz = this.camera.getTransforms().get(3).getTz();
        if( this.camera.getTransforms().get(3).getTy() > -700 && this.camera.getTransforms().get(3).getTz() > -1800)
        {
            this.camera.getTransforms().add(new Translate(0, camy-40, camz-100 ));
            this.camera.getTransforms().remove(3);
        }
    }

    // Dopředu
    public void plusCam(ActionEvent actionEvent) {
        double camy = this.camera.getTransforms().get(3).getTy();
        double camz = this.camera.getTransforms().get(3).getTz();
        if( this.camera.getTransforms().get(3).getTy() < -100 && this.camera.getTransforms().get(3).getTz() < -300)
        {
            this.camera.getTransforms().add(new Translate(0, camy+40, camz+100 ));
            this.camera.getTransforms().remove(3);

        }
    }
}