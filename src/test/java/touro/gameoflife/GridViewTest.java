package touro.gameoflife;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.awt.*;

import static touro.gameoflife.GridView.GRID_SIZE;
import static touro.gameoflife.GridView.CELL_SIZE;
import static touro.gameoflife.GridView.rows;
import static touro.gameoflife.GridView.cols;

public class GridViewTest {

    @Test
    public void drawGrid() {
        //given
        Grid grid = mock(Grid.class);
        GridView view = new GridView(grid);

        Graphics g = mock(Graphics.class);

        //when
        view.drawGrid(g);

        //then
        for (int i = 0; i < rows; i++) {
            verify(g).drawLine(0, i * CELL_SIZE, GRID_SIZE, i * CELL_SIZE);
        }

        for (int i = 0; i < cols; i++) {
            verify(g).drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, GRID_SIZE);
        }
    }

    @Test
    public void paintLiveCells() {
        //given
        Grid grid = new Grid();
        GridView view = new GridView(grid);

        Graphics g = mock(Graphics.class);

        Cell cell1 = new Cell(10, 20);
        Cell cell2 = new Cell(20, 30);
        Cell cell3 = new Cell(15, 18);

        grid.addCellToLiveCells(cell1);
        grid.addCellToLiveCells(cell2);
        grid.addCellToLiveCells(cell3);

        //when
        view.paintLiveCells(g);

        //then
        verify(g).fillRect(10 * CELL_SIZE, 20 * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        verify(g).fillRect(20 * CELL_SIZE, 30 * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        verify(g).fillRect(15 * CELL_SIZE, 18 * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}
