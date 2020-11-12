package touro.gameoflife;

import java.util.HashMap;
import java.util.HashSet;

public class Grid {
    private Direction[] directions = Direction.values();
    private HashSet<Cell> liveCells = new HashSet<>();

    public HashSet<Cell> getLiveCells() {
        return liveCells;
    }

    /***
     * @param cell
     * @return false if cell is already in liveCells
     */
    public boolean addCellToLiveCells(Cell cell) {
        return liveCells.add(cell);
    }

    /***
     * @param cell
     * @return true if cell was in liveCells
     */
    public boolean removeCellFromLiveCells(Cell cell) {
        return liveCells.remove(cell);
    }

    public void advance() {
        HashMap<Cell, Integer> potentialLiveCells = getPotentialLiveCellsMap();
        HashSet<Cell> newLiveCells = getNewLiveCells(potentialLiveCells);

        //replace current liveCells with the new ones
        liveCells.clear();
        liveCells.addAll(newLiveCells);
    }

    private HashSet<Cell> getNewLiveCells(HashMap<Cell, Integer> potentialLiveCells) {
        //add to newLiveCells cells which pass the conditions needed
        HashSet<Cell> newLiveCells = new HashSet<>();
        for (HashMap.Entry<Cell, Integer> entry : potentialLiveCells.entrySet()) {
            Cell cell = entry.getKey();
            int liveNeighbors = entry.getValue();

            if ((liveNeighbors == 2 && liveCells.contains(cell)) || liveNeighbors == 3) {
                newLiveCells.add(cell);
            }
        }
        return newLiveCells;
    }

    private HashMap<Cell, Integer> getPotentialLiveCellsMap() {
        HashMap<Cell, Integer> potentialLiveCells = new HashMap<>();

        //fill hashmap of cells -> neighbors
        for (Cell cell : liveCells) {
            for (Direction direction : directions) {
                Cell tempCell = cell.moveTo(direction);

                //either create or increment key/value
                int count = potentialLiveCells.getOrDefault(tempCell, 0);
                potentialLiveCells.put(tempCell, count + 1);
            }
        }
        return potentialLiveCells;
    }
}
