import java.awt.*;

abstract public interface Tetromino {
    public int[][] getTetro_grid();
    abstract public void rotateLeft();
    abstract public void rotateRight();

    abstract Color getColor();
}

