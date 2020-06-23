package Physics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

public class Animation {
    ArrayList<String> typeAnimation;
    private static String name = "";
    public int anim = 0;
    public String ad;

    public Animation(ArrayList<String> typeAnimation) {
        this.typeAnimation = typeAnimation;
    }

    public void update() {
        anim++;
        if (anim >= typeAnimation.size()) {
            anim = 0;
        }
        ad = typeAnimation.get(anim);
    }

    public static ArrayList<String> stayR() {
        name = "stayR";
        ArrayList<String> move = new ArrayList<>();
        move.add("images/jump/jump1.png");
        return move;
    }

    public static ArrayList<String> stayL() {
        name = "stayL";
        ArrayList<String> move = new ArrayList<>();
        move.add("images/jumpL/jump1L.png");
        return move;
    }

    public static ArrayList<String> jumpR(boolean isLong) {
        name = "jumpR";
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
        if (isLong) {
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
        }
        makeAnimationLonger(2, jump, "images/jump/jump23.png");
        makeAnimationLonger(2, jump, "images/jump/jump24.png");
        makeAnimationLonger(2, jump, "images/jump/jump25.png");
        makeAnimationLonger(2, jump, "images/jump/jump26.png");
        makeAnimationLonger(2, jump, "images/jump/jump27.png");
        if(!isLong){
            makeAnimationLonger(2, jump, "images/jump/jump28.png");
            makeAnimationLonger(2, jump, "images/jump/jump29.png");
            makeAnimationLonger(2, jump, "images/jump/jump30.png");
            makeAnimationLonger(2, jump, "images/jump/jump31.png");
            makeAnimationLonger(2, jump, "images/jump/jump32.png");
            makeAnimationLonger(2, jump, "images/jump/jump33.png");
        }
        return jump;
    }

    public static ArrayList<String> jumpL(boolean isLong) {
        name = "jumpL";
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
        if (isLong) {
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
        }
        makeAnimationLonger(2, jump, "images/jumpL/jump23L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump24L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump25L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump26L.png");
        makeAnimationLonger(2, jump, "images/jumpL/jump27L.png");
        if(!isLong){
            makeAnimationLonger(2, jump, "images/jumpL/jump28L.png");
            makeAnimationLonger(2, jump, "images/jumpL/jump29L.png");
            makeAnimationLonger(2, jump, "images/jumpL/jump30L.png");
            makeAnimationLonger(2, jump, "images/jumpL/jump31L.png");
            makeAnimationLonger(2, jump, "images/jumpL/jump32L.png");
            makeAnimationLonger(2, jump, "images/jumpL/jump33L.png");
        }
        return jump;
    }

    public static ArrayList<String> jumpStayL() {
        name = "jumpStayL";
        ArrayList<String> jump = new ArrayList<>();
        makeAnimationLonger(2, jump, "images/jumpL/jump27L.png");
        return jump;
    }

    public static ArrayList<String> jumpStayR() {
        name = "jumpStayR";
        ArrayList<String> jump = new ArrayList<>();
        makeAnimationLonger(2, jump, "images/jump/jump27.png");
        return jump;
    }


    public static ArrayList<String> ctrlStayR() {
        name = "ctrlStayR";
        ArrayList<String> ctrlMove = new ArrayList<>();
        ctrlMove.add("images/crouchR/crouch5.png");
        return ctrlMove;
    }

    public static ArrayList<String> ctrlStayL() {
        name = "ctrlStayL";
        ArrayList<String> ctrlMove = new ArrayList<>();
        ctrlMove.add("images/crouchL/crouch5.png");
        return ctrlMove;
    }

    public static ArrayList<String> ctrlR() {
        name = "ctrlR";
        ArrayList<String> ctrlR = new ArrayList<>();
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch1.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch2.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch3.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch4.png");
        makeAnimationLonger(3, ctrlR, "images/crouchR/crouch5.png");
        return ctrlR;
    }

    public static ArrayList<String> ctrlL() {
        name = "ctrlL";
        ArrayList<String> ctrlL = new ArrayList<>();
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch1.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch2.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch3.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch4.png");
        makeAnimationLonger(3, ctrlL, "images/crouchL/crouch5.png");
        return ctrlL;
    }

    public static ArrayList<String> moveCtrlR() {
        name = "moveCtrlR";
        ArrayList<String> moveCtrlR1 = new ArrayList<>();
        makeAnimationLonger(12, moveCtrlR1, "images/moveCrouchR/moveCrouch1.1.png");
        makeAnimationLonger(12, moveCtrlR1, "images/moveCrouchR/moveCrouch1.2.png");
        makeAnimationLonger(15, moveCtrlR1, "images/crouchR/crouch5.png");
        makeAnimationLonger(12, moveCtrlR1, "images/moveCrouchR/moveCrouch2.1.png");
        makeAnimationLonger(12, moveCtrlR1, "images/moveCrouchR/moveCrouch2.2.png");
        makeAnimationLonger(15, moveCtrlR1, "images/crouchR/crouch5.png");
        return moveCtrlR1;
    }

    public static ArrayList<String> turnRight() {
        name = "turnRight";
        ArrayList<String> turnRight = new ArrayList<>();
        makeAnimationLonger(7, turnRight, "images/turn/turn1.png");
        makeAnimationLonger(7, turnRight, "images/turn/turn2.png");
        makeAnimationLonger(7, turnRight, "images/turn/turn3.png");
        return turnRight;
    }

    public static ArrayList<String> turnLeft() {
        name = "turnLeft";
        ArrayList<String> turnLeft = new ArrayList<>();
        makeAnimationLonger(7, turnLeft, "images/turn/turn3.png");
        makeAnimationLonger(7, turnLeft, "images/turn/turn2.png");
        makeAnimationLonger(7, turnLeft, "images/turn/turn1.png");
        return turnLeft;
    }

    public static ArrayList<String> moveR() {
        name = "moveR";
        ArrayList<String> moveR = new ArrayList<>();
        makeAnimationLonger(4, moveR, "images/moveR2/move7.png");
        makeAnimationLonger(10, moveR, "images/moveR2/move1.png");
        makeAnimationLonger(4, moveR, "images/moveR2/move3.png");
        makeAnimationLonger(4, moveR, "images/moveR2/move4.png");
        makeAnimationLonger(4, moveR, "images/moveR2/move5.png");
        makeAnimationLonger(4, moveR, "images/moveR2/move6.png");

        return moveR;
    }

    public static ArrayList<String> moveL() {
        name = "moveL";
        ArrayList<String> moveL = new ArrayList<>();
        makeAnimationLonger(4, moveL, "images/moveL2/move7.png");
        makeAnimationLonger(10, moveL, "images/moveL2/move1.png");
        makeAnimationLonger(4, moveL, "images/moveL2/move3.png");
        makeAnimationLonger(4, moveL, "images/moveL2/move4.png");
        makeAnimationLonger(4, moveL, "images/moveL2/move5.png");
        makeAnimationLonger(4, moveL, "images/moveL2/move6.png");
        return moveL;
    }

    public static ArrayList<String> stairsL() {
        name = "stairsL";
        ArrayList<String> stairs = new ArrayList<>();
        makeAnimationLonger(4, stairs, "images/stairs/stairs2.png");
        makeAnimationLonger(4, stairs, "images/stairs/stairs3.png");
        makeAnimationLonger(4, stairs, "images/stairs/stairs4.png");
        makeAnimationLonger(4, stairs, "images/stairs/stairs5.png");
        makeAnimationLonger(4, stairs, "images/stairs/stairs6.png");
        return stairs;
    }

    public static ArrayList<String> stayStairs() {
        name = "stayStairs";
        ArrayList<String> stairs = new ArrayList<>();
        makeAnimationLonger(4, stairs, "images/stairs/stairs2.png");
        return stairs;
    }

    public static ArrayList<String> stairsR() {
        name = "stairsR";
        ArrayList<String> stairs = new ArrayList<>();
        makeAnimationLonger(10, stairs, "images/stairs/stairs2.png");
        makeAnimationLonger(10, stairs, "images/stairs/stairs3.png");
        makeAnimationLonger(10, stairs, "images/stairs/stairs4.png");
        makeAnimationLonger(10, stairs, "images/stairs/stairs5.png");
        makeAnimationLonger(10, stairs, "images/stairs/stairs6.png");
        return stairs;
    }

    public static ArrayList<String> moveCtrlL() {
        name = "moveCtrlL";
        ArrayList<String> moveCtrlL1 = new ArrayList<>();
        makeAnimationLonger(12, moveCtrlL1, "images/moveCrouchL/moveCrouch1.1.png");
        makeAnimationLonger(12, moveCtrlL1, "images/moveCrouchL/moveCrouch1.2.png");
        makeAnimationLonger(15, moveCtrlL1, "images/crouchL/crouch5.png");
        makeAnimationLonger(12, moveCtrlL1, "images/moveCrouchL/moveCrouch2.1.png");
        makeAnimationLonger(12, moveCtrlL1, "images/moveCrouchL/moveCrouch2.2.png");
        makeAnimationLonger(15, moveCtrlL1, "images/crouchL/crouch5.png");
        return moveCtrlL1;
    }

    public static ArrayList<String> notCtrlR() {
        name = "moveCtrlR";
        ArrayList<String> notCtrlR = new ArrayList<>();
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch5.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch4.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch3.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch2.png");
        makeAnimationLonger(3, notCtrlR, "images/crouchR/crouch1.png");
        return notCtrlR;
    }

    public static ArrayList<String> notCtrlL() {
        name = "notCtrlL";
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

    public static String getName() {
        return name;
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
