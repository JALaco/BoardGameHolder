import java.util.ArrayList;
import java.util.Scanner;

/**
 * A player in a game of cards.
 * 
 * @author Justin Lacombe
 * @version 8/8/2022
 */
public class CardPlayer {

    private ArrayList<Card> cards;
    private String name;

    /**
     * Default constructor of a CardPlayer
     * 
     * @param name the name of the player
     * @throws CloneNotSupportedException
     * @throws InterruptedException
     */
    public CardPlayer()
            throws CloneNotSupportedException, InterruptedException {
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

        this.runCardGameWar(players);
        in.close();
    }

    /**
     * Default constructor of a CardPlayer
     * 
     * @param name the name of the player
     * @throws CloneNotSupportedException
     * @throws InterruptedException
     */
    public CardPlayer(String name) {
        // add turn parameter? and +1 or -1 in CardGameWar after each turn
        this.name = name;
        this.cards = null;
    }

    /**
     * CardPlayer constructor.
     * 
     * @param name the name of the player
     * @param cards the player's deck
     */
    public CardPlayer(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    /**
     * Begins the card game.
     * 
     * @param newPlayers the players of the card game
     * @throws InterruptedException thrown to cause delay
     */
    public static void runCardGameWar(CardPlayer[] newPlayers)
            throws InterruptedException {
        CardPlayer[] players = newPlayers;
        CardPlayer player1 = players[0];
        CardPlayer player2 = players[1];
        System.out.println("The game of 'War' between " + player1.name + " and "
                + player2.name + " will now start.\n");

        while (player1.cards.size() != 0 || player2.cards.size() != 0) {
            players = seeWhoWins(players);

            if (player1.cards.size() == 0) {
                break;
            } else if (player2.cards.size() == 0) {
                break;
            }
        }
        if (player1.cards.size() == 0) {
            System.out.println(player2.name + " HAS WON THE GAME OF WAR");
        } else if (player2.cards.size() == 0) {
            System.out.println(player1.name + " HAS WON THE GAME OF WAR");
        }
    }

    public String getName() {
        return this.name;
    }

    /**
     * How many cards are left in this player's deck.
     * 
     * @return the number of remaining cards
     */
    public int cardsRemain() {
        return cards.size();
    }

    /**
     * Adds all of the cards in the given deck to this player's cards.
     * 
     * @param cards the cards to add
     */
    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Starts a war between two players.
     * 
     * @param newPlayers the players to do war
     * @return the players' changed decks after the war
     * @throws InterruptedException thrown to add delay
     */
    public static CardPlayer[] startWar(CardPlayer[] newPlayers)
            throws InterruptedException {
        CardPlayer player1 = newPlayers[0];
        CardPlayer player2 = newPlayers[1];
        CardPlayer[] players = newPlayers;
        int one = 0;
        int two = 0;
        ArrayList<Card> removed = new ArrayList<Card>();

        // removes the cards for the war
        if (player1.cardsRemain() > 3) {
            removed.addAll(player1.subList(0, 3));
            one = newPlayers[0].cards.size() - 3;
        } else if (player1.cardsRemain() == 1) {
            players = seeWhoWins(players);
            one = 1;
        } else if (player1.cards.size() < 4) {
            removed = player1.subList(0, player1.cardsRemain() - 1);
            one = newPlayers[0].cards.size() - player1.cardsRemain() - 1;
        }

        if (player2.cardsRemain() > 3) {
            removed.addAll(player2.subList(0, 3));
            two = newPlayers[1].cards.size() - 3;
        } else if (player2.cardsRemain() == 1) {
            players = seeWhoWins(players);
            two = 1;
        } else if (player1.cards.size() < 4) {
            removed.addAll(player2.subList(0, player2.cardsRemain() - 1));
            two = newPlayers[1].cards.size() - player2.cardsRemain() - 1;
        }

        players = seeWhoWins(players);

        if (player1.cards.size() > one) {
            player1.cards.addAll(removed);
        } else if (player2.cards.size() > two) {
            player2.cards.addAll(removed);
        }

        if (player1.cards.size() == 0) {
            System.out.println(player2.name + " HAS WON THE GAME OF WAR");
        } else if (player2.cards.size() == 0) {
            System.out.println(player1.name + " HAS WON THE GAME OF WAR");
        }

        return players;

    }

    /**
     * Removes the cards from a player.
     * 
     * @param start where to start removing
     * @param end where to stop removing
     * @return the player's cards after all necessary cards have been removed
     */
    public ArrayList<Card> subList(int start, int end) {
        ArrayList<Card> newDeck = new ArrayList<Card>();
        for (int i = start; i < end; i++) {
            newDeck.add(this.cards.get(0));
            this.cards.remove(0);
        }
        return newDeck;
    }

    /**
     * Sees whose card has a higher value and gives the winner both cards. If
     * both cards have the same value, it starts a war.
     * 
     * @param newPlayers the players
     * @return the players after giving the winner the cards.
     * @throws InterruptedException thrown to add delay
     */
    public static CardPlayer[] seeWhoWins(CardPlayer[] newPlayers)
            throws InterruptedException {
        CardPlayer[] players = newPlayers;
        CardPlayer player1 = players[0];
        CardPlayer player2 = players[1];

        if (player1.cards.size() == 0 || player2.cards.size() == 0) {
            return players;
        }

        Thread.sleep(2000);

        // 17 is the longest a card would be as a string
        // System.out.printf("%s(%d): %17s\t%s(%d): %s\n", player1.name,
        // player1.cardsRemain(), player1.cards.get(0), player2.name,
        // player2.cardsRemain(), player2.cards.get(0));
        System.out.printf("%s(%d): %17s\t%17s :%s(%d)\n", player1.name,
                player1.cardsRemain(), player1.cards.get(0),
                player2.cards.get(0), player2.name, player2.cardsRemain());

        if (player1.cards.get(0).getRank() > player2.cards.get(0).getRank()) {
            System.out.println(player1.name + " has the better card!\n");
            // adds both cards to the end of the winner's deck
            player1.cards.add(player2.cards.get(0));
            player1.cards.add(player1.cards.get(0));

            // removes both cards that were just played
            player1.cards.remove(0);
            player2.cards.remove(0);

        } else if (player2.cards.get(0).getRank() > player1.cards.get(
                0).getRank()) {
            System.out.println(player2.name + " has the better card!\n");
            // adds both cards to the end of the winner's deck
            player2.cards.add(player1.cards.get(0));
            player2.cards.add(player2.cards.get(0));

            // removes both cards that were just played
            player1.cards.remove(0);
            player2.cards.remove(0);
        } else if (player2.cards.get(0).getRank() == player1.cards.get(
                0).getRank()) {
            System.out.println("\nBoth cards are the same, war!");
            Thread.sleep(1000);
            System.out.println("Both players lay down 3 cards.\n");
            Thread.sleep(2000);

            players = startWar(players);
        }
        return newPlayers;
    }

}
