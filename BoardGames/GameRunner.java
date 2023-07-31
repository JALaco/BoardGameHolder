import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Starts the game holder application.
 * 
 * @author Justin Lacombe
 * @version 1/26/2023
 *
 */
public class GameRunner implements Runnable {

    /**
     * The entry point of the application.
     * 
     * @param args The command line arguments (which are ignored)
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(final String[] args)
            throws InterruptedException, InvocationTargetException {

        try {
            // UIManager.put("MenuBar.background", Color.ORANGE);

            SwingUtilities.invokeAndWait(new GameRunner());

        } catch (InvocationTargetException | InterruptedException e) {
            System.out.println("Unable to start the GUI.");
        }

    }

    /**
     * The code to execute in the event dispatch thread.
     */
    public void run() {
        setLookAndFeel();
        MenuScreen window = new MenuScreen();
//        MenuScreen window = null;
//        try {
//            window = new MenuScreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        window.setVisible(true);
    }

    /**
     * Set the look and feel for the application.
     */
    private void setLookAndFeel() {
        // Setup the look and feel
        boolean done = false;
        try {
            UIManager.getInsets(getClass(), new Locale("es", "ES"));
            UIManager.LookAndFeelInfo[] lfs = UIManager.getInstalledLookAndFeels();
            for (int i = 0; i < lfs.length && !done; i++) {
                if ("Nimbus".equals(lfs[i].getName())) {
                    UIManager.setLookAndFeel(lfs[i].getClassName());
                    done = true;
                }
            }

            if (!done) {
                String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
                UIManager.setLookAndFeel(lookAndFeel);
            }
        } catch (ClassNotFoundException cnfe) {
            // Use the default look and feel
        } catch (IllegalAccessException iae) {
            // Use the default look and feel
        } catch (InstantiationException ie) {
            // Use the default look and feel
        } catch (UnsupportedLookAndFeelException ulale) {
            // Use the default look and feel
        }
    }

}
