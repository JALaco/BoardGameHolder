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
    private boolean turn;

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
     * @param letter x or o
     * @param turn whether or not it is this player's turn
     */
    public TicTacToePlayer(String name, String letter, boolean turn) {
        this.name = name;
        this.letter = letter;
        this.turn = turn;
    }

    public String getName() {
        return this.name;
    }

    public String getLetter() {
        return this.letter;
    }

    public boolean getTurn() {
        return this.turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
