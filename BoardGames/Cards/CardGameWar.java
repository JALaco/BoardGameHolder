package Cards;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Starts a card game of war.
 * 
 * @author Justin Lacombe
 * @version 8/8/2022
 */
public class CardGameWar {

    private Deck deck;
    private CardPlayer[] players;

    /**
     * The constructor of a Card game of war.
     * 
     * @param name1 Name of player 1
     * @param name2 Name of player 2
     * @throws InterruptedException thrown to cause delay
     * @throws CloneNotSupportedException thrown if the type is not supported
     */
    public CardGameWar(String name1, String name2)
            throws InterruptedException, CloneNotSupportedException {
//        this.deck = new Deck();
//
//        deck.shuffleDeck();
//
//        ArrayList<Card> name1Deck = new ArrayList<>();
//        ArrayList<Card> name2Deck = new ArrayList<>();
//
//        name1Deck = deck.firstHalfDeck(name1Deck);
//        name2Deck = deck.secondHalfDeck(name2Deck);
//
//        CardPlayer[] p = {new CardPlayer(name1, name1Deck),
//                new CardPlayer(name2, name2Deck)};
//        this.players = p;
//
//        CardPlayer.runCardGameWar(players);
    }

    /**
     * Start of a game of war.
     * 
     * @param args the argumens from the command line
     * @throws InterruptedException adds delay to the game
     * @throws CloneNotSupportedException thrown if the type is not supported
     */
    public static void main(String[] args)
            throws InterruptedException, CloneNotSupportedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to 'War' the card game, to start, "
                + "enter the names of the players.");
        System.out.println("The first player is:");
        String name1 = in.nextLine();
        System.out.println("The second player is:");
        String name2 = in.nextLine();
        System.out.println();
        // CardGameWar war = new CardGameWar(name1, name2);
        Deck deck = new Deck();

        deck.shuffleDeck();

        ArrayList<Card> name1Deck = new ArrayList<>();
        ArrayList<Card> name2Deck = new ArrayList<>();

        name1Deck = deck.firstHalfDeck(name1Deck);
        name2Deck = deck.secondHalfDeck(name2Deck);

        CardPlayer[] p = {new CardPlayer(name1, name1Deck),
                new CardPlayer(name2, name2Deck)};
        CardPlayer[] players = p;

        CardPlayer.runCardGameWar(players);
        in.close();
    }

}
