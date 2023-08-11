package pokemonsorry;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Player of Pokemon Sorry.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 *
 */
public class PokemonPlayer {

    protected String team;
    protected String playerName;
    protected ArrayList<String> pieces;

    /**
     * Default Constructor.
     * 
     * @param team team name
     * @param playerName player name
     * @param pieces all pieces
     */
    public PokemonPlayer(String team, String playerName,
            ArrayList<String> pieces) {
        this.team = team;
        this.playerName = playerName;
        this.pieces = pieces;
    }

    /**
     * Adds the name to this player's pieces.
     * 
     * @param name name of pokemon
     */
    public void addPokemon(String name) {
        pieces.add(name);
    }
}
