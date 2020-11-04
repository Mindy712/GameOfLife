package touro.GameOfLife;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Grid {
    private Direction[] directions = Direction.values();

    //TODO: find a reasonable height and width
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;

    private final List<Cell> allCells = new ArrayList<>();
    private final HashSet<Cell> liveCells = new HashSet<>();

    public Grid() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                allCells.add(new Cell(x,y));
            }
        }
    }

    public List<Cell> getAllCells() {
        return allCells;
    }

    //TODO: will the view need this as a list?
    public HashSet<Cell> getLiveCells() {
        return liveCells;
    }

    public void advance() {
        HashSet<Cell> newLiveCells = new HashSet<>();

        for (Cell cell : allCells) {
            int liveNeighbors = 0;

            for (Direction direction : directions) {
                Cell neighbor = new Cell(cell.moveTo(direction));

                if (liveCells.contains(neighbor)) {
                    liveNeighbors++;

                    if (liveNeighbors == 3) {
                        newLiveCells.add(cell);
                        break;
                    }
                }

            }
        }

        liveCells.clear();
        liveCells.addAll(newLiveCells);
    }
}
