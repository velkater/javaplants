package algoplants;

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
        leafMesh.getPoints().addAll(
            0,    0,    0,            // Point 0 - Top
            0,    h,    -s/2,         // Point 1 - Front
            -s/2, h,    0,            // Point 2 - Left
            s/2,  h,    0,            // Point 3 - Back
            0,    h,    s/2           // Point 4 - Right
        );
        leafMesh.getFaces().addAll(
                0,0,  2,0,  1,0,          // Front left face
                0,0,  1,0,  3,0,          // Front right face
                0,0,  3,0,  4,0,          // Back right face
                0,0,  4,0,  2,0,          // Back left face
                4,0,  1,0,  2,0,          // Bottom rear face
                4,0,  3,0,  1,0           // Bottom front face
        );
        this.setMesh(leafMesh);
        this.setDrawMode(DrawMode.FILL);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        this.setMaterial(material);
    }

}
