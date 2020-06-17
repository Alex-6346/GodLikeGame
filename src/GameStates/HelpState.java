package GameStates;

import MainPack.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class HelpState extends GameState {


    private Image arrowUp;
    private Image arrowUpDown;
    private Image ctrlButton;
    private Image escButton;

    public HelpState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        arrowUp = new ImageIcon("images/upArrowKey.png").getImage();
        arrowUpDown = new ImageIcon("images/upAndDownArrowKeys.png").getImage();
        ctrlButton = new ImageIcon("images/CtrlButton.png").getImage();
        escButton = new ImageIcon("images/escButton.png").getImage();

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
        g.setFont(new Font("Arial", Font.PLAIN, 80));
        g.drawString("Move - Arrow Keys", Main.frame.getWidth()/2-325,240);
        g.drawString("Jump - ", Main.frame.getWidth()/2-200,320);
        g.drawImage(arrowUp,775,255,80,80,null);
        g.drawString("Сrouch - ", Main.frame.getWidth()/2-250,400);
        g.drawImage(ctrlButton,790, 335,130,80,null);
        g.drawString("Climb the ladder - ", Main.frame.getWidth()/2-350,480);
        g.drawImage(arrowUpDown,1000,375,80,160,null);
        g.drawString("Pause - ", Main.frame.getWidth()/2-225,560);
        g.drawImage(escButton,775,490,90,90,null);

        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.PLAIN, 120));
        g.drawString("OK!", Main.frame.getWidth()/2-100,700);

        }



    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ENTER){
            gameStateManager.states.pop();
            }
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
