package Cards;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Justa
 *
 */
public class WarRunner {

    /**
     * Start of a game of war.
     * 
     * @param args the argumens from the command line
     * @throws InterruptedException adds delay to the game
     * @throws CloneNotSupportedException thrown if the type is not supported
     */
    public static void main(String[] args)
            throws InterruptedException, CloneNotSupportedException {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Welcome to 'War' the card game, to start, "
//                + "enter the names of the players.");
//        System.out.println("The first player is:");
//        String name1 = in.nextLine();
//        System.out.println("The second player is:");
//        String name2 = in.nextLine();
//        System.out.println();
//        // CardGameWar war = new CardGameWar(name1, name2);
//        Deck deck = new Deck();
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
//        CardPlayer[] players = p;

//        CardPlayer.runCardGameWar(players);
//        in.close();
        new CardPlayer();
    }
}
