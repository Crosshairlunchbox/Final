

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class for the ERROR popup Dialog
 *
 * @author Mr. Chad Steffl, S02269293
 * @version 1.3, 12/11/16, Final Project, CSC 241
 */
public class ErrorXMLController implements Initializable {
    
  
    /** Continue through error button for popup GUI
     */
    @FXML
    private static Button continueButton;
    
    /**
     * Window height in pixels
     */
    private static final int WINDOW_HEIGHT = 300;
    
    /**
     * Window width in pixels
     */
    private static final int WINDOW_WIDTH = 100;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showStage();
    }    
    
    /**
     * Make error popup dialog appear and manually set the information.
     * POPUP message informs user that not enough information was entered.
     */
    public static void showStage(){
        Stage newStage = new Stage();
        HBox topLevel = new HBox();
        Label warning = new Label("Warning! Insufficient Data.");
        continueButton = new Button("Continue");
        topLevel.getChildren().add(warning);
        topLevel.getChildren().add(continueButton);
        
        Scene popupScene = new Scene(topLevel, WINDOW_HEIGHT, WINDOW_WIDTH);
        newStage.setScene(popupScene);
        newStage.show();
                
        continueButton.setOnAction((ActionEvent e) -> {
            newStage.close();
        });
                
    }

}
