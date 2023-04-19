import java.awt.event.KeyEvent;

public class Input {
    public Input(GameGrid gameGrid) {

    }
    public static final int UP = 224;
    public static final int DOWN = 225;
    public static final int LEFT = 226;
    public static final int RIGHT = 227;
    public static void moveTetromino(KeyEvent e) {
        switch(e.getKeyCode()) {
            case UP -> { GameGrid.FALL_SPEED /= 2; }
            case DOWN -> { GameGrid.FALL_SPEED *= 4; }
            case LEFT -> { GameGrid.current.setOffset(false); }
            case RIGHT -> { GameGrid.current.setOffset(true); }
        }
    }
}
