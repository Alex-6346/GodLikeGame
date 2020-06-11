package GameStates;

import Entities.Player;
import Mapping.Map;
import Objects.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Level1State extends GameState {

    private Player player;
    private Map map;


    public Level1State(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void init() {
        Image playerImage = new ImageIcon("images/person.jpg").getImage();
        player = new Player(playerImage, playerImage.getWidth(null), playerImage.getHeight(null), 700, 200);
        map = new Map("/map1.map");

    }

    @Override
    public void tick() {
        player.tick(map.getBlocks());

    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        map.draw(g);
    }





    @Override
    public void keyPressed(int key) {
        player.keyPressed(key, map.getBlocks());
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