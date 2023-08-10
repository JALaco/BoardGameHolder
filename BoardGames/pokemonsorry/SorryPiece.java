package pokemonsorry;

/**
 * Play piece for the game PokemonSorry.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 *
 */
public class SorryPiece {

    private String name;
    private String type;
    private int location;
    private boolean inSpawn;

    /**
     * Default Constructor.
     * 
     * @param name name of pokemon
     * @param type type of pokemon
     * @param location location on board of piece
     * @param inSpawn whether or not the piece is in its spawn
     */
    public SorryPiece(String name, String type, int location, boolean inSpawn) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.inSpawn = inSpawn;
    }

    public boolean getSpawn() {
        return this.inSpawn;
    }

    public int getLoaction() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    /**
     * Change location based on how many spaces to move.
     * 
     * @param moveSpaces the number of spaces to move
     */
    public void setLocation(int moveSpaces) {
        this.location += moveSpaces;
    }

    /**
     * Change whether or not the piece is in its spawn.
     * 
     * @param isInSpawn whether to put the piece in spawn or not
     */
    public void setSpawn(boolean isInSpawn) {
        this.inSpawn = isInSpawn;
    }
}
