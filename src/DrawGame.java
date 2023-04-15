import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;

public class DrawGame extends JComponent {
    private final int width;
    private final int height;
    private final int BLOCK_SIZE = 64; // Pixels per side of individual blocks in the grid
    private final GameGrid gameGrid;
    private final Timer timer;

    public DrawGame(GameGrid gameGrid) {
        width = (GameGrid.getGridWidth() * BLOCK_SIZE) + GameGrid.getGridWidth();
        height = (GameGrid.getGridHeight() * BLOCK_SIZE) + GameGrid.getGridHeight() + 16;
        this.gameGrid = gameGrid;

        timer = new Timer(1200, taskPerformer);
        timer.start();
    }

    @Override
    public int getHeight() { return height; }

    @Override
    public int getWidth() { return width; }

    public void displayGrid(Graphics2D g2d, GameGrid gameGrid) {
        GameGrid.GridBlock[][] gridMatrix = gameGrid.getGridMatrix();
        for (int i = 0; i < GameGrid.getGridHeight(); i++) {
            for (int j = 0; j < GameGrid.getGridWidth(); j++) {
                GameGrid.GridBlock gridBlock = gridMatrix[i][j];
                //if (!gridBlock.isVisible() || !gridBlock.isFalling()) continue;
                displayBlock(g2d, gridBlock);
            }
        }
    }

    private void displayFallingBlocks(Graphics2D g2d, GameGrid gameGrid) {
        // TODO: Later on, we can optimize this by simply calling from a map
        for (int i = 0; i < GameGrid.getGridHeight(); i++) {
            for (int j = 0; j < GameGrid.getGridWidth(); j++) {

            }
        }
    }

    public void displayBlock(Graphics2D g2d, GameGrid.GridBlock gridBlock) {
        Rectangle2D.Double block = new Rectangle2D.Double(
                gridBlock.getGrid_row_pos() * BLOCK_SIZE,
                gridBlock.getGrid_col_pos() * BLOCK_SIZE,
                BLOCK_SIZE-1,
                BLOCK_SIZE-1
        );
        g2d.setColor(gridBlock.getColor());
        g2d.fill(block);
    }
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            System.out.println("Hello!");
        }
    };
    /**
     * This gets called implicitly, java takes care of the rest
     * The graphics object gets passed in automatically as well, we don't have to make that
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // enhanced version of the graphics object. not necessary, but nice features
        displayGrid(g2d, gameGrid);
        displayFallingBlocks(g2d, gameGrid);
    }

}
