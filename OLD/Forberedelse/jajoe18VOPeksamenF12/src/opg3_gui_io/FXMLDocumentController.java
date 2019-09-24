/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg3_gui_io;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private TextArea textArea;

    @FXML
    private RadioButton textRadio;

    @FXML
    private RadioButton objectRadio;

    @FXML
    private TextField textField;

    @FXML
    private Button writeButton;

    @FXML
    private Button readButton;

    private FileIOInterface fileIO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void textHandler(ActionEvent event) {
        if(textRadio.isSelected()){
            fileIO = new TextFile();
        }
        else {
            fileIO = new ObjFile();
        }

        if(event.getSource() == writeButton){
            fileIO.writeToFile(textField.getText());
        }
        else if (event.getSource() == readButton) {
            textArea.setText(fileIO != null ? fileIO.readFromFile() : "No File Found");
        }
    }
}
