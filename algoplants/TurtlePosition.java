package algoplants;

public class TurtlePosition {
    //uvadi doleva nebo doprava kdyz se zelva diva nahoru
    private double rotZ;
    //uvadi hestli dolu nebo nahoru
    private double rotX;
    //otoceni sama na sobe - roll
    private double rotY;
    //pozice na ose Y, tj.
    private double Y;
    //velikost
    private double scale;

    @Override
    public String toString() {
        return "TurtlePosition{" +
                "rotZ=" + rotZ +
                ", rotX=" + rotX +
                ", rotY=" + rotY +
                ", Y=" + Y +
                ", scale=" + scale +
                '}';
    }

    public TurtlePosition() {
        this.setRotX(0);
        this.setRotY(0);
        this.setRotZ(0);
        this.setY(0);
        this.setScale(1);
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getRotZ() {
        return rotZ;
    }

    public void setRotZ(double rotZ) {
        this.rotZ = rotZ;
    }

    public double getRotX() {
        return rotX;
    }

    public void setRotX(double rotX) {
        this.rotX = rotX;
    }

    public double getRotY() {
        return rotY;
    }

    public void setRotY(double rotY) {
        this.rotY = rotY;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }
}
