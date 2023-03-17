import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Creates a game of hangman.
 * 
 * @author Justin Lacombe
 * @version 1/30/20223
 */
public class Hangman {

    private static int lives;
    private JFrame f;
    private static JTextArea text;

    private final String clear = "\n\n\n\n\n\n\n\n\n"
            + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    private ArrayList<String> phraseArray = new ArrayList<>();
    private ArrayList<String> hiddenPhrase = new ArrayList<>();
    private String used = "";

    /**
     * Sets up the game of hangman.
     * 
     * @throws InterruptedException thrown for sleeping
     */
    public Hangman() throws InterruptedException {
        setUpFrame();
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Welcome to the word guessing game, Hangman. \nTo start, enter "
                        + "the phrase you want others to guess: ");
        String phrase = in.nextLine().toUpperCase();
        for (int i = 0; i < phrase.length(); i++) {
            phraseArray.add("" + phrase.charAt(i));
        }
        System.out.println(
                "Now, how lives many would you like the guesser to have?"
                        + "(Use numerical values ex: 5, 3, 9.)");
        String livesStr = in.nextLine();
        try {
            lives = Integer.parseInt(livesStr);
            if (lives <= 0) {
                getLives();
            }
        } catch (NumberFormatException nfe) {
            getLives();
        }
        System.out.println(clear);
        for (int i = 0; i < phraseArray.size(); i++) {
            if (phraseArray.get(i).equals(" ")) {
                hiddenPhrase.add(" ");
            } else {
                hiddenPhrase.add("_");
            }
        }
        System.out.println("Lives Remainnig: " + lives + "\n");
        printArray(hiddenPhrase);
        guessLetters();
    }

    /**
     * Checks for a correct number of lives.
     */
    public static void getLives() {
        Scanner in = new Scanner(System.in);
        System.out.println("Try again. Enter a correctly formatted number"
                + " (Use numerical values above zero. ex: 5, 3, 9.)");
        String livesStr = in.nextLine();
        try {
            lives = Integer.parseInt(livesStr);
            return;
        } catch (NumberFormatException nfe) {
            getLives();
        }
    }

    /**
     * Prints an array.
     * 
     * @param arr the array to print
     */
    public void printArray(final ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("\n");
    }

    /**
     * Allows for the guessing of letters.
     * 
     * @throws InterruptedException thrown for sleeping
     */
    public void guessLetters() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Guess a letter: ");
        String letter = in.nextLine().toUpperCase();
        if (letter.length() != 1) {
            System.out.println(clear
                    + "<< You entered too many characters. Try again. >>\n");
            System.out.println("Lives Remainnig: " + lives + "\n");
            printArray(hiddenPhrase);
            guessLetters();
        }
        if (phraseArray.contains(letter)) {
            for (int i = 0; i < hiddenPhrase.size(); i++) {
                if (phraseArray.get(i).equals(letter)) {
                    hiddenPhrase.set(i, letter);
                    System.out.println(clear);
                }
            }
            System.out.println("Lives Remainnig: " + lives + "\n");
        } else { // GUESSED WRONG
            lives--;
            System.out.println(clear + "Sorry, there were no " + letter + "'s");
            addLetter(letter);
            Thread.sleep(1000);
            System.out.println(clear + "Lives Remainnig: " + lives + "\n");
        }
        if (lives != 0) {
            if (!hiddenPhrase.contains("_")) {
                winOptions();
                return;
            }
            printArray(hiddenPhrase);
            guessLetters();
        } else {
            System.out.println(
                    clear + "You have ran out of lives!" + "\nYou lose.");
            in.close();
            return;
        }
    }

    /**
     * Sets up the frame for used letters.
     */
    private void setUpFrame() {
        f = new JFrame();
        f.setSize(300, 200);
        f.setAlwaysOnTop(true);
        f.setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width
                        - (f.getWidth() + 50),
                Toolkit.getDefaultToolkit().getScreenSize().height / 2
                        - ((int) f.getHeight() / 2));
        text = new JTextArea("Previously Guessed Letters: \n         ");
        text.setFont(new Font("Serif", Font.BOLD, 20));
        f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
        text.setEditable(false);
        f.add(text);
        f.setVisible(true);
    }

    /**
     * Adds a letter to the used letters list.
     * 
     * @param letter the letter to add
     */
    private void addLetter(final String letter) {
        if (!used.contains(letter)) {
            this.text.setText(text.getText() + letter + ", ");
            used += letter;
        }
        if (used.length() == 8) {
            this.text.setText(text.getText() + "\n         ");
        }
    }

    /**
     * Closes the game and its assets.
     */
    private void closeGame() {
        System.out.println(clear + clear);
        this.f.dispose();
    }

    /**
     * Options given when you win.
     * 
     * @param win the user input
     * @throws InterruptedException hangman throw
     */
    private void winOptions() throws InterruptedException {
        System.out.println(clear + "You Win!\n\nTo quit, type \"Quit\"\tOR\tTo "
                + "play again, type \"Restart\"");
        Scanner in = new Scanner(System.in);
        String win = in.next();
        if (win.equalsIgnoreCase("Quit")) {
            closeGame();
        } else if (win.equalsIgnoreCase("Restart")) {
            closeGame();
            Hangman h = new Hangman();
        } else {
            System.out.println(
                    "\n\nYou did not enter a valid option, try again!");
        }
    }

    /**
     * Runs the game.
     * 
     * @param args arguments from the command line
     * @throws InterruptedException thrown for sleeping
     */
    public static void main(String[] args) throws InterruptedException {
        Hangman h = new Hangman();
        h.f.dispose();
    }

}
