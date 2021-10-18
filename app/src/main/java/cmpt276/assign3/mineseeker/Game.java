package cmpt276.assign3.mineseeker;
/*
*This class is called during the game
* holds a 2D array
*
* NEEDS TO BE UPDATED
* */


import cmpt276.assign3.mineseeker.model.GridObject;
import cmpt276.assign3.mineseeker.model.Options;

public class Game {
    private int rows, cols, numOfScans, numOfMines;
    private GridObject[][] grid;
    private static Options options = Options.getInstance();

    public Game() {
        this.rows = options.getRows();
        this.cols = options.getCols();
        this.numOfMines = options.getNumOfMines();

        this.numOfScans = 0;
        grid = new GridObject[rows][cols];
    }



}
