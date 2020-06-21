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

public class Level4State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;
    private int seconds;
    String time;
    Timer timer;
    private Image background;
    Animation playerImage;
    private Image mushroom;
    private Image flower;
    private Image empty;

    private Image goomba;
    private Image bowser;
    private Image yoshi;

    private Image uppertube;
    private Image downtube;

    public Level4State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        seconds = 120;
        time = "120";
        Player.isLvl1=false;
        Player.isLvl3=false;

        playerImage = new Animation(Animation.stayR());

        background = new ImageIcon("images/Lvl4/level4Background.jpg").getImage();
        mushroom = new ImageIcon("images/Lvl4/luckymushroom.png").getImage();
        goomba = new ImageIcon("images/Lvl4/goomba.png").getImage();
        empty = new ImageIcon("images/Lvl4/empty.png").getImage();

        flower = new ImageIcon("images/Lvl4/fireflower.png").getImage();
        bowser = new ImageIcon("images/Lvl4/bowsercry.png").getImage();

        yoshi = new ImageIcon("images/Lvl4/yoshi.png").getImage();

        player = new Player(playerImage, 60, 130, 100, 170, gameStateManager);

        uppertube = new ImageIcon("images/Lvl4/uppertube.png").getImage();
        downtube = new ImageIcon("images/Lvl4/downtube.png").getImage();

        b = new Block[20];

        b[0] = new Block(0, 0, 10, 830);
        b[1] = new Block(1390, 0, 10, 830);

        b[2] = new Block(0, 350, 1190, 115);

        b[3] = new Block(0, 770, 700, 60);
        b[4] = new Block(700,810,190,30);
        b[5] = new Block(890, 770, 510, 60);
        b[6] = new Block(630,625,70,145);
        b[7] = new Block(797,630,70,70);
        b[8] = new Block(890,660,70,110);
        b[9] = new Block(990,695,70,70);

        b[10] = new Block(1300,350,100,115);


        b[11] = new Block(215,280,70,70);
        b[12] = new Block(355, 180,345,70);
        b[13] = new Block(420,110,140,70);
        b[14] = new Block(630,0,70,60);
        b[15] = new Block(630,250,70,100);

        b[16] = new Block(1180,250,10,330);
        b[17] = new Block(1290,250,10,330);

        b[18] = new Block(1180,250,110,20);
        b[19] = new Block(320,600,20,230);

        l = new Ladder[1];
        l[0] = new Ladder(705, 555, 90, 220);

        e = new EObjects[5];
        e[0] = new EObjects(550, 300, mushroom, empty, true);
        e[1] = new EObjects(1200, 190, goomba, empty, false);
        e[2] = new EObjects(820, 750, flower, empty, false);
        e[3] = new EObjects(230, 570, bowser, empty, false);
        e[4] = new EObjects(70,640, yoshi, yoshi,true);


        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                if (seconds > 1) {
                    seconds--;
                    time = "" + seconds;
                }
                else {
                    seconds = 120;
                    gameStateManager.states.push(new Level4State(gameStateManager));
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

        if (e[1].isActivated()) {
            b[18] = new Block(2000, 2000, 0, 0);
        }

        if (e[3].isActivated()) {
            b[19] = new Block(2000, 2000, 0, 0);
        }

        if (e[4].isActivated()) {
            seconds = 120;
            gameStateManager.states.push(new Level4State(gameStateManager));
        }

        if(player.isFallen){
            seconds = 120;
            gameStateManager.states.push(new Level4State(gameStateManager));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < e.length; i++) {
            e[i].draw(g);
        }
        for (int i = 0; i < b.length; i++) {
         //  b[i].draw(g);
        }
        for (int i = 0; i < l.length; i++) {
           // l[i].draw(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Times", Font.BOLD, 30));
        if(Integer.valueOf(time)<100){
            g.drawString(time, 1280, 80);
        }else {
            g.drawString(time, 1260, 80);
        }
        player.draw(g);
        g.drawImage(uppertube,1176, 250, 129,200, null);
        g.drawImage(downtube,1176, 390, 129,200, null);
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b, l, e);

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