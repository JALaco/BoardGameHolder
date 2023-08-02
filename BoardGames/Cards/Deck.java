package Cards;
import java.util.ArrayList;

/**
 * A deck of cards.
 * 
 * @author Justin Lacombe
 * @version 8/7/2022
 */
public class Deck {

    private int size;
    private ArrayList<Card> cards;

    /**
     * Constructs a deck object
     */
    public Deck() {
        int num = 0;
        this.cards = new ArrayList<Card>();
        for (int i = 1; i < Card.RANKS.length; i++) {
            for (int j = 0; j < Card.SUITS.length; j++) {
                this.cards.add(new Card(i, j));
                num++;
            }
        }
        this.size = cards.size();
    }

    /**
     * Arguments from the command line.
     * 
     * @param args args from the command line
     * @throws CloneNotSupportedException thrown if the type is not supported
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Deck d = new Deck();
        System.out.println(d);
        d.shuffleDeck();
        System.out.println(d);
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.cards.size(); i++) {
            str = str + this.cards.get(i).toString() + "\n";
        }
        return str;
    }

    /**
     * Shuffles the deck.
     * 
     * @throws CloneNotSupportedException thrown if the type is not supported
     */
    public void shuffleDeck() throws CloneNotSupportedException {
        Deck d = new Deck();
        this.cards.clear();

        for (int i = 0; i < 52; i++) {
            int place = (int) (100 * Math.random()) % d.cards.size();
            this.cards.add(d.cards.get(place));
            d.cards.remove(place);
        }

//        Card[] dupe = new Card[26];
//        for (int i = 1; i < Card.RANKS.length; i++) {
//            for (int j = 0; j < Card.SUITS.length; j++) {
//                int place = (int) (100 * Math.random()) % dupe.length;
//                if (dupe[place] == null) {
//                    dupe[place] = new Card(i, j);
//                } else {
//                    j--;
//                }
////                if (dupe.size() < 26) {
////                    int place = (int) (100 * Math.random()) % dupe.size();
////                    this.cards.add(new Card(i, j));
////                }
//
//            }
//        }
////        ArrayList<Card> returnCards = new ArrayList<Card>();
//        for (int k = 0; k < dupe.length; k++) {
//            this.cards.add(dupe[k]);
//        }

    }

//        // Resets the deck to being blank
//        this.cards = new ArrayList<Card>();
//
//        for (int i = 1; i < Card.RANKS.length; i++) {
//            for (int j = 0; j < Card.SUITS.length; j++) {
//                int place = (int) (100 * Math.random()) % 52;
//                if (this.cards.get(place) == null) {
//                    this.cards.add(new Card(i, j));
//                } else {
//                    j--;
//                }
//            }
//        }

    public int getSize() {
        return size;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> firstHalfDeck(ArrayList<Card> c) {
        ArrayList<Card> deck = c;
        for (int i = 0; i < this.getSize() / 2; i++) {
            deck.add(this.cards.get(i));
        }
        return deck;
    }

    public ArrayList<Card> secondHalfDeck(ArrayList<Card> c) {
        ArrayList<Card> deck = c;
        for (int i = this.getSize() / 2; i < this.getSize(); i++) {
            deck.add(this.cards.get(i));
        }
        return deck;
    }
}
