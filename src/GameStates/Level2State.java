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
    private Image rocket;
    private Image fire;
    private Image sea;
    private Image sea2;
    private Image owl, ship2;
    private Image rope, rope2;
    private Image stick, ship;
    private Image empty;

    public static boolean lvl2IsUnlocked;

    public Level2State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        lvl2IsUnlocked = true;
        playerImage = new Animation(Animation.stayR());
        background = new ImageIcon("images/lvl2/level2Background1.jpg").getImage();
        rocket = new ImageIcon("images/lvl2/rocket.png").getImage();
        empty = new ImageIcon("images/empty.png").getImage();
        fire = new ImageIcon("images/lvl2/fire.png").getImage();
        sea = new ImageIcon("images/lvl2/sea1.png").getImage();
        owl = new ImageIcon("images/lvl2/owl.png").getImage();
        rope = new ImageIcon("images/lvl2/rope.png").getImage();
        stick = new ImageIcon("images/lvl2/stick.png").getImage();
        rope2 = new ImageIcon("images/lvl2/rope2.png").getImage();
        ship = new ImageIcon("images/lvl2/ship1.png").getImage();
        sea2 = new ImageIcon("images/lvl2/sea2.png").getImage();
        ship2 = new ImageIcon("images/lvl2/ship.png").getImage();
        player = new Player(playerImage, 60, 130, 280, 550, gameStateManager);

        b = new Block[8];

        b[0] = new Block(0, 610, 300, 10);//land1
        b[1] = new Block(0, 725, 400, 10);//plot
        b[2] = new Block(127, 481, 105, 10);//island1
        b[3] = new Block(250, 340, 210, 10);//island2
        b[4] = new Block(960, 310, 210, 10); //rope
        b[5] = new Block(910, 330, 200, 10);//island3
        b[6] = new Block(460, 600, 410, 10);//middle
        b[7] = new Block(0, 0, 0, 0);


        l = new Ladder[1];
        l[0] = new Ladder(995, 365, 100, 220);

        e = new EObjects[7];
        e[0] = new EObjects(20, 490, rope, empty, true);
        e[1] = new EObjects(450, 250, stick, empty, false);
        e[2] = new EObjects(970, 240, fire, empty, false);
        e[3] = new EObjects(547, 430, rocket, empty, false);
        e[4] = new EObjects(1150, 300, owl, empty, false);
        e[5] = new EObjects(0, 685, sea, empty, false);
        e[6] = new EObjects(850, 580, ship, empty, false);


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

        if (e[0].isActivated() && e[1].isActivated()) {
            e[0] = new EObjects(250, 255, rope2, rope2, true);
            b[4] = new Block(460, 310, 470, 10);
            e[2] = new EObjects(970, 240, fire, empty, false);
        }
        if (e[2].isActivated()) e[0] = new EObjects(0, 0, empty, empty, false);
        if (e[3].isActivated()) {
            e[5] = new EObjects(0, 510, sea2, empty, false);
            e[6] = new EObjects(0, 0, empty, empty, false);
            b[7] = new Block(870, 610, 100, 10);
        }
        if (e[5].isActivated()) {
            e[0] = new EObjects(20, 490, rope, empty, true);
        }

        if (e[3].isActivated()) {
            //TODO
            gameStateManager.states.push(new Level3State(gameStateManager));
        }

        if (player.isFallen) {
            //TODO ask menu
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

        //g.drawImage(sea, 0, 555, null);
        player.draw(g);

    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b, l, e);
        if (key == KeyEvent.VK_R) {
            gameStateManager.states.push(new Level2State(gameStateManager));
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
