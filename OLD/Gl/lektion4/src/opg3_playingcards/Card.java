package opg3_playingcards;

/**
 * VOP eksamen F2014
 * Tom klasse til opgave 3
 * @author erso
 */
public class Card implements CardInterface {
    private int suit;
    private int face;

    public Card (int face, int suit) {
        this.suit = suit;
        this.face = face;
    }

    public String toString () {
        String card = " ";
        if (suit < 1)
            return "This is not a valid card";
        if (suit > 4)
            return "this is not a valid card";
        if (face < 1)
            return "this is not a valid card";
        if (face > 13)
            return "this is not a valid card";

        switch (suit) {
            case SPADES:
                card += SPADES_NAME;
                break;
            case CLUBS:
                card += CLUBS_NAME;
                break;
            case DIAMONDS:
                card += DIAMONDS_NAME;
                break;
            case HEARTS:
                card += HEARTS_NAME;
                break;
        }
        switch (face) {
            case ACE:
                card += ACE_NAME;
                break;
            case JACK:
                card += JACK_NAME;
                break;
            case QUEEN:
                card += QUEEN_NAME;
                break;
            case KING:
                card += KING_NAME;
                break;
            }
            if(face >1 && face < 11)
                card += face;

            return card;
    }
    public static void main(String[] args) {
        System.out.println(new Card(1, 3));
        System.out.println(new Card(3, 1));
        System.out.println(new Card(13, 4));
        System.out.println(new Card(12, 3));
        System.out.println(new Card(17, 5));
    }
}
