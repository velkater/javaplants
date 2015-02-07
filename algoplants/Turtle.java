package algoplants;

import javafx.scene.Group;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.Stack;

public class Turtle {

    private double delta;
    private double step;

    private TurtlePosition position;
    private Stack<TurtlePosition> stack;

    private void drawShape(Shape3D shape)
    {
        Rotate rotx = new Rotate(this.getPosition().getRotX(),
                0, this.getPosition().getY(), 0, Rotate.X_AXIS);
        Rotate roty = new Rotate(this.getPosition().getRotY(),
                0, 0, 0, Rotate.Y_AXIS);
        Rotate rotz = new Rotate(this.getPosition().getRotZ(),
                0, 0, 0, Rotate.Z_AXIS);
        Translate trans = new Translate(0, this.getPosition().getY(), 0);
        shape.setScaleX(this.getPosition().getScale());
        shape.setScaleY(this.getPosition().getScale());
        shape.setScaleZ(this.getPosition().getScale());
        shape.getTransforms().addAll(trans,rotx,roty,rotz);

    }

    public Group read(String code)
    {
        Group gr = new Group();
        for(int i = 0, n = code.length() ; i < n ; i++) {
            char c = code.charAt(i);
            switch (c) {
                case 'B':
                    System.out.println("branch");
                    Branch branch = new Branch(5,this.getStep() * this.getPosition().getScale());
                    drawShape(branch);
                    gr.getChildren().add(branch);
                    break;
                case 'L':
                    System.out.println("leaf");
                    Leaf leaf = new Leaf(4,5);
                    drawShape(leaf);
                    gr.getChildren().add(leaf);
                    break;
                case 'S':
                    System.out.println("stem");
                    Stem stem = new Stem(5,this.getStep() * this.getPosition().getScale());
                    drawShape(stem);
                    gr.getChildren().add(stem);
                    break;
                case 'F':
                    System.out.println("flower");
                    Flower flower = new Flower(7);
                    drawShape(flower);
                    gr.getChildren().add(flower);
                    break;
                case 'g':
                    System.out.println("g");
                    double Y = this.getPosition().getY();
                    this.getPosition().setY((Y-this.getStep() * this.getPosition().getScale()));
                    break;
                case '+':
                    System.out.println("plus");
                    this.getPosition().setRotZ(-this.getDelta());
                    break;
                case '-':
                    System.out.println("minus");
                    break;
                case '&':
                    System.out.println("and");
                    break;
                case '^':
                    System.out.println("land");
                    break;
                case '\\':
                    System.out.println("\\");
                    break;
                case '/':
                    System.out.println("/");
                    break;
                case '|':
                    System.out.println("|");
                    break;
                case '[':
                    System.out.println("[");
                    break;
                case ']':
                    System.out.println("]");
                    break;
                default:
                    System.out.println("chybny znak");
                    break;
            }
        }
        return gr;
    }

    public Turtle(double delta, double step) {
        this.delta = delta;
        this.step = step;
        this.position = new TurtlePosition();
        this.stack = new Stack<TurtlePosition>();
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "delta=" + delta +
                ", step=" + step +
                ", position=" + position +
                ", stack=" + stack +
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

    public Stack<TurtlePosition> getStack() {
        return stack;
    }

    public void setStack(Stack<TurtlePosition> stack) {
        this.stack = stack;
    }
}
