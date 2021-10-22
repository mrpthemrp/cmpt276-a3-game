package cmpt276.assign3.mineseeker.ui;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import cmpt276.assign3.mineseeker.R;

public class WinnerMessage extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Create view
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.congrats_message,null);
        DialogInterface.OnClickListener listener = (dialogInterface, i) -> {
            Intent intent = MainMenu.makeIntent(getActivity());
            startActivity(intent);
            getActivity().finish();
        };

        //build dialog
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton(R.string.win_Pos,listener)
                .create();
    }
}
