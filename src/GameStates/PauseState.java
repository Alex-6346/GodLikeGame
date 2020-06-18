package GameStates;

import MainPack.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PauseState extends JFrame implements KeyListener {

    private GameStateManager gameStateManager;
    private JButton menu = new JButton("Menu");
    private JButton exit = new JButton("Exit");
    private JButton back = new JButton("Back");

    private int currentButton = 0;

    public PauseState(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        setTitle("Pause menu");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(450, 170));
        addKeyListener(this);
        setLayout(new FlowLayout());
        setUndecorated(true);
        setResizable(false);
        setFocusable(true);
        setVisible(true);
        styleButton(back, Color.GREEN);
        styleButton(menu, Color.WHITE);
        styleButton(exit, Color.WHITE);
        add(back);
        add(menu);
        add(exit);
        setForeground(new Color(135, 206, 250));
        pack();
        setLocationRelativeTo(Main.frame);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_DOWN) {
            if (currentButton == 0) {
                menu.setForeground(Color.GREEN);
                back.setForeground(Color.WHITE);
                currentButton++;
            }
            else if (currentButton == 1) {
                exit.setForeground(Color.GREEN);
                menu.setForeground(Color.WHITE);
                currentButton++;
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (currentButton == 2) {
                menu.setForeground(Color.GREEN);
                exit.setForeground(Color.WHITE);
                currentButton--;
            }
            else if (currentButton == 1) {
                back.setForeground(Color.GREEN);
                menu.setForeground(Color.WHITE);
                currentButton--;
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            if (currentButton == 0) {
                setVisible(false);
            }
            if (currentButton == 1) {
                gameStateManager.states.push(new MenuState(gameStateManager));
                setVisible(false);
            }
            if (currentButton == 2) {
                System.exit(1);
            }

        }
    }

    private static void styleButton(JButton button, Color color) {
        button.setFont(new Font("Times", Font.BOLD, 20));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(color);
        button.setBackground(new Color(135, 206, 250));
        button.setPreferredSize(new Dimension(450, 50));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
