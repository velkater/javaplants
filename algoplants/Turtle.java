package algoplants;

import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import java.lang.Math;
import java.util.Stack;

public class Turtle {

    private double delta;
    private double step;

    private TurtlePosition position;
    private Stack<TurtlePosition> stack;

    private Rotate Zrot;
    private Rotate Xrot;
    private Rotate Yrot;
    private Rotate Zrotneg;
    private Rotate Xrotneg;
    private Rotate Yrotneg;

    private void drawShape(Shape3D shape)
    {
        Point3D coord = this.getPosition().getCoordinates();
        //System.out.println("coord"+coord);
        shape.setTranslateY(coord.getY());
        shape.setTranslateX(coord.getX());
        shape.setTranslateZ(coord.getZ());
        Rotate rotz = new Rotate(Math.signum(this.getPosition().getU().getX()) *
                Math.toDegrees(Math.acos(Math.abs(
                        this.getPosition().getU().getY()))), 0,0,0, Rotate.Z_AXIS);
        Rotate roty = new Rotate(Math.atan2(this.getPosition().getU().getX(),this.getPosition().getU().getZ())
                ,0,0,0,Rotate.Y_AXIS);
        shape.getTransforms().addAll(rotz,roty);

    }

    public Group read(String code)
    {
        Group gr = new Group();
        TurtlePosition actpos = this.getPosition();
        for(int i = 0, n = code.length() ; i < n ; i++) {
            char c = code.charAt(i);
            switch (c) {
                case 'B':
                    actpos =this.getPosition();
                    actpos.setCoordinates(actpos.getCoordinates().add(
                            actpos.getU().multiply(this.step / 2)));
                    Branch branch = new Branch(5*this.getPosition().getScale(),
                            this.getStep() * this.getPosition().getScale());
                    drawShape(branch);
                    gr.getChildren().add(branch);
                    actpos.setCoordinates(actpos.getCoordinates().add(
                            actpos.getU().multiply(this.step/2)));
                    break;
                case 'L':
                    Leaf leaf = new Leaf(50,50);
                    drawShape(leaf);
                    gr.getChildren().add(leaf);
                    break;
                case 'S':
                    Stem stem = new Stem(5*this.getPosition().getScale(),
                            this.getStep() * this.getPosition().getScale());
                    drawShape(stem);
                    gr.getChildren().add(stem);
                    break;
                case 'F':
                    actpos = this.getPosition();
                    Flower flower = new Flower(7);
                    drawShape(flower);
                    gr.getChildren().add(flower);
                    break;
                case 'g':
                    //this.getPosition().setTranslateY(
                    //        (-step / 2) * this.getPosition().getScale()
                    //);
                    /*this.getPosition().AddTransform(
                            new Translate(0,(-step/2)*this.getPosition().getScale(),0));*/
                    break;
                case '+':
                    //rotace doprava
                    this.getPosition().setL(this.Zrotneg.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.Zrotneg.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.Zrotneg.transform(this.getPosition().getH()));
                    break;
                case '-':
                    //rotace doleva
                    this.getPosition().setL(this.Zrot.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.Zrot.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.Zrot.transform(this.getPosition().getH()));
                    break;
                case '&':
                    //rotace dolu
                    //this.getPosition().AddTransform(
                    //        new Rotate(-delta,0,0,0,Rotate.X_AXIS));
                    break;
                case '^':
                    //rotace nahoru
                    //this.getPosition().AddTransform(
                    //        new Rotate(delta,0,0,0,Rotate.X_AXIS));
                    break;
                case '\\':
                    //rotace roll doleva
                    //this.getPosition().AddTransform(
                    //        new Rotate(delta, 0, 0, 0, Rotate.Y_AXIS));
                    break;
                case '/':
                    //rotace roll doprava
                    //this.getPosition().AddTransform(
                    //        new Rotate(-delta, 0, 0, 0, Rotate.Y_AXIS));
                    break;
                case '|':
                    //rotace o 180
                    //this.getPosition().AddTransform(
                    //        new Rotate(180,0,0,0,Rotate.Z_AXIS));
                    System.out.println("|");
                    break;
                case '[':
                    //zapamatuje si pozici v zasobniku
                    this.savePosition();
                    break;
                case ']':
                    //vrati se na posledni pozici do zasobniku
                    this.goToLast();
                    break;
                case '!':
                    //zmensi velikost
                    //this.getPosition().setScale(this.getPosition().getScale()*0.8);
                    break;
                default:
                    System.out.println("chybny znak");
                    break;
            }
        }
        return gr;
    }

    public void savePosition() {
        TurtlePosition actpos = this.getPosition();
        TurtlePosition savedPos = new TurtlePosition();
        savedPos.setScale(actpos.getScale());
        savedPos.setCoordinates(actpos.getCoordinates());
        savedPos.setH(actpos.getH());
        savedPos.setL(actpos.getL());
        savedPos.setU(actpos.getU());
        stack.push(savedPos);
    }

    public void goToLast() {
        this.setPosition(stack.pop());
    }

    public Turtle(double delta, double step) {
        this.delta = delta;
        this.step = step;
        this.position = new TurtlePosition();
        this.stack = new Stack<TurtlePosition>();
        this.Zrot = new Rotate(delta, 0, 0, 0, Rotate.Z_AXIS);
        this.Xrot = new Rotate(delta, 0, 0, 0, Rotate.X_AXIS);
        this.Yrot = new Rotate(delta, 0, 0, 0, Rotate.Y_AXIS);
        this.Zrotneg = new Rotate(-delta, 0, 0, 0, Rotate.Z_AXIS);
        this.Xrotneg = new Rotate(-delta, 0, 0, 0, Rotate.X_AXIS);
        this.Yrotneg = new Rotate(-delta, 0, 0, 0, Rotate.Y_AXIS);
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "delta=" + delta +
                ", step=" + step +
                ", position=" + position +
                '}';
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public TurtlePosition getPosition() {
        return position;
    }

    public void setPosition(TurtlePosition position) {
        this.position = position;
    }
}
