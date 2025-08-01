package TETRIS;

import mino.Block;
import java.awt.Color;

public class PlayField {
    public static final int WIDTH = 12;
    public static final int HEIGHT = 20;
    private Block[][] blocks;

    public PlayField() {
        blocks = new Block[HEIGHT][WIDTH];
    }

    public boolean isCollision(int x, int y) {
        if (y >= HEIGHT || x < 0 || x >= WIDTH || y < 0) {
            return true;
        }
        return blocks[y][x] != null;
    }

    public void addBlock(int x, int y, Block block) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            blocks[y][x] = block;
        }
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void removeFullLines() {
        for (int row = HEIGHT - 1; row >= 0; row--) {
            if (isLineFull(row)) {
                removeLine(row);
                shiftLinesDown(row);
                row++; // Check the same row again
            }
        }
    }

    private boolean isLineFull(int row) {
        for (int col = 0; col < WIDTH; col++) {
            if (blocks[row][col] == null) {
                return false;
            }
        }
        return true;
    }

    private void removeLine(int row) {
        for (int col = 0; col < WIDTH; col++) {
            blocks[row][col] = null;
        }
    }

    private void shiftLinesDown(int startRow) {
        for (int row = startRow; row > 0; row--) {
            blocks[row] = blocks[row - 1].clone();
        }
        blocks[0] = new Block[WIDTH];
    }
}
