package GameStates;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class GameStateManager {

    public Stack<GameState> states;

    public GameStateManager(){
        states = new Stack<GameState>();
        states.push(new MenuState(this));
    }

    public void tick(){
        states.peek().tick();
    }


    public  void draw(Graphics g){
        states.peek().draw(g);
    }

    public void keyPressed(int key){
        states.peek().keyPressed(key);
    }

    public void keyReleased(int key){
        states.peek().keyReleased(key);
    }

    public void mouseClicked(MouseEvent e) {
        states.peek().mouseClicked(e);
    }


    public void mouseEntered(MouseEvent e) {
        states.peek().mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        states.peek().mouseExited(e);
    }

}
