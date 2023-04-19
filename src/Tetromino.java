import java.awt.*;

public interface Tetromino {
    GridBlock[][] getTetroGrid();
    int[][] getBinaryTetroGrid();
    void rotateLeft();
    void rotateRight();

    int getCurrentDistanceFallen();
    int getOffset();
    void setOffset(boolean left);

    void gradualFall();

    Color getColor();

    /**
     * Initializes a 2D-Matrix of GridBlocks based on the specifications defined in a binary grid of similar nature.
     * @param binaryTetroGrid The shape scheme that this GridBlock matrix will be based off of
     * @param color The color of the GridBlocks generated
     * @return A new 2D-Matrix of GridBlocks that coincides with the shape of the input binary matrix
     */
    static GridBlock[][] initializeTetroGrid(int[][] binaryTetroGrid, Color color) {
        int R = binaryTetroGrid.length;
        int C = binaryTetroGrid[0].length;
        GridBlock[][] ret = new GridBlock[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (binaryTetroGrid[i][j] != 0) ret[i][j] = new GridBlock(i, j+(GameGrid.GRID_WIDTH-C)/2, color);
            }
        }
        return ret;
    }
}

