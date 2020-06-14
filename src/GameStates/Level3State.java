package GameStates;

import Entities.Player;
import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Level3State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;

    private Image background;

    public Level3State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        Player.isLvl3 = true;
        Image playerImage = new ImageIcon("images/person.jpg").getImage();
        background = new ImageIcon("images/level3Background.jpg").getImage();
        Image eBefore = new ImageIcon("images/eBefore.jpg").getImage();
        Image eAfter = new ImageIcon("images/eAfter.jpg").getImage();
        player = new Player(playerImage, playerImage.getWidth(null), playerImage.getHeight(null), 700, 200);

        b = new Block[11];

        b[0] = new Block(0, 0, 20, 850);
        b[1] = new Block(1380, 0, 20, 850);


        b[2] = new Block(220, 243, 565, 10);
        b[3] = new Block(550, 370, 445, 10);

        b[4] = new Block(1095, 370, 280, 10);
        b[5] = new Block(30, 480, 660, 10);
        b[6] = new Block(810, 600, 300, 10);
        b[7] = new Block(800, 460, 10, 140);
        b[8] = new Block(1110, 460, 10, 140);
        b[9] = new Block(800, 450, 165, 10);
        b[10] = new Block(965, 410, 25, 10);



        l = new Ladder[1];
        l[0] = new Ladder(995, 365, 100, 220);

        e = new EObjects[1];
        e[0] = new EObjects(710, 680, eBefore, eAfter, "marker");
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

        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < e.length; i++) {
            e[i].draw(g);
        }
        player.draw(g);
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