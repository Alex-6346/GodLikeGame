package GameStates;

import MainPack.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class HelpState extends GameState {

    private Image сtrl;
    private Image arrowUp;
    private Image arrowUpDown;


    public HelpState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        Image сtrl = new ImageIcon("images/CtrlButton.png").getImage();
        Image arrowUp = new ImageIcon("images/upArrowKey.png").getImage();
        Image arrowUpDown = new ImageIcon("images/upAndDownArrowKeys").getImage();
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0, 0, Main.frame.getWidth(), Main.frame.getHeight());
        g.setFont(new Font("Arial", Font.PLAIN, 100));
        g.setColor(Color.WHITE);
        g.drawString("Controls:", Main.frame.getWidth()/2-175,100);
        g.drawString("Move - Arrow Keys", Main.frame.getWidth()/2-400,250);
        g.drawString("Jump - ", Main.frame.getWidth()/2-250,350);
        g.drawImage(arrowUp,700,300,100,100,null);


        }


    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

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
