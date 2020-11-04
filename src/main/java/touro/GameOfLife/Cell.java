package touro.GameOfLife;

public class Cell {
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //TODO: do I need this?
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

    public boolean equals(Cell cell) {
        //TODO: do we need this at all?
        return x == cell.x && y == cell.y;
    }

    public String toString() {
        return "Cell: x= " + x + ", y= " + y ;
    }
}
