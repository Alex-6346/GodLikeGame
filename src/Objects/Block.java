package Objects;

import java.awt.*;

public class Block extends Rectangle {

    public static final int BLOCK_SIZE = 90;
    private int id;



    public Block(int x, int y, int id){
        setBounds(x,y,BLOCK_SIZE,BLOCK_SIZE);
        this.id = id;
    }

    public void tick(){

    }

    public void draw(Graphics g) {
        if (id != 0) {
            g.fillRect(x, y, width, height);
        }
    }

    //getters and setters
    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }



}
