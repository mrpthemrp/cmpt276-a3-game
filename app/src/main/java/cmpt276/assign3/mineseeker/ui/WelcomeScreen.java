package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;

import cmpt276.assign3.mineseeker.R;

public class WelcomeScreen extends AppCompatActivity {
    private Timer timer = new Timer();
    private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        setupTimerTask();
        setUpSkipWelcomeBtn();
        timer.schedule(this.task, 10000 );
        //delay goes by milliseconds, 10000 = 10 seconds
    }

    private void setupTimerTask() {
        this.task = new TimerTask() {
            @Override
            public void run() {
                endActivity();
            }
        };
    }

    private void setUpSkipWelcomeBtn() {
        Button skipWelcome = findViewById(R.id.welcome_SkipToMain);
        skipWelcome.setOnClickListener(view -> endActivity());
    }

    private void endActivity (){
        Intent intent = MainMenu.makeIntent(WelcomeScreen.this);
        startActivity(intent);
        finish();
    }
}