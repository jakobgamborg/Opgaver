/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jajoe18vopreeksamenf18;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author jakob
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField ScrollingText;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public class CharacterScroller implements Runnable {

        @Override
        public void run() {
            String text = ScrollingText.getText();
            char[] charArray = text.toCharArray();
            for(int i = 0; i < charArray.length; i++){
                charArray[i] =                     
            }
        }
    }
    public class WordScroller implements  Runnable {

        @Override
        public void run() {

        }
    }
}
