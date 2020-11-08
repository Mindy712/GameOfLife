package touro.GameOfLife;

import java.awt.event.MouseEvent;

public class MouseClickEventListener {

   public static void changeClicked(Grid grid, MouseEvent e) {

       try {
           int x = e.getX() / GridView.CELL_SIZE;
           int y = e.getY() / GridView.CELL_SIZE;

           Cell currCell = new Cell(x, y);

           if (grid.getLiveCells().contains(currCell)) {
               grid.removeCellFromLiveCells(currCell);
           }
           else {
               grid.addCellToLiveCells(currCell);
           }
       }
       catch (Exception exception) {
           exception.printStackTrace();
       }
   }

   public static void advancePressed(Grid grid) {
       try {
           grid.advance();
       } catch (Exception exception) {
           exception.printStackTrace();
       }
   };
}
