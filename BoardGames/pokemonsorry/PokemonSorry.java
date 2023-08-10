package pokemonsorry;

import java.util.ArrayList;
import java.util.HashMap;

import cards.Card;

/**
 * Attempt at replicating the board game Pokemon 'Sorry'.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 */
public class PokemonSorry {

    // protected SorryPiece[] redPieces;
    // protected SorryPiece[] bluePieces;
    // protected SorryPiece[] greenPieces;
    // protected SorryPiece[] yellowPieces;
    HashMap<String, SorryPiece> pieces = new HashMap<>();

    protected PokemonPlayer[] players = new PokemonPlayer[4];
    protected ArrayList<PokemonSorryCard> cards = new ArrayList<PokemonSorryCard>();
    protected int deckSize;

    /**
     * Default Constructor. Creates deck and players and pieces
     */
    public PokemonSorry() {

        this.cards = new ArrayList<PokemonSorryCard>();
        for (int i = 0; i < PokemonSorryCard.RANKS.length; i++) {
            if (i == 3 || i == 5 || i == 8 || i == 10) {
                for (int j = 1; j < PokemonSorryCard.SUITS.length; j++) {
                    this.cards.add(new PokemonSorryCard(i, j));
                }
            } else {
                for (int k = 1; k < PokemonSorryCard.SUITS.length; k++) {
                    this.cards.add(new PokemonSorryCard(i, 0));
                }
            }
        }
        this.deckSize = cards.size();

        addPieces();

        // players[0] = new PokemonPlayer("Fire", "Name1", redPieces);
        // players[1] = new PokemonPlayer("Water", "Name2", bluePieces);
        // players[2] = new PokemonPlayer("Grass", "Name3", greenPieces);
        // players[3] = new PokemonPlayer("Electric", "Name4", yellowPieces);
    }

    /**
     * Creates pieces and adds them to the corresponding array.
     */
    public void addPieces() {
        pieces.put("Ponyta", new SorryPiece("Ponyta", "Fire", 0, true));
        pieces.put("Growlithe", new SorryPiece("Growlithe", "Fire", 0, true));
        pieces.put("Arcanine", new SorryPiece("Arcanine", "Fire", 0, true));
        pieces.put("Rapidash", new SorryPiece("Rapidash", "Fire", 0, true));

        pieces.put("Squirtle", new SorryPiece("Squirtle", "Water", 0, true));
        pieces.put("Psyduck", new SorryPiece("Psyduck", "Water", 0, true));
        pieces.put("Starmie", new SorryPiece("Starmie", "Water", 0, true));
        pieces.put("Staryu", new SorryPiece("Staryu", "Water", 0, true));

        pieces.put("Bulbasaur", new SorryPiece("Bulbasaur", "Grass", 0, true));
        pieces.put("Tangela", new SorryPiece("Tangela", "Grass", 0, true));
        pieces.put("Vileplume", new SorryPiece("Vileplume", "Grass", 0, true));
        pieces.put("Victreebel",
                new SorryPiece("Victreebel", "Grass", 0, true));

        pieces.put("Voltorb", new SorryPiece("Voltorb", "Electric", 0, true));
        pieces.put("Raichu", new SorryPiece("Raichu", "Electric", 0, true));
        pieces.put("Pikachu", new SorryPiece("Pikachu", "Electric", 0, true));
        pieces.put("Electabuzz",
                new SorryPiece("Electabuzz", "Electric", 0, true));
        // redPieces[0] = new SorryPiece("Ponyta", "Fire", 0, true);
        // redPieces[1] = new SorryPiece("Growlithe", "Fire", 0, true);
        // redPieces[2] = new SorryPiece("Arcanine", "Fire", 0, true);
        // redPieces[3] = new SorryPiece("Rapidash", "Fire", 0, true);
        //
        // bluePieces[0] = new SorryPiece("Squirtle", "Water", 0, true);
        // bluePieces[1] = new SorryPiece("Psyduck", "Water", 0, true);
        // bluePieces[2] = new SorryPiece("Starmie", "Water", 0, true);
        // bluePieces[3] = new SorryPiece("Staryu", "Water", 0, true);
        //
        // greenPieces[0] = new SorryPiece("Bulbasaur", "Grass", 0, true);
        // greenPieces[1] = new SorryPiece("Tangela", "Grass", 0, true);
        // greenPieces[2] = new SorryPiece("Vileplume", "Grass", 0, true);
        // greenPieces[3] = new SorryPiece("Victreebel", "Grass", 0, true);
        //
        // yellowPieces[0] = new SorryPiece("Voltorb", "Electric", 0, true);
        // yellowPieces[1] = new SorryPiece("Raichu", "Electric", 0, true);
        // yellowPieces[2] = new SorryPiece("Pikachu", "Electric", 0, true);
        // yellowPieces[3] = new SorryPiece("Electabuzz", "Electric", 0, true);
    }

}
