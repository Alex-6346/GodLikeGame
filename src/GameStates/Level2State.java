package GameStates;

import Entities.Player;
import MainPack.Main;
import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;
import Physics.Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;

public class Level2State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;
    private int seconds;
    private Image background;
    Animation playerImage;
    private Image owl;
    private Image rope;
    private Image rocket;
    private Image empty;
    private Image fire;
    private Image sea;

    public Level2State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        Player.isLvl2 = true;
        playerImage = new Animation(Animation.stayR());
        background = new ImageIcon("images/level2Background.jpg").getImage();
        owl = new ImageIcon("images/owl.png").getImage();
        rope = new ImageIcon("images/rope.png").getImage();
        rocket = new ImageIcon("images/rocket.png").getImage();
        empty = new ImageIcon("images/empty.png").getImage();
        fire = new ImageIcon("images/fire.png").getImage();
        sea = new ImageIcon("images/sea.png").getImage();
        player = new Player(playerImage, 60, 130, 280, 550, gameStateManager);

        b = new Block[2];

        b[0] = new Block(0,725,400,10);
        b[1] = new Block(0, 610, 300, 10);
/*

        b[2] = new Block(220, 243, 565, 10);
        b[3] = new Block(550, 370, 445, 10);

        b[4] = new Block(1095, 370, 280, 10);
        b[5] = new Block(30, 480, 660, 10);
        b[6] = new Block(810, 600, 300, 10);
        b[7] = new Block(800, 460, 10, 140);
        b[8] = new Block(1110, 460, 10, 140);
        b[9] = new Block(800, 450, 165, 10);
        b[10] = new Block(965, 410, 25, 10);
        b[11] = new Block(965, 210, 10, 170);*/


        l = new Ladder[1];
        l[0] = new Ladder(995, 365, 100, 220);

        e = new EObjects[5];
        e[0] = new EObjects(800, 25, owl, empty, true);
        e[1] = new EObjects(0, 530, rope, empty, true);
        e[2] = new EObjects(970, 240, fire, empty, false);
        e[3] = new EObjects(0, 555, sea, empty, false);
        e[4] = new EObjects(547, 398, rocket, empty, false);



    }

    @Override
    public void tick() {
        player.update();
        for (int i = 0; i < b.length; i++) {
            b[i].tick();
        }

        /*for (int i = 0; i < l.length; i++) {
            l[i].tick();
        }*/
        for (int i = 0; i < e.length; i++) {
            e[i].tick();
        }
        //player.tickLadder(l);
        player.tickEObjects(e);
        player.tickBlock(b);

        if (e[0].isActivated()) {
            //b[11] = new Block(1390, 210, 10, 170);
        }
        /*if (e[3].isActivated()) {
            //TODO
            //gameStateManager.states.push(new Level4State(gameStateManager));
        }*/
        if(player.isFallen){
            //TODO ask menu
            seconds = 90;
            gameStateManager.states.push(new Level2State(gameStateManager));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < e.length; i++) {
            e[i].draw(g);
        }
        Graphics2D g2 = (Graphics2D) g;

        player.draw(g);
        //g.drawImage(owl, 705, 369, null);
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b,l, e);

    }

    @Override
    public void keyTyped(int key) {

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
