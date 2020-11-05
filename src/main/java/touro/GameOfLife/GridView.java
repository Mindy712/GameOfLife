package touro.GameOfLife;

import javax.swing.*;
import java.awt.*;

public class GridView extends JComponent {

    private final Grid grid;
    public static final int CELL_SIZE = 10;

    public GridView(Grid grid) {
        this.grid = grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
    }

    void paintGrid(Graphics g) {
        for (Cell cell : grid.getAllCells()) {
            if (grid.getLiveCells().contains(cell)) {
                g.setColor(Color.YELLOW);
                g.fillRect(cell.getX() * CELL_SIZE, cell.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            } else {
                g.setColor(Color.GRAY);
                g.fillRect(cell.getX() * CELL_SIZE, cell.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}
