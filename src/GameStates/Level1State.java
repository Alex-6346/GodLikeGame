package GameStates;

import Entities.Player;
import Objects.Block;
import Objects.Ladder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Level1State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;


    public Level1State(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {
        Image playerImage = new ImageIcon("images/person.jpg").getImage();
        player = new Player(playerImage, playerImage.getWidth(null), playerImage.getHeight(null), 700, 200);

        b = new Block[3];

        b[0] = new Block(450,550, 500, 90);
        b[1] = new Block(932,410,200,10);
        b[2] = new Block(450,380, 200, 150);


        l = new Ladder[1];
        l[0] = new Ladder( 850,390,80,130);
    }

    @Override
    public void tick() {
        for(int i=0;i<b.length;i++){
            b[i].tick();
        }

        for(int i=0;i<l.length;i++){
            l[i].tick();
        }
        player.tickLadder(l);
        player.tickBlock(b);

    }

    @Override
    public void draw(Graphics g) {

        for(int i=0;i<l.length;i++){
            l[i].draw(g);
        }
        player.draw(g);

        for(int i=0;i<b.length;i++){
            b[i].draw(g);
        }
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b,l);
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