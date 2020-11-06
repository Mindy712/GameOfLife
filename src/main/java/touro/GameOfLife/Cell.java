package touro.GameOfLife;

import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(Cell cell) {
        this.x = cell.x;
        this.y = cell.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell moveTo(Direction direction) {
        switch (direction) {
            case North:
                return new Cell(x, y - 1);
            case NorthEast:
                return new Cell(x + 1, y - 1);
            case East:
                return new Cell(x + 1, y);
            case SouthEast:
                return new Cell(x + 1, y + 1);
            case South:
                return new Cell(x, y + 1);
            case SouthWest:
                return new Cell(x - 1, y + 1);
            case West:
                return new Cell(x - 1, y);
            case NorthWest:
                return new Cell(x - 1, y - 1);
            default:
                throw new RuntimeException(direction + " is not a known Direction");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString() {
        return "Cell: x= " + x + ", y= " + y ;
    }
}
