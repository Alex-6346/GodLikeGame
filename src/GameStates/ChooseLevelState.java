package GameStates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import MainPack.Main;

import static GameStates.Level3State.lvl3IsUnlocked;
import static GameStates.Level4State.lvl4IsUnlocked;


public class ChooseLevelState extends GameState {

    private int currentSelection = 0;

    private String[] options = new String[]{"1", "2", "3", "4", "5"};


    public static boolean lvl2IsUnlocked = false;

    public static boolean lvl5IsUnlocked = false;

    public ChooseLevelState(GameStateManager gameStateManager) {
        super(gameStateManager);
    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Main.frame.getWidth(), Main.frame.getHeight());

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 100));
        g.drawString("Choose the level:", Main.frame.getWidth()/2-365,100);

        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) {
                g.setColor(Color.RED);
                if(i==0){
                    g.setColor(Color.GREEN);
                }
                if(i==1){
                    if(lvl2IsUnlocked) g.setColor(Color.GREEN);
                }
                if(i==2){
                    if(lvl3IsUnlocked) g.setColor(Color.GREEN);
                }
                if(i==3){
                    if(lvl4IsUnlocked) g.setColor(Color.GREEN);
                }
                if(i==4){
                    if(lvl5IsUnlocked) g.setColor(Color.GREEN);
                }

            } else{
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], (i + 1) *Main.frame.getWidth() / 5 - 180, Main.frame.getHeight() / 2);
        }
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_RIGHT) {
            if (currentSelection < options.length-1) {
                currentSelection++;
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (currentSelection > 0) {
                currentSelection--;
            }
        }
        if (key == KeyEvent.VK_ENTER){
            if(currentSelection == 0){
                gameStateManager.states.push(new Level1State(gameStateManager));
            }

            if(currentSelection == 1) {
                //if(lvl2IsUnlocked) gameStateManager.states.push(new Level2State(gameStateManager));
            }

            if(currentSelection == 2){
               if(lvl3IsUnlocked) gameStateManager.states.push(new Level3State(gameStateManager));
            }

            if(currentSelection == 3){
                if(lvl4IsUnlocked) gameStateManager.states.push(new Level4State(gameStateManager));
            }

            if(currentSelection == 4){
                //if(lvl5IsUnlocked) gameStateManager.states.push(new Level5State(gameStateManager));
            }

        }
    }

    @Override
    public void keyTyped(int key) {

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
