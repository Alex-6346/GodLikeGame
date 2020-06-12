package Objects;

import java.awt.*;

public class Block extends Rectangle {


    public Block(int x, int y, int width, int height){
        setBounds(x,y,width,height);
    }

    public void tick(){

    }

    public void draw(Graphics g){
        g.fillRect(x,y,width,height);
    }



}
