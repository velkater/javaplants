package algoplants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Flower extends Sphere {
    public Flower() {
        this(20,Color.RED);
    }

    public Flower(double radius, Color color) {
        super(radius);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        this.setMaterial(material);
    }
}
