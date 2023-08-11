package pokemonsorry;

import java.util.ArrayList;
import java.util.HashMap;

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
    protected HashMap<String, SorryPiece> pieces = new HashMap<>();

    protected PokemonPlayer[] players = new PokemonPlayer[4];
    protected PokemonSorryCard currCard;
    protected ArrayList<PokemonSorryCard> cards = new ArrayList<PokemonSorryCard>();
    protected boolean gameOver = false;

    /**
     * Default Constructor. Creates deck and players and pieces
     */
    public PokemonSorry() {
        try {
            createShuffledDeck();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        players[0] = new PokemonPlayer("Fire", "Name1", new ArrayList<>());
        players[1] = new PokemonPlayer("Water", "Name2", new ArrayList<>());
        players[2] = new PokemonPlayer("Grass", "Name3", new ArrayList<>());
        players[3] = new PokemonPlayer("Electric", "Name4", new ArrayList<>());

        addPieces();

        int i = 0;
        while (!gameOver) {
            takeTurn(i);
            i = (1 + i) % 4;
        }
    }

    public void takeTurn(int playerNum) {
        PokemonPlayer currPlayer = players[playerNum];

        // Player draws a card (Use button popup?) ---

        // Player then chooses through a button pop up screen, which
        // of their pieces to move. OR Ask how they want to move BEFORE choosing
        // piece:

        // - If Sorry, ask which other player to switch with
        // - If 2, draw again
        // - If 3, check if type matches and ask if they want to move normal or
        // move the pokemon into their gym
        // - If 4, move backwards 4
        // - If 5, check if type matches and ask if they want to move normal or
        // move 5 and draw again
        // - If 7, ask how many spaces they want to move (dropdown)
        // - If 8, check if type matches and ask if they want to move normal or
        // move to any color pokeball
        // - If 10, ask if they want to move normal or backwards 1
        // - If 11, ask if they want to move normal or change places with an
        // opponent
        // - If 12, check if type matches and ask if they want to move normal or
        // move 24 spaces

        // Once the piece is moved, change all of the necessary info and return;

        // TODO

        players[playerNum] = currPlayer;
    }

    /**
     * Creates pieces and adds them to the corresponding array.
     */
    public void addPieces() {
        // Adds them to the boards map of pieces
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

        // Adds them to the individual player's pieces
        players[0].addPokemon("Ponyta");
        players[0].addPokemon("Growlithe");
        players[0].addPokemon("Arcanine");
        players[0].addPokemon("Rapidash");

        players[1].addPokemon("Squirtle");
        players[1].addPokemon("Psyduck");
        players[1].addPokemon("Starmie");
        players[1].addPokemon("Staryu");

        players[2].addPokemon("Bulbasaur");
        players[2].addPokemon("Tangela");
        players[2].addPokemon("Vileplume");
        players[2].addPokemon("Victreebel");

        players[3].addPokemon("Voltorb");
        players[3].addPokemon("Raichu");
        players[3].addPokemon("Pikachu");
        players[3].addPokemon("Electabuzz");
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

    public void createShuffledDeck() throws CloneNotSupportedException {
        // Creates organized deck of cards
        ArrayList<PokemonSorryCard> shuffleCards = new ArrayList<PokemonSorryCard>();
        for (int i = 0; i < PokemonSorryCard.RANKS.length; i++) {
            if (i == 3 || i == 5 || i == 8 || i == 10) {
                for (int j = 1; j < PokemonSorryCard.SUITS.length; j++) {
                    shuffleCards.add(new PokemonSorryCard(i, j));
                }
            } else {
                for (int k = 1; k < PokemonSorryCard.SUITS.length; k++) {
                    shuffleCards.add(new PokemonSorryCard(i, 0));
                }
            }
        }

        // Shuffles the organized deck and puts it into this.cards
        this.cards.clear();

        int place = 0;
        while (shuffleCards.size() > 0) {
            place = (int) (100 * Math.random()) % shuffleCards.size();
            this.cards.add(shuffleCards.get(place));
            shuffleCards.remove(place);
        }
    }

}
