package touro.gameoflife;

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
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(gridView, BorderLayout.CENTER);

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MouseClickEventListener.changeClicked(grid, e);
                repaint();
            }
        });

        JButton advance = new JButton("Advance");
        buttonPanel.add(advance, BorderLayout.WEST);
        advance.addActionListener(actionEvent -> {
            MouseClickEventListener.advancePressed(grid);
            repaint();
        });

        JButton playPause = new JButton("Play/Pause");
        buttonPanel.add(playPause, BorderLayout.EAST);
        playPause.addActionListener(actionEvent -> {
            MouseClickEventListener.play(grid, gridView);
        });
    }
}
