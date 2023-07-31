import java.util.ArrayList;

/**
 * A single playing card.
 * 
 * @author Justin Lacombe
 * @version 8/7/2022
 */
public class Card {

    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts",
            "Spades"};

    private final int rank;
    private final int suit;

    /**
     * The constructor.
     * 
     * @param rank The rank of the card
     * @param suit The suit of the card
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Turns a card into a string.
     * 
     * @return The card as a string.
     */
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    /**
     * Determines if a card is the same as another.
     * 
     * @param that The card to check against
     * @return Whether or not they are the same card
     */
    public boolean equals(Card that) {
        return this.rank == that.rank && this.suit == that.suit;
    }

    /**
     * Checks to see if a card is "higher", "lower", or the same in terms of
     * value.
     * 
     * @param that The card to check against
     * @return The comparison of the cards (-1 if this card is lower in value, 1
     *     if it is higher, and 0 if they are the same value)
     */
    public int compareTo(Card that) {
        // DIFFERNT FOR THE CARD GAME WAR (SUIT DOES NOT MATTER)
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    /**
     * Prints a deck of cards
     * 
     * @param cards
     */
    public static void printDeck(ArrayList<Card> cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

}
