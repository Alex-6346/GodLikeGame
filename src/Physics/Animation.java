package Physics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation {
    ArrayList <String> move=new ArrayList<>();
    public int anim=0;
    public String ad;

    public Animation(){
        move.add("images/per1.png");
        move.add("images/per1.png");
        move.add("images/per1.png");
        move.add("images/per1.png");
        move.add("images/per2.png");
        move.add("images/per2.png");
        move.add("images/per2.png");
        move.add("images/per2.png");
    }

    public void update(){
        anim++;
        if(anim>=move.size()) anim=0;
        ad=move.get(anim);
    }
    //отрисовка
    public void animDraw(Graphics g, int x, int y){
        g.drawImage(new ImageIcon(ad).getImage(), x, y, null);
    }
}
