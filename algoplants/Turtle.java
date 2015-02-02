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

    private void drawShape(Group group, Shape3D shape)
    {
        Rotate rotx = new Rotate(this.getPosition().getRotX(),
                0, 0, 0, Rotate.X_AXIS);
        Rotate roty = new Rotate(this.getPosition().getRotY(),
                0, 0, 0, Rotate.Y_AXIS);
        Rotate rotz = new Rotate(this.getPosition().getRotZ(),
                0, 0, 0, Rotate.Z_AXIS);
        Translate trans = new Translate(0, this.getPosition().getY(), 0);
        shape.setScaleX(this.getPosition().getScale());
        shape.setScaleY(this.getPosition().getScale());
        shape.setScaleZ(this.getPosition().getScale());
        shape.getTransforms().addAll(rotx,roty,rotz,trans);

    }

    public void read(String code, Group group)
    {
        for(int i = 0, n = code.length() ; i < n ; i++) {
            char c = code.charAt(i);
            switch (c) {
                case 'B':
                    System.out.println("branch");
            }
        }
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
