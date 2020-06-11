package MainPack;

import MainPack.Main;

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class Display {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setTitle("Game");
        frame.setFocusable(true);
        frame.add(new Main(frame));
        frame.setVisible(true);
    }
}
