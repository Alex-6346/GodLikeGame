package Physics;

import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;

import java.awt.*;

public class Collision {

    public static boolean playerBlock(Point p, Block b) {
        return b.contains(p);
    }

    public static boolean middleRightAndLeftEdge(int start, int end, int yStart, int yEnd, Block b) {
        if (b.getY() >= yStart && b.getY() + b.getHeight() <= yEnd &&
                ((b.getX() <= start + 10 && b.getX() + b.getWidth() >= end - 10) ||
                        (b.getX() <= start && (end - b.getX() - b.getWidth() < 10)) ||
                        (b.getX() >= start && (end - b.getX() > -10)))) {
            return true;
        } else return false;
    }

    public static boolean playerLadder(Point p, Ladder l) {
        return l.contains(p);
    }

    public static boolean playerEObject(Point p, EObjects e) {
        return e.contains(p);
    }
}
