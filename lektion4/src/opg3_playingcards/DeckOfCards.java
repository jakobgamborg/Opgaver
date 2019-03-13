package opg3_playingcards;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * VOP eksamen F2014
 * Kodeskelet til opgave 3c og 3d
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards(){
        deck = new Card[NUMBER_OF_CARDS];
        int i = 0;
        for(int j = ACE; j<=KING; j++) {
                for (int k = CLUBS; k<= SPADES; k++){
                    deck[i] = new Card(j,k);
                    i++;
                }
            }
        }

    // Faerdiskrevet metode til "paen" udskrift af kortbunken
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        Random ran = new Random();

        for (int i = 1; i<swaps;i++){
            int randomOne = ran.nextInt(51);
            int randomTwo = ran.nextInt(51);
            Collections.swap(Arrays.asList(deck),randomOne,randomTwo);
        }
    }

   
    public static void main(String[] args) {
        
            // Til test af opg 3 c
            DeckOfCards deckOfCards = new DeckOfCards();

            System.out.println("Opg 3c:\n" + deckOfCards);
            // Til test af opg 3 d
            deckOfCards.shuffle(2);
            System.out.println("Opg 3d:\n" + deckOfCards);
        

    }

}
