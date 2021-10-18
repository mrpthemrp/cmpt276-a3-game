package cmpt276.assign3.mineseeker.model;
/*
*This class is called during the game
* holds a 2D array
*
* NEEDS TO BE UPDATED
* */


import cmpt276.assign3.mineseeker.model.GridObject;
import cmpt276.assign3.mineseeker.model.Options;

public class Game {
    private int rows, cols, numOfScans, numOfCartons;
    private GridObject[][] grid;
    private static Options options = Options.getInstance();
    private boolean allCartonsFound;

    public Game() {
        this.rows = options.getRows();
        this.cols = options.getCols();
        this.numOfCartons = options.getNumOfCartons();

        this.numOfScans = 0;
        this.allCartonsFound = false;
        grid = new GridObject[rows][cols];
    }

    //SETTERS
    public void setNumOfScans(int numOfScans) {
        this.numOfScans = numOfScans;
    }

    public void setNumOfCartonsLeft(int numOfCartons) {
        this.numOfCartons = numOfCartons;
    }

    public void setAllCartonsFound(boolean allCartonsFound) {
        this.allCartonsFound = allCartonsFound;
    }

    //GETTERS
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumOfScans() {
        return numOfScans;
    }

    public int getNumOfCartonsLeft() {
        return numOfCartons;
    }

    public GridObject[][] getGrid() {
        return grid;
    }

    public boolean gameWon(){
        return allCartonsFound==true;
    }
}
