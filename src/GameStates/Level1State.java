package GameStates;

import Entities.Player;
import Objects.Block;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Level1State extends GameState {

    private Player player = new Player(20,20);;
    private Block[] b = new Block[]{new Block(750,750), new Block(850,850), new  Block(950,950)};


    public Level1State(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {
        player = new Player(20,20);

        b = new Block[3];

        b[0] = new Block(750,750);
        b[1] = new Block(850,850);
        b[2] = new Block(950,950);
    }

    @Override
    public void tick() {
        for(int i=0;i<b.length;i++){
            b[i].tick();
        }

        player.tick(b);

    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);

        for(int i=0;i<b.length;i++){
            b[i].draw(g);
        }
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key);
    }

    @Override
    public void keyReleased(int key) {
        player.keyReleased(key);
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