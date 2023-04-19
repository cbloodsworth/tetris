import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawGame extends JComponent implements ActionListener{
    private final int width;
    private final int height;
    private final int BLOCK_SIZE = 32; // Pixels per side of individual blocks in the grid
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

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Hello");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("pRessed?");
            Input.moveTetromino(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("pressed.");
        }
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
