package touro.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOfLifeFrame extends JFrame {
    public GameOfLifeFrame(Grid grid,
                           GridView gridview,
                           MouseClickEventListener mouseClick)
        throws HeadlessException {
        super();

        setSize(grid.Width, grid.Height + 10);
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
