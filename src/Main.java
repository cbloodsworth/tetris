import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameGrid gameGrid = new GameGrid();
        JFrame window = new JFrame();
        DrawGame draw = new DrawGame(gameGrid);
        window.setSize(draw.getWidth(), draw.getHeight());
        window.setTitle("Tetris");
        window.getContentPane().setBackground(Color.BLACK);
        //window.setLocationRelativeTo(null); // center of screen
        window.add(draw);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        GameGrid.spawnTetromino();
    }
}