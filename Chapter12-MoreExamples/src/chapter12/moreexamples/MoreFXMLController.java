
package chapter12.moreexamples;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MoreFXMLController implements Initializable {

    @FXML
    private HBox topBox;
    @FXML
    private VBox leftBox;
    @FXML
    private HBox bottomBox;
    @FXML
    private VBox rightBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void buttonClick(ActionEvent event) {
        Label label = new Label("Happy April 1st!");
        leftBox.getChildren().add(label);
        label = new Label("Happy April 1st!");
        rightBox.getChildren().add(label);
        label = new Label("Happy April 1st!");
        topBox.getChildren().add(label);
        label = new Label("Happy April 1st!");
        bottomBox.getChildren().add(label);
    }
    
}
