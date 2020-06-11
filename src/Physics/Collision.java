package Physics;

import Objects.Block;

import java.awt.*;

public class Collision {

    public static boolean playerBlock(Point p, Block b){
        return b.contains(p);
    }

}
