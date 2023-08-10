package pokemonsorry;

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
    private SorryPiece[] pieces;

    public PokemonPlayer(String team, String playerName, SorryPiece[] pieces) {
        this.team = team;
        this.playerName = playerName;
        this.pieces = pieces;
    }
}
