package pokemonsorry;

import java.util.ArrayList;

/**
 * Runs a game of Pokemon sorry.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 *
 */
public class SorryRunner {

    /**
     * Start of the program.
     * 
     * @param args from the command line
     */
    public static void main(String[] args) {
        PokemonSorry ps = new PokemonSorry();
        ArrayList<PokemonSorryCard> print = ps.cards;
        PokemonSorryCard.printDeck(print);
//        System.out.println("hi");
    }
}
