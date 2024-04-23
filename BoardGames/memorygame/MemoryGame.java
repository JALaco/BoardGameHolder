    package memorygame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import java.util.Random;

/**
 * TicTacToe Class.
 * 
 * @author Justin
 * @version 8/2/2023
 */
public class MemoryGame extends JFrame
        implements ActionListener, ComponentListener {

    /**
     * Default.
     */
    private static final long serialVersionUID = 1L;
    private final Color transparent = new Color(0, 0, 0, 0);
    private final Color textPanelColor = new Color(56, 98, 200);

    private final int screenHeight = 500;
    private final int screenWidth = 500;

    private ArrayList<JButton> buttons = new ArrayList<>();
    private boolean gameOver = false;
    private int totalTurns = 0;
    private boolean change = false;

    private ArrayList<Integer> order = new ArrayList<>();
    private ArrayList<Integer> playerOrder;

    private int level = 1;

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
    public MemoryGame() {
//        if (playerSetUp() == 1) {
//            return;
//        }
        setUpLayout();

        text.setText("Level 1");

        JOptionPane.showMessageDialog(contentPane, "Ready?");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

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

        // Character limit?
//        while (player1.getName().length() < 1) {
//            try {
//                player1 = new TicTacToePlayer(
//                        JOptionPane.showInputDialog(
//                                "Enter Player One's name (X):").toUpperCase(),
//                        "x", true);
//            } catch (NullPointerException npe) {
//                return 0;
//            }
//        }
//        while (player2.getName().length() < 1) {
//            try {
//                player2 = new TicTacToePlayer(
//                        JOptionPane.showInputDialog(
//                                "Enter Player Two's name (O):").toUpperCase(),
//                        "o", false);
//            } catch (NullPointerException npe) {
//                return 1;
//            }
//        }
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
        text.setText(" ");

        // Blends text panel and text field colors
        text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        text.setBackground(textPanelColor);

        textPanel.add(text);

        contentPane.add(board, BorderLayout.CENTER);
        contentPane.add(textPanel, BorderLayout.NORTH);

        preventBlank();
    }

    public void startTurns() {
        change = false;

        // Clear buttons
        clearButtons();

        text.setText("Level " + (order.size() + 1));

        playerOrder = new ArrayList<>();
        Random rand = new Random();
        int randomNum = rand.nextInt(0, 9);
        order.add(randomNum);

        for (int i = 0; i < order.size(); i++) {
            int currentOrderNum = order.get(i);
            try {
                if (i == 0) {
                    Thread.sleep(200);
                }
                Thread.sleep(300);

                buttons.get(currentOrderNum).setFocusPainted(true);
                buttons.get(currentOrderNum).setContentAreaFilled(true);
                buttons.get(currentOrderNum).setBackground(Color.CYAN);

                Thread.sleep(600);

                buttons.get(currentOrderNum).setBackground(transparent);
                buttons.get(currentOrderNum).setFocusPainted(false);
                buttons.get(currentOrderNum).setContentAreaFilled(false);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (JButton b : buttons) {
            b.setEnabled(true);
        }

        // Allows for the waiting of a button push and the next level to begin
        while (change == false && this.isEnabled()) {
            if (!this.isDisplayable()) {
                // If window has been closed, stop the program
                System.exit(0);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        startTurns();
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
            b.setRolloverEnabled(true); // removing makes more intuitive
            // b.setRolloverSelectedIcon(new Icon);
            b.setBackground(transparent);
            b.setContentAreaFilled(false);
        }
    }

    /**
     * Clears the buttons to their original state
     */
    public void clearButtons() {
        for (JButton b : buttons) {
            b.setFocusPainted(false);
            b.setBackground(transparent);
            b.setContentAreaFilled(false);
        }
        for (JButton b : buttons) {
            b.setEnabled(false);
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
                playerOrder.add(0);
                break;
            case "  ":
                playerOrder.add(1);
                break;
            case "   ":
                playerOrder.add(2);
                break;
            case "    ":
                playerOrder.add(3);
                break;
            case "     ":
                playerOrder.add(4);
                break;
            case "      ":
                playerOrder.add(5);
                break;
            case "       ":
                playerOrder.add(6);
                break;
            case "        ":
                playerOrder.add(7);
                break;
            case "         ":
                playerOrder.add(8);
                break;
            default:
                break;
        }
        for (int i = 0; i < playerOrder.size(); i++) {
            if (order.get(i) != playerOrder.get(i)) {
                text.setText("Lose.");
                for (JButton b : buttons) {
                    b.setEnabled(false);
                }
                change = false;
            }
        }
        if (playerOrder.size() == order.size() && playerOrder.equals(order)) {
            System.out.println("SAME!");
            level++;
            if (level >= 100) {
                text.setText("You reached the max level! You win!");
                change = false;
            }

            // Stops the while loop in startTurns() and allows for the next call
            // of it to begin
            change = true;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        } else if (playerOrder.size() == order.size()
                && !playerOrder.equals(order)) {

            text.setText("Lose.");
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            change = false;
        }
    }

    /**
     * Runs the game.
     * 
     * @param args arguments from the command line
     */
    public static void main(String[] args) throws InterruptedException {
        MemoryGame mg = new MemoryGame();

    }

}
