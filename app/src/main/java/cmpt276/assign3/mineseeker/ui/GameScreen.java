package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import cmpt276.assign3.mineseeker.R;
import cmpt276.assign3.mineseeker.model.Game;
import cmpt276.assign3.mineseeker.model.GridObject;
import cmpt276.assign3.mineseeker.model.Options;

public class GameScreen extends AppCompatActivity {
    private Options options = Options.getInstance();
    private int scans, numCartons, foundCartons, rows,cols;
    private TextView numScans,numCartonsFound;
    private Game game;
    private GridObject[][] modelGrid;
    private Button[][] buttonGrid;
    private ArrayList<GridObject> milkCartonsInGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        game = new Game();
        setupValues();
        setupGrids();
        populateButtons();
        lockCellSize();
    }

    //SET UP METHODS
    private void setupGrids() {
        this.modelGrid = game.getGrid();
        this.buttonGrid = new Button[this.rows][this.cols];
        this.milkCartonsInGrid = new ArrayList<>(6);
    }

    private void setupValues() {
        this.scans = 0;
        this.foundCartons = 0;
        this.numCartons = options.getNumOfCartons();
        this.rows = options.getRows();
        this.cols = options.getCols();
        this.numScans = findViewById(R.id.game_NumScans);
        this.numCartonsFound = findViewById(R.id.game_FoundCartons);

        this.numScans.setText(getString(R.string.game_NumberOfScans,this.scans));
        this.numCartonsFound.setText(getString(R.string.game_FoundMilkCartons,this.foundCartons,this.numCartons));
    }

    private void populateButtons() {
        TableLayout grid = findViewById(R.id.game_GridContainer);
        for(int r =0; r < this.rows; r++){
            TableRow newRow = new TableRow(this);
            newRow.setLayoutParams(new TableRow.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            grid.addView(newRow);

            for(int c =0; c < this.cols; c++){
                //add cells that are milk cartons to array
                if(modelGrid[r][c].isMilkCarton()){
                    milkCartonsInGrid.add(modelGrid[r][c]);
                }

                //create buttons
                final int FINAL_ROW = r ;
                final int FINAL_COL = c ;
                Button btn = new Button(this);
//                btn.setLayoutParams(new TableRow.LayoutParams(
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        1.0f
//                ));
                btn.setPadding(0,0,0,0);
                btn.setOnClickListener(view -> cellSelected(FINAL_ROW, FINAL_COL));
                buttonGrid[r][c]= btn;
                newRow.addView(btn);
            }
        }
        System.out.println("Number of table rows: "+grid.getChildCount());
    }

    //GAME LOGIC
    private void checkForNearbyCartons(int row, int col){
        GridObject selected = modelGrid[row][col];
        int nearbyCartons=0;
        for(int r= 0 ; r< this.rows; r++){
            for (int c = 0; c < this.cols; c++) {
                if(r ==row) {
                    GridObject rowObject = modelGrid[row][c];
                    if(rowObject.isMilkCarton() ){
                        nearbyCartons++;
                    }
                }
                if(c ==col) {
                    GridObject colObject = modelGrid[r][col];
                    if(colObject.isMilkCarton()&&(colObject != selected)){
                        nearbyCartons++;
                    }
                }
            }
        }

        selected.setNumOfNearbyCartons(nearbyCartons);
    }

    private void updateCellSelectedText(int row, int col){
        Button selected = buttonGrid[row][col];
        GridObject cell = modelGrid[row][col];

        String numOfNearbyCartons = Integer.toString(cell.getNumOfNearbyCartons());
        selected.setText(numOfNearbyCartons);
        selected.setTextColor(getResources().getColor(R.color.black, getTheme()));
        selected.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    private void updateGameScreenText(boolean foundCarton){
        if(foundCarton){
            numCartonsFound.setText(getString(R.string.game_FoundMilkCartons, this.foundCartons, this.numCartons));

        }
        else {
            numScans.setText(getString(R.string.game_NumberOfScans, this.scans));
        }

    }
    private void updateAssociatedCellNumbers(int row, int col) {
        Button selected = buttonGrid[row][col];

        for(int r = 0; r< this.rows; r++){
            for(int c =0; c< this.cols; c++){
                    if(r ==row) {
                        GridObject rowObject = modelGrid[row][c];
                        if(rowObject.isTextVisible()){
                            int newNearby = rowObject.getNumOfNearbyCartons();
                            newNearby--;
                            if(newNearby<0){
                                newNearby=0;
                            }
                            buttonGrid[row][c].setText(newNearby);
                        }
                    }
                    if(c ==col) {
                        GridObject colObject = modelGrid[r][col];
                        if(colObject.isTextVisible()){
                            int newNearby = colObject.getNumOfNearbyCartons();
                            newNearby--;
                            if(newNearby<0){
                                newNearby=0;
                            }
                            buttonGrid[r][col].setText(newNearby);
                        }
                    }
            }
        }
    }

    private boolean gameWon(){
        return foundCartons == numCartons;
    }

    //ON CELL TAP
    private void showMilkCarton (Button btn) {
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.peach_milk);
        int width = btn.getWidth();
        int height = btn.getHeight();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, width, height, true);
        btn.setBackground(new BitmapDrawable(getResources(),scaledBitmap));
    }

    private void cellSelected(int row, int cols) {
        Button selected = buttonGrid[row][cols];
        GridObject cell = modelGrid[row][cols];
        checkForNearbyCartons(row, cols);

        if (!gameWon()) {
            if (cell.isMilkCarton() && !cell.isFound()) {
                showMilkCarton(selected);
                this.foundCartons++;
                cell.setFound(true);
                updateGameScreenText(true);
                updateAssociatedCellNumbers(row, cols);
            } else {
                this.scans++;
                updateGameScreenText(false);
            }
        }

        updateCellSelectedText(row, cols);
        lockCellSize();

        if (gameWon()) {
            getDialogMessage();
        }
    }

    private void getDialogMessage() {
        FragmentManager manager = getSupportFragmentManager();
        WinnerMessage winMessage = new WinnerMessage();
        winMessage.show(manager,"Winner Message Dialog");

    }

    private void lockCellSize() {
        for(int r =0; r< this.rows; r++){
            for(int c =0; c< this.cols;c++){
                Button btn = buttonGrid[r][c];

                int width = btn.getWidth();
                int height = btn.getHeight();

                btn.setMinWidth(width);
                btn.setMaxWidth(width);

                btn.setMinHeight(height);
                btn.setMaxHeight(height);
            }
        }
    }


    public static Intent makeIntent(Context context){
        return new Intent(context, GameScreen.class);
    }

}