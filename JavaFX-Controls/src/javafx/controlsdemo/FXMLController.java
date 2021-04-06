package javafx.controlsdemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private Label textLabel;
    @FXML
    private Slider tensSlider;
    @FXML
    private Slider onesSlider;
    @FXML
    private TextField textField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button buyNowButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tensSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) -> {
                    updateLabel();
                }
        );

        onesSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) -> {
                    updateLabel();
                }
        );
    }

    private void updateLabel() {
        int value = 0;

        value += onesSlider.getValue();
        value += Math.round(tensSlider.getValue()) * 10;

        textLabel.setText("$" + Integer.toString(value));

        if (Integer.parseInt(textField.getText()) != value) {
            textField.setText(Integer.toString(value));

            // https://stackoverflow.com/questions/8293774/set-caret-position-in-javafx-scene-control-textarea-and-javafx-scene-control-tex
            textField.positionCaret(textField.getText().length());
        }
    }

    @FXML
    private void textChanged(KeyEvent event) {
        try {
            int value = Integer.parseInt(textField.getText());
            if (value < 0 || value >= 100) {
                errorLabel.setText("Please enter a value between 0-99");
            } else {
                errorLabel.setText("");
                onesSlider.setValue(value % 10);
                tensSlider.setValue(value / 10); // integer division is good here
            }

        } catch (NumberFormatException exception) {
            errorLabel.setText("Please enter a valid number!");
        }
    }

    @FXML
    private void buyNowButtonClicked(ActionEvent event) {
        Stage stage = (Stage) buyNowButton.getScene().getWindow();
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyNowFXML.fxml"));
            //BuyNowFXMLController controller = new BuyNowFXMLController(Integer.parseInt(textField.getText()));
            //loader.setController(controller);
            
            Parent root = loader.load();
            
            BuyNowFXMLController controller = loader.getController();
            controller.setValue(Integer.parseInt(textField.getText()));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
