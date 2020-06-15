package Physics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation {
    ArrayList<String> typeAnimation = new ArrayList<>();
    public int anim = 0;
    public String ad;

    public Animation(){}

    public Animation(ArrayList<String> typeAnimation) {
        this.typeAnimation = typeAnimation;
    }

    public void update() {
        anim++;
        if (anim >= typeAnimation.size()) anim = 0;
        ad = typeAnimation.get(anim);
    }

    public static ArrayList<String> move(){
        ArrayList<String> move = new ArrayList<>();
        move.add("images/person.jpg");
        return move;
    }

    public static ArrayList<String> ctrlMove(){
        ArrayList<String> move = new ArrayList<>();
        move.add("images/personHalfCut.png");
        return move;
    }

    public void setTypeAnimation(ArrayList<String>newTypeAnimation){
        typeAnimation = newTypeAnimation;
        anim = 0;
    }

    //отрисовка
    public void animDraw(Graphics g, int x, int y) {
        g.drawImage(new ImageIcon(ad).getImage(), x, y, null);
    }
}
