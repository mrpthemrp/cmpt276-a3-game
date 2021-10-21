package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

import cmpt276.assign3.mineseeker.R;

public class WelcomeScreen extends AppCompatActivity {
    private Timer timer = new Timer();
    private TimerTask task;
    private ImageView carton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        setupTimerTask();
        setupImageAnimation();
        setUpSkipWelcomeBtn();
        timer.schedule(this.task, 10000 );
        //delay goes by milliseconds, 10000 = 10 seconds
    }

    private void setupImageAnimation() {
        this.carton = findViewById(R.id.welcome_milkCarton);
        this.carton.animate().setDuration(10000);
        WelcomeScreen.this.carton.animate().rotationBy(360);
        this.carton.animate().start();
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
        timer.cancel();
        this.carton.animate().cancel();
        finish();
    }
}