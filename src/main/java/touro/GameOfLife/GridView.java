package touro.GameOfLife;

import javax.swing.*;
import java.awt.*;

public class GridView extends JComponent {

    private final Grid grid;
    public static final int GRID_SIZE = 100;
    public static final int CELL_SIZE = 10;
    private final int rows = 30;
    private final int cols = 30;

    public GridView(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
    }

    void paintGrid(Graphics g) {
        g.setColor(Color.BLACK);

        for (int i = 0; i < rows; i++) {
            g.drawLine(0, i * CELL_SIZE, GRID_SIZE, i * CELL_SIZE);
        }

        for (int i = 0; i < cols; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, GRID_SIZE);
        }

        g.setColor(Color.YELLOW);

        for (Cell cell : grid.getLiveCells()) {
            g.fillRect(cell.getX() * CELL_SIZE, cell.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }
}
