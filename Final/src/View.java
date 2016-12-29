

//import controller.FinalXMLController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * View for FINAL output
 * @author Mr. Chad Steffl, S02269293
 * @version 1.3, 12/11/16, Final Project, CSC 241
 */
public class View extends Application {
    
    /**
     * Show GUI
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FinalXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Character Builder");
        stage.setScene(scene);
        stage.show();
    }
}
    
    

