package Physics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

public class Animation {
    ArrayList<String> typeAnimation;
    public int anim = 0;
    public String ad;

    public Animation(ArrayList<String> typeAnimation) {
        this.typeAnimation = typeAnimation;
    }

    public void update() {
        anim++;
        if (anim >= typeAnimation.size()) anim = 0;
        ad = typeAnimation.get(anim);
    }

    public static ArrayList<String> stayR() {
        ArrayList<String> move = new ArrayList<>();
        move.add("images/jump/jump1.png");
        return move;
    }

    public static ArrayList<String> stayL() {
        ArrayList<String> move = new ArrayList<>();
        move.add("images/jumpL/jump1L.png");
        return move;
    }

    public static ArrayList<String> jumpR() {
        ArrayList<String> jump = new ArrayList<>();
        makeAnimationLonger(2, jump, "images/jump/jump1.png");
        makeAnimationLonger(2, jump, "images/jump/jump2.png");
        makeAnimationLonger(2, jump, "images/jump/jump3.png");
        makeAnimationLonger(2, jump, "images/jump/jump4.png");
        makeAnimationLonger(2, jump, "images/jump/jump5.png");
        makeAnimationLonger(2, jump, "images/jump/jump6.png");
        makeAnimationLonger(2, jump, "images/jump/jump7.png");
        makeAnimationLonger(2, jump, "images/jump/jump8.png");
        makeAnimationLonger(2, jump, "images/jump/jump9.png");
        makeAnimationLonger(2, jump, "images/jump/jump10.png");
        makeAnimationLonger(2, jump, "images/jump/jump11.png");
        makeAnimationLonger(2, jump, "images/jump/jump12.png");
        makeAnimationLonger(2, jump, "images/jump/jump13.png");
        makeAnimationLonger(2, jump, "images/jump/jump14.png");
        makeAnimationLonger(2, jump, "images/jump/jump15.png");
        makeAnimationLonger(2, jump, "images/jump/jump16.png");
        makeAnimationLonger(2, jump, "images/jump/jump17.png");
        makeAnimationLonger(2, jump, "images/jump/jump18.png");
        makeAnimationLonger(2, jump, "images/jump/jump19.png");
        makeAnimationLonger(2, jump, "images/jump/jump20.png");
        makeAnimationLonger(2, jump, "images/jump/jump21.png");
        makeAnimationLonger(2, jump, "images/jump/jump22.png");
        makeAnimationLonger(2, jump, "images/jump/jump23.png");
        makeAnimationLonger(2, jump, "images/jump/jump24.png");
        makeAnimationLonger(2, jump, "images/jump/jump25.png");
        makeAnimationLonger(2, jump, "images/jump/jump26.png");
        makeAnimationLonger(2, jump, "images/jump/jump27.png");
        makeAnimationLonger(2, jump, "images/jump/jump28.png");
        makeAnimationLonger(2, jump, "images/jump/jump29.png");
        makeAnimationLonger(2, jump, "images/jump/jump30.png");
        makeAnimationLonger(2, jump, "images/jump/jump31.png");
        makeAnimationLonger(2, jump, "images/jump/jump32.png");
        makeAnimationLonger(2, jump, "images/jump/jump33.png");
        return jump;
    }

    public static ArrayList<String> jumpL() {
        ArrayList<String> jump = new ArrayList<>();
        makeAnimationLonger(2, jump, "images/jumpL/jump1L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump2L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump3L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump4L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump5L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump6L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump7L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump8L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump9L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump10L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump11L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump12L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump13L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump14L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump15L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump16L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump17L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump18L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump19L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump20L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump21L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump22L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump23L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump24L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump25L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump26L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump27L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump28L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump29L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump30L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump31L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump32L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump33L.png");
        return jump;
    }

    public static ArrayList<String> ctrlStayR() {
        ArrayList<String> ctrlMove = new ArrayList<>();
        ctrlMove.add("images/crouchR/crouch5.png");
        return ctrlMove;
    }

    public static ArrayList<String> ctrlStayL() {
        ArrayList<String> ctrlMove = new ArrayList<>();
        ctrlMove.add("images/crouchL/crouch5.png");
        return ctrlMove;
    }

    public static ArrayList<String> ctrlR() {
        ArrayList<String> ctrlR = new ArrayList<>();
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch1.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch2.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch3.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch4.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch5.png");
        return ctrlR;
    }
    public static ArrayList<String> ctrlL() {
        ArrayList<String> ctrlL = new ArrayList<>();
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch1.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch2.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch3.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch4.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch5.png");
        return ctrlL;
    }

    public static ArrayList<String> moveCtrlR() {
        ArrayList<String> moveCtrlR1 = new ArrayList<>();
        makeAnimationLonger(6, moveCtrlR1, "images/moveCrouchR/moveCrouch1.1.png");
        makeAnimationLonger(6, moveCtrlR1, "images/moveCrouchR/moveCrouch1.2.png");
        makeAnimationLonger(6, moveCtrlR1, "images/moveCrouchR/moveCrouch2.1.png");
        makeAnimationLonger(6, moveCtrlR1, "images/moveCrouchR/moveCrouch2.2.png");
        return moveCtrlR1;
    }

    public static ArrayList<String> moveCtrlL() {
        ArrayList<String> moveCtrlL1 = new ArrayList<>();
        makeAnimationLonger(6, moveCtrlL1, "images/moveCrouchL/moveCrouch1.1.png");
        makeAnimationLonger(6, moveCtrlL1, "images/moveCrouchL/moveCrouch1.2.png");
        makeAnimationLonger(6, moveCtrlL1, "images/moveCrouchL/moveCrouch2.1.png");
        makeAnimationLonger(6, moveCtrlL1, "images/moveCrouchL/moveCrouch2.2.png");
        return moveCtrlL1;
    }

    public static ArrayList<String> notCtrlR() {
        ArrayList<String> notCtrlR = new ArrayList<>();
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch5.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch4.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch3.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch2.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch1.png");
        return notCtrlR;
    }
    public static ArrayList<String> notCtrlL() {
        ArrayList<String> notCtrlL = new ArrayList<>();
        makeAnimationLonger(3, notCtrlL, "images/crouchL/crouch5.png");
        makeAnimationLonger(3, notCtrlL, "images/crouchL/crouch4.png");
        makeAnimationLonger(3, notCtrlL, "images/crouchL/crouch3.png");
        makeAnimationLonger(3, notCtrlL, "images/crouchL/crouch2.png");
        makeAnimationLonger(3, notCtrlL, "images/crouchL/crouch1.png");
        return notCtrlL;
    }

    public void setTypeAnimation(ArrayList<String> newTypeAnimation) {
        typeAnimation = newTypeAnimation;
        anim = 0;
    }

    private static void makeAnimationLonger(int numberOfRepeats, ArrayList<String> animation, String picture) {
        for (int i = 0; i < numberOfRepeats; i++) {
            animation.add(picture);
        }
    }

    //отрисовка
    public void animDraw(Graphics g, int x, int y) {
        g.drawImage(new ImageIcon(ad).getImage(), x, y, null);
    }
}
