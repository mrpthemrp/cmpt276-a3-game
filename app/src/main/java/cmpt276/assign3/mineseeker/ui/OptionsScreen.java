package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cmpt276.assign3.mineseeker.R;
import cmpt276.assign3.mineseeker.model.Options;

public class OptionsScreen extends AppCompatActivity {
    public static final String CARTON_NUMBER_SELECTED = "Carton number selected";
    public static final String ROW_SIZE_SELECTED = "Row size selected";
    public static final String COL_SIZE_SELECTED = "Col size selected";
    private Options options;
    private int rows, cols, numCartons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);

        setupRadioGroupSize();
        setupRadioGroupCartons();
        setupOptions();
        setupValues();
    }

    private void setupRadioGroupCartons() {
        RadioGroup cartons = findViewById(R.id.options_CartonGroup);

        int[] cartonOptions = getResources().getIntArray(R.array.milkCartonOptions);

        //create buttons
        for (final int carton : cartonOptions) {
            RadioButton button = new RadioButton(this);
            button.setTextColor(getResources().getColor(R.color.white,getTheme()));
            button.setText(getString(R.string.carton, carton));

            button.setOnClickListener(view -> {
                saveCartonNumber(carton);
                this.numCartons = carton;
            });

            //add to view
            cartons.addView(button);

            //set default
            if (carton == getCartonNumberSelected(this)) {
                button.setChecked(true);
            }
        }
    }

    private void saveCartonNumber(int carton) {
        SharedPreferences prefs = this.getSharedPreferences("AppPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(CARTON_NUMBER_SELECTED, carton);
        editor.apply();
        options.resetNumOfCartons(this.numCartons);
    }

    static public int getCartonNumberSelected(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPreferences",MODE_PRIVATE);
        return prefs.getInt(CARTON_NUMBER_SELECTED, context.getResources().getInteger(R.integer.default_cartonNumber));
    }

    private void setupRadioGroupSize() {
        RadioGroup boardSize = findViewById(R.id.options_SizeGroup);

        int[] rowOptions = getResources().getIntArray(R.array.sizeRowOptions);
        int[] colOptions = getResources().getIntArray(R.array.sizeColOptions);

        //create buttons
        for(int i =0; i< rowOptions.length;i++){
            final int row = rowOptions[i];
            final int col = colOptions[i];

            RadioButton button = new RadioButton(this);
            button.setTextColor(getResources().getColor(R.color.white,getTheme()));
            button.setText(getString(R.string.size_rxc, row,col));

            button.setOnClickListener(view -> {
                saveBoardSize(row, col);
                this.rows = row;
                this.cols = col;
            });

            //add to view
            boardSize.addView(button);

            //set default
            if(row == getRowSize(this) && col == getColSize(this)){
                button.setChecked(true);
            }
        }
    }

    private void saveBoardSize(int row, int col) {
        SharedPreferences prefs = this.getSharedPreferences("AppPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(ROW_SIZE_SELECTED, row);
        editor.putInt(COL_SIZE_SELECTED, col);
        editor.apply();

        options.resetRows(this.rows);
        options.resetCols(this.cols);
    }

    static public int getRowSize(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPreferences",MODE_PRIVATE);
        return prefs.getInt(ROW_SIZE_SELECTED, context.getResources().getInteger(R.integer.default_row));
    }

    static public int getColSize(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPreferences",MODE_PRIVATE);
        return prefs.getInt(COL_SIZE_SELECTED, context.getResources().getInteger(R.integer.default_col));
    }

    private void setupValues() {
        this.numCartons = getCartonNumberSelected(this);
        this.rows = getRowSize(this);
        this.cols = getColSize(this);
    }

    private void setupOptions() {
        this.options = new Options(this.rows, this.cols, this.numCartons);
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, OptionsScreen.class);
    }

}