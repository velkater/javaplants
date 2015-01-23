package algoplants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.image.Image;

import java.awt.*;

public class Branch extends Cylinder{

    public Branch() {
        this(11,150);
    }

    public Branch(double radius, double height) {
        super(radius, height);
        PhongMaterial material = new PhongMaterial();
        material.setBumpMap(new Image("texture_wood2.jpg"));
        material.setDiffuseColor(Color.web("D2BA6C"));
        this.setMaterial(material);
    }
}
