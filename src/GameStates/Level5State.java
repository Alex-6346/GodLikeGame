package GameStates;

import Entities.Player;
import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;
import Physics.Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Level5State extends GameState {

    private Player player;
    private Block[] b;
    private Ladder[] l;
    private EObjects[] e;
    private Image background;
    Animation playerImage;
    private Image window;
    private Image eBefore;
    private Image eAfter;
    private Image empty;
    private Image key;
    private Image torch1;
    private Image torch2;
    private Image torchAfter;

    public static boolean lvl5IsUnlocked;

    public Level5State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        lvl5IsUnlocked=true;
        playerImage = new Animation(Animation.stayR());
        background = new ImageIcon("images/Lvl5/lvl5.jpg").getImage();
        window = new ImageIcon("images/Lvl5/window.png").getImage();
        eBefore = new ImageIcon("images/eBefore.jpg").getImage();
        eAfter = new ImageIcon("images/eAfter.jpg").getImage();
        empty = new ImageIcon("images/empty.png").getImage();
        key = new ImageIcon("images/Lvl5/key.png").getImage();
        torch1 = new ImageIcon("images/Lvl5/torch.png").getImage();
        torch2 = new ImageIcon("images/Lvl5/torch2.png").getImage();
        torchAfter = new ImageIcon("images/Lvl5/torchAfter.png").getImage();
        player = new Player(playerImage, 60, 130, 100, 120, gameStateManager);

        b = new Block[8];

        b[0] = new Block(0, 0, 20, 850);
        b[1] = new Block(1380, 0, 20, 850);

        //3 floor
        b[2] = new Block(0, 250, 373, 10);
        b[3] = new Block(533, 250, 867, 10);

        //2 floor
        b[5] = new Block(0, 530, 75, 10);
        b[4] = new Block(255, 530, 1145, 10);

        //1 floor
        b[6] = new Block(0, 805, 1400, 10);

        //wall
        b[7] = new Block(955, 540, 30, 265);


        l = new Ladder[2];
        l[0] = new Ladder(75, 520, 180, 280);
        l[1] = new Ladder(353, 240, 180, 280);

        e = new EObjects[6];
        e[0] = new EObjects(780, 575, torch1, torchAfter, true);
        e[1] = new EObjects(676, 150, eBefore, empty, false);
        e[2] = new EObjects(1010, 730, eBefore, eAfter, false);
        e[3] = new EObjects(130, 380, eBefore, eAfter, false);
        e[4] = new EObjects(200, 140, eBefore, key, false);
        e[5] = new EObjects(1010, 430, eBefore, eAfter, false);
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
            b[1] = new Block(1380, 250, 20, 280);
            Player.isLvl5 = true;
        }

        if (e[5].isActivated()) {
            //TODO end
        }

        if(player.isFallen){
            gameStateManager.states.push(new Level5State(gameStateManager));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < e.length; i++) {
            e[i].draw(g);
        }
        if (e[1].isActivated()) {
            g.drawImage(torch2, 676, 70, null);
        }
        player.draw(g);
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, b, l, e);
        if(key == KeyEvent.VK_R){
            gameStateManager.states.push(new Level5State(gameStateManager));
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