package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.util.ArrayList;

/**
 * TicTacToe Class.
 * 
 * @author Justin
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

    private final int screenHeight = 500;
    private final int screenWidth = 500;

    private TicTacToePlayer player1;
    private TicTacToePlayer player2;

    private ArrayList<JButton> buttons = new ArrayList<>();
    private boolean gameOver = false;

    private Container contentPane;
    private JPanel board = new JPanel();
    private JPanel textPanel = new JPanel();
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
        // switches players
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
                player1 = new TicTacToePlayer(
                        JOptionPane.showInputDialog(
                                "Enter Player One's name (X):").toUpperCase(),
                        "x", -1);
            } catch (NullPointerException npe) {
                return 0;
            }
        }
        while (player2.getName().length() < 1) {
            try {
                player2 = new TicTacToePlayer(
                        JOptionPane.showInputDialog(
                                "Enter Player Two's name (O):").toUpperCase(),
                        "o", -1);
            } catch (NullPointerException npe) {
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
        JTextArea text = new JTextArea();
        textPanel.setBackground(textPanelColor);
        Font font = new Font("Sans Serif", Font.PLAIN, 20);
        text.setFont(font);
        text.setForeground(Color.WHITE);
        text.setEditable(false);
        text.setBackground(transparent);
        text.setText(" ");

        textPanel.add(text);

        contentPane.add(board, BorderLayout.CENTER);
        contentPane.add(textPanel, BorderLayout.NORTH);

        preventBlank();
    }

    public void startTurns() {
        // TODO
//        while (!gameOver) {
//            if (player1.getTurns() < player2.getTurns()) {
//                // TODO PLAYER 1's TURN
//            } else {
//                // TODO PLAYER 2's TURN
//            }
//        }
        return;
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
            b.setRolloverEnabled(false);
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
                System.out.println("one");

                // Allows the clicked button to change colors
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "  ":
                System.out.println("two");
                buttons.get(1).setContentAreaFilled(true);
                buttons.get(1).setBackground(new Color(100, 100, 100));
                break;
            case "   ":
                System.out.println("three");
                buttons.get(2).setContentAreaFilled(true);
                buttons.get(2).setBackground(new Color(100, 100, 100));
                break;
            case "    ":
                System.out.println("four");
                buttons.get(3).setContentAreaFilled(true);
                buttons.get(3).setBackground(new Color(100, 100, 100));
                break;
            case "     ":
                System.out.println("five");
                buttons.get(4).setContentAreaFilled(true);
                buttons.get(4).setBackground(new Color(100, 100, 100));
                break;
            case "      ":
                System.out.println("six");
                buttons.get(5).setContentAreaFilled(true);
                buttons.get(5).setBackground(new Color(100, 100, 100));
                break;
            case "       ":
                System.out.println("seven");
                buttons.get(6).setContentAreaFilled(true);
                buttons.get(6).setBackground(new Color(100, 100, 100));
                break;
            case "        ":
                System.out.println("eight");
                buttons.get(7).setContentAreaFilled(true);
                buttons.get(7).setBackground(new Color(100, 100, 100));
                break;
            case "         ":
                System.out.println("nine");
                buttons.get(8).setContentAreaFilled(true);
                buttons.get(8).setBackground(new Color(100, 100, 100));
                break;
            default:
                break;
        }
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
