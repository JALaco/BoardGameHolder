package tictactoe;


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
import javax.swing.JTextArea;

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
    private final int screenHeight = 500;
    private final int screenWidth = 500;

    /**
     * Default Constructor.
     */
    public TicTacToe() {
        playerSetUp();
        setUpLayout();
    }

    /**
     * Creates TicTacToe Player objects.
     */
    public void playerSetUp() {
        // TODO
    }

    /**
     * Sets up the GUI for the menu screen.
     */
    public void setUpLayout() {
        Container contentPane;
        setSize(screenWidth, screenHeight);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contentPane = getContentPane();

        // Centers the Game menu
        this.setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2
                        - (screenWidth / 2),
                Toolkit.getDefaultToolkit().getScreenSize().height / 2
                        - (screenHeight / 2));

        GridBagLayout gridLayout = new GridBagLayout();
        contentPane.setLayout(gridLayout);
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
    }

}
