package touro.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOfLifeFrame extends JFrame {
    public GameOfLifeFrame(Grid grid,
                           GridView gridView,
                           MouseClickEventListener mouseClick)
        throws HeadlessException {
        super();

        setSize(grid.WIDTH, grid.HEIGHT + 10);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BorderLayout());

        add(gridView, BorderLayout.CENTER);

        JButton advance = new JButton("Advance");
        add(advance, BorderLayout.SOUTH);
        advance.addActionListener(actionEvent -> {
            mouseClick.advancePressed(grid);
        });

        mouseClick.changeClicked(grid);
    }
}
