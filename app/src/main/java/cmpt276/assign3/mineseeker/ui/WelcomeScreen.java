package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cmpt276.assign3.mineseeker.R;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        setUpSkipWelcomeBtn();
    }

    private void setUpSkipWelcomeBtn() {
        Button skipWelcome = findViewById(R.id.welcome_SkipToMain);
        skipWelcome.setOnClickListener(view -> {

        });
    }


}