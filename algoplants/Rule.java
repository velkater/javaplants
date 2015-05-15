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
        choice.getItems().addAll('B', 'L','S', 'F');
        text = new TextField();
        text.setMinWidth(200);
        this.getChildren().add(choice);
        this.getChildren().add(text);
    }

    public Character getKey()
    {
        return (Character) this.choice.getValue();
    }
    public String getCode()
    {
        if (text.getText() != "")
            return text.getText();
        else return null;
    }
}
