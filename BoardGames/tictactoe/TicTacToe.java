package tictactoe;

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

    private final int screenHeight = 500;
    private final int screenWidth = 500;

    private TicTacToePlayer player1;
    private TicTacToePlayer player2;

    private ArrayList<JButton> buttons = new ArrayList<>();

    private Container contentPane;
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
        while (player1.getName().length() < 1) {
            try {
                player1 = new TicTacToePlayer(
                        JOptionPane.showInputDialog(
                                "Enter Player One's name (X):").toUpperCase(),
                        "x");
            } catch (NullPointerException npe) {
                return 1;
            }
        }
        while (player2.getName().length() < 1) {
            try {
                player2 = new TicTacToePlayer(
                        JOptionPane.showInputDialog(
                                "Enter Player Two's name (O):").toUpperCase(),
                        "o");
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

        // Centers the board
        this.setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2
                        - (screenWidth / 2),
                Toolkit.getDefaultToolkit().getScreenSize().height / 2
                        - (screenHeight / 2));

        GridLayout gridLayout = new GridLayout(3, 3);

        contentPane.setLayout(gridLayout);
        addButtons();

//        for (int i = 0; i < 9; i++) {
//            buttons.get(i).setText(String.format("%d", i));
//        }
    }

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
            contentPane.add(b);

            // Removes the initial highlight of the buttons
            b.setRolloverEnabled(false);
            b.setBackground(transparent);
            b.setContentAreaFilled(false);
        }
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
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "  ":
                System.out.println("two");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "   ":
                System.out.println("three");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "    ":
                System.out.println("four");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "     ":
                System.out.println("five");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "      ":
                System.out.println("six");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "       ":
                System.out.println("seven");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "        ":
                System.out.println("eight");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
                break;
            case "         ":
                System.out.println("nine");
                buttons.get(0).setContentAreaFilled(true);
                buttons.get(0).setBackground(new Color(100, 100, 100));
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
