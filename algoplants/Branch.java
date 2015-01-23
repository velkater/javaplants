package algoplants;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

public class Branch extends Cylinder{

    public Branch() {
        this(50,200);
    }

    public Branch(double radius, double height) {
        super(radius, height);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BURLYWOOD);
        //material.setSpecularColor(Color.rgb(30, 30, 30));
        this.setMaterial(material);
    }
}
