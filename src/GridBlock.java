import java.awt.*;

public class GridBlock {
    private Color color;
    private boolean visible;
    private boolean falling;
    private boolean placed;
    private final int GRID_COL_POS; // Relative to top left of screen
    private final int GRID_ROW_POS; // Relative to top left of screen

    public GridBlock(int grid_col_pos, int grid_row_pos, Color color) {
        visible = false;
        this.color = color;
        this.GRID_COL_POS = grid_col_pos;
        this.GRID_ROW_POS = grid_row_pos;
    }

    public int getGrid_col_pos() {
        return GRID_COL_POS;
    }

    public int getGrid_row_pos() {
        return GRID_ROW_POS;
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

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public void notVisible() {
        visible = false;
    }
}
