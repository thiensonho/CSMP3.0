package cs.zsurvival;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;

/**
 * Main game window. Contains menu panel or board panel.
 */
public class GameFrame extends JFrame {
    // note: WINDOW_WIDTH > BOARD_WIDTH * PIECE_SIZE
    // same for height
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    private StatePanel currentPanel;

    public static Font PLAY_BODY;
    public static Font PLAY_TITLE;
    public static Font PLAY_SMALL;

    // allow other classes to access the main frame
    private static GameFrame mainFrame = null;

    public static GameFrame get() {
        return mainFrame;
    }

    public GameFrame() {
        super("ZSurvival!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        if (mainFrame != null) {
            throw new RuntimeException("More than one GameFrame");
        }
        mainFrame = this;
    }
    
    /**
     * Initialize components and game
     */
    public void init() {
        currentPanel = new GamePanel();
        getContentPane().add(currentPanel);
        addKeyListener((KeyListener)currentPanel);
    }

    protected void updateTitle(boolean mute) {
        setTitle("ZSurvival");
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    /**
     * Transition to another panel
     *
     * Removes current panel, if any, and adds the target panel and its
     * KeyListener.
     * @param target Target JPanel, must be a KeyListener
     */
    public void transition(StatePanel target) {
        if (currentPanel == target)
            return;
        if (currentPanel != null) {
            remove(currentPanel);
            removeKeyListener(currentPanel);
            currentPanel.removed();
        }
        currentPanel = target;
        getContentPane().add(currentPanel);
        addKeyListener(currentPanel);
        currentPanel.revalidate();
        repaint();
    }

    public static void main(String argv[]) {
        GameFrame frame = new GameFrame();
        frame.init();
        frame.setVisible(true);
    }
}
