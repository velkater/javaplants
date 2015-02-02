package algoplants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Flower extends Sphere {
    public Flower() {
        this(20);
    }

    public Flower(double radius) {
        super(radius);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.LAVENDER);
        this.setMaterial(material);
    }
}
