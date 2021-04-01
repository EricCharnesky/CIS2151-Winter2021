
package eveningguihelloworld;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMLController implements Initializable {

    @FXML
    private HBox topBox;
    @FXML
    private VBox leftBox;
    @FXML
    private HBox bottomBox;
    @FXML
    private VBox rightBox;
    @FXML
    private RadioButton topButton;
    @FXML
    private RadioButton leftButton;
    @FXML
    private RadioButton bottomButton;
    @FXML
    private RadioButton rightButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonClicked(ActionEvent event) {
        Label newLabel = new Label("Hello world!");
        if ( topButton.isSelected()) {
            topBox.getChildren().add(newLabel);
        }
        else if ( rightButton.isSelected()){
            rightBox.getChildren().add(newLabel);
        }
        else if ( bottomButton.isSelected()){
            bottomBox.getChildren().add(newLabel);
        }
        else if ( leftButton.isSelected()){
            leftBox.getChildren().add(newLabel);
        }
    }
    
}
