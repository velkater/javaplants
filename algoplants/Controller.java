package algoplants;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;


public class Controller {
    @FXML Rectangle rect;

    public void novy(ActionEvent actionEvent) {
       rect.setFill(Color.web("#0076a3"));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.showAndWait();
    }
}
