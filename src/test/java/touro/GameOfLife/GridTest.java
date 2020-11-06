package touro.GameOfLife;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void advance_noNeighbor() {
        //given
        Grid grid = new Grid();
        Cell cell = new Cell(0,1);
        grid.addCellToLiveCells(cell);

        //when
        grid.advance();

        //then
        assertEquals(grid.getLiveCells().size(), 0);
    }

    @Test
    public void advance_oneNeighbor() {
        //given
        Grid grid = new Grid();
        Cell cell1 = new Cell(0,1);
        Cell cell2 = new Cell(0,2);
        grid.addCellToLiveCells(cell1);
        grid.addCellToLiveCells(cell2);

        //when
        grid.advance();

        //then
        assertEquals(grid.getLiveCells().size(), 0);
    }

    @Test
    public void advance_glider() {
        //given
        Grid grid = new Grid();
        grid.addCellToLiveCells(new Cell(1,2));
        grid.addCellToLiveCells(new Cell(2,3));
        grid.addCellToLiveCells(new Cell(3,1));
        grid.addCellToLiveCells(new Cell(3,2));
        grid.addCellToLiveCells(new Cell(3,3));

        HashSet<Cell> nextMoveShouldBe = new HashSet<>();
        nextMoveShouldBe.add(new Cell(2,1));
        nextMoveShouldBe.add(new Cell(2,3));
        nextMoveShouldBe.add(new Cell(3,2));
        nextMoveShouldBe.add(new Cell(3,3));
        nextMoveShouldBe.add(new Cell(4,2));

        //when
        grid.advance();

        //then
        assertEquals(grid.getLiveCells(), nextMoveShouldBe);
    }
}