package MainPack;

import GameStates.GameStateManager;
import Physics.Animation;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel implements Runnable, KeyListener, MouseListener {

    public  static JFrame frame;

    private Thread thread;
    private boolean isRunning = false;
    private int fps = 60;

    private long targetTime = 1000 / fps;
    private GameStateManager gameStateManager;

    public Main(JFrame frame) {
        this.frame = frame;
        gameStateManager = new GameStateManager();
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.setFocusable(true);
        start();


    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        gameStateManager.draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameStateManager.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameStateManager.keyReleased(e.getKeyCode());
    }

    @Override
    public void run() {
        long start, elapsed, wait;
        while (isRunning) {
            start = System.nanoTime();
            tick();
            repaint();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if (wait < 0) {
                wait = 5;
            }

            try {
                thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void tick() {
        gameStateManager.tick();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        gameStateManager.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        gameStateManager.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gameStateManager.mouseExited(e);
    }

}
