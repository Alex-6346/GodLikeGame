package GameStates;

import Entities.Player;
import Objects.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Level1State extends GameState {

    private Player player;
    private Block[] b;


    public Level1State(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {
        Image playerImage = new ImageIcon("images/person.jpg").getImage();
        player = new Player(playerImage, playerImage.getWidth(null), playerImage.getHeight(null), 700, 200);

        b = new Block[3];

        b[0] = new Block(750,450, 90, 90);
        b[1] = new Block(850,550, 90, 90);
        b[2] = new Block(950,650, 90, 90);
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
        player.keyPressed(key, b);
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