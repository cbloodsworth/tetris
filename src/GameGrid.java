import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGrid {
    static final int GRID_HEIGHT = 20;
    static final int GRID_WIDTH = 10;
    static int FALL_SPEED = 1000; // In milliseconds
    // Color scheme constants

    public static GridBlock[][] gridMatrix = new GridBlock[GRID_HEIGHT][GRID_WIDTH];
    public static Tetromino current;

    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            gradualFallTetromino();
        }
    };

    public GameGrid() {
        // Initializes the gridBlocks
        for (int i = 0; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                gridMatrix[i][j] = new GridBlock(i, j, DrawGame.BACKGROUND_COLOR);
            }
        }
        Timer timer = new Timer(FALL_SPEED, taskPerformer);
        timer.start();
        spawnTetromino(); // TODO: MOVE THIS LINE LATER
        reloadTetromino(true);
    }
    public GridBlock[][] getGridMatrix() {
        return gridMatrix;
    }
    public static void spawnTetromino() {
//        int roll = (int)(Math.random() * 7);
//        switch(roll) {
//
//        }
        current = new Tetro_L();
    }

    public static void reloadTetromino(boolean display) {
        // Iterate through the tetromino matrix
        int R = current.getTetroGrid().length;
        int C = current.getTetroGrid()[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (current.getBinaryTetroGrid()[i][j] == 0) continue; // Only display relevant blocks
                GridBlock currBlock = gridMatrix
                        [i + current.getCurrentDistanceFallen()]
                        [j + (GRID_WIDTH-C)/2 + current.getOffset()];

                currBlock.setVisible(display);
                currBlock.setFalling(display);
                currBlock.setColor(display?current.getColor():DrawGame.BACKGROUND_COLOR);
            }
        }
    }
    public static void gradualFallTetromino() {
        reloadTetromino(false);
        current.gradualFall();
        reloadTetromino(true);
    }
    public static Tetromino getCurrentTetromino() {
        return current;
    }
}
