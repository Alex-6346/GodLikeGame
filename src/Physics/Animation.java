package Physics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation {
    ArrayList <String> move=new ArrayList<>();
    public int anim;
    public String ad;

    public Animation(){
        move.add("per1.PNG");
        move.add("per1.PNG");
        move.add("per1.PNG");
        move.add("per1.PNG");
        move.add("per2.PNG");
        move.add("per2.PNG");
        move.add("per2.PNG");
        move.add("per2.PNG");
    }
    public void update(){
        anim++;
        if(anim>move.size()) anim=0;
        ad=move.get(anim);
    }
    //отрисовка
    public void animDraw(Graphics g){
        g.drawImage(new ImageIcon(ad).getImage(), 450, 200, null);
    }
}
