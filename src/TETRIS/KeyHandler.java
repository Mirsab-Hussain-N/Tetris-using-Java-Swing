package TETRIS;

import java.awt.event.*;

public class KeyHandler implements KeyListener{

    public static boolean leftPressed, rightPressed;
    public static boolean rotateCW, rotateCCW, rotate180, softDrop, hardDrop;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        int code = e.getKeyCode();  //WHAT BUTTON U PRESSEDDD

        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }

        if(code == KeyEvent.VK_LEFT){
            rotateCCW = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            rotateCW = true;
        }
        if(code == KeyEvent.VK_UP){
            rotate180 = true;
        }
        if(code == KeyEvent.VK_W){
            softDrop = true;
        }
        if(code == KeyEvent.VK_S){
            hardDrop = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
