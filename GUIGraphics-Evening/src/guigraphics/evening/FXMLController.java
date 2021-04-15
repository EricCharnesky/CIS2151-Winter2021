package guigraphics.evening;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLController implements Initializable {

    @FXML
    private ImageView imageViewLeft;
    @FXML
    private ImageView imageViewRight;
    @FXML
    private Pane pane;
    @FXML
    private Slider hueSlider;
    @FXML
    private Slider saturationSlider;
    @FXML
    private Slider brigthnessSlider;
    @FXML
    private Slider contrastSlider;

    private double hue = 0;

    private ColorAdjust colorAdjust;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorAdjust = new ColorAdjust();

        Blend blend = new Blend();
        blend.setMode(BlendMode.ADD);
        blend.setTopInput(colorAdjust);
        blend.setBottomInput(new Reflection());
        imageViewRight.setEffect(blend);
        hueSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) -> {
                    applyColorAdjust();
                });
        saturationSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) -> {
                    applyColorAdjust();
                });
        brigthnessSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) -> {
                    applyColorAdjust();
                });
        contrastSlider.valueProperty().addListener(
                (observable, oldvalue, newvalue) -> {
                    applyColorAdjust();
                });

        // https://stackoverflow.com/questions/38566638/javafx-displaying-time-and-refresh-in-every-second
        Thread timerThread = new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(100); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    updateHue();
                });
            }
        });

        timerThread.start();//start the thread and its ok

    }

    private void updateHue() {
        hue += .01;
        if (hue > 1) {
            hue = -1;
        }
        hueSlider.setValue(hue);
    }

    private void applyColorAdjust() {

        colorAdjust.setHue(hueSlider.getValue());
        colorAdjust.setContrast(contrastSlider.getValue());
        colorAdjust.setBrightness(brigthnessSlider.getValue());
        colorAdjust.setSaturation(saturationSlider.getValue());

    }

    @FXML
    private void buttonClick(ActionEvent event) {
        Image image = new Image("images/AceOfSpades.png");

        imageViewLeft.setImage(image);

        // already set in scene builder, but here's how to do it in code
        Reflection reflection = new Reflection();
        reflection.setFraction(.7);
        imageViewLeft.setEffect(reflection);

        Rectangle rectangle = new Rectangle();

        rectangle.setX(0);
        rectangle.setY(0);

        rectangle.setWidth(100);
        rectangle.setHeight(175);

        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);

        rectangle.setStroke(Color.DODGERBLUE);
        rectangle.setFill(Color.TRANSPARENT);

        Rectangle diamond1 = new Rectangle(20, 20, Color.RED);
        diamond1.setX(40);
        diamond1.setY(20);
        diamond1.setRotate(45);

        Rectangle diamond2 = new Rectangle(20, 20, Color.RED);
        diamond2.setX(40);
        diamond2.setY(140);
        diamond2.setRotate(45);

        Text text = new Text(80, 20, "2");
        text.setFont(new Font("Comic Sans", 20));
        text.setStroke(Color.RED);

        pane.getChildren().add(rectangle);
        pane.getChildren().add(diamond1);
        pane.getChildren().add(diamond2);
        pane.getChildren().add(text);

    }

}
