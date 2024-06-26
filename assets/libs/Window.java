package assets.libs;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Window {

    public static int SCREEN_HEIGHT = 480;
    public static int SCREEN_WIDTH = 800;

    private List<KeyListener> listeners;
    private GamePanel panel;
    public Window(GamePanel panel) {
        this.panel = panel;
        this.listeners = new ArrayList<>();
    }
    public JPanel build() {
        JFrame jframe = new JFrame();
        jframe.setSize(new Dimension((int) SCREEN_WIDTH, (int) SCREEN_HEIGHT));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setVisible(true);
        listeners.forEach(listener -> {
            jframe.addKeyListener(listener);
        });
        panel.setPreferredSize(new Dimension((int) SCREEN_WIDTH, (int) SCREEN_HEIGHT));
        panel.setVisible(true);
        panel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        panel.setDoubleBuffered(true);
        jframe.add(panel);
        return panel;
    }


    public void add_keylistener(KeyListener l) {
        this.listeners.add(l);
    }
}