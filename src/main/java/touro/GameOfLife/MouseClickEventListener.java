package touro.GameOfLife;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class MouseClickEventListener {
    private MouseEvent e;

    public MouseClickEventListener(MouseEvent e) {
       this.e = e;
   }

   /*TODO: Would need to have methods to access the liveCells Hashset.
        This will obviously not work, just wanted to get the idea down. */
   public void changeClicked(Grid grid) {

       try {
           int x = e.getX();
           int y = e.getY();

           Cell currCell = new Cell(x, y);
           HashSet<Cell> liveCells = grid.getLiveCells();

           if (liveCells.contains(currCell)) {
               liveCells.remove(currCell);
           }
           else {
               liveCells.add(currCell);
           }
       }
       catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void advancePressed(Grid grid) {
       try {
           grid.advance();
       } catch (IOException e) {
           e.printStackTrace();
       }
   };
}
