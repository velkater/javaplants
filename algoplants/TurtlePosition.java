package algoplants;

import javafx.geometry.Point3D;



public class TurtlePosition{
    private double scale;
    private Point3D coordinates;
    private Point3D H;
    private Point3D L;
    private Point3D U;

    public TurtlePosition() {
        this.scale=1;
        this.coordinates= new Point3D(0,0,0);
        this.H = new Point3D(0,0,1);
        this.L = new Point3D(-1,0,0);
        this.U = H.crossProduct(L);
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public Point3D getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point3D coordinates) {
        this.coordinates = coordinates;
    }

    public Point3D getH() {
        return H;
    }

    public void setH(Point3D h) {
        H = h;
    }

    public Point3D getL() {
        return L;
    }

    public void setL(Point3D l) {
        L = l;
    }

    public Point3D getU() {
        return U;
    }

    public void setU(Point3D u) {
        U = u;
    }

    @Override
    public String toString() {
        return "TurtlePosition{" +
                "scale=" + scale +
                ", coordinates=" + coordinates +
                ", H=" + H +
                ", L=" + L +
                ", U=" + U +
                '}';
    }
}
