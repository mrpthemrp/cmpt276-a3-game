package cmpt276.assign3.mineseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cmpt276.assign3.mineseeker.R;
import cmpt276.assign3.mineseeker.ui.WelcomeScreen;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, MainMenu.class);
    }
}