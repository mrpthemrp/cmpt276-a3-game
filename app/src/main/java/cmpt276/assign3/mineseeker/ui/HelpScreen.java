package cmpt276.assign3.mineseeker.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cmpt276.assign3.mineseeker.R;

public class HelpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        setupHyperlinks();
    }

    private void setupHyperlinks() {
        TextView hyperlink1 = findViewById(R.id.help_Hyperlink);
        TextView hyperlink2 = findViewById(R.id.help_CitationContent1);
        TextView hyperlink3 = findViewById(R.id.help_CitationContent2);
        TextView hyperlink4 = findViewById(R.id.help_CitationContent3);

        hyperlink1.setMovementMethod(LinkMovementMethod.getInstance());
        hyperlink2.setMovementMethod(LinkMovementMethod.getInstance());
        hyperlink3.setMovementMethod(LinkMovementMethod.getInstance());
        hyperlink4.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, HelpScreen.class);
    }
}