package cmpt276.assign3.mineseeker.model;

public class Options {
    private int rows, cols, numOfMines;
    private static Options instance;

    public Options(){
        this.cols = cols;
        this.rows = rows;
        this.numOfMines = numOfMines;
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
