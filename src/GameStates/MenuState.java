package GameStates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import MainPack.Main;

public class MenuState extends GameState {

    private int currentSelection = 0;

    private String[] options = new String[]{"Start", "Help", "Exit"};

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0, 0, Main.frame.getWidth(), Main.frame.getHeight());
        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) {
                g.setColor(Color.GREEN);
            } else g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 100));
            g.drawString(options[i], Main.frame.getWidth() / 2 - 100, (i + 1) * Main.frame.getHeight() / 3 - 150);
        }
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_DOWN) {
            if (currentSelection < options.length-1) {
                currentSelection++;
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (currentSelection > 0) {
                currentSelection--;
            }
        }
        if (key == KeyEvent.VK_ENTER){
            if(currentSelection == 0){
                gameStateManager.states.push(new Level3State(gameStateManager));
            }

            if(currentSelection == 1) {
                gameStateManager.states.push(new HelpState(gameStateManager));
            }

            if(currentSelection == 2){

            }

        }
    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
