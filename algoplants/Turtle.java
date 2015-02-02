package algoplants;

import java.util.Stack;

public class Turtle {

    private double scale;
    private double delta;
    private double step;

    private TurtlePosition position;
    private Stack<TurtlePosition> stack;

    @Override
    public String toString() {
        return "Turtle{" +
                "scale=" + scale +
                ", delta=" + delta +
                ", step=" + step +
                ", position=" + position +
                '}';
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
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
