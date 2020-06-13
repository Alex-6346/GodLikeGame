package Physics;

import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;

import java.awt.*;

public class Collision {

    public static boolean playerBlock(Point p, Block b){
        return b.contains(p);
    }
    public static boolean playerLadder(Point p, Ladder l) { return l.contains(p);}
    public static boolean playerEObject(Point p, EObjects e) { return e.contains(p);}
}
