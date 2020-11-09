package touro.GameOfLife;

import org.junit.Test;

import java.awt.event.MouseEvent;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MouseClickEventListenerTest {

    Grid grid = mock(Grid.class);

    @Test
    public void changeClickedAddCell() {
        //given
        MouseEvent e = mock(MouseEvent.class);
        MouseClickEventListener mouseClick = new MouseClickEventListener();

        doReturn(24).when(e).getX();
        doReturn(36).when(e).getY();

        //expect x / 10 and y / 10 because CellSize is 10
        Cell expected = new Cell(2,3);

        //when
        mouseClick.changeClicked(grid, e);

        //then
        verify(grid).getLiveCells();
        verify(grid).addCellToLiveCells(expected);
    }

    @Test
    public void changeClickedRemoveCell() {
        //given
        MouseEvent e = mock(MouseEvent.class);
        MouseClickEventListener mouseClick = new MouseClickEventListener();

        HashSet cells = new HashSet();
        Cell expected = new Cell(5,19);
        cells.add(expected);

        doReturn(cells).when(grid).getLiveCells();

        doReturn(56).when(e).getX();
        doReturn(192).when(e).getY();

        //when
        mouseClick.changeClicked(grid, e);

        //then
        verify(grid).getLiveCells();
        verify(grid).removeCellFromLiveCells(expected);
    }

    @Test
    public void advancePressed() {
        //given
        MouseClickEventListener mouseClick = new MouseClickEventListener();

        //when
        mouseClick.advancePressed(grid);

        //then
        verify(grid).advance();

    }
}