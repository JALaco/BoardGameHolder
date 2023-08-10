package pokemonsorry;

import java.util.HashMap;

/**
 * Player of Pokemon Sorry.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 *
 */
public class PokemonPlayer {

    private String team;
    private String playerName;
    private HashMap<String, SorryPiece> pieces;

    /**
     * Default Constructor.
     * 
     * @param team team name
     * @param playerName player name
     * @param pieces all pieces
     */
    public PokemonPlayer(String team, String playerName,
            HashMap<String, SorryPiece> pieces) {
        this.team = team;
        this.playerName = playerName;
        this.pieces = pieces;
    }
}
