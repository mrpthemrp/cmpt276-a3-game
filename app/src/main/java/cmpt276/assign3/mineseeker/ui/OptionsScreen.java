package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cmpt276.assign3.mineseeker.R;

public class OptionsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, OptionsScreen.class);
    }

}