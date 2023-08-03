package tictactoe;

/**
 * TicTacToe player.
 * 
 * @author Justin Lacombe
 * @version 8/3/2023
 */
public class TicTacToePlayer {

    private String name;
    private String letter;
    private int turns;

    /**
     * Default constructor.
     * 
     */
    public TicTacToePlayer() {
        this.name = "";
    }

    /**
     * Constructor.
     * 
     * @param name the name of the player
     */
    public TicTacToePlayer(String name, String letter, int turns) {
        this.name = name;
        this.letter = letter;
        this.turns = turns;
    }

    public String getName() {
        return this.name;
    }

    public int getTurns() {
        return this.turns;
    }
}
