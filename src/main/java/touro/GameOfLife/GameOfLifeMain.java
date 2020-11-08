package touro.GameOfLife;

import java.awt.event.MouseEvent;

public class GameOfLifeMain {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridview = new GridView(grid);
        MouseEvent event = null;
        MouseClickEventListener mouseClick = new MouseClickEventListener(event);

        GameOfLifeFrame frame = new GameOfLifeFrame(grid, gridview, mouseClick);

        frame.setVisible(true);
    }
}
