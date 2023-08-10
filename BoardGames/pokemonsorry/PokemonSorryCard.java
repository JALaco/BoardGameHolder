package pokemonsorry;

import java.util.ArrayList;

/**
 * A single playing card.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 */
public class PokemonSorryCard {

    public static final String[] RANKS = {"Sorry", "1", "2", "3", "4", "5", "7",
            "8", "10", "11", "12"};

    public static final String[] SUITS = {"Normal", "Fire", "Water", "Grass",
            "Electric"};

    private final int rank;
    private final int suit;

    /**
     * The constructor.
     * 
     * @param rank The rank of the card
     * @param suit The suit of the card
     */
    public PokemonSorryCard(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Turns a card into a string.
     * 
     * @return The card as a string.
     */
    public String toString() {
        return SUITS[this.suit] + " " + RANKS[this.rank];
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    /**
     * Prints a deck of cards.
     * 
     * @param cards all cards
     */
    public static void printDeck(ArrayList<PokemonSorryCard> cards) {
        for (PokemonSorryCard card : cards) {
            System.out.println(card);
        }
    }

}
