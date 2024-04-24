package pokemonsorry;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/**
 * Runs a game of Pokemon sorry.
 * 
 * @author Justin Lacombe
 * @version 8/10/2023
 *
 */
public class SorryRunner {

    protected static int screenWidth = 800;
    protected static int screenHeight = 800;
    protected static int tileSize = screenWidth / 16;

    /**
     * Start of the program.
     * 
     * @param args from the command line
     */
    public static void main(String[] args) {
         createBoard();
        PokemonSorry ps = new PokemonSorry();
    }

    /**
     * Creates the visual board for the PokemonSorry game.
     */
    public static void createBoard() {
        StdDraw.setCanvasSize(screenWidth, screenHeight);
        StdDraw.setXscale(0, screenWidth);
        StdDraw.setYscale(0, screenHeight);

        StdDraw.setPenRadius(
                StdDraw.getPenRadius() + (1.5 * StdDraw.getPenRadius()));
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledSquare(screenWidth / 2, screenHeight / 2,
                screenHeight / 2);
        StdDraw.setPenColor(Color.ORANGE);
        StdDraw.filledSquare(screenWidth / 2, screenHeight / 2,
                screenHeight / 2 - tileSize);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledEllipse(screenWidth / 2, screenHeight / 2,
                screenWidth / 5, screenHeight / 10);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.ellipse(screenWidth / 2, screenHeight / 2, screenWidth / 5,
                screenHeight / 10);
        StdDraw.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        StdDraw.text(screenWidth / 2, screenHeight / 2, "Sorry!");

        // Draws safety zones
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(screenWidth - tileSize * 2.5, tileSize * 2.5,
                tileSize / 2, tileSize / 2 * 7);
        StdDraw.filledRectangle(screenWidth - tileSize * 2.5,
                screenWidth - tileSize * 2.5, tileSize / 2 * 7, tileSize / 2);
        StdDraw.filledRectangle(tileSize * 2.5, screenWidth - tileSize * 2.5,
                tileSize / 2, tileSize / 2 * 7);
        StdDraw.filledRectangle(tileSize * 2.5, tileSize * 2.5,
                tileSize / 2 * 7, tileSize / 2);

        // Draw outline of tiles
        StdDraw.setPenColor(Color.BLACK);

        // Draw Safe Zone Tile outline
        for (int i = 1; i < 6; i++) {
            StdDraw.square(screenWidth - (2.5 * tileSize),
                    (i * tileSize) + tileSize / 2, tileSize / 2);
            StdDraw.square(screenWidth - ((i * tileSize) + tileSize / 2),
                    screenWidth - (2.5 * tileSize), tileSize / 2);
            StdDraw.square((i * tileSize) + tileSize / 2, 2.5 * tileSize,
                    tileSize / 2);

            StdDraw.square(2.5 * tileSize,
                    screenWidth - (i * tileSize) - tileSize / 2, tileSize / 2);
        }

        // Draws outer and inner 4 main lines
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.line(tileSize, 0, tileSize, screenWidth);
        StdDraw.line(0, 0, 0, screenWidth);

        StdDraw.setPenColor(Color.RED);
        StdDraw.line(0, tileSize, screenWidth, tileSize);
        StdDraw.line(0, 0, screenWidth, 0);

        StdDraw.setPenColor(Color.GREEN);
        StdDraw.line(screenWidth - tileSize, 0, screenWidth - tileSize,
                screenWidth);
        StdDraw.line(screenWidth, screenWidth, screenWidth, 0);

        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.line(0, screenWidth - tileSize, screenWidth,
                screenWidth - tileSize);
        StdDraw.line(screenWidth, screenWidth, 0, screenWidth);

        // Draws outer tiles
        for (int i = 0; i < 15; i++) {
            StdDraw.setPenColor(Color.YELLOW);
            StdDraw.line(i * tileSize, screenWidth - tileSize, i * tileSize,
                    screenWidth);
            StdDraw.setPenColor(Color.RED);
            StdDraw.line(i * tileSize, -screenWidth, i * tileSize, tileSize);
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.line(-screenWidth, i * tileSize, tileSize, i * tileSize);
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.line(screenWidth - tileSize, i * tileSize, screenWidth,
                    i * tileSize);
        }

        // Draw safe zone and spawn circles
        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.filledCircle(tileSize * 2.5, screenWidth - (7 * tileSize),
                tileSize * 1.5);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.filledCircle(tileSize * 9, screenWidth - (2.5 * tileSize),
                tileSize * 1.5);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledCircle(7 * tileSize, 2.5 * tileSize, tileSize * 1.5);
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(screenWidth - 2.5 * tileSize, 7 * tileSize,
                tileSize * 1.5);

        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(11.5 * tileSize, 2.25 * tileSize, tileSize * 1.25);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledCircle(2.25 * tileSize, 4.5 * tileSize, tileSize * 1.25);
        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.filledCircle(4.5 * tileSize, screenWidth - 2.25 * tileSize,
                tileSize * 1.25);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.filledCircle(screenWidth - 2.25 * tileSize,
                screenWidth - 4.5 * tileSize, tileSize * 1.25);

        // Draw safe Zone and spawn circle outlines
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.circle(tileSize * 2.5, screenWidth - (7 * tileSize),
                tileSize * 1.5);
        StdDraw.circle(tileSize * 9, screenWidth - (2.5 * tileSize),
                tileSize * 1.5);
        StdDraw.circle(7 * tileSize, 2.5 * tileSize, tileSize * 1.5);
        StdDraw.circle(screenWidth - 2.5 * tileSize, 7 * tileSize,
                tileSize * 1.5);

        StdDraw.circle(11.5 * tileSize, 2.25 * tileSize, tileSize * 1.25);
        StdDraw.circle(2.25 * tileSize, 4.5 * tileSize, tileSize * 1.25);
        StdDraw.circle(4.5 * tileSize, screenWidth - 2.25 * tileSize,
                tileSize * 1.25);
        StdDraw.circle(screenWidth - 2.25 * tileSize,
                screenWidth - 4.5 * tileSize, tileSize * 1.25);

//        for (int i = 0; i < 1000; i++) {
//            StdDraw.filledSquare(i, i, i);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
    }
}
