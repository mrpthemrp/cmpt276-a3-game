package cmpt276.assign3.mineseeker.model;

import android.util.Log;

import cmpt276.assign3.mineseeker.ui.OptionsScreen;

public class Options {
    private int rows, cols, numOfCartons;
    private static Options instance;

    public Options(int row, int col, int numOfCartons){
        this.rows= row;
        this.cols=col;
        this.numOfCartons=numOfCartons;
    }

    //Setters
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

    public static void setupOptions(Options instance){
        Options.instance = instance;
    }
    public static Options getInstance() {
        if(instance == null){
            instance = new Options(4,6,6);
        }
        return instance;
    }
}
