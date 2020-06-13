package GameStates;

import Entities.Player;
import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Level1State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;


    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        Image playerImage = new ImageIcon("images/person.jpg").getImage();
        Image eBefore = new ImageIcon("images/eBefore.jpg").getImage();
        Image eAfter = new ImageIcon("images/eAfter.jpg").getImage();
        player = new Player(playerImage, playerImage.getWidth(null), playerImage.getHeight(null), 700, 200);

        b = new Block[7];

        // b[0] = new Block(450,550, 500, 90);
        // b[1] = new Block(932,410,200,10);
        // b[2] = new Block(450,380, 200, 100);
        b[0] = new Block(0, 0, 20, 850);
        b[1] = new Block(1380, 0, 20, 850);
        b[2] = new Block(0, 280, 402, 10);
        b[3] = new Block(498, 280, 902, 10);

        b[4] = new Block(0, 550, 1000, 10);
        b[5] = new Block(1096, 550, 304, 10);


        b[6] = new Block(0, 820, 1400, 10);


        l = new Ladder[3];
        l[0] = new Ladder(405, 260, 90, 300);
        l[1] = new Ladder(1003, 530, 90, 300);
        l[2] = new Ladder(703, 600, 90, 200);

        e = new EObjects[1];
        e[0] = new EObjects(710, 480, eBefore, eAfter, "marker");
    }

    @Override
    public void tick() {
        for (int i = 0; i < b.length; i++) {
            b[i].tick();
        }

        for (int i = 0; i < l.length; i++) {
            l[i].tick();
        }
        for (int i = 0; i < e.length; i++) {
            e[i].tick();
        }
        player.tickLadder(l);
        player.tickEObjects(e);
        player.tickBlock(b);

    }

    @Override
    public void draw(Graphics g) {

        for (int i = 0; i < l.length; i++) {
            l[i].draw(g);
        }

        for (int i = 0; i < e.length; i++) {
            e[i].draw(g);
        }

        player.draw(g);

        for (int i = 0; i < b.length; i++) {
            b[i].draw(g);
        }
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b, l, e);
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