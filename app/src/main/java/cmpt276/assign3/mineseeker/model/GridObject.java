package cmpt276.assign3.mineseeker.model;
/*Class Comment:
* This class creates a GridObject object which
* will be called by the ?? class.
*
*
* TO UPDATE!!!
* */
public class GridObject {
    private boolean isMilkCarton,found;
    private int numOfNearbyCartons, rowNumber, columnNumber ;

    public GridObject(int row, int col, boolean isMilkCarton){
        this.rowNumber = row;
        this.columnNumber = col;
        this.isMilkCarton = isMilkCarton;
        this.found = false;
    }

    //SETTERS
    public void setNumOfNearbyCartons(int numOfNearbyCartons) {
        this.numOfNearbyCartons = numOfNearbyCartons;
    }

    //only called on milkCarton is true
    public void setFound(boolean isFound){
        this.found = isFound;
    }

    //GETTERS
    public boolean isMilkCarton() {
        return isMilkCarton;
    }

    public boolean isFound() {
        return this.found;
    }

    public int getNumOfNearbyCartons() {
        return numOfNearbyCartons;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
