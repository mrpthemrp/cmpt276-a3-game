package cmpt276.assign3.mineseeker.model;

/*
 * TOP-LEVEL CLASS COMMENT
 *
 * This class creates a singular GridObject.
 * It holds all data in a GridObject.
 * */
public class GridObject {
    private boolean isMilkCarton, found, textVisible;
    private int numOfNearbyCartons;

    public GridObject(boolean isMilkCarton) {
        this.isMilkCarton = isMilkCarton;
        this.found = false;
        this.textVisible = false;
    }

    //SETTERS
    public void setNumOfNearbyCartons(int numOfNearbyCartons) {
        this.numOfNearbyCartons = numOfNearbyCartons;
    }

    public void setTextVisible(boolean textVisible) {
        this.textVisible = textVisible;
    }

    //only called on milkCarton is true
    public void setFound(boolean isFound) {
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

    public boolean isTextVisible() {
        return textVisible;
    }

}
