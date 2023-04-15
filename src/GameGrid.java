import java.awt.*;

public class GameGrid {
    static final int GRID_HEIGHT = 20;
    static final int GRID_WIDTH = 10;
    public static class GridBlock {
        private Color color;
        private boolean visible;
        private boolean falling;
        private boolean placed;
        private final int grid_col_pos; // Relative to top left of screen
        private final int grid_row_pos; // Relative to top left of screen

        public GridBlock(int grid_col_pos, int grid_row_pos, Color color) {
            visible = false;
            this.color = color;
            this.grid_col_pos = grid_col_pos;
            this.grid_row_pos = grid_row_pos;
        }

        public int getGrid_col_pos() {
            return grid_col_pos;
        }

        public int getGrid_row_pos() {
            return grid_row_pos;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public boolean isVisible() {
            return visible;
        }

        public boolean isFalling() {
            return falling;
        }

        public boolean isPlaced() {
            return placed;
        }

        public void notVisible() {
            visible = false;
        }
    }
    public static GridBlock[][] gridMatrix = new GridBlock[GRID_HEIGHT][GRID_WIDTH];
    public static Tetromino current;

    public GameGrid() {
        // Initializes the gridBlocks
        for (int i = 0; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                gridMatrix[i][j] = new GridBlock(i, j, Color.DARK_GRAY);
            }
        }
    }
    public GridBlock[][] getGridMatrix() {
        return gridMatrix;
    }
    public static int getGridHeight() {
        return GRID_HEIGHT;
    }
    public static int getGridWidth() {
        return GRID_WIDTH;
    }
    public static void spawnTetromino() {
//        int roll = (int)(Math.random() * 7);
//        switch(roll) {
//
//        }
        Tetromino tetromino = new Tetro_Straight();
        for (int i = 0; i < tetromino.getTetro_grid().length; i++) {
            for (int j = 0; j < tetromino.getTetro_grid()[0].length; j++) {
                int curr = tetromino.getTetro_grid()[i][j];
                if (curr == 0) continue;
                GridBlock currBlock = gridMatrix[0+i][3+j];

                currBlock.visible = true;
                currBlock.falling = true;
                currBlock.setColor(tetromino.getColor());
            }
        }
    }
}
