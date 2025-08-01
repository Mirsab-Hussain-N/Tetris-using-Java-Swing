package mino;

import java.awt.Color;

public class Mino_Z1 extends Mino {
    public Mino_Z1() {
        create(Color.red);
    }

    public void setXY(int x, int y) {
        /*   o         ← b[1]
         * o o         ← b[0] b[2]
         * o           ← b[3]
         */
        b[0].x = x;
        b[0].y = y;

        b[1].x = x;
        b[1].y = y - Block.SIZE;

        b[2].x = x - Block.SIZE;
        b[2].y = y;

        b[3].x = x - Block.SIZE;
        b[3].y = y + Block.SIZE;
    }

    public void getDirection1() {
        // Vertical Z
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;

        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;

        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        updateXY(1);
    }

    public void getDirection2() {
        // Horizontal Z:
        // o o         ← b[2] b[0]
        //   o o       ←     b[3] b[1]
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y + Block.SIZE;

        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;

        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Block.SIZE;

        updateXY(2);
    }

    public void getDirection3() {
        getDirection1();
    }

    public void getDirection4() {
        getDirection2();
    }
}
