package touro.GameOfLife;

import java.awt.event.MouseEvent;
import java.io.IOException;

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

           if (grid.liveCells.containsKey(currCell)) {
               grid.liveCells.remove(currCell);
           }
           else {
               grid.liveCells.add(currCell);
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
