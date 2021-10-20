package cmpt276.assign3.mineseeker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

import cmpt276.assign3.mineseeker.R;

public class HelpScreen extends AppCompatActivity {
    private TextView hyperlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        setupHyperlink();

    }

    private void setupHyperlink() {
        hyperlink = findViewById(R.id.help_Hyperlink);
        hyperlink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, HelpScreen.class);
    }
}