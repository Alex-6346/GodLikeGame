package GameStates;

import Entities.Player;
import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;
import Physics.Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Level1State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;
    Animation playerImage;
    private Image background;

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        playerImage = new Animation(Animation.move());
        Player.isLvl1 = true;
        Image eBefore = new ImageIcon("images/eBefore.jpg").getImage();
        Image eAfter = new ImageIcon("images/eAfter.jpg").getImage();
        background = new ImageIcon("images/level1Background.jpg").getImage();
        player = new Player(playerImage, 60,130, 100, 500);

        b = new Block[18];

        //walls
        b[0] = new Block(0, 0, 2, 850);
        b[1] = new Block(1398, 0, 2, 850);

        //beginning platform
        b[2] = new Block(0,725,425,10);

        //left clock
        b[3] = new Block(280, 250, 15, 370);
        b[4] = new Block(230, 465, 280, 10);

        //central clock
        b[5] = new Block(460,590,290,10);
        b[6] = new Block(677,400,20,330);

        //centralhigh clock
        b[7] = new Block(480,360,100,10);
        b[8] = new Block(572,245,15,150);
        b[9] = new Block(580,350,95,20);

        //central ri clock
        b[10] = new Block(750,630,470,10);

        //down ri clock
        b[11] = new Block(1120,755,230,10);

        //firstladder clock
        b[12] = new Block(1325,655,100,10);

        //secondladder clock
        b[13] = new Block(1325,530,100,10);

        //rightclock
        b[14] = new Block(1100,425, 245,10);
        b[15] = new Block(1160,385, 15,45);

        //neartofinal clock
        b[16] = new Block(1060,283, 145,10);

        //final clock
        b[17] = new Block(1195,225, 220,10);



        l = new Ladder[1];
        l[0]= new Ladder(2000,2000,0,0);

        e = new EObjects[1];
        e[0] = new EObjects(710, 480, eBefore, eAfter, true);
    }

    @Override
    public void tick() {
        player.uodate();
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

        for (int i = 0; i < l.length; i++) {
            //l[i].draw(g);
        }

        for (int i = 0; i < e.length; i++) {
          //  e[i].draw(g);
        }

        player.draw(g);

        for (int i = 0; i < b.length; i++) {
         // b[i].draw(g);
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