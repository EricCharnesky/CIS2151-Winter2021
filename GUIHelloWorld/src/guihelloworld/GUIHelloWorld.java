
package guihelloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIHelloWorld extends Application {

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
        // change the name of your fxml file to match
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("GUI GUI GUI");
        stage.setScene(scene);
        stage.show();
    }
    
}
