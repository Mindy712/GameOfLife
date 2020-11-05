package touro.GameOfLife;

public class GameOfLifeMain {
    public static void main(String[] args) {
        Grid grid = new Grid();
        GridView gridview = new GridView();
        MouseClickEventListener mouseClick = new MouseClickEventListener();

        GameOfLifeFrame frame = new GameOfLifeFrame(grid, gridview, mouseClick);

        frame.setVisible(true);
    }
}
