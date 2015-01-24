package algoplants;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Leaf extends MeshView {
    public Leaf()
    {
        this(10,25);
    }
    public Leaf(float s, float h)
    {
        TriangleMesh leafMesh = new TriangleMesh();
        leafMesh.getTexCoords().addAll(0,0);
        float points[] =
        {
            0,      -h,         0,            // vrch
            -s/2,   0,          -h/50,         // levy predni
            -s/2,   0,          h/50,         // levy zadni
            s/2,    0,          h/50,         // pravy zadni
            s/2,    0,          -h/50,         // pravy predni
            0,      (h*2)/5,    0,         // spodni
            -h/50,  h,    -h/50,         // konec stonku 1
            -h/50,  h,    h/50,         // konec stonku 2
            h/50,   h,    h/50,         // konec stonku 3
            h/50,   h,    -h/50,      // konec stonku 4
            0,      (h*2)/7,    0  //vrch stonku
        };
        leafMesh.getPoints().addAll(points);
        leafMesh.getFaces().addAll(
                0,0,  1,0,  2,0,          // leva krajni
                0,0,  2,0,  3,0,          // zadni
                0,0,  3,0,  4,0,          // prava krajni
                0,0,  4,0,  1,0,          // predni
                2,0,  1,0,  5,0,          // leva krajni spodni
                2,0,  5,0,  3,0,           // zadni spodni
                3,0,  5,0,  4,0,          // prava krajni spodni
                1,0,  3,0,  5,0,           // predni spodni
                10,0,  6,0,  7,0,          // stonek leva
                10,0,  7,0,  8,0,           // stonek zadni
                10,0,  8,0,  9,0,          // stonek prava
                10,0,  9,0,  6,0,           // stonek predni
                9,0,  7,0,  8,0,          // spodek stonku
                9,0,  7,0,  6,0           // spodek stonku


        );
        this.setMesh(leafMesh);
        this.setDrawMode(DrawMode.FILL);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image("diffuse_leaf.jpg"));
        this.setMaterial(material);
    }

}
