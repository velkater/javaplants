package algoplants;



import javafx.collections.ObservableList;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Transform;

/* Želva je pomyslný cylinder -- ten obsahuje všechny funkce, co od želvy potřebujeme
*  a není potřeba implementovat nějaké zbytečné funkce, kdybychom dědili z nějaké abstraktní třídy*/

public class TurtlePosition extends Cylinder {

    /* O kolik se má zmenšit velikost kroku želvy, od 0 do 1 */
    private double scale;

    public TurtlePosition() {
        super();
        this.scale = 1;
    }

    /* Pozice želvy jsou všechny je seznam všech transformací, které se do ni přidaly */
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