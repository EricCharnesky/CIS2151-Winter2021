
package gui.graphics;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Pane drawingPane;
    
    private ArrayList<String> values;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        values = new ArrayList<String>();
    }    

    @FXML
    private void buttonClick(ActionEvent event) {
        // package/image
        Image aceOfSpades = new Image("images/AceOfSpades.png");
        imageViewLeft.setImage(aceOfSpades);
        
        values.add("some value");
        
        Rectangle rectangle = new Rectangle();
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setWidth(100);
        rectangle.setHeight(200);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.TRANSPARENT);
        
        Rectangle diamond = new Rectangle();
        diamond.setX(40);
        diamond.setY(20);
        diamond.setWidth(20);
        diamond.setHeight(20);
        diamond.setFill(Color.RED);
        diamond.setRotate(45);
        
        Rectangle diamond2 = new Rectangle();
        diamond2.setX(40);
        diamond2.setY(160);
        diamond2.setWidth(20);
        diamond2.setHeight(20);
        diamond2.setFill(Color.RED);
        diamond2.setRotate(45);
        
        Text text = new Text(80, 20, "2");
        text.setFont( new Font("Comic Sans", 24));
        text.setStroke(Color.RED);
        
        drawingPane.getChildren().add(rectangle);
        drawingPane.getChildren().add(diamond);
        drawingPane.getChildren().add(diamond2);
        drawingPane.getChildren().add(text);
        
    }
    
}
