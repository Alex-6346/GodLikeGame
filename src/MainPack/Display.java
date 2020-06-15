package MainPack;

import GameStates.Level1State;
import MainPack.Main;

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class Display {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension( 1400, 860));
        frame.setResizable(false);
        frame.setTitle("Game");
        frame.setFocusable(true);
        frame.add(new Main(frame));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
