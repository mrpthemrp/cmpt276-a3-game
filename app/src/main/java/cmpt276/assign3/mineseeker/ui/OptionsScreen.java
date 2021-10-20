package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cmpt276.assign3.mineseeker.R;
import cmpt276.assign3.mineseeker.model.Options;

public class OptionsScreen extends AppCompatActivity {
    private Options options;
    private int rows, cols, numCartons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);

        setupDelGameDataBtn();
        setupRadioGroupSize();
        setupRadioGroupCartons();

        setupOptions();
    }

    //SETUP THINGS
    private void setupRadioGroupCartons() {
        RadioGroup cartons = findViewById(R.id.options_CartonGroup);

        cartons.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedCarton = radioGroup.getCheckedRadioButtonId();
            //6
            if(selectedCarton == findViewById(R.id.cartons_6).getId()){
                this.numCartons = 6;
            }
            else if(selectedCarton == findViewById(R.id.cartons_10).getId()){
                this.numCartons = 10;
            }
            else if(selectedCarton == findViewById(R.id.cartons_15).getId()){
                this.numCartons = 15;
            }
            else if(selectedCarton == findViewById(R.id.cartons_20).getId()){
                this.numCartons = 20;
            }
        });
    }

    private void setupRadioGroupSize() {
        RadioGroup boardSize = findViewById(R.id.options_SizeGroup);

        boardSize.setOnCheckedChangeListener((radioGroup, i) -> {
            int selectedSize = radioGroup.getCheckedRadioButtonId();
            //6
            if(selectedSize == findViewById(R.id.size_4x6).getId()){
                this.rows = 4;
                this.cols = 6;
            }
            else if(selectedSize == findViewById(R.id.size_5x10).getId()){
                this.rows = 5;
                this.cols = 10;
            }
            else if(selectedSize == findViewById(R.id.size_6x15).getId()){
                this.rows = 6;
                this.cols = 15;
            }
        });
    }

    private void setupDelGameDataBtn() {
        Button delGameBtn = findViewById(R.id.options_EraseTimesPlayed);
        delGameBtn.setOnClickListener(view -> {
            //del game data
            Toast.makeText(OptionsScreen.this,"Deleted Game Data!", Toast.LENGTH_SHORT).show();
        });
    }

    private void setupOptions() {
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, OptionsScreen.class);
    }

}