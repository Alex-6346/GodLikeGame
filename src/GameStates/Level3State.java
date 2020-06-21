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

public class Level3State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;
    private int seconds;
    String time;
    Timer timer;
    private Image background;
    Animation playerImage;
    private Image hole;
    private Image eBefore;
    private Image eAfter;
    private Image empty;
    private Image fruit;
    private Image potion;

    public static boolean lvl3IsUnlocked;

    public Level3State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        lvl3IsUnlocked=true;
        seconds = 90;
        time = "90";
        Player.isLvl3 = true;
        playerImage = new Animation(Animation.stayR());
        background = new ImageIcon("images/level3Background.jpg").getImage();
        hole = new ImageIcon("images/lvl3Hole.png").getImage();
        eBefore = new ImageIcon("images/eBefore.jpg").getImage();
        eAfter = new ImageIcon("images/eAfter.jpg").getImage();
        empty = new ImageIcon("images/empty.png").getImage();
        fruit = new ImageIcon("images/lvl3Fruit.png").getImage();
        potion = new ImageIcon("images/lvl3Potion.png").getImage();
        player = new Player(playerImage, 60, 130, 100, 350, gameStateManager);

        b = new Block[12];

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
        b[11] = new Block(965, 210, 10, 170);


        l = new Ladder[1];
        l[0] = new Ladder(995, 365, 100, 220);

        e = new EObjects[4];
        e[0] = new EObjects(200, 340, fruit, empty, true);
        e[1] = new EObjects(1010, 330, eBefore, eAfter, false);
        e[2] = new EObjects(850, 500, potion, empty, false);
        e[3] = new EObjects(300, 160, eBefore, eAfter, false);

        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                if (seconds > 1) {
                    seconds--;
                    time = "" + seconds;
                }
                else {
                    seconds = 90;
                    //TODO ask menu
                    gameStateManager.states.push(new Level3State(gameStateManager));
                }
            }
        };
        long delay = 1000;
        long period = 1000;
        timer = new Timer();
        timer.scheduleAtFixedRate(repeatedTask, delay, period);

    }

    @Override
    public void tick() {
        player.update();
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

        if (e[0].isActivated()) {
            b[11] = new Block(1390, 210, 10, 170);
        }
        if (e[3].isActivated()) {
            //TODO
            //gameStateManager.states.push(new Level4State(gameStateManager));
        }
        if(player.isFallen){
            //TODO ask menu
            seconds = 90;
            gameStateManager.states.push(new Level3State(gameStateManager));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < e.length; i++) {
            e[i].draw(g);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Float(1276, 30, 60, 60));
        g2.setColor(Color.BLACK);
        g.setFont(new Font("Times", Font.PLAIN, 30));
        if(Integer.valueOf(time)<10){
            g.drawString(time, 1299, 70);
        }else {
            g.drawString(time, 1290, 70);
        }
        player.draw(g);
        g.drawImage(hole, 705, 369, null);
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b, l, e);
        if(key == KeyEvent.VK_R){
            gameStateManager.states.push(new Level3State(gameStateManager));
        }
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