package Entities;

import Objects.Block;
import Physics.Collision;
import MainPack.Main;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Player {

    private boolean right = false, left = false, jumping = false, falling = false;
    private double x,y;
    private int width,height;

    private double moveSpeed = 1;

    private double jumpSpeed = 40;
    private double currentJumpSpeed = jumpSpeed;

    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;


    public Player(int width, int height) {
        x = Main.frame.getWidth()/2;
        y = Main.frame.getHeight()/2;
        this.width = width;
        this.height = height;
    }

    public void tick(Block[]b) {
        int iX = (int)x;
        int iY = (int)y;

        for(int i=0; i<b.length; i++){
            //collision while moving right
            if(Collision.playerBlock(new Point(iX+width,iY), b[i]) ||
                    Collision.playerBlock(new Point(iX+width,iY+height-3), b[i])) {
                right = false;
            }

            //collision while moving left

            if(Collision.playerBlock(new Point(iX,iY), b[i]) ||
                    Collision.playerBlock(new Point(iX,iY+height-3), b[i])) {
                left = false;
            }

            //collision while jumping

            if(Collision.playerBlock(new Point(iX,iY), b[i]) ||
                    Collision.playerBlock(new Point(iX+width,iY), b[i])) {
                jumping = false;
                falling = true;
            }


            //collision while falling

            if(Collision.playerBlock(new Point(iX,iY+height+1), b[i]) ||
                    Collision.playerBlock(new Point(iX+width,iY+height+1), b[i])) {
                falling = false;
                break;
            } else {
                falling = true;
            }
        }


        if(right){

            x = x + moveSpeed;
        }

        if(left){
            x = x - moveSpeed;
        }

        if(jumping){
            y = y-currentJumpSpeed;
            currentJumpSpeed=currentJumpSpeed-1;
            if(currentJumpSpeed<=0){
                currentJumpSpeed=jumpSpeed;
                jumping = false;
                falling = true;
            }
        }

        if(falling) {
            y = y + currentFallSpeed;

            if (currentFallSpeed < maxFallSpeed) {
                currentFallSpeed = currentFallSpeed + 0.1;
            }
        }
        Main.frame.revalidate();
        Main.frame.repaint();
    }



    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x,(int)y,width,height);
    }

    public void keyPressed(int key) {
        if(key == KeyEvent.VK_RIGHT) right = true;
        if(key == KeyEvent.VK_LEFT) left = true;
        if(key == KeyEvent.VK_UP) jumping = true;
    }

    public void keyReleased(int key) {
        if(key == KeyEvent.VK_RIGHT) right = false;
        if(key == KeyEvent.VK_LEFT) left = false;
    }


}
