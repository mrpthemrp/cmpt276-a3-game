package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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

    private void showMilkCarton (Button btn) {
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.peach_milk);
        int width = btn.getWidth();
        int height = btn.getHeight();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, height, height, true);
        btn.setBackground(new BitmapDrawable(getResources(),scaledBitmap));
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
                final int FINAL_ROW = r ;
                final int FINAL_COL = c ;
                Button btn = new Button(this);
                btn.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        0.1f
                ));

                btn.setOnClickListener(view -> cellSelected(FINAL_ROW, FINAL_COL));
                buttonGrid[r][c]= btn;
                newRow.addView(btn);
            }
        }
    }

    private void cellSelected(int row, int cols) {
        if(modelGrid[row][cols].isMilkCarton()){
            showMilkCarton(buttonGrid[row][cols]);
            this.foundCartons++;
            numCartonsFound.setText(getString(R.string.game_FoundMilkCartons,this.foundCartons,this.numCartons));

        }
        else{
            this.scans++;
            numScans.setText(getString(R.string.game_NumberOfScans, this.scans));
        }
        lockCellSize();
    }

    private void lockCellSize() {
        for(int r =0; r< this.rows; r++){
            for(int c =0; c< this.cols;c++){
                Button btn = buttonGrid[r][c];

                int width = btn.getWidth();
                int height = btn.getHeight();

                btn.setMinWidth(width);
                btn.setMaxWidth(width);

                btn.setMinHeight(width);
                btn.setMaxHeight(width);
            }
        }
    }

    private void setupGrids() {
        this.modelGrid = game.getGrid();
        this.buttonGrid = new Button[this.rows][this.cols];
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

    public static Intent makeIntent(Context context){
        return new Intent(context, GameScreen.class);
    }

}