package cmpt276.assign3.mineseeker.model;
/* This class creates a Game object that
 * holds a 2D array of GridObjects and game data.
 * It gets data from the Options instance.
 * */

import java.util.Random;

public class Game {
    private int rows, cols, numOfCartons, cartonAddedToGridCounter;
    private GridObject[][] grid;
    private static Options options = Options.getInstance();

    public Game() {
        this.rows = options.getRows();
        this.cols = options.getCols();
        this.numOfCartons = options.getNumOfCartons();

        this.cartonAddedToGridCounter = 0;
        grid = new GridObject[rows][cols];
        populateGrid();
    }

    private void populateGrid() {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                boolean isCarton = isCarton();
                GridObject newCell = new GridObject(isCarton);
                grid[r][c] = newCell;
            }
        }
    }

    private boolean isCarton() {
        if (this.cartonAddedToGridCounter == this.numOfCartons) {
            return false;
        }
        Random random = new Random();
        boolean isCarton = random.nextInt(5) < 2;
        if (isCarton) {
            this.cartonAddedToGridCounter++;
        }
        return isCarton;
    }

    public GridObject[][] getGrid() {
        return grid;
    }
}
