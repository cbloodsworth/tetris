import java.awt.*;

public class Tetro_Straight implements Tetromino {
    int[][] tetro_grid = new int[4][4];

    public Tetro_Straight() {
        tetro_grid = new int[][] {
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
    }

    @Override
    public int[][] getTetro_grid() {
        return tetro_grid;
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

    public Color getColor() {
        return Color.CYAN;
    }
}
