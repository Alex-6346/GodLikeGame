package GameStates;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameState {
    protected GameStateManager gameStateManager;
    public GameState(GameStateManager gameStateManager){
        this.gameStateManager = gameStateManager;
    }

    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);
    public abstract void mouseClicked(MouseEvent e);
    public abstract void mouseEntered(MouseEvent e);
    public abstract void mouseExited(MouseEvent e);
}
