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

    private Rotate rot;
    private Rotate rotneg;


    private void drawShape(Shape3D shape)
    {
        //System.out.println("U =" + this.getPosition().getU());
        //System.out.println("L =" + this.getPosition().getL());
        //System.out.println("H =" + this.getPosition().getH());
        Point3D coord = this.getPosition().getCoordinates();
        //System.out.println("coord"+coord);
        shape.setTranslateY(coord.getY());
        shape.setTranslateX(coord.getX());
        shape.setTranslateZ(coord.getZ());
        double alpha1 = 0;
        if (this.getPosition().getU().getX() == 0)
        {
            alpha1 = Math.signum(this.getPosition().getU().getZ()) * 90;
        }
        else
        {
            alpha1 = Math.toDegrees(Math.atan(this.getPosition().getU().getZ()/
                    (-this.getPosition().getU().getX())));
        }

        //System.out.println("alpha1 =" + alpha1);
        Rotate roty = new Rotate(alpha1, 0, 0, 0, Rotate.Y_AXIS);
        shape.getTransforms().add(roty);

        double xu = this.getPosition().getU().getX();
        double zu = this.getPosition().getU().getZ();
        double xu2 = xu * Math.cos(alpha1) - zu * Math.sin(alpha1);
        double zu2 = xu * Math.sin(alpha1) + zu * Math.cos(alpha1);
        double alpha2 = Math.signum(xu2) *
                (90 - Math.toDegrees(Math.asin( -this.getPosition().getU().getY())));

        //System.out.println("alpha2 =" + alpha2);
        Rotate rotz = new Rotate(alpha2, 0,0,0, Rotate.Z_AXIS);
        shape.getTransforms().add(rotz);
        double xl = this.getPosition().getL().getX();
        double zl = this.getPosition().getL().getZ();
        double xl2 = xl * Math.cos(alpha1) - zl * Math.sin(alpha1);
        double zl2 = xl * Math.sin(alpha1) + zl * Math.cos(alpha1);
        double yl2 = this.getPosition().getL().getY();
        double xl3 = xl2 * Math.cos(alpha2) - yl2 * Math.sin(alpha2);

        double alpha3 = -Math.signum(zl2) * (90 - Math.toDegrees(Math.asin(-xl3)));

        //System.out.println("alpha3 =" + alpha3);
        Rotate roty2 = new Rotate(alpha3 ,0,0,0,Rotate.Y_AXIS);
        shape.getTransforms().add(roty2);

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
                    //rotace doleva
                    rotneg.setAxis(this.getPosition().getH());
                    this.getPosition().setL(this.rotneg.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.rotneg.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.rotneg.transform(this.getPosition().getH()));
                    break;
                case '-':
                    //rotace doprava
                    rot.setAxis(this.getPosition().getH());
                    this.getPosition().setL(this.rot.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.rot.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.rot.transform(this.getPosition().getH()));
                    break;
                case '&':
                    //rotace dolu
                    //this.getPosition().AddTransform(
                    //        new Rotate(-delta,0,0,0,Rotate.X_AXIS));
                    rot.setAxis(this.getPosition().getL());
                    this.getPosition().setL(this.rot.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.rot.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.rot.transform(this.getPosition().getH()));
                    break;
                case '^':
                    //rotace nahoru
                    //this.getPosition().AddTransform(
                    //        new Rotate(delta,0,0,0,Rotate.X_AXIS));
                    rotneg.setAxis(this.getPosition().getL());
                    this.getPosition().setL(this.rotneg.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.rotneg.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.rotneg.transform(this.getPosition().getH()));
                    break;
                case '\\':
                    //rotace roll doleva
                    //this.getPosition().AddTransform(
                    //        new Rotate(delta, 0, 0, 0, Rotate.Y_AXIS));
                    rotneg.setAxis(this.getPosition().getU());
                    this.getPosition().setL(this.rotneg.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.rotneg.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.rotneg.transform(this.getPosition().getH()));
                    break;
                case '/':
                    //rotace roll doprava
                    //this.getPosition().AddTransform(
                    //        new Rotate(-delta, 0, 0, 0, Rotate.Y_AXIS));
                    rot.setAxis(this.getPosition().getU());
                    this.getPosition().setL(this.rot.transform(this.getPosition().getL()));
                    this.getPosition().setU(this.rot.transform(this.getPosition().getU()));
                    this.getPosition().setH(this.rot.transform(this.getPosition().getH()));
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
        this.rot = new Rotate(delta);
        this.rotneg = new Rotate(-delta);
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
