package cmpt276.assign3.mineseeker.model;

public class Options {
    private int rows, cols, numOfCartons;
    private static Options instance;

    public Options(){
        //default values are the lowest number of all listed options in UI
        this.cols = 6;
        this.rows = 4;
        this.numOfCartons = 6;
    }


    //SETTERS - get rid of setters eventually;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setNumOfCartons(int numOfCartons) {
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
            instance = new Options();
        }

        return instance;
    }
}
