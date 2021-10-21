package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
        makeButtonGrid();
    }

    private void setupGrids() {
        this.modelGrid = game.getGrid();
        this.buttonGrid = new Button[this.rows][this.cols];
    }

    private void makeButtonGrid() {
        TableLayout grid = findViewById(R.id.game_Grid);
        for(int r =0; r< this.rows; r++){
            TableRow row = new TableRow(this);
            for(int c =0; c< this.cols; c++){
                Button cell = new Button(this);
                if(modelGrid[r][c].isMilkCarton()){
                    //cell.setVisibility(View.INVISIBLE);
                    cell.setBackground(getResources().getDrawable(R.drawable.peach_milk,getTheme()));
                }
                row.addView(cell);
            }
            grid.addView(row);
        }
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