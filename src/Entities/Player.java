package Entities;

import GameStates.GameStateManager;
import GameStates.PauseState;
import Objects.Block;
import Objects.EObjects;
import Objects.Ladder;

import Physics.Animation;
import Physics.Collision;
import MainPack.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


public class Player {

    private boolean right = false, left = false, jumping = false, falling = false, upLadder = false, downLadder = false, halfCut = false, ctrlReleased = false;
    private boolean beingOnLadder = false;
    private boolean first = true;
    private boolean turnRight = true;
    private boolean topCollision = false;
    public static boolean isLvl3 = false;
    public static boolean isLvl2=false;
    public static boolean isLvl1 = false;
    public static boolean isLvl3Cellar = false;
    private boolean actionE = false;
    private int currentE;

    public boolean isFallen = false;

    private double x, y;
    private int width, height;
    private int counterOfCtrl = 0;

    private double moveSpeed = 1.7;

    //ArrayList<String> player;
    public int anim = 0;
    public String ad;

    //private Image player;
    private Animation player;
    private double jumpSpeed = 22;
    private double currentJumpSpeed = jumpSpeed;

    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;

    private double movingOnLadder = 2;
    private GameStateManager gameStateManager;
    private Timer timerCtrlDown;
    private Timer timerCtrlUp;

    private Timer timerJump;

    public Player(Animation player, int width, int height, int x, int y, GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
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


        if (y > Main.frame.getHeight()) {
            isFallen = true;
        }

        if (isLvl3) {
            if (iY <= 470 && iY >= 410) {
                isLvl3Cellar = true;
            } else {
                isLvl3Cellar = false;
            }


        }

        for (int i = 0; i < b.length; i++) {

            //collision while moving right
            if ((!halfCut && (Collision.playerBlock(new Point(iX + 2 + width, iY), b[i]) ||
                    (!isLvl1 && Collision.playerBlock(new Point(iX + 2 + width, iY + height / 4), b[i])))) ||
                    Collision.playerBlock(new Point(iX + 2 + width, iY + height / 2), b[i]) ||
                    (!isLvl1 && Collision.playerBlock(new Point(iX + 2 + width, iY + 3 * height / 4), b[i])) ||
                    Collision.playerBlock(new Point(iX + 2 + width, iY + height - 3), b[i])) {
                right = false;
            }

            //collision while moving left
            if ((!halfCut && (Collision.playerBlock(new Point(iX - 2, iY), b[i]) ||
                    (!isLvl1 && Collision.playerBlock(new Point(iX - 2, iY + height / 4), b[i])))) ||
                    Collision.playerBlock(new Point(iX - 2, iY + height / 2), b[i]) ||
                    (!isLvl1 && Collision.playerBlock(new Point(iX - 2, iY + 3 * height / 4), b[i])) ||
                    Collision.playerBlock(new Point(iX - 2, iY + height - 3), b[i])) {
                left = false;
            }

            if ((!isLvl3 || isLvl3Cellar) && !isLvl1) {
                //collision while jumping
                if (Collision.playerBlock(new Point(iX, iY), b[i]) ||
                        Collision.playerBlock(new Point(iX + width, iY), b[i])) {
                    jumping = false;
                }
            }

            if (!halfCut && !jumping &&(Collision.playerBlock(new Point(iX, iY + height + 50), b[i]) ||
                    Collision.playerBlock(new Point(iX + width / 2, iY + height + 50), b[i]) ||
                    Collision.playerBlock(new Point(iX + width, iY + height + 50), b[i]))) {
                if (turnRight) {
                    player.setTypeAnimation(Animation.landingR());
                } else player.setTypeAnimation(Animation.landingL());
                TimerTask task2 = new TimerTask() {
                    @Override
                    public void run() {
                        if (turnRight) {
                            player.setTypeAnimation(Animation.stayR());
                        } else {
                            player.setTypeAnimation(Animation.stayL());
                        }
                    }
                };
                long delay = 200;
                timerCtrlUp = new Timer();
                timerCtrlUp.schedule(task2, delay);


            }

            //collision while falling
            if (Collision.playerBlock(new Point(iX, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 2 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 3 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 4 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + width / 2, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 6 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 7 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 8 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + 9 * width / 10, iY + height + iMaxFallSpeed), b[i]) ||
                    Collision.playerBlock(new Point(iX + width, iY + height + iMaxFallSpeed), b[i])) {
                if (!upLadder) {
                    y = b[i].getY() - height;
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
            if ((x + moveSpeed) < Main.frame.getWidth()) {
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
                if (turnRight) {
                    player.setTypeAnimation(Animation.ctrlR());
                } else {
                    player.setTypeAnimation(Animation.ctrlL());
                }
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        if (turnRight) {
                            player.setTypeAnimation(Animation.ctrlStayR());
                        } else {
                            player.setTypeAnimation(Animation.ctrlStayL());
                        }
                    }
                };
                long delay = 200;
                timerCtrlDown = new Timer();
                timerCtrlDown.schedule(task, delay);
                moveSpeed = 1;
                counterOfCtrl++;
            }

        } else {
            if (counterOfCtrl == 0) {
                if (!jumping) {
                    if (turnRight) {
                        player.setTypeAnimation(Animation.notCtrlR());
                    } else {
                        player.setTypeAnimation(Animation.notCtrlL());
                    }
                    TimerTask task2 = new TimerTask() {
                        @Override
                        public void run() {
                            if (turnRight) {
                                player.setTypeAnimation(Animation.stayR());
                            } else {
                                player.setTypeAnimation(Animation.stayL());
                            }
                        }
                    };
                    long delay = 200;
                    timerCtrlUp = new Timer();
                    timerCtrlUp.schedule(task2, delay);
                }
                counterOfCtrl++;
            }
            moveSpeed = 1.7;
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
        player.animDraw(g, (int) x, (int) y);
    }

    public void update() {
        player.update();
    }

    public void keyTyped(int key, Block[] b, Ladder[] l, EObjects[] e) {

    }

    public void keyPressed(int key, Block[] b, Ladder[] l, EObjects[] e) {
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
            upLadder = false;
            if (!turnRight) {
                if (halfCut) {
                    player.setTypeAnimation(Animation.ctrlStayR());
                } else if (jumping) {
                    player.setTypeAnimation(Animation.jumpR());
                } else {
                    player.setTypeAnimation(Animation.turnRight());
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            player.setTypeAnimation(Animation.moveR());
                        }
                    };
                    long delay = 100;
                    timerCtrlUp = new Timer();
                    timerCtrlUp.schedule(task, delay);
                }
                turnRight = true;
            } else {
                if (halfCut) {
                    if (first && !jumping) {
                        player.setTypeAnimation(Animation.moveCtrlR());
                        first = false;
                    }
                } else {
                    if (first && !jumping) {
                        player.setTypeAnimation(Animation.moveR());
                        first = false;
                    }
                }
            }
            turnRight = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
            upLadder = false;
            if (turnRight) {
                if (halfCut) {
                    player.setTypeAnimation(Animation.ctrlStayL());
                } else if (jumping) {
                    player.setTypeAnimation(Animation.jumpL());
                } else {
                    player.setTypeAnimation(Animation.turnLeft());
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            player.setTypeAnimation(Animation.moveL());
                        }
                    };
                    long delay = 100;
                    timerCtrlUp = new Timer();
                    timerCtrlUp.schedule(task, delay);
                }
            } else {
                if (halfCut) {
                    if (first && !jumping) {
                        player.setTypeAnimation(Animation.moveCtrlL());
                        first = false;
                    }
                } else {
                    if (first && !jumping) {
                        player.setTypeAnimation(Animation.moveL());
                        first = false;
                    }
                }
            }
            turnRight = false;
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
                    if (Collision.playerBlock(new Point(iX + 1, iY), b[i]) ||
                            Collision.playerBlock(new Point(iX + width / 2, iY), b[i]) ||
                            Collision.playerBlock(new Point(iX + width, iY), b[i])) {
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
                        if (first) {
                            if (turnRight) {
                                player.setTypeAnimation(Animation.stairsR());
                            } else player.setTypeAnimation(Animation.stairsL());
                            first = false;
                        }
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
                            TimerTask task = new TimerTask() {
                                @Override
                                public void run() {
                                    if (turnRight) {
                                        player.setTypeAnimation(Animation.stayR());
                                    } else {
                                        player.setTypeAnimation(Animation.stayL());
                                    }
                                }
                            };
                            long delay = 850;
                            timerJump = new Timer();
                            timerJump.schedule(task, delay);
                            if (turnRight) {
                                player.setTypeAnimation(Animation.jumpR());
                            } else {
                                player.setTypeAnimation(Animation.jumpL());
                            }

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

        if (key == KeyEvent.VK_ESCAPE) {
            PauseState pauseState = new PauseState(gameStateManager);
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
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
            if (halfCut) {
                player.setTypeAnimation(Animation.ctrlStayR());
                first = true;
            } else if (!jumping) {
                player.setTypeAnimation(Animation.stayR());
                first = true;
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
            if (halfCut) {
                player.setTypeAnimation(Animation.ctrlStayL());
                first = true;
            } else if (!jumping) {
                player.setTypeAnimation(Animation.stayL());
                first = true;
            }
        }
        if (key == KeyEvent.VK_UP) {
            if (upLadder) {
                player.setTypeAnimation(Animation.stayStairs());
                first = true;
            }
            upLadder = false;
        }
        if (key == KeyEvent.VK_DOWN) downLadder = false;
    }
}
