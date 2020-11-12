package touro.gameoflife;

import javax.swing.*;
import java.awt.*;

public class GridView extends JComponent {

    private final Grid grid;
    public static final int GRID_SIZE = 500;
    public static final int CELL_SIZE = 10;
    public static final int rows = GRID_SIZE/CELL_SIZE;
    public static final int cols = GRID_SIZE/CELL_SIZE;

    public GridView(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBackground(g);
        paintLiveCells(g);
        drawGrid(g);
    }

    private void paintBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i < rows; i++) {
            g.drawLine(0, i * CELL_SIZE, GRID_SIZE, i * CELL_SIZE);
        }

        for (int i = 0; i < cols; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, GRID_SIZE);
        }

    }
        void paintLiveCells(Graphics g) {
        g.setColor(Color.YELLOW);

        for (Cell cell : grid.getLiveCells()) {
            g.fillRect(cell.getX() * CELL_SIZE, cell.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }
}
