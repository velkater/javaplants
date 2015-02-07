package algoplants;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Translate;

public class Stem extends Cylinder {

    public Stem() {
        this(11,250);
    }

    public Stem(double radius, double height) {
        super(radius, height);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image("diffuse_leaf.jpg"));
        //material.setDiffuseColor(Color.web("D2BA6C"));
        this.setMaterial(material);
    }
}