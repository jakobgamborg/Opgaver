/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jajoe18vopreeksamenf18;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import population.TownStatistics;

/**
 * @author jakob
 */
public class FXMLDocumentController implements Initializable {

// Opgave 1
    @FXML
    private TextField scrollField;
    @FXML
    private Button stop;
    @FXML
    private Button start;
    @FXML
    private RadioButton word;
    @FXML
    private RadioButton character;
    @FXML
    private ToggleGroup scrollGroup;
    @FXML
    private Label scrollLabel;

    private Thread thread;
    private long waitTime;
    private int scrollUpdates;

    // Opgave 2
    @FXML
    private Button readFileButton;
    @FXML
    private Button sortButton;
    @FXML
    private Button clearButton;
    @FXML
    private TextArea townTextArea;

    private TownStatistics townStat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        waitTime = 200;
        townStat = new TownStatistics();
    }


    @FXML
    private void scrollHandler(ActionEvent event) {
        if (event.getSource() == start) {
            scrollUpdates = 0;
            Runnable runner = character.isSelected()
                    ? new CharacterScroller()
                    : new WordScroller();


            thread = new Thread(runner);
            thread.setDaemon(true);
            thread.start();
        } else if (event.getSource() == stop) {
            thread.interrupt();
        }

    }

    public void populationHandler(ActionEvent event) {
        if(event.getSource() == readFileButton) {
            townStat.readFile("Danske Byer.txt");
            townTextArea.setText(townStat.toString());
        }
        else if (event.getSource() == sortButton) {
            townStat.sort();
            townTextArea.setText(townStat.toString());
        }
        else if (event.getSource() == clearButton){
            townTextArea.setText(null);
        }
    }



    private class CharacterScroller implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    scrollUpdates++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            scrollField.setText(scrollField.getText()
                                    .substring(1, scrollField.getText().length())
                                    + scrollField.getText().charAt(0));
                            scrollLabel.setText("Updates: " + scrollUpdates);
                        }
                    });
                    Thread.sleep(waitTime);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    public class WordScroller implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    String[] words = scrollField.getText().split(" ");
                    scrollUpdates++;
                    scrollField.clear();
                    scrollUpdates++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 1; i < words.length; i++) {
                                scrollField.appendText(words[i]);
                                scrollField.appendText(" ");
                            }
                            scrollField.appendText(words[0]);
                            scrollLabel.setText("Updates " + scrollUpdates);
                        }
                    });
                    Thread.sleep(waitTime);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
