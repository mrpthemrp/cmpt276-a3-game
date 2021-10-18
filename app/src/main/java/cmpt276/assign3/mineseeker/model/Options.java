package cmpt276.assign3.mineseeker.model;

public class Options {
    private int rows, cols, numOfMines;
    private static Options instance;

    public Options(){
        //default values are the lowest number of all listed options in UI
        this.cols = 6;
        this.rows = 4;
        this.numOfMines = 6;
    }

    //SETTERS

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setNumOfMines(int numOfMines) {
        this.numOfMines = numOfMines;
    }

    //GETTERS
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumOfMines() {
        return numOfMines;
    }

    public static Options getInstance() {
        if(instance == null){
            instance = new Options();
        }

        return instance;
    }
}
