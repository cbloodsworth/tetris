import java.awt.*;

public class Tetro_Straight implements Tetromino {
    GridBlock[][] tetro_grid = new GridBlock[4][4];
    int[][] binary_tetro_grid = new int[4][4];

    int currDistFallen;
    int offset;


    public Tetro_Straight() {
        binary_tetro_grid = new int[][] {
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        tetro_grid = Tetromino.initializeTetroGrid(binary_tetro_grid, Color.CYAN);
        currDistFallen = 0;
        offset = 0;
    }

    @Override
    public GridBlock[][] getTetroGrid() {
        return tetro_grid;
    }

    @Override
    public int[][] getBinaryTetroGrid() {
        return binary_tetro_grid;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

    @Override
    public int getCurrentDistanceFallen() {
        return currDistFallen;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public void gradualFall() {
        currDistFallen++;
    }

    public Color getColor() {
        return Color.CYAN;
    }
}
