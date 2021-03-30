
package chapter12.examples;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author EricC
 */
public class Chapter12FXMLController implements Initializable {

    @FXML
    private Label bottomTextLabel;
    @FXML
    private HBox topBox;
    @FXML
    private VBox verticalBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void centerButton(ActionEvent event) {
        Label newLabel = new Label("Center click");
        
        topBox.getChildren().add(newLabel);
        
        bottomTextLabel.setText("Hello Center Button");
    }

    @FXML
    private void rightButon(ActionEvent event) {
        
         Label newLabel = new Label("Right click");
        
        verticalBox.getChildren().add(newLabel);
        
        bottomTextLabel.setText("Hello right Button");
    }
    
}
