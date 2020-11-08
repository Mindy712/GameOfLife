package touro.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOfLifeFrame extends JFrame {
    public GameOfLifeFrame(Grid grid,
                           GridView gridView)
        throws HeadlessException {
        super();

        setSize(515, 563);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        panel.add(gridView, BorderLayout.CENTER);

        JButton advance = new JButton("Advance");
        panel.add(advance, BorderLayout.SOUTH);
        advance.addActionListener(actionEvent -> {
            MouseClickEventListener.advancePressed(grid);
            repaint();
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MouseClickEventListener.changeClicked(grid, e);
                repaint();
            }
        });
    }
}
