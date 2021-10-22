package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import cmpt276.assign3.mineseeker.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGameBtn();
        setupOptionsBtn();
        setupHelpBtn();
    }

    //SET UP BUTTONS
    private void setupHelpBtn() {
        Button helpBtn = findViewById(R.id.mainMenu_HelpBtn);
        helpBtn.setOnClickListener(view -> {
            Intent switchToHelp = HelpScreen.makeIntent(MainMenu.this);
            startActivity(switchToHelp);
        });
    }

    private void setupGameBtn() {
        Button gameBtn = findViewById(R.id.mainMenu_GameBtn);
        gameBtn.setOnClickListener(view -> {
            Intent switchToGame = GameScreen.makeIntent(MainMenu.this);
            startActivity(switchToGame);
        });
    }

    private void setupOptionsBtn() {
        Button optionsBtn = findViewById(R.id.mainMenu_OptionsBtn);
        optionsBtn.setOnClickListener(view -> {
            Intent switchToOptions = OptionsScreen.makeIntent(MainMenu.this);
            startActivity(switchToOptions);
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MainMenu.class);
    }
}