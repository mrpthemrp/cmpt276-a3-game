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
    public static final String APP_PREF = "AppPreferences";
    private int rows, cols, numCartons;
    private static Options instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);

        if (instance == null) {
            instance = new Options(getResources().getInteger(R.integer.default_row),
                    getResources().getInteger(R.integer.default_col),
                    getResources().getInteger(R.integer.default_cartonNumber));
        }

        setupRadioGroupSize();
        setupRadioGroupCartons();
        setupValues();
    }

    @Override
    public void onBackPressed() {
        OptionsScreen.setupValues(OptionsScreen.instance);
        super.onBackPressed();
    }

    private void setupRadioGroupCartons() {
        RadioGroup cartons = findViewById(R.id.options_CartonGroup);

        int[] cartonOptions = getResources().getIntArray(R.array.milkCartonOptions);

        //create buttons
        for (final int carton : cartonOptions) {
            RadioButton button = new RadioButton(this);
            button.setTextColor(getResources().getColor(R.color.white, getTheme()));
            button.setText(getString(R.string.carton, carton));

            button.setOnClickListener(view -> {
                this.numCartons = carton;
                saveCartonNumber(this.numCartons);
            });

            //add to view
            cartons.addView(button);

            //set default
            if (carton == getCartonNumberSelected(this)) {
                button.setChecked(true);
            }
        }
    }

    private void setupRadioGroupSize() {
        RadioGroup boardSize = findViewById(R.id.options_SizeGroup);

        int[] rowOptions = getResources().getIntArray(R.array.sizeRowOptions);
        int[] colOptions = getResources().getIntArray(R.array.sizeColOptions);

        //create buttons
        for (int i = 0; i < rowOptions.length; i++) {
            final int row = rowOptions[i];
            final int col = colOptions[i];

            RadioButton button = new RadioButton(this);
            button.setTextColor(getResources().getColor(R.color.white, getTheme()));
            button.setText(getString(R.string.size_rxc, row, col));

            button.setOnClickListener(view -> {
                this.rows = row;
                this.cols = col;
                saveBoardSize(this.rows, this.cols);
            });

            //add to view
            boardSize.addView(button);

            //set default
            if (row == getRowSize(this) && col == getColSize(this)) {
                button.setChecked(true);
            }
        }
    }

    private void saveCartonNumber(int carton) {
        SharedPreferences prefs = this.getSharedPreferences(APP_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(CARTON_NUMBER_SELECTED, carton);
        editor.apply();
    }

    private void saveBoardSize(int row, int col) {
        SharedPreferences prefs = this.getSharedPreferences(APP_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(ROW_SIZE_SELECTED, row);
        editor.putInt(COL_SIZE_SELECTED, col);
        editor.apply();

    }

    static public int getCartonNumberSelected(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREF, MODE_PRIVATE);
        return prefs.getInt(CARTON_NUMBER_SELECTED, context.getResources().getInteger(R.integer.default_cartonNumber));
    }

    static public int getRowSize(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREF, MODE_PRIVATE);
        return prefs.getInt(ROW_SIZE_SELECTED, context.getResources().getInteger(R.integer.default_row));
    }

    static public int getColSize(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREF, MODE_PRIVATE);
        return prefs.getInt(COL_SIZE_SELECTED, context.getResources().getInteger(R.integer.default_col));
    }

    private void setupValues() {
        this.numCartons = getCartonNumberSelected(this);
        this.rows = getRowSize(this);
        this.cols = getColSize(this);

        instance.setRows(this.rows);
        instance.setCols(this.cols);
        instance.setNumOfCartons(this.numCartons);
    }

    public static void setupValues(Options options) {
        instance = options;
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, OptionsScreen.class);
    }
}