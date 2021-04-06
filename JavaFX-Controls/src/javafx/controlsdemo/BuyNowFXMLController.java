/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.controlsdemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BuyNowFXMLController implements Initializable {

    int value;
    
    @FXML
    private Label textLabel;

    public BuyNowFXMLController()
    {
        value = 0;
    }
    
    public BuyNowFXMLController(int value) {
        this.value = value;
    }
    
    public void setValue(int value)
    {
        this.value = value;
        textLabel.setText(Integer.toString(value));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textLabel.setText(Integer.toString(value));
    }

}
