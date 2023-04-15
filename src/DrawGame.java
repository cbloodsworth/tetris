import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;

public class DrawGame extends JComponent implements ActionListener {
    private final int width;
    private final int height;
    private final int BLOCK_SIZE = 64; // Pixels per side of individual blocks in the grid
    private final GameGrid gameGrid;

    // COLOR CONSTANTS
    static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

    public DrawGame(GameGrid gameGrid) {
        width = (GameGrid.GRID_WIDTH * BLOCK_SIZE) + GameGrid.GRID_WIDTH;
        height = (GameGrid.GRID_HEIGHT * BLOCK_SIZE) + GameGrid.GRID_HEIGHT + 16;
        this.gameGrid = gameGrid;
        Timer timer = new Timer(32, this); // 32ms is close to 30fps
        timer.start();
    }

    @Override
    public int getHeight() { return height; }

    @Override
    public int getWidth() { return width; }

    public void displayGrid(Graphics2D g2d, GameGrid gameGrid) {
        for (int i = 0; i < GameGrid.GRID_HEIGHT; i++) {
            for (int j = 0; j < GameGrid.GRID_WIDTH; j++) {
                displayBlock(g2d, GameGrid.gridMatrix[i][j]);
            }
        }
    }

    private void displayFallingTetromino(Graphics2D g2d, Tetromino tetromino) {
        // TODO: Later on, we can optimize this by simply calling from a map
        for (int i = 0; i < tetromino.getTetroGrid().length; i++) {
            for (int j = 0; j < tetromino.getTetroGrid()[0].length; j++) {
                if (tetromino.getBinaryTetroGrid()[i][j] != 0) displayBlock(g2d, tetromino.getTetroGrid()[i][j]);
            }
        }
    }

    public void displayBlock(Graphics2D g2d, GridBlock gridBlock) {
        if (gridBlock == null) return;
        Rectangle2D.Double block = new Rectangle2D.Double(
                gridBlock.getGrid_row_pos() * BLOCK_SIZE,
                gridBlock.getGrid_col_pos() * BLOCK_SIZE,
                BLOCK_SIZE-1,
                BLOCK_SIZE-1
        );
        g2d.setColor(gridBlock.getColor());
        g2d.fill(block);
    }

    /**
     * This gets called implicitly, java takes care of the rest
     * The graphics object gets passed in automatically as well, we don't have to make that
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // enhanced version of the graphics object. not necessary, but nice features
        displayGrid(g2d, gameGrid);
        Rectangle2D.Double block = new Rectangle2D.Double(
                64,
                64,
                BLOCK_SIZE-1,
                BLOCK_SIZE-1
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
