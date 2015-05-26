package algoplants;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.Stack;
public class Turtle {

    /* Úhel */
    private double delta;
    /* Počáteční délka kroku želvy */
    private double step;
    /* Pozice želvy */
    private TurtlePosition position;
    /* Zásobník na pamatování pozic želvy */
    private Stack<TurtlePosition> stack;

    private void drawShape(Shape3D shape)
    {
        /* Do nového objaktu se uloží transformace, které jsou uložené v želvě */
        shape.getTransforms().addAll(position.getPosition());
    }

    public Group read(String code)
    {
        /* Group je skupina 3D objektů, která se bude přidávat do 3D subscény */
        Group gr = new Group();
        /* Procházení kúodu znak po znaku */
        for(int i = 0, n = code.length() ; i < n ; i++) {
            /* Náhodné číslo kvůli náhodnému růstu listů a plodů(doprava nebo doleva od kořene)*/
            double rn = Math.random();
            double sign = 1; // určení znamíka jestli list či plod poroste doprava nebo doleva
            if (rn < 0.5)
                sign = -1;

            char c = code.charAt(i);
            switch (c) {
                case 'B':
                    /* hnědá větev */
                    this.getPosition().AddTransform(
                            new Translate(0,(-step/2)*this.getPosition().getScale(),0));
                    Branch branch = new Branch(5*this.getPosition().getScale(),
                            this.getStep() * this.getPosition().getScale());
                    /* najití správné pozice a otočení podle pozice želvy */
                    drawShape(branch);
                    /* Přidání větve do skupiny */
                    gr.getChildren().add(branch);
                    this.getPosition().AddTransform(
                            new Translate(0, (-step / 2) * this.getPosition().getScale(), 0));
                    break;
                case 'L':
                    /* velký list */
                    Leaf leaf = new Leaf(50,50);
                    drawShape(leaf);
                    leaf.getTransforms().addAll(
                            new Rotate(sign*this.getDelta()/5, 0,0,0, Rotate.Y_AXIS),
                            new Rotate(sign*this.getDelta()/2, 0,0,0, Rotate.Z_AXIS),
                            new Translate(0,-60,0)
                    );
                    gr.getChildren().add(leaf);
                    break;
                case 'l':
                    /* malý list */
                    Leaf sleaf = new Leaf(25,25);
                    drawShape(sleaf);
                    sleaf.getTransforms().addAll(
                            new Rotate(sign*this.getDelta(), 0,0,0, Rotate.Z_AXIS),
                            new Translate(0,-15,0)
                    );
                    gr.getChildren().add(sleaf);
                    break;
                case 'S':
                    /* stéblo nebo mladá větev */
                    this.getPosition().AddTransform(
                            new Translate(0,(-step/2)*this.getPosition().getScale(),0));
                    Stem stem = new Stem(5*this.getPosition().getScale(),
                            this.getStep() * this.getPosition().getScale());
                    drawShape(stem);
                    gr.getChildren().add(stem);
                    this.getPosition().AddTransform(
                            new Translate(0, (-step / 2) * this.getPosition().getScale(), 0));
                    break;
                case 'F':
                    /* velký plod (nebo kytka) */
                    Flower flower = new Flower(20, Color.RED);
                    drawShape(flower);
                    flower.getTransforms().addAll(new Rotate(sign*this.getDelta(), 0,0,0, Rotate.Z_AXIS),
                            new Translate(0,-15,0)
                    );
                    gr.getChildren().add(flower);
                    break;
                case 'f':
                    /* malý plod nebo kytka */
                    Flower sflower = new Flower(7, Color.YELLOW);
                    drawShape(sflower);
                    sflower.getTransforms().addAll(new Rotate(sign*this.getDelta(), 0,0,0, Rotate.Z_AXIS),
                            new Translate(0,-15,0)
                    );
                    gr.getChildren().add(sflower);
                    break;
                case 'g':
                    /* udělání kroku bez vykreslování */
                    this.getPosition().AddTransform(
                            new Translate(0,(-step/2)*this.getPosition().getScale(),0));
                    break;
                /* Na začátku se želva dívá smšrem nahoru po ose y */
                case '+':
                    //rotace doprava
                    this.getPosition().AddTransform(
                            new Rotate(-delta,0,0,0,Rotate.Z_AXIS));
                    break;
                case '-':
                    //rotace doleva
                    this.getPosition().AddTransform(
                            new Rotate(delta,0,0,0,Rotate.Z_AXIS));
                    break;
                case '&':
                    //rotace dolu
                    this.getPosition().AddTransform(
                            new Rotate(-delta,0,0,0,Rotate.X_AXIS));
                    break;
                case '^':
                    //rotace nahoru
                    this.getPosition().AddTransform(
                            new Rotate(delta,0,0,0,Rotate.X_AXIS));
                    break;
                case '\\':
                    //rotace kolem svojí osy doleva
                    this.getPosition().AddTransform(
                            new Rotate(delta, 0, 0, 0, Rotate.Y_AXIS));
                    break;
                case '/':
                    //rotace kolem svojí osy doprava
                    this.getPosition().AddTransform(
                            new Rotate(-delta, 0, 0, 0, Rotate.Y_AXIS));
                    break;
                case '|':
                    //rotace o 180
                    this.getPosition().AddTransform(
                            new Rotate(180,0,0,0,Rotate.Z_AXIS));
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
                    this.getPosition().setScale(this.getPosition().getScale()*0.8);
                    break;
                default:
                    System.out.println("chybný znak");
                    break;
            }
        }
        /* Vrácení skupiny 3D objektů, která se přidá na subscénu*/
        return gr;
    }

    /* Zapamatování si pozdce želvy */
    public void savePosition() {
        TurtlePosition savedPos = new TurtlePosition();
        savedPos.getTransforms().addAll(position.getPosition());
        savedPos.setScale(position.getScale());
        stack.push(savedPos);
    }

    /* Vrácení na poslední zapamatovanou pozici želvy */
    public void goToLast() {
        //System.out.println(stack.peek());
        this.setPosition(stack.pop());
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
