package cmpt276.assign3.mineseeker.model;

public class Options {
    private int rows, cols, numOfCartons;
    private static Options instance;

    public Options(int rows, int cols, int numOfCartons){
        this.cols = cols;
        this.rows = rows;
        this.numOfCartons = numOfCartons;
    }


    //SETTERS

    public void resetRows(int rows) {
        this.rows = rows;
    }

    public void resetCols(int cols) {
        this.cols = cols;
    }

    public void resetNumOfCartons(int numOfCartons) {
        this.numOfCartons = numOfCartons;
    }

    //GETTERS
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumOfCartons() {
        return numOfCartons;
    }

    public static Options getInstance() {
        if(instance == null){
            //default values  4x6, 6 cartons
            instance = new Options(4,6,6);
        }

        return instance;
    }
}
