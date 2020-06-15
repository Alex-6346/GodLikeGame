package Entities;

import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;

import Physics.Animation;
import Physics.Collision;
import MainPack.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Player {

    private boolean right = false, left = false, jumping = false, falling = false, upLadder = false, downLadder = false, halfCut = false, ctrlReleased = false;
    private boolean beingOnLadder = false;
    private boolean topCollision = false;
    public static boolean isLvl3 = false;
    public static boolean isLvl3Cellar = false;
    private boolean actionE = false;
    private int currentE;


    private double x, y;
    private int width, height;
    private int counterOfCtrl = 0;

    private double moveSpeed = 1.7;

    //ArrayList<String> player;
    public int anim=0;
    public String ad;

    //private Image player;
    private Animation player;
    private double jumpSpeed = 20;
    private double currentJumpSpeed = jumpSpeed;

    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;

    private double movingOnLadder = 2;

    public Player(Animation player, int width, int height, int x, int y) {
        this.player = player;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void tickBlock(Block[] b) {

        int iX = (int) x;
        int iY = (int) y;
        int iMaxFallSpeed = (int) maxFallSpeed;

        if (isLvl3) {
            if (iY <= 470 && iY >= 410) {
                isLvl3Cellar = true;
            } else {
                isLvl3Cellar = false;
            }

        }

        for (int i = 0; i < b.length; i++) {
            //collision while moving right
            if (Collision.playerBlock(new Point(iX - 1 + width, iY), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1 + width, iY + height / 4), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1 + width, iY + height / 2), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1 + width, iY + 3 * height / 4), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1 + width, iY + height - 3), b[i])) {
                right = false;
            }

            //collision while moving left
            if (Collision.playerBlock(new Point(iX + 1, iY), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1, iY + height / 4), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1, iY + height / 2), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1, iY + 3 * height / 4), b[i]) ||
                    Collision.playerBlock(new Point(iX - 1, iY + height - 3), b[i])) {

                left = false;
            }

            if (!isLvl3 || isLvl3Cellar) {
                //collision while jumping

                if (Collision.playerBlock(new Point(iX, iY), b[i]) ||
                        Collision.playerBlock(new Point(iX + width, iY), b[i])) {
                    jumping = false;
                    //if (!beingOnLadder) {
                    falling = true;
                    // }
                }
            }


            //collision while falling

            if (Collision.playerBlock(new Point(iX, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + width / 2, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + width, iY + height + iMaxFallSpeed), b[i])) {

                if (!upLadder) {
                    y = b[i].getY()- 200;//player.getHeight(null);
                }
                falling = false;
                topCollision = true;
            } else {
                if (!beingOnLadder && !topCollision) {
                    falling = true;
                }
            }
        }
        topCollision = false;

        if (right) {
            if ((x + moveSpeed + 450) < Main.frame.getWidth()) {
                x = x + moveSpeed;
            }
        }

        if (left) {
            if ((x - moveSpeed) > 0) {
                x = x - moveSpeed;
            }
        }

        if (halfCut == true) {
            if (counterOfCtrl == 2) {
                y = y + height / 2;
                counterOfCtrl++;
            }
            moveSpeed = 1;
            //player=new Animation();
            //player = new ImageIcon("images/personHalfCut.jpg").getImage();
            height = 200;
        }
        if (halfCut == false) {
            if (counterOfCtrl == 0) {
                y = y - height;
                counterOfCtrl++;
            }
            moveSpeed = 1.7;
            //player=new Animation();
            //player = new ImageIcon("images/person.jpg").getImage();
            height = 200;
        }

        if (jumping) {
            y = y - currentJumpSpeed;
            currentJumpSpeed = currentJumpSpeed - 1;
            if (currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;

            }
        }


        if (falling) {
            y = y + currentFallSpeed;
            if (currentFallSpeed < maxFallSpeed) {
                currentFallSpeed = currentFallSpeed + 0.1;
            }
        }

        Main.frame.revalidate();
        Main.frame.repaint();
    }


    public void tickLadder(Ladder[] l) {
        int iX = (int) x;
        int iY = (int) y;
        beingOnLadder = false;
        for (int i = 0; i < l.length; i++) {
            if ((Collision.playerLadder(new Point(iX, iY), l[i]) &&
                    Collision.playerLadder(new Point(iX + width, iY), l[i])) ||

                    (Collision.playerLadder(new Point(iX, iX + height / 2), l[i]) &&
                            Collision.playerLadder(new Point(iX + width, iY + height / 2), l[i])) ||

                    (Collision.playerLadder(new Point(iX, iY + height - 2), l[i]) &&
                            Collision.playerLadder(new Point(iX + width, iY + height - 2), l[i]))) {
                falling = false;
                beingOnLadder = true;
            } else {
                if (!beingOnLadder) {
                    falling = true;
                }
            }
        }

        if (upLadder) {
            y = y - movingOnLadder;
        }

        if (downLadder) {
            y = y + movingOnLadder;
        }

    }

    public void tickEObjects(EObjects[] e) {
        if (actionE && e[currentE].getReadyForActivation()) {
            e[currentE].setChangedImage();
            e[currentE].setActivated(true);
            if ((currentE + 1) < e.length) {
                e[currentE + 1].setReadyForActivation(true);
            }
        }
    }


    public void draw(Graphics g) {
        //g.drawImage(player, (int) x, (int) y, null);

        player.animDraw(g, (int) x, (int) y);
    }

    public void uodate(){
        player.update();
    }

    public void keyPressed(int key, Block[] b, Ladder[] l, EObjects[] e) {
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
            upLadder = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
            upLadder = false;
        }
        if (key == KeyEvent.VK_CONTROL) {
            if (counterOfCtrl == 1) {
                halfCut = true;
                counterOfCtrl++;
            } else {
                int iX = (int) x;
                int iY = (int) y;
                boolean trueCtrl = true;
                for (int i = 0; i < b.length; i++) {
                    if (Collision.playerBlock(new Point(iX + 1, iY - height), b[i]) ||
                            Collision.playerBlock(new Point(iX + width / 2, iY - height), b[i]) ||
                            Collision.playerBlock(new Point(iX + width, iY - height), b[i])) {
                        trueCtrl = false;
                    }
                }
                if (trueCtrl) {
                    halfCut = false;
                    counterOfCtrl = 0;
                }
            }
        }
        if (key == KeyEvent.VK_E) {
            for (int i = 0; i < e.length; i++) {
                int iX = (int) x;
                int iY = (int) y;
                if (Collision.playerEObject(new Point(iX, iY), e[i]) ||
                        Collision.playerEObject(new Point(iX + width / 2, iY), e[i]) ||
                        Collision.playerEObject(new Point(iX + width, iY), e[i]) ||
                        Collision.playerEObject(new Point(iX, iY + height - 2), e[i]) ||
                        Collision.playerEObject(new Point(iX + width / 2, iY + height - 2), e[i]) ||
                        Collision.playerEObject(new Point(iX + width, iY + height - 2), e[i]) ||
                        Collision.playerEObject(new Point(iX, iY + height / 2), e[i]) ||
                        Collision.playerEObject(new Point(iX + width / 2, iY + height / 2), e[i]) ||
                        Collision.playerEObject(new Point(iX + width, iY + height / 2), e[i])) {
                    actionE = true;
                    currentE = i;
                }
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (falling == false) {
                for (int i = 0; i < l.length; i++) {
                    int iX = (int) x;
                    int iY = (int) y;
                    if ((Collision.playerLadder(new Point(iX, iY), l[i]) &&
                            Collision.playerLadder(new Point(iX + width, iY), l[i])) ||
                            (Collision.playerLadder(new Point(iX, iY + height - 2), l[i]) &&
                                    Collision.playerLadder(new Point(iX + width, iY + height - 2), l[i]))) {
                        upLadder = true;
                        beingOnLadder = true;
                    } else {
                        if (!beingOnLadder) {
                            upLadder = false;
                        }
                    }
                }

                if (!upLadder) {
                    for (int i = 0; i < b.length; i++) {
                        int iX = (int) x;
                        int iY = (int) y;
                        if ((Collision.playerBlock(new Point(iX, iY + height + 7), b[i]) ||
                                Collision.playerBlock(new Point(iX + width / 2, iY + height + 7), b[i]) ||
                                Collision.playerBlock(new Point(iX + width, iY + height + 7), b[i])) && !halfCut) {
                            jumping = true;
                        }
                    }

                    for (int i = 0; i < l.length; i++) {
                        int iX = (int) x;
                        int iY = (int) y;
                        if ((Collision.playerLadder(new Point(iX, iY), l[i]) &&
                                Collision.playerLadder(new Point(iX + width, iY), l[i])) ||
                                (Collision.playerLadder(new Point(iX, iY + height / 2), l[i]) &&
                                        Collision.playerLadder(new Point(iX + width, iY + height / 2), l[i])) ||
                                (Collision.playerLadder(new Point(iX, iY + height), l[i]) &&
                                        Collision.playerLadder(new Point(iX + width, iY + height), l[i]))) {
                            jumping = false;
                        }
                    }
                }
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            for (int i = 0; i < l.length; i++) {
                int iX = (int) x;
                int iY = (int) y;
                if (Collision.playerLadder(new Point(iX, iY), l[i]) ||
                        Collision.playerLadder(new Point(iX + width, iY), l[i]) ||
                        Collision.playerLadder(new Point(iX, iY + height), l[i]) ||
                        Collision.playerLadder(new Point(iX + width, iY + height), l[i]) && !halfCut) {
                    downLadder = true;
                    beingOnLadder = true;
                } else {
                    if (!beingOnLadder) {
                        falling = true;
                    }
                }
            }
        }
    }

    public void keyReleased(int key) {
        if (key == KeyEvent.VK_RIGHT) right = false;
        if (key == KeyEvent.VK_LEFT) left = false;
        if (key == KeyEvent.VK_UP) upLadder = false;
        if (key == KeyEvent.VK_DOWN) downLadder = false;
    }
}
