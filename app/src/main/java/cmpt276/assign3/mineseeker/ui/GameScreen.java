package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cmpt276.assign3.mineseeker.R;
import cmpt276.assign3.mineseeker.model.Game;
import cmpt276.assign3.mineseeker.model.Options;

public class GameScreen extends AppCompatActivity {
    private Options options = Options.getInstance();
    private int scans, numCartons, foundCartons;
    private TextView numScans,numCartonsFound;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        game = new Game();
        setupValues();
    }

    private void setupValues() {
        this.scans = 0;
        this.foundCartons = 0;
        this.numCartons = options.getNumOfCartons();
        this.numScans = findViewById(R.id.game_NumScans);
        this.numCartonsFound = findViewById(R.id.game_FoundCartons);

        this.numScans.setText(getString(R.string.game_NumberOfScans,this.scans));
        this.numCartonsFound.setText(getString(R.string.game_FoundMilkCartons,this.foundCartons,this.numCartons));
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, GameScreen.class);
    }

}