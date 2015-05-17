package algoplants;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Translate;

public class Stem extends Cylinder {

    public Stem() {
        this(5,50);
    }

    public Stem(double radius, double height) {
        super(radius, height);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.web("00CC00"));
        this.setMaterial(material);
    }
}