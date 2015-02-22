package algoplants;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Rule extends HBox{

    TextField text;
    ChoiceBox choice;
    public Rule() {
        super();
        choice = new ChoiceBox();
        choice.getItems().addAll("1", "2","3");
        text = new TextField();
        text.setMinWidth(350);
        this.getChildren().add(choice);
        this.getChildren().add(text);
    }
}
