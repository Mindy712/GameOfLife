package touro.GameOfLife;

public class GameOfLifeMain {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridview = new GridView(grid);
        GameOfLifeFrame frame = new GameOfLifeFrame(grid, gridview);
        frame.setVisible(true);
    }
}
