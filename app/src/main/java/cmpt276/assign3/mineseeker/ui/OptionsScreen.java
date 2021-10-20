package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import cmpt276.assign3.mineseeker.R;
import cmpt276.assign3.mineseeker.model.Options;

public class OptionsScreen extends AppCompatActivity {
    private Options options = Options.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);

        setupDelGameDataBtn();
        setupRadioGroupSize();
        setupRadioGroupCartons();
    }

    //SETUP THINGS
    private void setupRadioGroupCartons() {

    }

    private void setupRadioGroupSize() {
        
    }

    private void setupDelGameDataBtn() {
        Button delGameBtn = findViewById(R.id.options_EraseTimesPlayed);
        delGameBtn.setOnClickListener(view -> {
            //del game data
            Toast.makeText(OptionsScreen.this,"Deleted Game Data!", Toast.LENGTH_SHORT).show();
        });
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, OptionsScreen.class);
    }

}