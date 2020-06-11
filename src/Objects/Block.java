package Objects;

import java.awt.*;

public class Block extends Rectangle {

    public static final int BLOCK_SIZE = 32;

    public Block(int x, int y){
        setBounds(x,y,BLOCK_SIZE,BLOCK_SIZE);
    }

    public void tick(){

    }

    public void draw(Graphics g){
        g.fillRect(x,y,width,height);
    }



}
