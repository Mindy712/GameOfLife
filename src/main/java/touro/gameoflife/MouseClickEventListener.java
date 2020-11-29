package touro.gameoflife;

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
   }

   private static boolean playing = false;
   public static void play(Grid grid, GridView view) {
        if (playing == false) {
            playing = true;
        }
        else {
            playing = false;
        }

       Thread thread = new Thread() {
           @Override
           public void run() {
               super.run();
               while(playing) {
                   grid.advance();
                   view.repaint();
                   try {
                       Thread.sleep(120);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       };
       thread.start();
   }
}
