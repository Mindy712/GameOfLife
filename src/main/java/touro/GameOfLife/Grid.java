package touro.GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    public static final int HEIGHT = 40;
    public static final int WIDTH = 100;

    private final List<Cell> cells = new ArrayList<>();

    public List<Cell> getCells() {
        return cells;
    }
}
