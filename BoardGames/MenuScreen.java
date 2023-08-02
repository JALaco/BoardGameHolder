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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Cards.CardPlayer;
import Hangman.Hangman;

/**
 * The Menu of games.
 * 
 * @author Justin Lacombe
 * @version 1/26/2023
 *
 */
public class MenuScreen extends JFrame
        implements ActionListener, ComponentListener {
    /**
     * Default serialization.
     */
    private static final long serialVersionUID = 1L;
    private final int contHeight = 500;
    private final int contWidh = 500;

    private JButton war;
    private JButton ticTacToe;
    private JButton hangman;

    private JFrame frame;

    private boolean warBool = false;
    private boolean ticBool = false;
    private boolean hangBool = false;

    // private Color background = new Color(155, 142, 2);
    private Color background = new Color(173, 216, 255);
    private Color transparent = new Color(0, 0, 0, 0);

    /**
     * Menu screen for the Game holder.
     */
    public MenuScreen() {
        setUpLayout();
    }

    /**
     * Sets up the GUI for the menu screen.
     */
    public void setUpLayout() {
        Container contentPane;
        setSize(contWidh, contHeight);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contentPane = getContentPane();

        // Centers the Game menu
        this.setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2
                        - (contWidh / 2),
                Toolkit.getDefaultToolkit().getScreenSize().height / 2
                        - (contHeight / 2));
        contentPane.setBackground(background);

        GridBagLayout gridLayout = new GridBagLayout();
        contentPane.setLayout(gridLayout);

        war = new JButton("War");
        war.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        war.addActionListener(this);

        ticTacToe = new JButton("Tic-Tac-Toe");
        ticTacToe.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        ticTacToe.addActionListener(this);

        hangman = new JButton("Hangman");
        hangman.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        hangman.addActionListener(this);

        GridBagConstraints c = new GridBagConstraints();
        c.ipady = 0;
        c.ipadx = contentPane.getWidth() - 50;

        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;

        JTextArea title = new JTextArea(
                "         Welcome to \n    the Game Holder!");
        title.setFont(new Font("Forte", Font.PLAIN, 50));
        title.setEditable(false);
        title.setBackground(transparent); // Makes title transparent
        title.setBorder(null);

        // JScrollPane scrollPane = new JScrollPane(title);
        // scrollPane.getViewport().setOpaque(false);
        // scrollPane.setOpaque(false);

        c.insets = new Insets(15, 0, 0, 0);
        gridLayout.setConstraints(title, c);
        title.setPreferredSize(new Dimension(contentPane.getWidth() - 50, 100));
        contentPane.add(title);

        c.anchor = GridBagConstraints.FIRST_LINE_START;

        c.insets = new Insets(0, 0, 0, 0); // top padding
        c.ipady = 50;
        c.ipadx = 450;

        c.weightx = 2;
        c.weighty = 2;
        c.gridx = 0;
        c.gridy = 2;

        c.anchor = GridBagConstraints.CENTER;

        JPanel buttonsFirstRow = new JPanel();
        buttonsFirstRow.setLayout(new GridLayout(5, 1));
        buttonsFirstRow.setBackground(transparent);

        c.gridy = 3;
        c.ipadx = 500; // max width of button?

        c.insets = new Insets(0, 50, 0, 50); // top padding

        JPanel spacer1 = new JPanel();
        JPanel spacer2 = new JPanel();
        spacer1.setBackground(transparent);
        spacer2.setBackground(transparent);

        buttonsFirstRow.add(war);
        buttonsFirstRow.add(spacer1);
        buttonsFirstRow.add(ticTacToe);
        buttonsFirstRow.add(spacer2);
        buttonsFirstRow.add(hangman);

        gridLayout.setConstraints(buttonsFirstRow, c);
        contentPane.add(buttonsFirstRow);
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

        switch (str) {
            case "War":
                System.out.println("War");
                if (!warBool) {
                    try {
                        this.setVisible(false);
                        new CardPlayer();
                    } catch (CloneNotSupportedException
                            | InterruptedException cnse) {
                        cnse.printStackTrace();
                    }
                }
                warBool = true;
                // TODO Need to add display for the card game and have the text
                // appear on that display. Maybe just make a container with a
                // scrollable?
                break;
            case "Tic-Tac-Toe":
                System.out.println("Tic-Tac-Toe");
                if (!ticBool) {
                    frame = new JFrame();
                    frame.setSize(100, 100);
                    frame.setVisible(true);
                    JTextArea tic = new JTextArea("Tic-Tac-Toe");
                    tic.setEditable(false);
                    frame.add(tic);
                }
                ticBool = true;
                break;
            case "Hangman":
                System.out.println("Hangman");
                if (!hangBool) {
                    try {
                        this.setVisible(true);
                        Hangman h = new Hangman();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }

                    frame = new JFrame();
                    frame.setSize(100, 100);
                    frame.setVisible(true);
                    JTextArea hman = new JTextArea("Hangman");
                    hman.setEditable(false);
                    frame.add(hman);
                }
                hangBool = true;
                break;
            default:
                break;
        }
    }

}
