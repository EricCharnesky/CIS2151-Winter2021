package chapter12.examples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chapter12Examples extends Application {

    public static void main(String[] args) {

        // right click Libraries in the project, add the JavaFX16 library        
        // right click project, go to Run, add this to VM Options
        // make sure the project JDK platfor and JFX versions match - 16 for both
        // --add-modules javafx.controls,javafx.fxml
        // in the Libraries, Run tab, add JavaFX16 to the Module Path
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Chapter12FXML.fxml"));
        //Label helloWorldLabel = new Label("Hello World");
        //VBox vbox = new VBox(helloWorldLabel);
        Scene scene = new Scene(root);
        stage.setTitle("GUI GUI GUI");
        stage.setScene(scene);
        stage.show();
    }

}
