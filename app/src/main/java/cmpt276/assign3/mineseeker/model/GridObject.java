package cmpt276.assign3.mineseeker.model;
/*Class Comment:
* This class creates a GridObject object which
* will be called by the ?? class.
*
*
* TO UPDATE!!!
* */
public class GridObject {
    private boolean isMilkCarton,selected;
    private int numOfNearbyCartons, rowNumber, columnNumber ;

    public GridObject(int row, int col, boolean isMilkCarton){
        this.rowNumber = row;
        this.columnNumber = col;
        this.isMilkCarton = isMilkCarton;
        this.selected = false;
    }

    //SETTERS
    public void setMilkCarton(boolean milkCarton) {
        this.isMilkCarton = milkCarton;
    }

    public void setNumOfNearbyCartons(int numOfNearbyCartons) {
        this.numOfNearbyCartons = numOfNearbyCartons;
    }

    //GETTERS
    public boolean isMilkCarton() {
        return isMilkCarton;
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
