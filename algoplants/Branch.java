package algoplants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

/* Třída pro vytváření větve */
public class Branch extends Cylinder{

    public Branch() {
        this(5,50);
    }

    public Branch(double radius, double height) {
        super(radius, height);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.web("996633"));
        this.setMaterial(material);
    }
}
