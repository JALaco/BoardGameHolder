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
    public TicTacToePlayer(String name, String letter) {
        this.name = name;
        this.letter = letter;
    }

    public String getName() {
        return this.name;
    }
}
