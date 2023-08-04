package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

/**
 * TicTacToe Class.
 * 
 * @author Justin Lacombe
 * @version 8/2/2023
 */
public class TicTacToe extends JFrame
        implements ActionListener, ComponentListener {

    /**
     * Default.
     */
    private static final long serialVersionUID = 1L;
    private final Color transparent = new Color(0, 0, 0, 0);
    private final Color textPanelColor = new Color(56, 98, 200);
    private final Color buttonColor = new Color(100, 100, 100);

    private Font buttonFont = new Font("Sans Serif", Font.PLAIN, 100);

    private final int screenHeight = 500;
    private final int screenWidth = 500;

    private TicTacToePlayer player1;
    private TicTacToePlayer player2;
    private TicTacToePlayer currentPlayer;

    private ArrayList<JButton> buttons = new ArrayList<>();
    private boolean gameOver = false;
    private int totalTurns = 0;

    private Container contentPane;
    private JPanel board = new JPanel();
    private JPanel textPanel = new JPanel();
    private JTextField text = new JTextField();

    private JButton one = new JButton(" ");
    private JButton two = new JButton("  ");
    private JButton three = new JButton("   ");
    private JButton four = new JButton("    ");
    private JButton five = new JButton("     ");
    private JButton six = new JButton("      ");
    private JButton seven = new JButton("       ");
    private JButton eight = new JButton("        ");
    private JButton nine = new JButton("         ");

    /**
     * Default Constructor.
     */
    public TicTacToe() {
        if (playerSetUp() == 1) {
            return;
        }

        setUpLayout();
        startTurns();

        // Feature: When single clicking a square, the x or o appears, but
        // doesn't make it permanent, can still switch spots if needed, only
        // when you click twice on a square, does it become permanent and
        // switches players [MAYBE]
    }

    /**
     * Creates TicTacToe Player objects.
     * 
     * @return 0 if nothing goes wrong, 1 if there is an error
     */
    public int playerSetUp() {
        player1 = new TicTacToePlayer();
        player2 = new TicTacToePlayer();

        // Character limit?
        while (player1.getName().length() < 1) {
            try {
                player1 = new TicTacToePlayer(JOptionPane.showInputDialog(
                        "Enter Player One's name (X):"), "X", true);
            } catch (NullPointerException npe) {
                return 1;
            }
            if (player1.getName() == null) {
                return 1;
            }
        }
        while (player2.getName().length() < 1) {
            try {
                player2 = new TicTacToePlayer(JOptionPane.showInputDialog(
                        "Enter Player Two's name (O):"), "O", false);
            } catch (NullPointerException npe) {
                return 1;
            }
            if (player2.getName() == null) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Sets up the GUI for the menu screen.
     */
    public void setUpLayout() {
        setSize(screenWidth, screenHeight);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Centers the board
        this.setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2
                        - (screenWidth / 2),
                Toolkit.getDefaultToolkit().getScreenSize().height / 2
                        - (screenHeight / 2));

        board.setLayout(new GridLayout(3, 3));
        addButtons();

        // Creating text field at the top
        textPanel.setBackground(textPanelColor);
        Font textFont = new Font("Sans Serif", Font.PLAIN, 20);
        text.setFont(textFont);
        text.setForeground(Color.WHITE);
        text.setEditable(false);
        text.setText("");

        // Blends text panel and text field colors
        text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        text.setBackground(textPanelColor);

        textPanel.add(text);

        contentPane.add(board, BorderLayout.CENTER);
        contentPane.add(textPanel, BorderLayout.NORTH);

        preventBlank();
    }

    /**
     * Starts the taking of turns between players.
     */
    public void startTurns() {
        if (!gameOver) {
            if (player1.getTurn()) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            player1.setTurn(!player1.getTurn());
            player2.setTurn(!player2.getTurn());
            text.setText(String.format("It is %s's turn. (%s)",
                    currentPlayer.getName(), currentPlayer.getLetter()));
        }
        return;
    }

    /**
     * Checks if a player has won the game.
     */
    public void checkIfWin() {
        // need at least 5 turns for there to be a possible win
        if (totalTurns > 4) {
            // Check all 8 possible ways to win
            String winningString = "";
            for (int i = 0; i < 3; i++) {
                winningString += currentPlayer.getLetter();
            }
            if (winningString.equals(buttons.get(0).getText()
                    + buttons.get(1).getText() + buttons.get(2).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(3).getText()
                    + buttons.get(4).getText() + buttons.get(5).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(6).getText()
                    + buttons.get(7).getText() + buttons.get(8).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(0).getText()
                    + buttons.get(3).getText() + buttons.get(6).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(1).getText()
                    + buttons.get(4).getText() + buttons.get(7).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(2).getText()
                    + buttons.get(5).getText() + buttons.get(8).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(0).getText()
                    + buttons.get(4).getText() + buttons.get(8).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            } else if (winningString.equals(buttons.get(2).getText()
                    + buttons.get(4).getText() + buttons.get(6).getText())) {
                text.setText(currentPlayer.getName() + " has won the game!");
                gameOver = true;
            }
        }
        if (totalTurns >= 9) {
            text.setText("It is a tie! No one won!");
            gameOver = true;
        }
        if (gameOver) {
            endGame();
        }
    }

    /**
     * Give the player(s) options after the game is over.
     */
    public void endGame() {
        for (JButton b : buttons) {
            b.setEnabled(false);
        }
        String choice = "";
        while (choice.length() < 1) {
            choice = JOptionPane.showInputDialog("To Quit, type \"Quit\"."
                    + "\nTo Restart, type \"Restart\"");
            if (choice == null) {
                this.dispose();
                return;
            }
        }
        if (choice.toUpperCase().equals("QUIT")
                || choice.toUpperCase().equals("Q")) {
            this.dispose();
        } else if (choice.toUpperCase().equals("RESTART")
                || choice.toUpperCase().equals("R")) {
            this.dispose();
            new TicTacToe();
        }
    }

    /**
     * Adds the buttons to the button array, board, and edits their effects.
     */
    public void addButtons() {
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);

        for (JButton b : buttons) {
            b.addActionListener(this);
            board.add(b);

            // Removes the initial highlight of the buttons
            b.setFocusPainted(false);
            // b.setRolloverEnabled(false); // removing makes more intuitive
            b.setBackground(transparent);
            b.setContentAreaFilled(false);
        }
    }

    /**
     * Prevents the frame from being blank.
     */
    public void preventBlank() {
        this.setSize(screenWidth + 1, screenHeight + 1);
        this.setSize(screenWidth - 1, screenHeight - 1);
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        // Will need to make the placement of COLOR, a variable depending on
        // which player's turn it is
        switch (str) {
            case " ":
//                System.out.println("one");

                // Allows the clicked button to place the players letter
                // buttons.get(0).setContentAreaFilled(true);
                // buttons.get(0).setFont(font);
                // buttons.get(0).setText(currentPlayer.getLetter());
                // buttons.get(0).setContentAreaFilled(false);
                setButton(buttons.get(0));
                break;
            case "  ":
//                System.out.println("two");
                // buttons.get(1).setContentAreaFilled(true);
                // buttons.get(1).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(1));
                break;
            case "   ":
//                System.out.println("three");
                // buttons.get(2).setContentAreaFilled(true);
                // buttons.get(2).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(2));
                break;
            case "    ":
//                System.out.println("four");
                // buttons.get(3).setContentAreaFilled(true);
                // buttons.get(3).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(3));
                break;
            case "     ":
//                System.out.println("five");
                // buttons.get(4).setContentAreaFilled(true);
                // buttons.get(4).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(4));
                break;
            case "      ":
//                System.out.println("six");
                // buttons.get(5).setContentAreaFilled(true);
                // buttons.get(5).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(5));
                break;
            case "       ":
//                System.out.println("seven");
                // buttons.get(6).setContentAreaFilled(true);
                // buttons.get(6).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(6));
                break;
            case "        ":
//                System.out.println("eight");
                // buttons.get(7).setContentAreaFilled(true);
                // buttons.get(7).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(7));
                break;
            case "         ":
//                System.out.println("nine");
                // buttons.get(8).setContentAreaFilled(true);
                // buttons.get(8).setBackground(new Color(100, 100, 100));
                setButton(buttons.get(8));
                break;
            default:
                break;
        }
        totalTurns++;
        checkIfWin();
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        startTurns();
    }

    /**
     * Applies everything needed for when a button is clicked
     * 
     * @param b
     */
    public void setButton(JButton b) {
        b.setContentAreaFilled(true);
        b.setFont(buttonFont);
        b.setText(currentPlayer.getLetter());
        b.setContentAreaFilled(false);

        // Easy fix to prevent double clicking and switching turns, but doesnt
        // look as nice on screen
        b.setEnabled(false);
    }

    /**
     * Runs the game.
     * 
     * @param args arguments from the command line
     */
    public static void main(String[] args) throws InterruptedException {
        TicTacToe ttt = new TicTacToe();
    }

}
