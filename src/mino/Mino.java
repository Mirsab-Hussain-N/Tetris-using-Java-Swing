package mino;
import java.awt.Color;
import java.awt.Graphics2D;

import TETRIS.KeyHandler;
import TETRIS.PlayManager;
public class Mino {         //SUPER CLASS FOR ALL OTHER MINOS
    public Block b[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;
    public int direction = 1; //THERE ARE 4 DIRECTIONS (1/2/3/4)
    boolean leftCollision, bottomCollision;
    boolean rightCollision = false;


    public void create(Color c){
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);

        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }

    public void setXY(int x, int y){

    }
    public void updateXY(int direction){
        this.direction = direction;
        b[0].x = tempB[0].x;
        b[0].y = tempB[0].y;
        b[1].x = tempB[1].x;
        b[1].y = tempB[1].y;
        b[2].x = tempB[2].x;
        b[2].y = tempB[2].y;
        b[3].x = tempB[3].x;
        b[3].y = tempB[3].y;
    }
    public void getDirection1(){}
    public void getDirection2(){}
    public void getDirection3(){}
    public void getDirection4(){}

    public void checkMovementCollision(){
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        //check frame collision
        //left wall
        for(int i = 0; i < b.length; i++){
            if(b[i].x == PlayManager.left_x){
                leftCollision = true;
            }
        }
        //right wall
        for(int i = 0; i < b.length; i++){
            if(b[i].x + Block.SIZE == PlayManager.right_x){
                rightCollision = true;
            }
        }
        //bottom floor
        for(int i = 0; i < b.length; i++){
            if(b[i].y + Block.SIZE == PlayManager.bottom_y){
                bottomCollision = true;
            }
        }


    }
    public void checkRotationCollision(){

    }

    public void update(){
        //MOVE THE MINOS

        //SOFTDROP
        if(KeyHandler.softDrop){
            for (int i = 0; i < 4; i++) {
                b[i].y += Block.SIZE;
            }
            autoDropCounter = 0;
            KeyHandler.softDrop = false;
        }

        if(KeyHandler.hardDrop){
            while(true){
                for (int i = 0; i < 4; i++) {
                    b[i].y += Block.SIZE;
                }
                // Break after some fake depth (temporary until collision check)
                // Replace this with a real "collidesBelow()" check later.
                if (b[0].y > 600) break;  // temporary
            }
            KeyHandler.hardDrop = false;
        }

        if (KeyHandler.rotateCW) {
            switch (direction) {
                case 1: getDirection2(); break;
                case 2: getDirection3(); break;
                case 3: getDirection4(); break;
                case 4: getDirection1(); break;
            }
            KeyHandler.rotateCW = false;
        }
        checkMovementCollision();

        // COUNTER-CLOCKWISE ROTATION
        if (KeyHandler.rotateCCW) {
            switch (direction) {
                case 1: getDirection4(); break;
                case 4: getDirection3(); break;
                case 3: getDirection2(); break;
                case 2: getDirection1(); break;
            }
            KeyHandler.rotateCCW = false;
        }

        // 180-DEGREE ROTATION
        if (KeyHandler.rotate180) {
            switch (direction) {
                case 1: getDirection3(); break;
                case 2: getDirection4(); break;
                case 3: getDirection1(); break;
                case 4: getDirection2(); break;
            }
            KeyHandler.rotate180 = false;
        }
        if(KeyHandler.leftPressed){
            if(leftCollision == false){
                b[0].x -= Block.SIZE;
                b[1].x -= Block.SIZE;
                b[2].x -= Block.SIZE;
                b[3].x -= Block.SIZE;
            }
            KeyHandler.leftPressed = false;
            
        }
        if(KeyHandler.rightPressed){
            if(rightCollision == false){
                b[0].x += Block.SIZE;
                b[1].x += Block.SIZE;
                b[2].x += Block.SIZE;
                b[3].x += Block.SIZE;
            }
            KeyHandler.rightPressed = false;
        }


        autoDropCounter++;  //increases every frame
        if(autoDropCounter == PlayManager.dropInterval){
            //mino goes down
            b[0].y += Block.SIZE;
            b[1].y += Block.SIZE;
            b[2].y += Block.SIZE;
            b[3].y += Block.SIZE;
            autoDropCounter = 0;
        }
    }
    public void draw(Graphics2D g2){

        // g2.setColor(b[0].c);
        // g2.fillRect(b[0].x, b[0].y,Block.SIZE , Block.SIZE);
        // g2.fillRect(b[1].x, b[1].y,Block.SIZE , Block.SIZE);
        // g2.fillRect(b[2].x, b[2].y,Block.SIZE , Block.SIZE);
        // g2.fillRect(b[3].x, b[3].y,Block.SIZE , Block.SIZE);



        int margin = 1;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x + margin, b[0].y + margin,Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[1].x + margin, b[1].y + margin,Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[2].x + margin, b[2].y + margin,Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[3].x + margin, b[3].y + margin,Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
    }
}
