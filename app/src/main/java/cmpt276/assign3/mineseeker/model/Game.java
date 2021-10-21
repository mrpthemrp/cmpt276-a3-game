package cmpt276.assign3.mineseeker.model;
/*
*This class creates a Game object that holds and sets up
* a 2D array of GridObjects, it determines which cells
* are holding a milk carton.
*
* This class does not handle game won, or cell selected.
* */


import java.util.Random;

public class Game {
    private int rows, cols, numOfScans, numOfCartons, cartonAddedToGridCounter;
    private GridObject[][] grid;
    private static Options options = Options.getInstance();

    public Game() {
        this.rows = options.getRows();
        this.cols = options.getCols();
        this.numOfCartons = options.getNumOfCartons();

        this.numOfScans = 0;
        this.cartonAddedToGridCounter = 0;
        grid = new GridObject[rows][cols];
        populateGrid();
    }

    private void populateGrid() {
        for(int r =0; r< this.rows; r++){
            for(int c = 0;c<this.cols;c++){
                boolean isCarton = setCartonBool();
                GridObject newCell = new GridObject(r,c,isCarton);
                grid[r][c]= newCell;
            }
        }
    }

    private boolean setCartonBool (){
        if(this.cartonAddedToGridCounter==this.numOfCartons){
            return false;
        }
        Random random = new Random();
        boolean isCarton= random.nextInt(5) < 2;
        if(isCarton){
            this.cartonAddedToGridCounter++;
        }
        return isCarton;
    }

    //SETTERS
    public void setNumOfScans(int numOfScans) {
        this.numOfScans = numOfScans;
    }

    public void setNumOfCartonsLeft(int numOfCartons) {
        this.numOfCartons = numOfCartons;
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

    public int getNumOfCartons() {
        return numOfCartons;
    }

    public GridObject[][] getGrid() {
        return grid;
    }
}
