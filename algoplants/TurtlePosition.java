package algoplants;


import javafx.collections.ObservableList;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Transform;


public class TurtlePosition extends Cylinder {
    private double scale;

    public TurtlePosition() {
        super();
        this.scale = 1;
    }

    public ObservableList<Transform> getPosition() {
        return this.getTransforms();
    }
    public void AddTransform(Transform trans) {
        this.getTransforms().add(trans);
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "TurtlePosition{" +
                '}';
    }
}