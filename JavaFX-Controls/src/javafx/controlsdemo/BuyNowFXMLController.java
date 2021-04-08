/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.controlsdemo;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class BuyNowFXMLController implements Initializable {

    int value;

    @FXML
    private Label textLabel;
    @FXML
    private CheckBox firstCheckBox;
    @FXML
    private CheckBox secondCheckBox;
    @FXML
    private CheckBox thirdCheckBox;
    @FXML
    private CheckBox fourthCheckBox;
    @FXML
    private CheckBox fifthCheckBox;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label thirdLabel;
    @FXML
    private Label fourthLabel;

    private Random random;

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    private int rolls;

    @FXML
    private Label fifthLabel;

    public BuyNowFXMLController() {
        value = 0;
        random = new Random();
        rolls = 0;
    }

    private void roll() {

        if (!firstCheckBox.isSelected()) {
            first = random.nextInt(6) + 1;
        }
        if (!secondCheckBox.isSelected()) {
            second = random.nextInt(6) + 1;
        }
        if (!thirdCheckBox.isSelected()) {
            third = random.nextInt(6) + 1;
        }
        if (!fourthCheckBox.isSelected()) {
            fourth = random.nextInt(6) + 1;
        }
        if (!fifthCheckBox.isSelected()) {
            fifth = random.nextInt(6) + 1;
        }

        rolls++;

        updateLabels();
    }

    private void updateLabels() {
        firstLabel.setText(Integer.toString(first));
        secondLabel.setText(Integer.toString(second));
        thirdLabel.setText(Integer.toString(third));
        fourthLabel.setText(Integer.toString(fourth));
        fifthLabel.setText(Integer.toString(fifth));

        textLabel.setText("Roll number " + Integer.toString(rolls));
    }

//    
//    public BuyNowFXMLController(int value) {
//        this.value = value;
//    }
    public void setValue(int value) {
        this.value = value;
        textLabel.setText(Integer.toString(value));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textLabel.setText(Integer.toString(value));
        // you can't interact with FXML objects until initialize - not in the constructor
        roll();
    }

    private void checkBoxClicked(ActionEvent event) {
        if (event.getSource() == firstCheckBox && firstCheckBox.isSelected()) {
            textLabel.setText("first button!");
        } else if (event.getSource() == secondCheckBox && secondCheckBox.isSelected()) {
            textLabel.setText("second button!");
        } else if (event.getSource() == thirdCheckBox && thirdCheckBox.isSelected()) {
            textLabel.setText("third button!");
        }
    }

    @FXML
    private void rollButtonClicked(ActionEvent event) {
        roll();
    }

}
