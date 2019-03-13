package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import opg2_numberplates.NumberPlates;
import opg3_playingcards.DeckOfCards;

import java.awt.*;

public class Controller {
    private NumberPlates numberPlates;
    @FXML private Button tjekKnap;
    @FXML private TextField nummerpladeInput;
    @FXML private Label resultat;
    @FXML private DeckOfCards deckOfCards;
    @FXML private TextField kortTekst;
    @FXML private RadioButton radio50;
    @FXML private RadioButton radio100;
    @FXML private RadioButton radio250;
    @FXML private ToggleGroup shuffleGroup;

    @FXML
    public void initialize() {
        deckOfCards = new DeckOfCards();
        kortTekst.setText(deckOfCards.toString());
        try {
            numberPlates = new NumberPlates();
        } catch (Exception exception) {
            showError(exception.getMessage());
        }
    }

    private void showError(String message) {
        System.out.println(message);
    }

    public void btnHandle(ActionEvent actionEvent) {
        String numberPlate = nummerpladeInput.getText();
        resultat.setText(numberPlates.validate(numberPlate));
    }

    public void btnHandletwo(ActionEvent actionEvent) {
        if(radio50.isSelected()) {
            deckOfCards.shuffle(50);
        }
        else if(radio100.isSelected()) {
            deckOfCards.shuffle(100);
        } else {
            deckOfCards.shuffle(250);
        }
        kortTekst.setText(deckOfCards.toString());
    }
}
